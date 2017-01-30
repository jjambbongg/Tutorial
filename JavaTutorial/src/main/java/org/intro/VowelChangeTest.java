package org.intro;

import java.util.Scanner;

public class VowelChangeTest {

	public static boolean isVowel(char input) {		
		char vCharArry[] = {'a','e','i','o','u'};
		for(char c:vCharArry) {
			if(input==c) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String sampleStr = sc.nextLine();
		sc.close();
		//String sampleStr = "apple";
		int strLength = 0;
		int hIdx = 0;
		int tIdx = 0;
		strLength = sampleStr.length() - 1;
		tIdx = strLength;
		char [] charArry = sampleStr.toCharArray();
		
		while(hIdx<tIdx) {
			if(isVowel(charArry[hIdx]) && isVowel(charArry[tIdx])) {
				char charTemp = charArry[hIdx];
				charArry[hIdx] = charArry[tIdx];
				charArry[tIdx] = charTemp;
				System.out.println(String.valueOf(charArry));
				hIdx++;
				tIdx--;
				//break;
			} else if(!(isVowel(charArry[hIdx]))) {
				hIdx++;
			} else if(!(isVowel(charArry[tIdx]))) {
				tIdx--;
			}
		}
		
	}
	
	
	
}
