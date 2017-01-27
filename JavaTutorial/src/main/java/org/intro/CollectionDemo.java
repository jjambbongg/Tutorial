package org.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Computer implements Comparable{

	int serial;
	String owner;
	
	Computer(int serial, String owner) {
		this.serial = serial;
		this.owner = owner;
	}
	
	public String toString() {
		return serial + ":" + owner;
	}
	
	public int compareTo(Object o) {
		return this.serial - ((Computer)o).serial;
	}
}

public class CollectionDemo {

	public static void main(String[] args) {
		List<Computer> computers = new ArrayList<Computer>();
		computers.add(new Computer(500, "Sophie"));
		computers.add(new Computer(200, "Tom"));
		computers.add(new Computer(3323, "Jack"));
		
		Iterator<Computer> i = computers.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}
		
		Collections.sort(computers);
		Iterator<Computer> sortedI = computers.iterator();
		while(sortedI.hasNext()) {
			System.out.println(sortedI.next().toString());
		}	
	}
}
