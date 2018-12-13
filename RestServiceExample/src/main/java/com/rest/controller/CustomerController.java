package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.rest.repository.Customer;
import com.rest.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="customer")
public class CustomerController {

	@Autowired
    private CustomerService customerService;

	@RequestMapping(value="/getAllCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}

	@GetMapping(value="/getAllCustomersGetMap")
	public List<Customer> getAllCustomersGet() {
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}

	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public String addCustomer(@RequestParam String name, @RequestParam String email) {
		String result = customerService.addCustomer(name, email);
		return result;
	}

	@PostMapping(value="/addCustomerPostMap")
	public String addCustomerPostMap(@RequestParam String name, @RequestParam String email) {
		String result = customerService.addCustomer(name, email);
		return result;
	}

	@DeleteMapping(value="/deleteCustomerDeleteMap")
	public String deleteCustomerDeleteMap(@RequestParam String name, @RequestParam String email) {
		String result = customerService.deleteCustomer(name, email);
		return result;
	}

	@RequestMapping(value="/deleteCustomer", method=RequestMethod.DELETE)
	public String deleteCustomer(@RequestParam String name, @RequestParam String email) {
		String result = customerService.deleteCustomer(name, email);
		return result;
	}

	@RequestMapping(value="/updateCustomer", method=RequestMethod.PUT)
	public String updateCustomer(@RequestParam String name, @RequestParam String email) {
		String result = customerService.updateCustomer(name, email);
		return result;
	}

	@PutMapping(value="/updateCustomerPutMap")
	public String updateCustomerPutMap(@RequestParam String name, @RequestParam String email) {
		String result = customerService.updateCustomer(name, email);
		return result;
	}
    
    @RequestMapping(value = "/getCustomersByName", consumes="application/json")
    public List<Customer> getCustomersByName(@RequestBody String json) {
    	
    	List<Customer> customers = null;
    	Customer customer = null;

        try {
    	
        	customer = new ObjectMapper().readValue(json, Customer.class);
    		customers = customerService.getCustomersByName(customer.getName());

    	} catch (Exception ex) {
    		System.out.println("Error: " + ex.getMessage());
    	}
        
        return customers;
    }

}
