package org.intro;

public class CustomeExceptionTest {

	static class CustomRuntimeException extends RuntimeException {
		CustomRuntimeException(String message) {
			super(message);
		}
	}
	
	public static void main(String[] args) {
		throw new CustomRuntimeException("my custom runtime exception message");
	}
}
