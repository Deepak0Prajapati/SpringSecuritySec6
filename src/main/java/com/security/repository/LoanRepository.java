package com.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import com.security.model.Loans;

public interface LoanRepository  extends CrudRepository<Loans, Integer>{
	
//	@PreAuthorize("hasRole('USER')")	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
