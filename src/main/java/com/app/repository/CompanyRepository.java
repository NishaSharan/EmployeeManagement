package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.model.Company;
import com.app.model.Employee;


public interface CompanyRepository extends CrudRepository<Company, Integer>{
	public Company findByCompanyName(String compName);

}



