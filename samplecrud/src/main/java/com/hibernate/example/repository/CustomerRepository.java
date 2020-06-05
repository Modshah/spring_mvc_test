package com.hibernate.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.example.Models.Customers;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
	List<Customers> findByFirstName(String FirstName);
	List<Customers> findAll();
}
