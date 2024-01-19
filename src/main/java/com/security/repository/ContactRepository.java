package com.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.security.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, String>{

}
