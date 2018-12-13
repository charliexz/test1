package com.rest.repository;

import java.util.Date;

public class Customer {
	int id;
    String name;
    String email;
    Date date;

    public Customer() {
    }

    public Customer(int id, String name, String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getEmail() {
    	return email;
    }

}
