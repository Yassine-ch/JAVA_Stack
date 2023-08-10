package com.yassine.DojoAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yassine.DojoAndNinjas.models.Dojo;
import com.yassine.DojoAndNinjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "showDojo.jsp";
	}
	
	
	@GetMapping("/new")
	public String renderNewForm(@ModelAttribute("newDojo") Dojo newDojo) {
		return "newDojo.jsp";
	}
	
	
	@PostMapping("/new")
	public String processNewForm(
			@Valid @ModelAttribute("newDojo") Dojo newDojo,
			BindingResult result
			) {
		
		
		if (result.hasErrors()) {
			return "newDojo.jsp";
		}
		
		Dojo createdDojo = dojoService.createDojo(newDojo);
		
		return "redirect:/dojos/" + createdDojo.getId();
	}

}