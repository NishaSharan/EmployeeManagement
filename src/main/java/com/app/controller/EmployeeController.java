package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveemployees/{compName}")	
	public List<Employee> saveEmployees(@RequestBody List<Employee> empList, @PathVariable("compName") String compName) {
		List<Employee> empResponse = employeeService.saveEmployeeList(empList,compName);
		return empResponse;
	}	
	
	@PostMapping("/saveemployee/{compName}") 
	//public Employee saveEmployee(@RequestBody EmpDTO empDTO) {		
	Employee saveEmployeeByComp(@RequestBody Employee employee, @PathVariable("compName") String compName)
	{	
		Employee empResponse = employeeService.saveEmployee(employee,compName);
		return empResponse;
	}
	
	@GetMapping("/employee/{empid}")  
	private Employee getEmployeeById(@PathVariable("empid") int empid) 
	{
		return employeeService.getEmployeeById(empid);
	}
	
	@GetMapping(value = {"/employeedetails/{firstName}"})  
	private List<Employee> getEmployeeByFirstName(@PathVariable("firstName") String firstName) 
	{
		return employeeService.getEmployeeByFirstName(firstName);
	}
	
	@GetMapping(value = {"/employee/{firstName}/{lastName}"})  
	private List<Employee> getEmployeeByName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) 
	{	
		return employeeService.getEmployeeByName(firstName, lastName);
		
	}
	
	@DeleteMapping("/employeebyid/{empid}")
	private int deleteEmployeeById(@PathVariable("empid") int empid) 
	{
		return(employeeService.deleteByEmpId(empid));
	}
	 
	@DeleteMapping("/employeebyname/{firstName}")
	private int deleteEmployeeByName(@PathVariable("firstName") String firstName) 
	{
		return(employeeService.deleteByFirstName(firstName));
	}
	
	@GetMapping("/employee/avgsal")  
	private int getEmployeeAverageSalary() 
	{
		System.out.println("---inside getEmployeeAverageSalary-----------");
	return employeeService.getAverageSalary();
	}
	
	
	
	@GetMapping("/companyaveragesalary/{companyname}")  
	private int getAverageSalaryByCompany(@PathVariable("companyname") String companyName) 
	{
		System.out.println("---inside getEmployeeAverageSalary-----------");
		return employeeService.getAverageSalaryByCompany(companyName);
	}
	
	@GetMapping("/employee/all")  
	private List<Employee> getAllEmployees() 
	{
		//System.out.println("---inside getEmployeeAverageSalary-----------");
		return employeeService.getAllEmployees();
	}
	
	
	@GetMapping("/employeebycompany/{companyname}")  
	private List<Employee> getEmployeeByCompany(@PathVariable("companyname") String companyName) 
	{
		System.out.println("companyname------------------------"+companyName);
	return employeeService.getEmployeeByCompany(companyName);
	}
	
	

}
