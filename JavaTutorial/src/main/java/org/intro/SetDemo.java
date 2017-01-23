package org.intro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetDemo {

	public static void main(String[] args) {
		HashSet<Integer> A = new HashSet<Integer>();
		//ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(3);
	
		Iterator iter = A.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		HashSet<Integer> B = new HashSet<Integer>();
		B.add(3);
		B.add(4);
		
		HashSet<Integer> C = new HashSet<Integer>();
		C.add(1);
		C.add(2);
		
		System.out.println(A.containsAll(B));
		System.out.println(A.containsAll(C));
		
		//A.addAll(B);
		//A.retainAll(B);
		A.removeAll(B);
		System.out.println(A);
		
	
	}
}
