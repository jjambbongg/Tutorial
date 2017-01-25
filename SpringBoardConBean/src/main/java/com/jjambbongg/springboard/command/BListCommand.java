package com.jjambbongg.springboard.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.jjambbongg.springboard.dao.BDao;
import com.jjambbongg.springboard.dto.BDto;

public class BListCommand implements BCommand{

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);	
	}
 
}
