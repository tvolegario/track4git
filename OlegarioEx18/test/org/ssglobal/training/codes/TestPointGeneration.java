package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPointGeneration {
	
	private PointGeneration pg;
	
	@BeforeEach
	public void setUp() {
		pg = new PointGeneration();
	}
	
	/* Sunny */
	@Test
	public void testPublicMethod() {
		Point expected = new Point(11, 11);
		Point actual = pg.publicMethod();
		Assertions.assertEquals(expected.getX(), actual.getX());
		Assertions.assertEquals(expected.getY(), actual.getY());
	}
	
	@Test
	public void testCallPrivateMethod() {
		Point expected = new Point(2, 2);
		Point actual = pg.callPrivateMethod();
		Assertions.assertEquals(expected.getX(), actual.getX());
		Assertions.assertEquals(expected.getY(), actual.getY());
	}
	
	/* Rainy */
	
	@Test
	public void testPublicMethodRainy() {
		Point unexpected = new Point(12, 12);
		Point actual = pg.publicMethod();
		Assertions.assertNotEquals(unexpected.getX(), actual.getX());
		Assertions.assertNotEquals(unexpected.getY(), actual.getY());
	}
	
	@Test
	public void testCallPrivateMethodRainy() {
		Point unexpected = new Point(1, 1);
		Point actual = pg.callPrivateMethod();
		Assertions.assertNotEquals(unexpected.getX(), actual.getX());
		Assertions.assertNotEquals(unexpected.getY(), actual.getY());
	}
	
	@AfterEach
	public void tearDown() {
		pg = null;
	}

}
