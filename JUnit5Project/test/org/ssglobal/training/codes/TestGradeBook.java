package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestGradeBook {
	private GradeBook gb;
	
	@BeforeEach
	public void setUp() {
		gb = new GradeBook();
	}
	
	// Sunny day testing
	@ParameterizedTest
	@ValueSource(doubles = {95.5, 90.5, 70.5, 56.5, 68.6})
	public void testAddFiveGrades1(double testData) {
		gb.addGrade(testData);
		gb.printGrades();
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {40.5, 30.5, 25.5, 52.6, 50.6})
	public void testAddFiveGrades2(double testData) {
		gb.addGrade(testData);
		gb.printGrades();
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {40.5, 30.5, 25.5, 52.6, 50.6})
	public void testDelGrades(double testData) {
		gb.addGrade(testData);
		gb.delGrade(testData);
		gb.printGrades();
		
	}
	
	@AfterEach
	public void tearDown() {
		gb = null;
	}

}
