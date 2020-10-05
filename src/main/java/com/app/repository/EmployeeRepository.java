package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Company;
import com.app.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	public Employee findByEmpId(int empId);
	
	@Query("SELECT AVG(e.salary) from Employee e")
    int getAverageSalary();	
	
	@Query("SELECT AVG(e.salary) from Employee e group by e.company")
    int getAverageSalaryForCompany(String companyName);
	
	@Query("SELECT e from Employee e")
	List<Employee> getAllEmployees();
	
	@Query("FROM Employee emp where emp.firstName=:firstName")
	List<Employee> findByFirstName(@Param("firstName")String firstName);
	
	@Query("FROM Employee emp where emp.firstName=:firstName AND emp.lastName=:lastName ") 
	List<Employee> findByName(@Param("firstName")String firstName,@Param("lastName")String lastName);
	
	@Query("FROM Employee emp where emp.company.company_id=:company_id") 
	List<Employee> getEmployeeByCompany(@Param("company_id")Long compId);
	
	@Modifying      
	@Transactional 	
    @Query(value = "DELETE FROM Employee e WHERE e.empId = :empId") 
	public int deleteByEmpId(@Param("empId") int empId);
	
	@Modifying     
	@Transactional 
    @Query(value = "DELETE FROM Employee e WHERE e.firstName = :firstName")       // it will delete all the record with specific name
    int deleteByFirstName(@Param("firstName") String firstName);
	
}
