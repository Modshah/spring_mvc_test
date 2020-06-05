package com.hibernate.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.example.Models.CustomerUI;
import com.hibernate.example.Models.Customers;
import com.hibernate.example.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repository;
	
	@GetMapping("/bulkcreate")
	public String bulkcreate(){
	// save a single Customer
	repository.save(new Customers("Rajesh", "Bhojwani"));
	// save a list of Customers
	        repository.saveAll(Arrays.asList(new Customers("Salim", "Khan")
	                       , new Customers("Rajesh", "Parihar")
	                       , new Customers("Rahul", "Dravid")
	                       , new Customers("Dharmendra", "Bhojwani")));
	return "Customers are created";
	}
	
	@PostMapping("/create")
	public String create(@RequestBody CustomerUI customer){
	// save a single Customer
	repository.save(new Customers(customer.getFirstName(), customer.getLastName()));
	return "Customer is created";
	}
	
	@GetMapping("/findall")
	public List<CustomerUI> findAll(){
		List<Customers> customers = repository.findAll();
		List<CustomerUI> customerUI = new ArrayList<>();
		for (Customers customer : customers) {
		customerUI.add(new CustomerUI(customer.getFirstName(),customer.getLastName()));
		}
		return customerUI;
	}
	
	@RequestMapping("/search/{id}")
	public String search(@PathVariable long id){
		String customer = "";
		customer = repository.findById(id).toString();
		return customer;
	}
	
//	@RequestMapping("/error")
//	public String error() {
//		return "Some error occured";
//	}
}
