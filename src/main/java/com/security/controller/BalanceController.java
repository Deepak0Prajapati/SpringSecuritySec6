package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.AccountTransactions;
import com.security.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {
	
	@Autowired
	private AccountTransactionsRepository accountTransactionsRepository;
	
	
	public List<AccountTransactions> getBalanceDetails(@RequestParam int id){
		
		List<AccountTransactions> accountTransactions=accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
		if(accountTransactions!=null) {
			return accountTransactions;
		}
		else {
			return null;
			
		}
		
	}

}
