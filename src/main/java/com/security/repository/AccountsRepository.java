package com.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.security.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
