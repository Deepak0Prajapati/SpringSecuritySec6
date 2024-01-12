package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Customer;
import com.security.repository.CustomerRepository;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		
		Customer savedCustomer=null;
	    ResponseEntity<String> response=null;
	    try {
	    	
	    	String hashpwd = passwordEncoder.encode(customer.getPwd());
	    	customer.setPwd(hashpwd);
	    	
	    	savedCustomer=customerRepository.save(customer);
	    	if(savedCustomer.getId()>0) {
	    		response=ResponseEntity
	    				.status(HttpStatus.CREATED)
	    				.body("Given User Details are successfully registered");
	    	}
	    	
	    }catch (Exception e) {
	    	response=ResponseEntity
	    			.status(HttpStatus.INTERNAL_SERVER_ERROR)
	    			.body("an exception occured due to"+e.getMessage());
			// TODO: handle exception
		}
	    return response;
		
	}
	
	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Authentication authentication) {
		List<Customer> customer=customerRepository.findByEmail(authentication.getName());
		if(customer.size()>0) {
			return customer.get(0);
		}
		else {
			return null;
			
		}
	}

}
