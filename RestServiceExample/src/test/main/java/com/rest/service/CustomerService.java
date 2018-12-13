package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.repository.Customer;
import com.rest.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

	@RequestMapping(value="/getAllCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@RequestMapping(value="/addCustomer")
	public String addCustomer(String name, String email) {
		String result = "Customer Inserted";
		try {
		    customerRepository.addCustomer(name, email);
		} catch (Exception ex) {
			result = "Add Customer failed: " + ex.getMessage();
		}
		return result;
	}

	@RequestMapping(value="/deleteCustomer")
	public String deleteCustomer(String name, String email) {
		String result = "customer deleted";
		try {
		    customerRepository.deleteCustomer(name, email);
		} catch (Exception ex) {
			result = "Delete Customer failed: " + ex.getMessage();
		}
		return result;
	}

	@RequestMapping(value="/updateCustomer")
	public String updateCustomer(String name, String newEmail) {
		String result = "customer updated";
		try {
		    customerRepository.updateCustomer(name, newEmail);
		} catch (Exception ex) {
			result = "Update Customer failed: " + ex.getMessage();
		}
		return result;
	}

	@RequestMapping(value="/getCustomersByName")
	public List<Customer> getCustomersByName(String name) {
		List<Customer> customers = null;
		try {
			customers = customerRepository.getCustomersByName(name);
		} catch (Exception ex) {
			System.out.println("getCustomersByName Customer failed: " + ex.getMessage());
		}
		return customers;
	}

}
