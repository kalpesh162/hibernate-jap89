package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Department;
import com.util.HibernateUtility;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public void saveDepartment(Department department) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();

			session.save(department);

			tx.commit();

		} catch (Exception e) {
			if (tx != null || tx.isActive())
				tx.rollback();

			throw e;
		}

	}

}
