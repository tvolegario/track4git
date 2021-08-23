package org.ssglobal.training.codes;


import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
	
	private EmployeeDao empDao;
	
	public EmployeeService(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	public List<String> getAllFirstNames(){
		return empDao.selectAllEmployees().stream().map((rec) -> {
						return rec.getFirstName();
				   }).collect(Collectors.toList());
	}

}
