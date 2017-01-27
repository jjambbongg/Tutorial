package org.intro;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("one", 1);
		hm.put("two", 2);
		hm.put("three", 3);
		hm.put("four", 4);
		
		iteratorUsingForEach(hm);
		iteratorUsingIterator(hm);
	}
	
	public static void iteratorUsingForEach(HashMap map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for(Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	public static void iteratorUsingIterator(HashMap map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		System.out.println(entries);
		Iterator<Map.Entry<String, Integer>> i = entries.iterator();
		while(i.hasNext()) {
			Map.Entry<String, Integer> entry = i.next();
			System.out.println(entry.getKey() + ":"+ entry.getValue());
		}
	}
}
