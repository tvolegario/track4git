package org.ssglobal.training.codes;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestLocator {
	
	@Mock
	private LocatorService ls;
	
	@InjectMocks
	private Locator l;
	
	/* Sunny */
	@Test
	public void testLocatePositive() {
		when(ls.geoLocate(isA(Point.class))).thenReturn(new Point(1,2));
		Point actual = l.locate(1, 2);
		Assertions.assertEquals(1, actual.getX());
		Assertions.assertEquals(2, actual.getY());
	}
	
	@Test
	public void testLocateNegative() {
		Point actual = l.locate(-1, -2);
		Assertions.assertEquals(1, actual.getX());
		Assertions.assertEquals(2, actual.getY());
	}
	
	@Test
	public void testLocateNegativePositive() {
		Point actual = l.locate(-1, 2);
		Assertions.assertEquals(1, actual.getX());
		Assertions.assertEquals(2, actual.getY());
	}
		
	@Test
	public void testLocateZero() {
		when(ls.geoLocate(isA(Point.class))).thenReturn(new Point(0,0));
		Point actual = l.locate(0, 0);
		Assertions.assertEquals(0, actual.getX());
		Assertions.assertEquals(0, actual.getY());
	}

}
