package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDAO {
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(int id);
	
	List<Employee> getAllEmployees();
	

}
