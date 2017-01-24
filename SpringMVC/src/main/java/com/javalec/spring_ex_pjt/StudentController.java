package com.javalec.spring_ex_pjt;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_ex_pjt.student.Student;
import com.javalec.spring_ex_pjt.student.StudentValidator;

@Controller
public class StudentController {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	/*
	 * @RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
		String page = "createDonePage";
		
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "name", "trouble");
		
		if(result.hasErrors()) {
			page = "createPage";
		}
		return page;
	}*/
	
	@RequestMapping("/student/create") 
	public String studentCreate(@ModelAttribute("student") @Validated Student student, BindingResult result) {
		String page = "createDonePage";
		
		if(result.hasErrors()) {
			page = "createPage";
		}
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
	
}
