package org.intro;

class Calculator {
    int left, right, third;
 
    public Calculator(int left, int right) {
    	this.left = left;
    	this.right = right;
    }
    
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    public void setOprands(int left, int right, int thrid) {
    	//this.left = left;
    	//this.right = right;
    	this.setOprands(left, right);
    	this.third = third;
    }
 
    public int setOprands(int left, int right, int third, int fourth) {
        this.left = left;
        this.right = right;
        return third;
    }
    
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
 
class SubstractionableCalculator extends Calculator {
    public SubstractionableCalculator(int left, int right) {
    	super(left, right);
    	//this.left = left;
        //this.right = right;
    }
 
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorDemo {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}