package org.ssglobal.training.codes;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TestFunList {
	
	private FunList funList;
	
	@BeforeEach
	public void setup() {
		// System.out.println("Initialization");
		// All objects to be called should be instantiated here
		// One setup for test case
		funList = new FunList("test/config/myfile.txt");
	}
	
	// Sunny Day Testing
	
	@Disabled
	@Test
	public void testCountEqualsValue() {
		long count = funList.countWords();
		Assertions.assertEquals(6, count);
		// There is an algo problem
	}
	
	@Test
	public void testCountNonNegativeFile1() {
		long count = funList.countWords();
		Assertions.assertTrue(count >= 0);
	}
	
	@Test
	public void testCountNonNegativeFile2() {
		FunList funList = new FunList("test/config/myfile2.txt");
		long count = funList.countWords();
		Assertions.assertEquals(0, count);
		funList = null;
	}
	
	@Disabled
	@Test
	public void testContentListNotNull() {
		List<String> temp = funList.getContentList();
		Assertions.assertNotNull(temp);
	}
	
	// Enum, constant objects, or pointers pointing to one object
	@Disabled
	@Test
	public void testSameContentArrays() {
		Assertions.assertDoesNotThrow(() -> {
			String[] content = {"The fox jumps over the window"};
			String[] temp = funList.getContentArray();
			Assertions.assertSame(temp, content);
		});
	}
	
	@Disabled
	@Test
	public void testSameContentArraysValue() {
		String[] content = {"The fox jumps over the window"};
		String[] temp = funList.getContentArray();
		Assertions.assertArrayEquals(temp, content);
	}
	
	// Rainy Day Testing
	@Disabled
	@Test
	public void testSameContentArraysRainy() {
		Assertions.assertThrows(ClassCastException.class, () -> {
			String[] content = {"The fox jumps over the window"};
			String[] temp = funList.getContentArray();
			Assertions.assertSame(temp, content);
		});
	}
	
	@Disabled
	@Test
	public void testCountNonNegativeFile1Rainy() {
		long count = funList.countWords();
		Assertions.assertFalse(count <= 0);
	}
	
	@Disabled
	@Test
	public void testCountNonNegativeFile2Rainy() {
		FunList funList = new FunList("test/config/myfile2.txt");
		long count = funList.countWords();
		Assertions.assertNotEquals(6, count);
		funList = null;
	}
	
	@Test
	public void testContentListNotNullRainy() {
		List<String> temp = funList.getContentList();
		Assertions.assertNull(temp);
	}
	
	
	@Test
	public void testDisplayInSeconds() {
		Assertions.assertTimeout(Duration.ofSeconds(2), () -> {
			funList.showLines();	
		});
	}
	
	@Test
	public void testDisplayInMillis() {
		Assertions.assertTimeout(Duration.ofMillis(2), () -> {
			funList.showLines();	
		});
	}
	
	@RepeatedTest(value = 5)
	public void testSameContentArraysValueRepeat() {
		String[] content = {"The fox jumps over the window"};
		String[] temp = funList.getContentArray();
		Assertions.assertArrayEquals(temp, content);
	}
	
	@AfterEach
	public void teardown() {
		// System.out.println("Destroyer");
		funList = null;
	}

}
