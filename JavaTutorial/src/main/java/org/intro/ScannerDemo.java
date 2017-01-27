package org.intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		//int i = sc.nextInt();
		//System.out.println(i*1000);
		//sc.close();
		
		File f = new File("ScannerDemo.txt");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextInt()) {
				System.out.println(sc.nextInt()*1000);
			}
			sc.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
