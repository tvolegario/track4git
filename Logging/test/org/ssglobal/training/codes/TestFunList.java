package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFunList {
	
	private FunList funList;
	
	@BeforeEach
	public void setUp() {
		funList = new FunList("test/config/myfile.txt");
	}
	
	@Test
	public void testEnableDisplay() {
		funList.enableDisplay();
	}
	
	@AfterEach
	public void tearDown() {
		funList = null;
	}

}
