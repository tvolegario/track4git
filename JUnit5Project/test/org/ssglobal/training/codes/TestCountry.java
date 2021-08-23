package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class TestCountry {
	
	private Country country;
	
	@BeforeEach
	public void setUp() {
		country = new Country();
	}
	
	@ParameterizedTest
	@EnumSource(value = Country.Choice.class)
	public void testGreetPerCountry(Country.Choice option) {
		String result = country.sayGreet(option);
		Assertions.assertNotNull(result);
	}
	
	@ParameterizedTest
	@EnumSource(value = Country.Choice.class)
	public void testGreetPerCountryNotChoice(Country.Choice option) {
		String result = country.sayGreet(option);
		Assertions.assertNull(result);
	}
	
	@AfterEach
	public void tearDown() {
		country = null;
	}
	
	// Structures of Test Data (POJO, enum, array)
}
