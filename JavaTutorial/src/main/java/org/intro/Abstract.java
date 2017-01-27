package org.intro;

public class Abstract {

	abstract class Animal {
		public String commonInheritedVar = "Is an animal and eat anything";
		
		abstract void declareDiet();
		
		public String implementedMethod() {
			return commonInheritedVar + " this message from method from implementedMethod method";
		}
		public void liveIn() {
			System.out.println(commonInheritedVar + " this message from liveIn method");
		}
	}
	
	class Fish extends Animal {
		public String FishVar = "in the ocean";
		Fish() {
			super();
		}
		public void declareDiet() {
			System.out.println(commonInheritedVar + " from Fish class");
		}
		public void liveIn() {
			System.out.println(FishVar);
		}
	}
	
	class Bird extends Animal {
		public String BirdVar = "yes";
		public void hasEgg() {
			System.out.println(BirdVar);
		}
		public void declareDiet() {
			System.out.println(commonInheritedVar + " from Bird class");
		}
	}
	
	Fish fish = new Fish();
	Bird bird = new Bird();
	
	//polymorphism
	Animal tuna = new Fish(); // object declared Animal type and initiated with Fish type
	Fish tunaSister = (Fish)tuna;
	
	public static void main(String[] args) {
		Abstract app = new Abstract();
		app.fish.declareDiet();
		app.bird.declareDiet();
		app.tunaSister.declareDiet();
		
		app.tuna.liveIn();
		app.tunaSister.liveIn();
	}
	
}
