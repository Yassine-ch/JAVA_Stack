package com.yassine.examyoga.controller;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yassine.examyoga.models.Yoga;
import com.yassine.examyoga.services.UserService;
import com.yassine.examyoga.services.YogaService;

public class YogaController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private YogaService yogaServ;
	@GetMapping("/classes")
	public String welcome(HttpSession session, Model model) {

		// If no userId is found, redirect to logout
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		List<Yoga> yogas = yogaServ.allYogas();
		model.addAttribute("yogas", yogas);
		
	    return "classes.jsp";
	}
	
	@GetMapping("/new")
	public String addYoga(@ModelAttribute("yoga") Yoga yoga, HttpSession session) {
		 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		 
		return "newClass.jsp";
	}
	
	@PostMapping("/new")
	public String addYoga(@Valid @ModelAttribute("yoga") Yoga yoga, BindingResult result, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		
	    if(result.hasErrors()) {
	    	return "newClass.jsp";
	    }else {
	    	yogaServ.addYoga(new Yoga(yoga.getName(), yoga.getWeekday(), yoga.getPrice(), yoga.getDescription(), userServ.findById(userId)));
	    	return "redirect:/classes";
	    }
	}
	
	@GetMapping("/classes/{id}")
	public String showYogas(@PathVariable("id") Long id, HttpSession session, Model model) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userServ.findById(userId));
	     
		Yoga yoga = yogaServ.findYoga(id);
		model.addAttribute("yoga", yoga);
	     
	    return "viewClass.jsp";
	}
	
	@GetMapping("/classes/edit/{id}")
	public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {	
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		 
		Yoga yoga = yogaServ.findYoga(id);
		model.addAttribute("yoga", yoga);
		return "editClass.jsp";
	}
	
	@PutMapping("/classes/edit/{id}")
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("yoga") Yoga yoga, 
			BindingResult result, 
			HttpSession session) {	
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		 
		if(result.hasErrors()) {
			return "editClass.jsp";
		}else {
			yogaServ.updateYoga(yoga);
			return "redirect:/classes";
		}
	}
	
	@RequestMapping("/classes/delete/{id}")
	public String deleteYoga(@PathVariable("id") Long id, HttpSession session) {
		 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
    	 
    	yogaServ.deleteYoga(yogaServ.findYoga(id));
    	 
    	return "redirect:/classes";
	}
}
