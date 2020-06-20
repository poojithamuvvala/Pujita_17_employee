package com.capgemini.employee.services;

import java.util.List;

import com.capgemini.employee.dao.EmployeeDAO;
import com.capgemini.employee.dao.EmployeeDAOImpl;
import com.capgemini.employee.dto.EmployeeBean;

public class EmployeeServiceImple implements EmployeeService{
         EmployeeDAO dao=new EmployeeDAOImpl();
	public boolean addEmployee(EmployeeBean employeeDemo) {
		// TODO Auto-generated method stub
		return dao.addEmployee(employeeDemo);
	}

	public List<EmployeeBean> viewEmployees() {
		// TODO Auto-generated method stub
		return dao.viewEmployees();
	}

	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	public boolean update(EmployeeBean employeeDemo) {
		// TODO Auto-generated method stub
		return dao.update(employeeDemo);
	}

	public EmployeeBean getEmployeeDetailsById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeDetailsById(id);
	}

}
