package com.jjambbongg.springboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjambbongg.springboard.command.BCommand;
import com.jjambbongg.springboard.command.BContentCommand;
import com.jjambbongg.springboard.command.BDeleteCommand;
import com.jjambbongg.springboard.command.BListCommand;
import com.jjambbongg.springboard.command.BModifyCommand;
import com.jjambbongg.springboard.command.BReplyCommand;
import com.jjambbongg.springboard.command.BReplyViewCommand;
import com.jjambbongg.springboard.command.BWriteCommand;

@Controller
public class BController {

	BCommand command;
	
	@RequestMapping("/list")
	public String list(Model model) {
		printLog();
		command = new BListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		printLog();
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		printLog();
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		printLog();	
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		printLog();
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		printLog();
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		return "reply_view";
	}
	
	@RequestMapping("/reply") 
	public String replay(HttpServletRequest request, Model model) {
		printLog();
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		printLog();
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list";
	}

	private void printLog() {
		System.out.println(super.getClass());
	}
}
