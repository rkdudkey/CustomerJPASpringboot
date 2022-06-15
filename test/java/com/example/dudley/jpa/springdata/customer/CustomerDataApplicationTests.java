package com.example.dudley.jpa.springdata.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dudley.jpa.springdata.customer.entity.Customer;
import com.example.dudley.jpa.springdata.customer.repo.CustomerRepository;

@SpringBootTest
class CustomerDataApplicationTests {
	
	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCustomerCreate() {
		
		Customer customer = new Customer();
		customer.setEmail("ff@bu.com");
		customer.setName("SOy");
		
		customerRepository.save(customer);
		
	}
	
	@Test
	public void testRead() {
		Customer customer = customerRepository.findById((long) 1).get();
		assertNotNull(customer);
		assertEquals("Zoy", customer.getName());
	}
	
	@Test
	void testUpdate() {
		Customer customer = customerRepository.findById((long) 1).get();
		customer.setEmail("zz@bu.com");
		customerRepository.save(customer);		
		
	}
	
	@Test
	void testDelete() {
		if(customerRepository.existsById((long) 1)) {
			customerRepository.deleteById((long) 1);
		}
			
	}
	
	@Test
	void testCount() {
		System.out.println("total record >>>>>>>>>>>>>>>>>>>>>> " + customerRepository.count());
	}

}
