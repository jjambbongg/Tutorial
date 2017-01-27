package org.intro;

public class ExceptionTest {

	private static Exception exception;
	
	public static void main(String[] args) {
		try {
			doprocess();
		}catch(Exception e) {
			System.out.println(e);
		}finally{
			System.out.println("Finally called");
		}
	}
	
	public static void doprocess() throws Exception {
		boolean runIt = true;
		if(runIt) {
			throw exception;
		}
	}
}
