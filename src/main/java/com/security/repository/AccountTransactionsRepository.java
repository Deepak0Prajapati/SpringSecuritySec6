package com.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.security.model.AccountTransactions;


public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, String>{
	
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
