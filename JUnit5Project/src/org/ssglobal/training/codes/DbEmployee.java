package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.List;

public class DbEmployee {
	private List<Employee> empTbl;
	
	public DbEmployee() {
		empTbl = new ArrayList<>();
	}
	
	public List<Employee> addEmployee(String fname, String lname,
									   Integer age, Float salary){
		
		
		empTbl.add(new Employee(fname, lname, age, salary));
		return empTbl;
	}

}
