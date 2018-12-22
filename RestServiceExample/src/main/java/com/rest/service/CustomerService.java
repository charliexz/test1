package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.repository.Customer;
import com.rest.repository.CustomerRepository;
import com.rest.repository.CustomerJPARepository;
import com.data.Entity.CustomerEntity;
import org.springframework.context.annotation.ComponentScan;
@Service
@ComponentScan("com.rest.repository")
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerJPARepository customerJPARepository;

	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	public String addCustomer(String name, String email) {
		String result = "Customer Inserted";
		try {
		    customerRepository.addCustomer(name, email);
		} catch (Exception ex) {
			result = "Add Customer failed: " + ex.getMessage();
		}
		return result;
	}

	public String deleteCustomer(String name, String email) {
		String result = "customer deleted";
		try {
		    customerRepository.deleteCustomer(name, email);
		} catch (Exception ex) {
			result = "Delete Customer failed: " + ex.getMessage();
		}
		return result;
	}

	public String updateCustomer(String name, String newEmail) {
		String result = "customer updated";
		try {
		    customerRepository.updateCustomer(name, newEmail);
		} catch (Exception ex) {
			result = "Update Customer failed: " + ex.getMessage();
		}
		return result;
	}

	public List<Customer> getCustomersByName(String name) {
		List<Customer> customers = null;
		try {
			customers = customerRepository.getCustomersByName(name);
		} catch (Exception ex) {
			System.out.println("getCustomersByName Customer failed: " + ex.getMessage());
		}
		return customers;
	}

	public List<CustomerEntity> getCustomersByNameJPA(String name) {
		List<CustomerEntity> customers = null;
		try {
			customers = customerJPARepository.findByName(name);
		} catch (Exception ex) {
			System.out.println("getCustomersByName Customer failed: " + ex.getMessage());
		}
		return customers;
	}

	public String createCustomerJPA(CustomerEntity customer) {
		String message = "";
		try {
			customerJPARepository.save(customer);
			message = "Customer created";
		} catch (Exception ex) {
			System.out.println("create Customer failed: " + ex.getMessage());
			message = "create Customer failed: " + ex.getMessage();
		}
		return message;
	}

}
