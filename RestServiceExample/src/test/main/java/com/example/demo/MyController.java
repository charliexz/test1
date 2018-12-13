package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.rest.repository.Customer;
import com.rest.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MyController {
    
    @Autowired
    ICityService cityService;

    @Autowired
    private CustomerRepository customerRepository;
    
    @RequestMapping(value = "/getCities")
    public List<City> getCities() {

        List<City> cities = cityService.findAll();
        
        return cities;
    }
    
    @RequestMapping(value = "/getCity", consumes="application/json")
    public City getCity(@RequestBody String json) {
    	
        City city = null;

        try {
    	
    		city = new ObjectMapper().readValue(json, City.class);

    	} catch (Exception ex) {
    		
    	}
        
        return city;
    }

	@RequestMapping(value="/getAllCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}
    
}