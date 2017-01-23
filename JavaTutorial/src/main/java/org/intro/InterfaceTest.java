package org.intro;

import java.util.LinkedList;
import java.util.List;

interface Animalss {
	public String commmonInheritaedVariable = "is an animal and eat anything";
	void declareDiet();
}
interface Fish extends Animalss {
	public String fishVariable = "in the ocean";
	void liveIn();
}
class Tuna implements Fish {
	public void liveIn() {
		System.out.println(fishVariable);
	}
	public void declareDiet() {
		System.out.println("Tuna " + commmonInheritaedVariable);
	}
}
public class InterfaceTest {
	public static void main(String[] args) {
		Tuna tuna = new Tuna();
		tuna.liveIn();
	
		Animalss gTuna = new Tuna();
		gTuna.declareDiet();
		
		List<Animalss> dataModel = new LinkedList<Animalss>();
		dataModel.add(tuna);
		
	
	}
}
	