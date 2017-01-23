package org.intro;

class A{
	
	public String y() {
		return "public";
	}
	
	private String z() {
		return "private";
	}
	
	public String x() {
		return z();
	}
}

enum Fruit{
	APPLE("red"), PEACH("pink"), BANANA("yellow");
	private String color;
	public String getColor(){
		return this.color;
	}
	Fruit(String color) {
		this.color = color;
	}
}

public class AccessDemo1 {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.x());
		
		for(Fruit f:Fruit.values()) {
			System.out.println(f);
		}
		
	}
}
