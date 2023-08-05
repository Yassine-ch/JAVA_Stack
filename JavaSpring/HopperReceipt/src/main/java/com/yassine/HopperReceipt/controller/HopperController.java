package com.yassine.HopperReceipt.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class HopperController {
	@RequestMapping("/")
	public  String index(Model m ) {
		
		ArrayList<Hopper> hopperList = new ArrayList<Hopper>();
		
		 hopperList.add(new Hopper("Grace Hopper", "Copper wire", 5.8,
				 "Metal strips, also an illustration of nanoseconds",
				 "Little Things Corner Store"));
		 m.addAttribute("hopperList",hopperList);
	        
		return "index.jsp";
		
	}

}
