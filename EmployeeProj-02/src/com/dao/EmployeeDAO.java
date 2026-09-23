package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDAO {

	void saveEmployee(Employee employee);

	void deleteEmployee(int id);

	void upadateEmployee(int id, Employee employee);

	void upadateEmployee(int id, String name, double salary);

	Employee getEmployee(int id);

	List<Employee> getAllEmployees();

}
