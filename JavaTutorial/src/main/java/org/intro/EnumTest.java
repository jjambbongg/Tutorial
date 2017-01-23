package org.intro;


public class EnumTest {
	
	private static double salary;

	public static final String DEPARTMENT;
	
	public final String NAME;
	
	EnumTest() {
		NAME = "TEMP";
	}
	static {
		DEPARTMENT = "Development";
	}
	public static void main(String[] args) {
		
		salary = 200;
		
		System.out.println(DEPARTMENT+" average salary is "+salary);
		
		//showAnimal(Animal.BIRD);
	}
	
	public static void showAnimal(Animal animal) {
		if(animal == Animal.CAT) {
			System.out.println("- Cat:"+animal.str1+", "+animal.str2);
		} else if(animal ==  Animal.DOG) {
			System.out.println("- Dog:"+animal.str1+", "+animal.str2);
		} else if(animal ==  Animal.BIRD) {
			System.out.println("- Bird:"+animal.str1+", "+animal.str2);
		}
	}
	
	/*public static void main(String[] args) {
		showAnimal(Person.MEN);
	}
	
	public static void showAnimal(int animal) {
		if(animal==Animals.CAT) {
			System.out.println("Cat");
		} else if(animal==Animals.DOG) {
			System.out.println("Dog");
		} else if(animal==Animals.BIRD) {
			System.out.println("Bird");
		} else {
			System.out.println("None");
		}
	}*/
}


