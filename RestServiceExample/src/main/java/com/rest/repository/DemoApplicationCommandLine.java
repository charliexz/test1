package com.rest.repository;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@SpringBootApplication(scanBasePackages = {"com.example.demo","com.rest.repository","com.rest.controller","com.rest.service"})
//@EntityScan("com.data.Entity")
public class DemoApplicationCommandLine /*implements CommandLineRunner*/ {

/*
    @Autowired
    DataSource dataSource;

    @Autowired
    CustomerJPARepository customerRepository;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplicationCommandLine.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String... args) throws Exception {

    }*/
}
