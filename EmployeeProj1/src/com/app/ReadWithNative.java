package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.entity.Employee;

public class ReadWithNative {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		// from Employee e
		NativeQuery<Employee> query = session.createNativeQuery("Select * from emp101 ", Employee.class);

		List<Employee> list = query.getResultList();

		for (Employee employee : list)
			System.out.println(employee);

		factory.close();

	}

}
