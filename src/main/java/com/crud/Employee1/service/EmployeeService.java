package com.crud.Employee1.service;

import java.util.List;

import com.crud.Employee1.Model.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int employeeId);

}
