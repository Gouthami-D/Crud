package com.crud.Employee1.DAO;

import java.util.List;

import com.crud.Employee1.Model.Employee;


public interface EmployeeDAO   {
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	public void save (Employee theEmployee);
	public void deleteById(int theId);

}
