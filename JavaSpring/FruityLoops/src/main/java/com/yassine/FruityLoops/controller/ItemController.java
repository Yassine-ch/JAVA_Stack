package com.yassine.FruityLoops.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
	@RequestMapping("/")
	public String index (Model model) {
		ArrayList<Item> fruits = new ArrayList<Item>();
		fruits.add(new Item("Kiwi  ", 1.5));
		fruits.add(new Item("Mango ", 2.5));
		fruits.add(new Item("Goji Berries ", 3.5));
		fruits.add(new Item("Guava ", 0.55));
		 model.addAttribute("fruitsFromMyController",fruits);
		
		return "index.jsp";
		
				}

}
