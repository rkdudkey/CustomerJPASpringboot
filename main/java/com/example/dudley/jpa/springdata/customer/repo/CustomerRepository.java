package com.example.dudley.jpa.springdata.customer.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.dudley.jpa.springdata.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	

}
