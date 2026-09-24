package com.app;

import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOFactory;
import com.entity.Employee;

public class App {

	private static Employee getEmployee() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Name ");
		String name = scanner.nextLine();

		System.out.println("Enter Salary ");
		double salary = scanner.nextDouble();

		Employee employee = new Employee();
		employee.setName(name);
		employee.setSalary(salary);

		return employee;
	}

	public static void main(String[] args) {

		// Use DAO
		EmployeeDAO employeeDao = EmployeeDAOFactory.getEmployeeDAO();

		int option, x;

		do {

			Scanner scanner = new Scanner(System.in);

			System.out.println("******************");
			System.out.println("*** 1 : ADD EMPLOYEE       *********");
			System.out.println("*** 2 : DELETE EMPLOYEE    *********");
			System.out.println("*** 3 : GET EMPLOYEE       *********");
			System.out.println("*** 4 : UPDATE EMPLOYEE    *********");
			System.out.println("*** 5 : READ ALL EMPLOYEES *********");
			System.out.println("Enter Option ");

			option = scanner.nextInt();

			switch (option) {

			case 1:
				Employee employee = getEmployee();
				employeeDao.saveEmployee(employee);
				System.out.println("**** ADD SUCCESS ****");
				break;

			case 2:
				System.out.println("Enter Employee ID to DELETE");
				int dId = scanner.nextInt();

				employeeDao.deleteEmployee(dId);
				System.out.println("DELETE SUCCESS");
				break;

			case 3:
				System.out.println("Enter Employee ID to READ");
				int rId = scanner.nextInt();

				Employee emp = employeeDao.getEmployee(rId);

				if (emp != null) {
					System.out.println(emp);
				} else {
					System.out.println("No Employee exists with ID " + rId);
				}
				break;

			case 4:
				System.out.println("Enter EXISTING Employee ID ");
				int exId = scanner.nextInt();

				Employee existingEmployee = employeeDao.getEmployee(exId);

				if (existingEmployee != null) {

					System.out.println(existingEmployee);

					System.out.println("Enter Updated Information of Employee");
					Employee updatedEmployee = getEmployee();

					// ID is not entered by user.
					// Keep the existing ID for UPDATE.
					updatedEmployee.setId(exId);

					employeeDao.upadateEmployee(exId, updatedEmployee);

					System.out.println("Employee UPDATED SUCCESSFULLY");

				} else {
					System.out.println("No Employee exists with ID " + exId);
				}
				break;

			case 5:
				System.out.println("EMPLOYEE LIST");

				List<Employee> list = employeeDao.getAllEmployees();

				printList(list);
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}

			System.out.println("Press 1 to continue...");
			System.out.println("Enter ");
			x = scanner.nextInt();

		} while (x == 1);

	}

	private static void printList(List<Employee> list) {

		System.out.println("---------------------------------------------");
		System.out.println("ID            NAME              SALARY");
		System.out.println("---------------------------------------------");

		for (Employee employee : list) {

			System.out.printf("%4d", employee.getId());
			System.out.printf("%18s", employee.getName());
			System.out.printf("%15.2f", employee.getSalary());

			System.out.println();
		}
	}
}
