package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.util.HibernateUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;
		try (Session session = factory.openSession()) {

			tx = session.beginTransaction();
			session.persist(employee);
			tx.commit();

		} catch (Exception e) {

			if (tx != null && tx.isActive())
				tx.rollback();

		}

	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;

		SessionFactory factory = HibernateUtility.getSessionFactory();

		try (Session session = factory.openSession()) {

			employee = session.get(Employee.class, id);

		} catch (Exception e) {

		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = null;

		SessionFactory factory = HibernateUtility.getSessionFactory();

		try (Session session = factory.openSession()) {

			list = session.createQuery("from Employee e").getResultList();

		} catch (Exception e) {

		}
		return list;
	}

}
