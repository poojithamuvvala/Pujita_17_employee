package com.capgemini.employee.services;

import java.util.List;

import com.capgemini.employee.dto.EmployeeBean;

public interface EmployeeService {
	boolean addEmployee(EmployeeBean employeeDemo);
	List<EmployeeBean> viewEmployees();
	boolean deleteEmployee(int id);
	boolean update(EmployeeBean employeeDemo);
	public EmployeeBean getEmployeeDetailsById(int id);
}
