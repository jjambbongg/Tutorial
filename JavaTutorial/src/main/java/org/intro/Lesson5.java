package org.intro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lesson5 {

	static String data[] = new String[]{"first ", "second ", "thrid ", "fourth ", "fifth "};
	
	static List <String> loopList = Arrays.asList(data);

	public static void main(String[] args) {
		System.out.println("array loop old c syntax");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println("\n");
		
		System.out.println("array loop new syntax");
		for(String l:data) {
			System.out.print(l);
		}
		System.out.println("\n");
		
		System.out.println("old list loop");
		for(int i=0; i<loopList.size(); i++) {
			//List.get(i) have to lookup all the values in the list, cost a lot!
			System.out.print(loopList.get(i));		
		}
		System.out.println("\n");
		
		System.out.println("new list loop object");
		for(Object l:loopList) {
			System.out.print(l);
		}
		System.out.println("\n");
		
		System.out.println("#1 iterator");
		Iterator<String> iterator = loopList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
