package com.yassine.DojoAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yassine.DojoAndNinjas.models.Ninja;
import com.yassine.DojoAndNinjas.services.DojoService;
import com.yassine.DojoAndNinjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/new")
	public String renderCreateForm(@ModelAttribute("newNinja") Ninja newNinja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}

	
	@PostMapping("/new")
	public String processCreateForm(
			@Valid @ModelAttribute("newNinja") Ninja newNinja,
			BindingResult result,
			Model model
			) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "newNinja.jsp";
		}
		
		Ninja createdNinja = ninjaService.createNinja(newNinja);
		
		return "redirect:/dojos/" + createdNinja.getDojo().getId();
	}
	
	
}
