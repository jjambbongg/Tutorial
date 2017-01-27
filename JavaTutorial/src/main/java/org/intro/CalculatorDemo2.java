package org.intro;

class DivideException extends RuntimeException {
	DivideException() {
		super();
	}
	DivideException(String message) {
		super(message);
	}
}
class Calculator2 {
	int left, right = 0;
	
	public void setOperands(int left, int right) {
		//if(right==0) {
		//	throw new IllegalArgumentException("zero is not allowed");
		//}
		this.left = left;
		this.right = right;
	}
	
	public void divide() {
		if(right==0) {
			throw new DivideException("can't divide with 0");
		}
		try {
			System.out.println("Before");
			System.out.println(this.left/this.right);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class CalculatorDemo2 {
	public static void main(String[] args) {
		Calculator2 c2 = new Calculator2();
		c2.setOperands(10, 0);
		try{
			c2.divide();
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
