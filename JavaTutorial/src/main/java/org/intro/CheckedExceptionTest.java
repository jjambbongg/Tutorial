package org.intro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionTest {

	public static void main(String[] args) {
		//Set up a new thread
		final Thread mainThread = Thread.currentThread();
		
		Thread interruptingThread = new Thread(new Runnable() {
			public void run() {
				//interrupt mainThread
				mainThread.interrupt();
			}
		});
		
		//interrupt mainThread
		//interruptingThread.start();
		try {
			Thread.sleep(2000);
			addException();
		} catch (InterruptedException | FileNotFoundException e) { 
		//} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void addException() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("./intro.md"));
	}
	
}
