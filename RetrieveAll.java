package com.capgemini.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employee.dto.EmployeeBean;
import com.capgemini.employee.services.EmployeeService;
import com.capgemini.employee.services.EmployeeServiceImple;
@WebServlet("/RetrieveAll")
public class RetrieveAll extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		EmployeeService service = new EmployeeServiceImple();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>All Employees</h1>");
		

		List<EmployeeBean> list = service.viewEmployees();

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Id</th><th>LastName</th><th>FirstName</th><th>Department</th><th>Salary</th><th>EmailId</th></tr>");
	
			for (EmployeeBean e : list) {
				out.print("<tr><td>" + e.getEmpId() + "</td><td>" + e.getLastname() + "</td><td>" + e.getFirstname() + "</td>" + " <td>"
						+ e.getDepartment() + "</td><td>" + e.getSalary() + "</td>" + "<td>"+ e.getEmailId() +"</td></tr>");
		}
		out.print("</table>");
		
		RequestDispatcher res = request.getRequestDispatcher("/form.html");
        res.include(request, response);  

		out.close();
	}
}

