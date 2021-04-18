//triangleSpecialCases.java
//By Matthew Heusser Matt@xndev.com
//Redistributed under Creative commons share-alike license
//https://creativecommons.org/licenses/by-sa/4.0/
//
// The special cases test cases for triangle - zero, negative numbers, big numbers
//

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class triangleSpecialCasesTest {

	@Test
	public void test_zero() {
		triangle t = new triangle();
		String result = t.gettriangletype(0, 1, 2);
		assertEquals("One number is zero is not a triangle", "not a triangle", result);
	}
	
	@Test
	public void test_negative() {
		triangle t = new triangle();
		String result = t.gettriangletype(-1, -1, -1);
		assertEquals("negative numbers are not a triangle", "not a triangle", result);
	}
	
	@Test
	public void test_bignum() {
		triangle t = new triangle();
		String result = t.gettriangletype(17483647, 17483647, 17483647);
		assertEquals("MAXINT is still equilateral", "equilateral", result);
	}

}
