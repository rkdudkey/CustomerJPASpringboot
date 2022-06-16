package com.example.dudley.jpa.springdata.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.assertj.core.util.Arrays;
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
		customer.setEmail("zz@bu.com");
		customer.setName("ZOy");
		
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
	
	@Test
	void findByName() {
		List<Customer> customer = customerRepository.findByName("SOy");
		customer.forEach(c-> System.out.println(c.getName()));	
		
	}
	
	@Test
	void findByEmail() {
		List<Customer> customer = customerRepository.findByEmail("zz@bu.com");
		customer.forEach(c-> System.out.println(c.getName()));	
		
	}
	
	@Test
	void findByEmailLike() {
		List<Customer> customer = customerRepository.findByEmailLike("%zz%");
		customer.forEach(c-> System.out.println(c.getName() + " " + c.getEmail()));	
	}
	
	@Test
	void findByIdIn() {
		long[] a = {2,3};
		List<Customer> customer = customerRepository.findByIdIn(Arrays.asList(a));
		customer.forEach(c-> System.out.println(c.getName() + " " + c.getEmail()));	
	}

}
