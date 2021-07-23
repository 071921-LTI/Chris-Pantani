package com.revature;

import com.revature.exceptions.CalculatorException;

public class Calculator {
	

	/*
	 * Should be able to:
	 * 		- add
	 * 		- subtract
	 * 		- multiply
	 * 		- divide
	 * 			- throw a CalculatorException when attempting to divide by 0
	 * 		- isPrime: checks if a number is a prime number
	 * 		- compareThreeDecimals: returns true if the same up to 3 decimals
	 * 				- 3.123.compare...(3.1233445) should return true
	 */
	
	public double add(double x, double y) {
		double sum = (x+y);
		return sum;
	}
	
	public double subtract(double x, double y) {
		double difference = (x-y);
		return difference;
	}
	
	public double multiply(double x, double y) {
		double product = (x*y);
		return product;
	}
	
	public double divide(double x, double y){
		if(y==0) {
			throw new CalculatorException();
		}
		else {
			double dividend = (x/y);
			return dividend;
		}
	}
	
	public boolean isPrime(int x) {
		boolean isPrime = true;
		if(x<=1) {
			isPrime =  false;
		}
		else {
			for(int i=2; i<= x/2; i++)
			{
				if((x % i) == 0) {
					isPrime = false;
				}
			}
		}
		return isPrime;
	}
	
	public boolean compareThreeDecimal(double x, double y) {
		x = Math.floor(x*1000);
		y = Math.floor(y*1000);
		if(x == y) {
			return true;
		}
		else {
		return false;
			}
		}	
}
