package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Address;
import com.entity.Student;
import com.util.HibernateUtility;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void saveStudent(Student student) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;

		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();

			session.save(student);

			tx.commit();

		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
		}

	}
	
	
	@Override
	public void saveAddress(int id,Address address) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;

		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			
			Student student=session.get(Student.class,id);
			
			student.setAddress(address);
			session.merge(student);
			
		
			tx.commit();

		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
		}

	}
	
	
}
