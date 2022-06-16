package com.example.dudley.jpa.springdata.customer.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.dudley.jpa.springdata.customer.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByName(String name);
	
	List<Customer> findByEmail(String email);
	

	List<Customer> findByEmailLike(String email);
	
	
	List<Customer> findByIdIn(List<Object> ids);

}
