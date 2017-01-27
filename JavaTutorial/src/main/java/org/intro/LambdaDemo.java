package org.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		String[] strings = {"C", "o", "d", "e", "M", "a", "n", "7", "7"};
		System.out.print("- Before sorting :");
		for(String str:strings) {
			System.out.print(str);
		}
		System.out.println("");
		
		Arrays.sort(strings, (x,y) -> x.compareToIgnoreCase(y));
		System.out.print("- After sorting  :");
		for(String str:strings) {
			System.out.print(str);
		}
		System.out.println("");
		
		ArrayList<Integer> intArry = new ArrayList<Integer>();
		intArry.add(1);
		intArry.add(2);
		intArry.add(3);
		intArry.add(4);
		intArry.add(5);
		intArry.add(6);
		for(Integer integer:intArry) {
			System.out.print(integer + " ");
		}
		System.out.println("");
		intArry.forEach(n->System.out.print(n + " "));
		
	
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sophie");
		names.add("Tom");
		names.add("Mary");
		
		for(String str:names) {
			System.out.println(str);
		}
		names.forEach(x->System.out.println(x));
		
		List<String> listNames = Arrays.asList("Sophie", "Tom", "Mary");
		/*Collections.sort(listNames, new Comparator<String> () {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(listNames);*/
		
		Collections.sort(listNames, (a, b) -> a.compareTo(b));
		
		System.out.println(listNames);
		
		
		
	}
	
}
