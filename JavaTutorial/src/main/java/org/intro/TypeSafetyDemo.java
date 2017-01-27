package org.intro;

class Animal2 {
	
}

class Lion extends Animal2{
	public void hunt() {
		System.out.println("hunt");
	}
}

class Rabbit extends Animal2{
	public void bark() {
		System.out.println("bark");
	}
}

class Cage {
	private Animal2 ani;

	public Animal2 getAni() {
		return ani;
	}
	public void setAni(Animal2 ani) {
		this.ani = ani;
	}
}

class CageGeneric<T> {
	T anyAnimal;

	public T getAnyAnimal() {
		return anyAnimal;
	}
	public void setAnyAnimal(T anyAnimal) {
		this.anyAnimal = anyAnimal;
	}
	
	public <S> void open(T anyAnimal) {
		System.out.println("Cage is opened.");
	}
}


public class TypeSafetyDemo {

	public static void main(String[] args) {
		Lion li = new Lion();
		Cage ca = new Cage();
		ca.setAni(li);
		
		//Rabbit li2 = (Rabbit)ca.getAni();
		
		CageGeneric<Lion> ca2 = new CageGeneric<Lion>();
		ca2.setAnyAnimal(li);
		//ca2.getAnyAnimal(li2);
		ca2.open(li);
	}
}
