package com.yassine.beltDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yassine.beltDemo.models.Car;
import com.yassine.beltDemo.services.CarService;

import jakarta.validation.Valid;

@Controller
public class CarController {
	@Autowired 
	private CarService carService;
	//READ-**-*--*ALL
	@GetMapping("/home")
	public String home(@ModelAttribute("car")  Car car,Model  model ) {
	List<Car> allDaCars =	carService.allCars();
		model.addAttribute("allCars",allDaCars);
		return "home.jsp";
	}
	//CREATE*-*-*--**
	@PostMapping("/cars")
	public String makeCars(@Valid @ModelAttribute("car") Car car, BindingResult res, Model model) {
		
		if (res.hasErrors()) {
			return "home.jsp";
		}
		else {
			carService.createCar(car);
			return "redirect:/home";
		}
		
	}

	//DISPLAY-ROUTE --HOMEPAGE
	
	//UPDATE-*-*--**
	//DELETE-*-*-***-*
	//FINDBYID*--*-*--*

}
