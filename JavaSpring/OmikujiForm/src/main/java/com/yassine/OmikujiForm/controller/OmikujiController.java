package com.yassine.OmikujiForm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OmikujiController {
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	//method to process the Form
	@RequestMapping("/process")
	public String processForm() {
		return "redirect:/omikuji/show";
		
	}
	//Method To Show Info about OMIKUJI
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}

}
