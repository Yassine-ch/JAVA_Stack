package com.yassine.beltDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yassine.beltDemo.models.Car;
import com.yassine.beltDemo.models.User;
import com.yassine.beltDemo.services.CarService;
import com.yassine.beltDemo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CarController {
	@Autowired 
	private CarService carService;
	@Autowired 
	private UserService userService;
	//READ-**-*--*ALL
	@GetMapping("/home")
	public String home( @ModelAttribute("car")  Car car,Model  model,HttpSession session ) {
		Long userID =(Long) session.getAttribute("user_id");
		if(userID ==null) {
			return "redirect:/login";
		}
		else {	
		//ROTUE--GARD		
	List<Car> allDaCars =	carService.allCars();
		model.addAttribute("allCars",allDaCars);
		return "home.jsp";
		}
	}
	//CREATE*-*-*--**
	@PostMapping("/cars")
	public String makeCars(@Valid @ModelAttribute("car") Car car, BindingResult res, Model model , HttpSession session) {
		
		if (res.hasErrors()) {
			return "home.jsp";
		}
		else {
			///Grab the current loggedIn user
			Long userID =(Long) session.getAttribute("user_id");
		User loggedInUser =	userService.findOne(userID);
		//set the driver as loggedIn user
		car.setDriver(loggedInUser);
		//save the car to db
			carService.createCar(car);
			return "redirect:/home";
		}
		
	}

	//DISPLAY-ROUTE --HOMEPAGE
	
	//UPDATE-*-*--**
	//DELETE-*-*-***-*
	//FINDBYID*--*-*--*

}