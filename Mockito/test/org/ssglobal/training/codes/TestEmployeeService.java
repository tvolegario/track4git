package org.ssglobal.training.codes;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestEmployeeService {
	
	@Mock
	private EmployeeDao empDao;
	
	@InjectMocks
	private EmployeeService empService;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	public void testGetFirstNames() {
		List<Employee> allEmps = Arrays.asList(
								 new Employee("Anna", "Dimak", 15000.00),
								 new Employee("Lorna", "Dimak", 10000.00),
								 new Employee("Fe", "Dimak", 5000.00));
		List<Employee> empTbl = new ArrayList<>(allEmps);
		when(empDao.selectAllEmployees()).thenReturn(empTbl);
		
		List<String> result = empService.getAllFirstNames();
		List<String> names = Arrays.asList("Anna", "Lorna", "Fe");
		List<String> expected = new ArrayList<>(names);
		Assertions.assertIterableEquals(expected, result);
		
		verify(empDao, times(1)).selectAllEmployees();
	}
	
	@AfterEach
	public void tearDown() {
		empService = null;
	}

}
