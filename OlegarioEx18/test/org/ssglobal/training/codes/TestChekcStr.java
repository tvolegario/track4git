package org.ssglobal.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit5.JMockitExtension;

@ExtendWith(JMockitExtension.class)
public class TestChekcStr {
	
	private ChekcStr cs;
	
	/* SetUp */
	
	@BeforeEach
	public void setUp() {
		cs = new ChekcStr();
	}
	
	/* Sunny */
	
	@Test
	public void testConvert() {
		Assertions.assertEquals("101111110", cs.convert("Anna"));
	}
	
	@Test
	public void testTotal() {
		Assertions.assertEquals(382, cs.total("Anna"));
	}
	
	@Test
	public void testBinarise() {
		Assertions.assertEquals("101111110", cs.binarise(382));
	}
	
	/* Rainy */
	/* Empty String */
	
	@Test
	public void testConvertEmptyString() {
		Assertions.assertEquals("", cs.convert(""));
	}
	
	@Test
	public void testTotalEmptyString() {
		Assertions.assertEquals(0, cs.total(""));
	}
	
	/* Null String */
	
	@Test
	public void testConvertNullString() {
		Assertions.assertDoesNotThrow(() -> {
			Assertions.assertEquals("", cs.convert(null));
		});
	}
	
	@Test
	public void testTotalNullString() {
		Assertions.assertDoesNotThrow(() -> {
			Assertions.assertEquals(0, cs.total(null));
		});
	}
	
	/* Empty and Null String */
	
	@Test
	public void testBinariseZero() {
		Assertions.assertEquals("", cs.binarise(0));
	}
	
	/* WhiteSpaces */
	
	@Test
	public void testConvertNewLine() {
		Assertions.assertEquals("1010", cs.convert("\n"));
	}
	
	@Test
	public void testTotalNewLine() {
		Assertions.assertEquals(10, cs.total("\n"));
	}
	
	@Test
	public void testBinariseNewLine() {
		Assertions.assertEquals("1010", cs.binarise(10));
	}
	
	@Test
	public void testConvertHorizontalTab() {
		Assertions.assertEquals("1001", cs.convert("\t"));
	}
	
	@Test
	public void testTotalHorizontalTab() {
		Assertions.assertEquals(9, cs.total("\t"));
	}
	
	@Test
	public void testBinariseHorizontalTab() {
		Assertions.assertEquals("1001", cs.binarise(9));
	}
	
	@Test
	public void testConvertCarriageReturn() {
		Assertions.assertEquals("1101", cs.convert("\r"));
	}
	
	@Test
	public void testTotalCarriageReturn() {
		Assertions.assertEquals(13, cs.total("\r"));
	}
	
	@Test
	public void testBinariseCarriageReturn() {
		Assertions.assertEquals("1101", cs.binarise(13));
	}
	
	/*WhiteSpaces*/
	
	@Test
	public void testConvertStringWithWhiteSpaces() {
		Assertions.assertEquals("10001011100", cs.convert("hello world"));
	}
	
	@Test
	public void testTotalStringWithWhiteSpaces() {
		Assertions.assertEquals(1116, cs.total("hello world"));
	}
	
	@Test
	public void testBinariseStringWithWhiteSpaces() {
		Assertions.assertEquals("10001011100", cs.binarise(1116));
	}
	
	/* Numbers */
	
	@Test
	public void testConvertStringWithNumbers() {
		Assertions.assertEquals("1000011011", "1234xml");
	}
	
	@Test
	public void testTotalStringWithNumbers() {
		Assertions.assertEquals(539, cs.total("1234xml"));
	}
	
	@Test
	public void testBinariseStringWithNumbers() {
		Assertions.assertEquals("1000011011", cs.binarise(539));
	}
	
	/* Proposed Changes */
	
	@Test
	public void testBinariseStringMockUp() {
		new MockUp<ChekcStr>() {
			@Mock
			public String binarise(int value) {
				if (value == 0) return "";
				if (value % 2 == 1) 
					return(String.join("", binarise(value / 2), "1"));
				return String.join("", binarise(value / 2), "0");
			}
		};
		
		ChekcStr cs = new ChekcStr();
		Assertions.assertEquals("101111110", cs.convert("Anna"));
	}
	
	@Test
	public void testConvertNullStringMockUp() {
		new MockUp<ChekcStr>() {
			@Mock
			public String convert(String str) {
				if (str == null) return binarise(total(""));
				return binarise(total(str));
			}
			
			public int total(String str) {
				if(str=="") return 0;
				if(str.length()==1) return ((int)(str.charAt(0)));
				return ((int)(str.charAt(0)))+total(str.substring(1));
			} 
			
			@Mock
			public String binarise(int value) {
				if (value == 0) return "";
				if (value % 2 == 1) 
					return(String.join("", binarise(value / 2), "1"));
				return String.join("", binarise(value / 2), "0");
			}
		};
		
		ChekcStr cs = new ChekcStr();
		Assertions.assertEquals("", cs.convert(null));
	}
	
	/* TearDown */
	
	@AfterEach
	public void tearDown() {
		cs = null;
	}

}
