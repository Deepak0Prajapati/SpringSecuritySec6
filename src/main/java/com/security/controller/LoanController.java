package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Loans;
import com.security.repository.LoanRepository;

@RestController
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@GetMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestParam int id){
		List<Loans> loans=loanRepository.findByCustomerIdOrderByStartDtDesc(id);
		if(loans.size()>0) {
			return loans;
		}
		else {
			return null;
		}
	}
}
