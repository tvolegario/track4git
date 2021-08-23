package org.ssglobal.training.codes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	private Connection conn;
	
	public void openConnect(String username, String password, String url) {
		try {
			conn = DriverManager.getConnection(username, password, url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnect() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> selectAllEmployees(){
		List<Employee> emps = new ArrayList<>();
		try (Statement stmt = conn.createStatement()){
			ResultSet dataset = stmt.executeQuery("select * from employee");
			while (dataset.next()) {
				Employee rec = new Employee();
				rec.setFirstName(dataset.getString(0));
				rec.setLastName(dataset.getString(1));
				rec.setSalary(dataset.getDouble(2));
				emps.add(rec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return emps;
	}

}

class Employee {
	private String firstName;
	private String lastName;
	private double salary;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
