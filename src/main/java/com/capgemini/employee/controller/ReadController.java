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

import sun.net.www.content.text.plain;
@WebServlet("/ReadController")
public class ReadController extends HttpServlet {
//	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id1");
		EmployeeService service = new EmployeeServiceImple();
	    EmployeeBean bean=service.getEmployeeDetailsById(Integer.parseInt(id));
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1></h1>");

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Id</th><th>LastName</th><th>FirstName</th><th>Department</th><th>Salary</th><th>EmailId</th></tr>");
	
		
				out.print("<tr><td>" + bean.getEmpId() + "</td><td>" + bean.getLastname() + "</td><td>" + bean.getFirstname() + "</td>" + " <td>"
						+ bean.getDepartment() + "</td><td>" + bean.getSalary() + "</td>" + "<td>"+ bean.getEmailId() +"</td></tr>");
		
		out.print("</table>");
			
		
        RequestDispatcher dispatcher=req.getRequestDispatcher("/Home.html");
        dispatcher.include(req, resp);
		out.println("</body>");
		out.println("</html>");

	}

}