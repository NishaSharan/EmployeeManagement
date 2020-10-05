package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.model.Company;
import com.app.model.Employee;
import com.app.repository.CompanyRepository;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	CompanyRepository companyRepository;
	

	public List<Employee> saveEmployeeList(List<Employee> empList, String compName) {
		
		Company companyObj = companyRepository.findByCompanyName(compName);
		for(Employee emp:empList){
			emp.setCompany(companyObj); 
			}
		
		List<Employee> response = (List<Employee>) employeeRepository.saveAll(empList);
		return response;

	}
	
	public Employee saveEmployee(Employee emp, String compName) {
		Company companyObj = companyRepository.findByCompanyName(compName);
		emp.setCompany(companyObj);
		Employee response = employeeRepository.save(emp);
		return response;
	}

	public Employee findByEmpId(int empId) {
		Employee employee = employeeRepository.findByEmpId(empId);
		return employee;
	}

	public Employee getEmployeeById(int id) 
	{
		Employee emp = employeeRepository.findById(id).get();;
		return emp;
	}
	
	public void saveOrUpdate(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	
	
	//updating a record
	public void update(Employee employee, int empid) 
	{
		employeeRepository.save(employee);
	}
	
	public int  getAverageSalary()
	{
		return employeeRepository.getAverageSalary();
	}
	
	public int  getAverageSalaryByCompany(String companyName)
	{
		return employeeRepository.getAverageSalaryForCompany(companyName);
	}
	
	
	
	public List<Employee>  getAllEmployees()
	{
		return employeeRepository.getAllEmployees();
	}
	
	public List<Employee> getEmployeeByCompany(String companyName)  {
		Company comp = companyRepository.findByCompanyName(companyName);
		long compId = comp.getCompany_id();

		List<Employee> response = (List<Employee>) employeeRepository.getEmployeeByCompany(compId);
		return response;

	}
	
	public List<Employee> getEmployeeByFirstName(String firstName)  { 		
		List<Employee> empList = employeeRepository.findByFirstName(firstName);
		return empList;
	}
	
	public List<Employee> getEmployeeByName(String firstName, String lastName)  { 		
		List<Employee> empList = employeeRepository.findByName(firstName,lastName);
		return empList;
	}
	
	public int deleteByFirstName(String firstName)  {
		return(employeeRepository.deleteByFirstName(firstName));
	}
	
	public int deleteByEmpId(int empId)  {
		return(employeeRepository.deleteByEmpId(empId));

	}

}
