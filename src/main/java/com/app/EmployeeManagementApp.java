package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.model.Company;
import com.app.repository.CompanyRepository;

@SpringBootApplication

public class EmployeeManagementApp implements CommandLineRunner {	
	@Autowired
    private CompanyRepository companyRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApp.class, args);
	}
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		companyRepository.save(new Company(101,"Company_1"));
		companyRepository.save(new Company(102,"Company_2"));
		companyRepository.save(new Company(103,"Company_3"));
		companyRepository.save(new Company(104,"Company_4"));
		companyRepository.save(new Company(105,"Company_5"));	
	}

}
