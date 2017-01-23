package org.intro;

public class UncheckedExceptionTest {

	static String nullString = null;
	
	public static void main(String[] args) {
		//if(nullString!=null) System.out.println(nullString.length());
		
		try{
			System.out.println(nullString.length());
		}catch(NullPointerException e) {
			System.out.println("nullString is null and stack trace is :"+ e.getStackTrace());
		}
	}
}
