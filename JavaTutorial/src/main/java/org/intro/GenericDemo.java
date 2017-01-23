package org.intro;

class StudentInfo {
	public int grade;
	StudentInfo(int grade) {
		this.grade = grade;
	}
}
/*class StudentPerson {
	public StudentInfo info;
	StudentPerson(StudentInfo into) {
		this.info = info;
	}
}*/
class EmployeeInfo {
	public int rank;
	EmployeeInfo(int rank) {
		this.rank = rank;
	}
}
/*class EmployeePerson {
	public EmployeeInfo info;
	EmployeePerson(EmployeeInfo into) {
		this.info = info;
	}
}*/

/*class AllPerson {
	public Object info;
	AllPerson(Object info) {
		this.info = info;
	}
}*/
	
class AllPerson<T, S> {
	public T info;
	public S id;
	AllPerson(T info, S id) {
		this.info = info;
		this.id = id;
	}
	
	public <U> void printInfo(U info) {
		System.out.println(info);
	}
}

public class GenericDemo {
	public static void main(String[] args) {
		
		/*StudentInfo si = new StudentInfo(2);
        StudentPerson sp = new StudentPerson(si);
        System.out.println(sp.info.grade); 
        EmployeeInfo ei = new EmployeeInfo(1);
        EmployeePerson ep = new EmployeePerson(ei);
        System.out.println(ep.info.rank);*/
        
		/*AllPerson p1 = new AllPerson("Me");
		Student s1 = (Student)p1.info;
		System.out.println(s1);*/
		
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(2);
		AllPerson<EmployeeInfo, Integer> p1 = new AllPerson<EmployeeInfo, Integer>(e, i);
		p1.printInfo(i);
	}
}
