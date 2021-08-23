package org.ssglobal.training.codes;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestAnalytics {
	
	@Mock
	private Analytics mockedAnalytics;

	/* Sunny */
	
	@Test
	public void testGetAllCurrency() {
		List<Money> moneyList = Arrays.asList(new Money("PHP", 15000.00),
											  new Money("USD", 10000.00),
											  new Money("KRW", 5000.00));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.getAllCurrency()).thenCallRealMethod();
		
		List<String> currencies = Arrays.asList("PHP", "USD", "KRW");
		List<String> expected = new ArrayList<>(currencies);
		List<String> actual = mockedAnalytics.getAllCurrency();
		
		Assertions.assertIterableEquals(expected, actual);
	}
	
	@Test
	public void testTotalAmount() {
		List<Money> moneyList = Arrays.asList(new Money("PHP", 15000.00),
											  new Money("USD", 10000.00),
											  new Money("KRW", 5000.00));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.totalAmount()).thenCallRealMethod();
		
		Assertions.assertEquals(30000.00, mockedAnalytics.totalAmount());
	}
	
	/* Rainy */
	/* Negative amounts */
	
	@Test
	public void testGetAllCurrencyNegativeAmount() {
		List<Money> moneyList = Arrays.asList(new Money("PHP", -15000.00),
											  new Money("USD", -10000.00),
											  new Money("KRW", -5000.00));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.getAllCurrency()).thenCallRealMethod();
		
		List<String> currencies = Arrays.asList("PHP", "USD", "KRW");
		List<String> expected = new ArrayList<>(currencies);
		List<String> actual = mockedAnalytics.getAllCurrency();
		
		Assertions.assertIterableEquals(expected, actual);
	}
	
	@Test
	public void testTotalAmountNegativeAmount() {
		List<Money> moneyList = Arrays.asList(new Money("PHP", -15000.00),
											  new Money("USD", -10000.00),
											  new Money("KRW", -5000.00));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.totalAmount()).thenCallRealMethod();
		
		Assertions.assertEquals(-30000.00, mockedAnalytics.totalAmount());
	}
	
	/* Null amounts */
	
	@Test
	public void testGetAllCurrencyNullAmount() {
		List<Money> moneyList = Arrays.asList(new Money("PHP", null),
											  new Money("USD", null),
											  new Money("KRW", null));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.getAllCurrency()).thenCallRealMethod();
		
		List<String> currencies = Arrays.asList("PHP", "USD", "KRW");
		List<String> expected = new ArrayList<>(currencies);
		List<String> actual = mockedAnalytics.getAllCurrency();
		
		Assertions.assertIterableEquals(expected, actual);
	}
	
	@Test
	public void testTotalAmountNullAmount() {
		List<Money> moneyList = Arrays.asList(new Money("PHP", null),
											  new Money("USD", null),
											  new Money("KRW", null));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.totalAmount()).thenCallRealMethod();
		
		Assertions.assertDoesNotThrow(() -> {
			Assertions.assertEquals(0, mockedAnalytics.totalAmount());
		});
		
	}
	
	/* Null currency */
	
	@Test
	public void testGetAllCurrencyNullCurrency() {
		List<Money> moneyList = Arrays.asList(new Money(null, 15000.00),
											  new Money(null, 10000.00),
											  new Money(null, 5000.00));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.getAllCurrency()).thenCallRealMethod();
		
		List<String> expected = new ArrayList<>();
		List<String> actual = mockedAnalytics.getAllCurrency();
		
		Assertions.assertIterableEquals(expected, actual);
	}
	
	@Test
	public void testTotalAmountNullCurrency() {
		List<Money> moneyList = Arrays.asList(new Money(null, 15000.00),
											  new Money(null, 10000.00),
											  new Money(null, 5000.00));
		List<Money> moneyTbl = new ArrayList<>(moneyList);
		when(mockedAnalytics.getMoney()).thenReturn(moneyTbl);
		when(mockedAnalytics.totalAmount()).thenCallRealMethod();
		
		Assertions.assertEquals(30000.00, mockedAnalytics.totalAmount());
	}
	
}
