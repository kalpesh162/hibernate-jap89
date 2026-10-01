package com.app;

import java.util.List;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.entity.Address;
import com.entity.Employee;

public class App {

	public static void main(String[] args) {

		Address address = new Address("LAXMI ROAD", "PUNE", "MH", "420234");
		Employee employee = new Employee();
		employee.setName("Raveena");
		employee.setSalary(35000);
		employee.setAddress(address);

		EmployeeDAO dao = new EmployeeDAOImpl();
		dao.saveEmployee(employee);

		System.out.println("------------------------------");

		Employee employee2 = dao.getEmployeeById(1);
		System.out.println(employee2);
		
		System.out.println("+++++++++++++++++++++++++++++++");
		List<Employee>list=dao.getAllEmployees();
		
		for(Employee employee3:list)
			System.out.println(employee3);
		
		System.out.println("+++++++++++++++++++++++++++++++");

	}
}
