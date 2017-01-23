package org.intro;

interface Info {
	public abstract int getLevel();
}
class EmployeeInfo2 implements Info{
	public int rank;
	EmployeeInfo2(int rank) {
		this.rank = rank;
	}
	public int getLevel() {
		return this.rank;
	}
}
class AllPerson2<T extends Info> {
	public T info;
	AllPerson2(T info) {
		this.info = info;
		info.getLevel();
	}
}

public class GenericDemo2 {
	public static void main(String[] args) {
		EmployeeInfo2 e2 = new EmployeeInfo2(3);
		AllPerson2<EmployeeInfo2> p2 = new AllPerson2<EmployeeInfo2>(e2);
	}

}
