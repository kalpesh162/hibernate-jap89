package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class UpdateData {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		System.out.println("********  Before Read  ******");

		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println("********  Before Read  ******");

		if (employee != null) {
			employee.setName("Raveena");
			employee.setSalary(66464);
			System.out.println("********  Before UPDATE  ******");
			session.update(employee);

			Transaction tx = session.beginTransaction();

			tx.commit();
			System.out.println("******** After Commit  ******");
			System.out.println("data Updated");

		} else {
			System.out.println("Employee Not Found");
		}

		session.close();
		factory.close();

		System.out.print("Thank YOU");

	}

}
