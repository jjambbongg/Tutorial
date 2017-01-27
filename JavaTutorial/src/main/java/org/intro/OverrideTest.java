package org.intro;

public class OverrideTest {

	public boolean equals(OverrideTest over) {
		System.out.println("Inside of OverrideTest");
		return false;
	}
	
	@Override
	public boolean equals(Object other) {
		System.out.println("Inside @override");
		return false;
	}
	
	public static void main(String[] args) {
		Object t1 = new OverrideTest();
		Object t2 = new OverrideTest();
		OverrideTest t3 = new OverrideTest();
		Object o1 = new Object();
		
		int count = 0;
		System.out.println(count++);
		t1.equals(t2);
		System.out.println(count++);
		t1.equals(t3);
		System.out.println(count++);
		t3.equals(o1);
	}
}
