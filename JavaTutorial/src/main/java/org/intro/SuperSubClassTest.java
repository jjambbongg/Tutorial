package org.intro;

public class SuperSubClassTest {

	static class SuperClass {
		String name = "I am SuperClass";
		
		public void nonStaticMethod() {
			System.out.println("SuperClass non-static method");
		}
		
		public static void staticMethod() {
			System.out.println("SuperClass static method");
		}
	}
	
	static class SubClass extends SuperClass{
		String name = "I am SubClass";
		
		public void nonStaticMethod() {
			System.out.println("SubClass non-static method");
		}
		
		public static void staticMethod() {
			System.out.println("SubClass static method");
		}
		
		public void onlySubClassMethod() {
			System.out.println("SubClass only method");
		}
	}
	
	public static void main(String[] args) {
		SuperClass sup = new SuperClass();
		SuperClass sub = new SubClass();
		
		System.out.println(sup.name);
		sup.nonStaticMethod();
		sup.staticMethod();
		
		System.out.println(sub.name);
		sub.nonStaticMethod();
		sub.staticMethod();
		
		((SubClass)sub).onlySubClassMethod();
	}
}
