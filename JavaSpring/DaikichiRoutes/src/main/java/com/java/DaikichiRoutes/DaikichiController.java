package com.java.DaikichiRoutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	   @RequestMapping("")
    // 3. Method that maps to the request route above
    public String Welcome() { // 3
            return "WELCOME!";
    }
	   @RequestMapping("/today")
	   public String today() {
		   return "Today you will find luck in all your endeavors!";
	   }
	   @RequestMapping("/tomorrow")
	   public String tomorow() {
		   return "Tomorrow, an opportunity will arise , so be sure to be open to neew ideas";
	   }
	

}
