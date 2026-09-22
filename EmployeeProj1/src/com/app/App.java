package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class App {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Employee employee = new Employee();
		employee.setName("Kareena");
		employee.setSalary(343434);

		session.save(employee);

		Transaction tx = session.beginTransaction();

		tx.commit();

		session.close();
		factory.close();

		System.out.print("Thank YOU");

	}
}
