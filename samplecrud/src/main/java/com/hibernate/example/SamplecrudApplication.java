package com.hibernate.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages= {"com.hibernate.example"})
@SpringBootApplication
//@ComponentScan({"com.hibernate.example"})
//@ComponentScan(basePackages= {"com.hibernate.example"})
@EnableJpaRepositories("com.hibernate.example.repository")
//@SpringBootApplication
//@EnableJpaRepositories(considerNestedRepositories = true)

public class SamplecrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamplecrudApplication.class, args);
	}

}
