package org.intro;

public class Polymorphism {

	public String commonInheritedVar = "is a animal";
	void speak() {
		System.out.println("Animal Speak");
	}
	
	public static void main(String[] args) {
		//Polymorphism dog = new Dog(); 
		Dog dog = new Dog();
		System.out.print("A Dog ");
		dog.speak();
		dog.eat();
	
		Cat cat = new Cat();
		System.out.print("A Cat ");
		cat.speak();
	}
}

class Dog extends Polymorphism {
	@Override
	void speak() {
		System.out.println(commonInheritedVar+", Bark!");
	}
	
	void eat() {
		System.out.println(commonInheritedVar+", Dog eat");
	}
}

class Cat extends Polymorphism {
	@Override
	void speak() {
		System.out.println(commonInheritedVar+", Meow!");
	}
}
