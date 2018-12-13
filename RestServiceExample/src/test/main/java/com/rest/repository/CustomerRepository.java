package com.rest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	// Find all customers, thanks Java 8, you can create a custom RowMapper like this : 
    public List<Customer> findAll() {

        List<Customer> result = jdbcTemplate.query(
                "SELECT id, name, email, created_date FROM customer",
                (rs, rowNum) -> new Customer(rs.getInt("id"),
                        rs.getString("name"), rs.getString("email"), rs.getDate("created_date"))
        );

        return result;

    }

	// Add new customer
    public void addCustomer(String name, String email) {

        jdbcTemplate.update("INSERT INTO customer(name, email, created_date) VALUES (?,?,?)",
                name, email, new Date());

    }

	// delete a customer
    public void deleteCustomer(String name, String email) {

        jdbcTemplate.update("delete from customer where name=? and email = ?", name, email);

    }

	// update a customer
    public void updateCustomer(String name, String newEmail) {

        jdbcTemplate.update("update customer set email=? where name=?", newEmail, name);

    }

	// get Customers By Name
    public List<Customer> getCustomersByName(String name) {

    	List<Customer> result = jdbcTemplate.query("select * from customer where name=?", new Object[]{name}, 
    			(rs, rowNum) -> new Customer(rs.getInt("id"),rs.getString("name"), rs.getString("email"), rs.getDate("created_date")));

    	return result;
    }

}
