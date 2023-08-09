package com.yassine.SaveTravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yassine.SaveTravels.models.Expense;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

	
	@Autowired
	private com.yassine.SaveTravels.services.ExpenseService expenseService;
	
	// dashboard route
	@GetMapping("")
	public String index(Model model, @ModelAttribute("newExpense") Expense newExpense) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "index.jsp";
	}
	
	// create form submission
	@PostMapping("/new")
	public String processNewExpense(
			@Valid @ModelAttribute("newExpense") Expense newExpense,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {

			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		}
		
		expenseService.createExpense(newExpense);
		return "redirect:/expenses";
		
	}
	
	
	// display one route
	@GetMapping("/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "oneExpense.jsp";
	}
	
	
	
	// route to show edit form
	@GetMapping("/edit/{id}")
	public String renderEdit(@PathVariable("id") Long id, Model model) {
		Expense oneExpense = expenseService.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "edit.jsp";
	}
	
	// edit form submission
	@PutMapping("/edit/{id}")
	public String processEdit(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("oneExpense") Expense oneExpense,
			BindingResult result
			) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		expenseService.updateExpense(oneExpense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/{id}")
	public String deleteOne(@PathVariable("id") Long id) {
		expenseService.removeExpense(id);
		return "redirect:/expenses";
	}

}