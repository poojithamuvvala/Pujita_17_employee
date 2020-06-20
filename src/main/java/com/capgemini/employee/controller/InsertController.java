package com.capgemini.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.capgemini.employee.dto.EmployeeBean;
import com.capgemini.employee.services.EmployeeService;
import com.capgemini.employee.services.EmployeeServiceImple;
@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id=req.getParameter("id1");
    String firstname=req.getParameter("fname");
    String lastname=req.getParameter("lname");
    String email=req.getParameter("mail");
    String department=req.getParameter("dept");
    String salary=req.getParameter("sal");
    
    EmployeeBean bean=new EmployeeBean();
    bean.setEmpId(Integer.parseInt(id));
    bean.setEmailId(email);
    bean.setFirstname(firstname);
    bean.setEmailId(email);
    bean.setLastname(lastname);
    bean.setDepartment(department);
    bean.setSalary(Integer.parseInt(salary));
    EmployeeService service=new EmployeeServiceImple();
    boolean check= service.addEmployee(bean);
    PrintWriter out=resp.getWriter();
    out.println("<html>");
	out.println("<head>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1></h1>");
	
    if(check==true) {
				out.println("Insertion sucessfull");
			}
			else {
				out.println("Insertion unsucessfull");
			}
					
    out.println("</h1>"); 
    RequestDispatcher dispatcher=req.getRequestDispatcher("/Home.html");
    dispatcher.include(req, resp);
	out.println("</body>");
	out.println("</html>");
}
    
    }

