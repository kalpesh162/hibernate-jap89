package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Employee;
import com.utility.HibernateUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) {

		Transaction tx = null;
		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {

			tx = session.beginTransaction();

			session.save(employee);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	@Override
	public void deleteEmployee(int id) {
		Transaction tx = null;

		SessionFactory factory = HibernateUtility.getSessionFactory();
		try (Session session = factory.openSession();) {
			tx = session.beginTransaction();

			Employee employee = session.get(Employee.class, id);

			if (employee != null) {
				session.delete(employee);
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}

	}

	@Override
	public void upadateEmployee(int id, Employee updateEmployee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;

		try (Session session = factory.openSession();) {
			Employee employee1 = (Employee) session.get(Employee.class, id);

			if (employee1 != null) {
				employee1.setName(updateEmployee.getName());
				employee1.setSalary(updateEmployee.getSalary());

				tx = session.beginTransaction();

				session.update(employee1);

				tx.commit();

			} else {
				System.out.println("Employee Not Found ..");
				// throw new RuntimeException("Employee Not found "+id);
			}

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public void upadateEmployee(int id, String name, double salary) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;

		try (Session session = factory.openSession();) {

			Employee employee1 = (Employee) session.get(Employee.class, id);

			if (employee1 != null) {
				employee1.setName(name);
				employee1.setSalary(salary);

				session.beginTransaction();

				session.update(employee1);

				tx.commit();

			} else {
				System.out.println("Employee Not Found ..");

				// throw new RuntimeException("Employee Not found "+id);
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}

	}

	@Override
	public Employee getEmployee(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Employee employee1 = null;
		try (Session session = factory.openSession();) {

			employee1 = (Employee) session.get(Employee.class, id);

			if (employee1 != null) {
				return employee1;
			} else {
				System.out.println("Not Found Employee");
				// throw new RuntimeErrorException("Not Employee Founs With is "+id);
			}
		} catch (Exception e) {

		}

		return employee1;
	}

	@Override
	public List<Employee> getAllEmployees() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		List<Employee> list = new ArrayList<Employee>();
		try (Session session = factory.openSession();) {
			Query query = session.createQuery("from Employee e");

			list = query.list();

		}

		if (list.size() == 0)
			System.out.println("EMPTY LIST  ");

		return list;
	}

}
