//triangleRunner.java
//By Matthew Heusser Matt@xndev.com
//Redistributed under Creative commons share-alike license
//https://creativecommons.org/licenses/by-sa/4.0/
//
// The happy path cases test cases for triangle 
//


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class triangleTest {

	@Test
	public void test_equilateral() {
		triangle t = new triangle();
		String result = t.gettriangletype(1, 1, 1);
		assertEquals("111 is equilateral", "equilateral", result);
	}
	
	@Test
	public void test_scalene() {
		triangle t = new triangle();
		String result = t.gettriangletype(3, 4, 5);
		assertEquals("345 is scalene", "scalene", result);
	}
	
	@Test
	public void test_isosceles() {
		triangle t = new triangle();
		String result = t.gettriangletype(2, 2, 3);
		assertEquals("223 is isosceles", "isosceles", result);
	}
	
	@Test
	public void test_not_a_triangle() {
		triangle t = new triangle();		
		String result = t.gettriangletype(2, 2, 12);
		assertEquals("2 2 12 is not a triangle", "not a triangle", result);
	}
	

}
