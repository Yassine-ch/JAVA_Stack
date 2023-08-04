package com.javaHelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
	@RequestMapping("/")
	public String human() {
		return "Hello Human";
	}
@RequestMapping("/hello")
	public String hello(@RequestParam(value="name" )String name) {
		return "hello ....."+name;
		}

}
