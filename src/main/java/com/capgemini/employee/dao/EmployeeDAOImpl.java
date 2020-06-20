package com.capgemini.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.employee.dto.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDAO {

	public boolean addEmployee(EmployeeBean employee) {

		String url = "jdbc:mysql://localhost:3307?user=root&password=root";

		String query = "insert into demo.employees values(?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getLastname());
			preparedStatement.setString(3, employee.getFirstname());
			preparedStatement.setString(4, employee.getEmailId());
			preparedStatement.setString(5, employee.getDepartment());
			preparedStatement.setLong(6, employee.getSalary());

			int res = preparedStatement.executeUpdate();

			if (res != 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public boolean deleteEmployee(int id) {
		String url = "jdbc:mysql://localhost:3307?user=root&password=root";

		String query = "delete from  demo.employees where id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			if (res != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;

	}

	public boolean update(EmployeeBean employeeBean) {
		String url = "jdbc:mysql://localhost:3307?user=root&password=root";

		String query = "update demo.employees set lastname=? where id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employeeBean.getLastname());
			preparedStatement.setInt(2, employeeBean.getEmpId());
			int res = preparedStatement.executeUpdate();
			if (res != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public EmployeeBean getEmployeeDetailsById(int id) {
		String url = "jdbc:mysql://localhost:3307?user=root&password=root";
		EmployeeBean employeeBean = new EmployeeBean();
		String query = "select * from demo.employees where id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeBean.getEmpId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employeeBean.setEmpId(resultSet.getInt("id"));
				employeeBean.setLastname(resultSet.getString("lastname"));
				employeeBean.setFirstname(resultSet.getString("firstname"));
				employeeBean.setEmailId(resultSet.getString("email"));
				employeeBean.setDepartment(resultSet.getString("department"));
				employeeBean.setSalary(resultSet.getInt("salary"));
				return employeeBean;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employeeBean;
	}

	public List<EmployeeBean> viewEmployees() {
		String url = "jdbc:mysql://localhost:3307?user=root&password=root";
		String query = "select * from demo.employees";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			List<EmployeeBean> beans = new ArrayList<EmployeeBean>();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			List<EmployeeBean> l = new ArrayList<EmployeeBean>();
			while (resultSet.next()) {
				EmployeeBean bean = new EmployeeBean();
				bean.setEmpId(resultSet.getInt("id"));
				bean.setLastname(resultSet.getString("lastName"));
				bean.setFirstname(resultSet.getString("firstName"));
				bean.setEmailId(resultSet.getString("email"));
				bean.setDepartment(resultSet.getString("department"));
				bean.setSalary(resultSet.getInt("salary"));
				l.add(bean);
			}
			if (l.isEmpty()) {
				return null;
			} else {
				return l;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if (connection != null) {
					connection.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
}