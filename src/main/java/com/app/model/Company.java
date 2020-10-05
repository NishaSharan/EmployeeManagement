package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private long company_id;
	@Column(name = "companyName", nullable = false)
	private String companyName;
	public long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public Company() {
		
	}
	public Company(long company_id, String companyName) {
		super();
		this.company_id = company_id;
		this.companyName = companyName;
	}
	

}
