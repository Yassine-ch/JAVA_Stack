package com.yassine.OmikujiForm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	//method to process the Form
	@RequestMapping(value= "/process", method = RequestMethod.POST)
	public String processForm(
			@RequestParam("year")Integer year,
			@RequestParam("city")String city,
			@RequestParam("person")String person,
			@RequestParam("hobby")String hobby,
			@RequestParam("livingThing")String livingThing ,
			@RequestParam("message")String message,
			
			HttpSession session
			) {
		session.setAttribute("year", year);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("message", message);
		
		
		return "redirect:/show";
		
	}
	//Method To Show Info about OMIKUJI
		@RequestMapping("/show")
		public String show() {
			return "show.jsp";
		}

}
