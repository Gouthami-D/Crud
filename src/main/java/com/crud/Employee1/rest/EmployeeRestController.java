package com.crud.Employee1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Employee1.Model.Employee;
import com.crud.Employee1.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired //(constructor injection)
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService= theEmployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	//get single employee by id
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee theEmployee =employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found"+employeeId);
		}
		return theEmployee;
		
	}
	
	//save the employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
		
		
	}
	
	//updating a employee
	
	@PutMapping("employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	//deleting an employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		Employee tempEmployee = employeeService.findById(employeeId);
				
				if(tempEmployee == null) {
					throw new RuntimeException("employee id  not found" + employeeId);
					
				}
				employeeService.deleteById(employeeId);
				
				return  "Deleted employee Id - " + employeeId;
	}
}
	
	


