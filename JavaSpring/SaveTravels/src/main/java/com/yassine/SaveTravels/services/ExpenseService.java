package com.yassine.SaveTravels.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.SaveTravels.models.Expense;
import com.yassine.SaveTravels.repositories.ExpenseRepository;



@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	// ----- FIND ALL ------
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	
	// ----- FIND ONE ------
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}

	// ----- CREATE ------
	public Expense createExpense(Expense newExpense) {
		return expenseRepository.save(newExpense);
	}
	
	
	// ----- UPDATE ------
	public Expense updateExpense(Expense oneExpense) {
		return expenseRepository.save(oneExpense);
	}

	// ----- DELETE ------
	public void removeExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}