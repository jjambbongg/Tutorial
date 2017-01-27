package org.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelChangeTest {

	public String getResult(String input) {
		
		boolean isV = false;
		int idxR = 0;
		int idxL = 0;
		String rtn = "";
		char compCharArry[] = {'a','e','i','o','u'};
		char[] inputCharArry = input.toCharArray();
		
		if(input!=null) {
			idxL = input.length()-1;
		}
		
		for(int i=0; i<input.length(); i++) {
			input.charAt(i);
		}
		while(idxR<idxL) {
		
		for(char c:inputCharArry) {
			for(char compC:compCharArry) {
				if(c==compC) {
					isV = true;
				} else {
				
				}
			}
		}
		
		}
		
		
		System.out.println(rtn);
		return rtn;
	}
	
	
	
	public static void main(String[] args) {
		try {
			
			
			VowelChangeTest vowl = new VowelChangeTest();
			vowl.getResult("apple");
			
			for(String e:args) {
				System.out.println(e);
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
	}
	
}
