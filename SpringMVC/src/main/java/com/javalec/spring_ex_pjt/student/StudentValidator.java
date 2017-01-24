package com.javalec.spring_ex_pjt.student;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		//return false;
		System.out.println(this.getClass());
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("validate()");
		System.out.println(this.getClass());
		
		Student student = (Student)target;
		
		String studentName = student.getName();
		String studentId = student.getId();
		if(studentName==null || studentName.trim().isEmpty()) {
			System.out.println("Error occured 1");
			errors.rejectValue("name", "trouble");
		}
		if(studentId==null || studentId.trim().isEmpty()) {
			System.out.println("Error occured 2");
			errors.rejectValue("id", "trouble");
		}
		
	}
}
