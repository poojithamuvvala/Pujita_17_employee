package com.capgemini.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employee.dao.EmployeeDAO;
import com.capgemini.employee.dao.EmployeeDAOImpl;
import com.capgemini.employee.services.EmployeeService;
import com.capgemini.employee.services.EmployeeServiceImple;
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id=req.getParameter("id1");
		EmployeeService service=new EmployeeServiceImple();
		boolean check=service.deleteEmployee(Integer.parseInt(id));
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		
	    if(check==true) {
					out.println("Deletion sucessfull");
				}
				else {
					out.println("Deletion unsucessfull");
				}
						
	    out.println("</h1>");
	    RequestDispatcher dispatcher=req.getRequestDispatcher("/Home.html");
        dispatcher.include(req, resp);
		out.println("</body>");
		out.println("</html>");
	}
}
