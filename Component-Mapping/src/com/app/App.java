package com.app;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.entity.Address;
import com.entity.Employee;

public class App {

	
	public static void main(String[] args) {
		
		Address address=new Address("FC ROAD", "PUNE", "MH","43434");
		Employee employee=new Employee();
		employee.setName("Raju");
		employee.setSalary(10000);
		employee.setAddress(address);
		
		EmployeeDAO dao=new EmployeeDAOImpl();
		dao.saveEmployee(employee);
		
		System.out.println("00000000000000000");
		
		
	}
}
