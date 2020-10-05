package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name="Employee.searchbycompanyid" ,
query = "SELECT e from Employee e \r\n" + 
		"INNER JOIN Company c ON e.company.company_id = c.company_id ")	


public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int  empId;
	
	//@Column(name = "first_name", nullable = false)
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "salary")
	private int salary;
	
	@ManyToOne(cascade = CascadeType.ALL)//optional=false means this relationship becomes mandatory , no employee row can be saved without a company 
	@JoinColumn(name = "companyFK")
	private Company company;	
	
	public int getEmpId() {
		return empId;
	}

	public Employee(int empId, String firstName, String lastName, String email, String address, int salary,
			Company company) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.salary = salary;
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}	

	public Employee() {
		
	}	



}
