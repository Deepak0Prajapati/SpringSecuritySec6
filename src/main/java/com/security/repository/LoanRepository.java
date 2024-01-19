package com.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.security.model.Loans;

public interface LoanRepository  extends CrudRepository<Loans, Integer>{
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
