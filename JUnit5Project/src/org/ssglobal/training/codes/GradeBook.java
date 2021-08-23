package org.ssglobal.training.codes;

import java.util.Arrays;

public class GradeBook {
	
	private double[] grades = new double[0];
	
	public void addGrade(double grade) {
		double[] temp = new double[grades.length + 1];
		System.arraycopy(grades, 0, temp, 0, grades.length);
		temp[grades.length] = grade;
		
		grades = null; // para walang dangling
		grades = temp;
		temp = null; // optional for higher Java version (1.7 above)	
	}
	
	public void delGrade(double grade) {
		int counter = 0;
		
		// count all grade occurences
		for(double data : grades) {
			if (data == grade) {
				counter++;
			}
		}
		
		// create a new temp grades array minus counter grades
		double[] temp = new double[grades.length - counter];
		
		// remove all the grade
		int i = 0;
		for(double data : grades) {
			if (data != grade) {
				temp[i] = data;
				i++;
			}
		}
		
		grades = null;
		grades = temp;
		temp = null;
		
	}
	
	public void printGrades() {
		Arrays.stream(grades).forEach(System.out::println);
	}

}
