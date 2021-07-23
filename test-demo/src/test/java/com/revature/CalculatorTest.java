package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.exceptions.CalculatorException;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	/*
	 * JUnit annotations
	 * 	- @BeforeEach
	 * 	- @AfterEach
	 * 	- @BeforeAll
	 * 	- @AfterAll
	 * 	- @Test
	 * 	- @Ignore
	 *  - @Order
	 */
	
	private static Calculator calc;
	
	
	@BeforeAll
	public static void setUp() {
		calc = new Calculator();
	}
	
	@AfterAll
	public static void tearDown() {
	}
	
	@Order(1)
	@Test
	public void addTwoAndTwo() {
		double expected = 4;
		double actualResult = calc.add(2, 2);
		assertEquals(expected, actualResult, "Adding 2 and 2 should be 4");
	}
	
	@Order(2)
	@Test
	public void add2p5And4p8() {
		double expected = 7.3;
		double actualResult = calc.add(2.5, 4.8);
		assertEquals(expected, actualResult, "Adding 2.5 and 4.8 should be 7.3");
	}
	
	@Order(3)
	@Test
	public void addNeg5AndNeg6() {
		double expected = -11;
		double actualResult = calc.add(-5, -6);
		assertEquals(expected, actualResult, "Adding -5 and -6 should be -11");
	}
	
	@Order(4)
	@Test
	public void add12andNeg6() {
		double expected = 6;
		double actualResult = calc.add(12, -6);
		assertEquals(expected, actualResult, "Adding 12 and -6 should be 6");
	}
	
	@Order(6)
	@Test
	public void subtracttwoandtwo() {
		double expected = 0;
		double actualResult = calc.subtract(2, 2);
		assertEquals(expected, actualResult, "Subtracting 2 and 2 should be 0");
	}
	
	@Order(7)
	@Test
	public void subtract6p8and3p7() {
		double expected = 3.1;
		double actualResult = calc.subtract(6.8, 3.7);
		assertEquals(expected, actualResult, .001, "Subtracting 6.8 and 3.7 should be 3.1");
	}
	
	@Order(8)
	@Test
	public void subtractNeg7andNeg3() {
		double expected = -4;
		double actualResult = calc.subtract(-7, -3);
		assertEquals(expected, actualResult, .001, "Subtracting -7 and -3 should be -4");
	}
	
	@Order(9)
	@Test
	public void subtract10andNeg5() {
		double expected = 15;
		double actualResult = calc.subtract(10, -5);
		assertEquals(expected, actualResult, .001, "Subtracting 10 and -5 should be 15");
	}
	
	@Order(10)
	@Test
	public void Multiply2and2() {
		double expected = 4;
		double actualResult = calc.multiply(2, 2);
		assertEquals(expected, actualResult, .001, "Multiplying 2 and 2 should be 4");
	}
	
	@Order(11)
	@Test
	public void Multiply2p5an6p8() {
		double expected = 17.25;
		double actualResult = calc.multiply(2.5, 6.9);
		assertEquals(expected, actualResult, .001, "Multiplying 2.5 and 6.9 should be 17.24");
	}
	
	@Order(12)
	@Test
	public void MultiplyNeg2and8() {
		double expected = -16;
		double actualResult = calc.multiply(-2, 8);
		assertEquals(expected, actualResult, .001, "Multiplying -2 and 8 should be -16");
	}
	
	@Order(13)
	@Test
	public void divide2and2() {
		double expected = 1;
		double actualResult = calc.divide(2, 2);
		assertEquals(expected, actualResult, .001, "Dividing 2 and 2 should be 1");
	}
	
	@Order(14)
	@Test
	public void divideNeg12and4() {
		double expected = -3;
		double actualResult = calc.divide(-12, 4);
		assertEquals(expected, actualResult, .001, "Dividing -12 and 4 should be -3");
	}
	
	@Order(15)
	@Test
	public void divideBy0() {
		assertThrows(CalculatorException.class, () -> calc.divide(1,0));
	}
	
	@Order(16)
	@Test
	public void is1Prime() {
		boolean expected = false;
		boolean actualResult = calc.isPrime(1);
		assertEquals(expected, actualResult, "1 is not a prime number");
	}
	
	@Order(16)
	@Test
	public void is4Prime() {
		boolean expected = false;
		boolean actualResult = calc.isPrime(4);
		assertEquals(expected, actualResult, "4 is not a prime number");
	}
	
	@Order(16)
	@Test
	public void is17Prime() {
		boolean expected = true;
		boolean actualResult = calc.isPrime(17);
		assertEquals(expected, actualResult, "1 is a prime number");
	}
	
	@Order(17)
	@Test
	public void p111CompareP111() {
		boolean expected = true;
		boolean actualResult = calc.compareThreeDecimal(.111, .111);
		assertEquals(expected, actualResult, "111 and 111 are equal at 3 placed");
	}
	
	@Order(18)
	@Test
	public void p131CompareP111() {
		boolean expected = false;
		boolean actualResult = calc.compareThreeDecimal(.131, .111);
		assertEquals(expected, actualResult, "131 and 111 are equal at 3 placed");
	}
	
	@Order(19)
	@Test
	public void p1116899CompareP1110234() {
		boolean expected = true;
		boolean actualResult = calc.compareThreeDecimal(.1116899, .1110234);
		assertEquals(expected, actualResult, "1116899 and 1110234 are equal at 3 placed");
	}
	
	
	

}
