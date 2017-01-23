package org.intro;

public class SingletonClass {

	private static SingletonClass SINGLETON_CLASS_INSTANCE;
	
	public int i = 10;
	
	private SingletonClass() {
		
	}
	
	public static SingletonClass getSingletonClass() {
		if(SINGLETON_CLASS_INSTANCE==null) {
			SINGLETON_CLASS_INSTANCE = new SingletonClass();
		}
		return SINGLETON_CLASS_INSTANCE;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public static void main(String[] args) {
		SingletonFirst fClass = new SingletonFirst();
		SingletonSecond sClass = new SingletonSecond();
	}
}
