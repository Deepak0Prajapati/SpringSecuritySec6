package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Accounts;
import com.security.repository.AccountsRepository;

@RestController
public class AccountController {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	public 	Accounts getAccountDetails(@RequestParam int id) {
		Accounts accounts=accountsRepository.findByCustomerId(id);
		if(accounts!=null) {
			return accounts;
		}else {
			return null;
		}
	}
}
