package org.intro;

public class SingletonFirst {

	public SingletonFirst() {
		
		SingletonClass singletonClass = SingletonClass.getSingletonClass();
		System.out.println("First Class");
		System.out.println("i="+singletonClass.getI());
		singletonClass.setI(200);
		System.out.println("i="+singletonClass.i);
	}
}
