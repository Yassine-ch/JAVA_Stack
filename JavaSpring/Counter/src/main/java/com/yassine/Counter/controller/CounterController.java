package com.yassine.Counter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class CounterController {

	@RequestMapping("/")
	public String index(HttpSession session) {

		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count + 1);
		}
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/counter";
	}
	@RequestMapping("/plus2")
	public String plus2(HttpSession session) {

		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count + 2);
		}
		return "upBy2.jsp";
	}
}