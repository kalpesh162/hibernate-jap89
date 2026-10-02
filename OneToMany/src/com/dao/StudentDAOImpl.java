package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Department;
import com.entity.Student;
import com.util.HibernateUtility;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void saveStudent(Integer deptId, Student student) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;

		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			// read Department
			Department dept = session.get(Department.class, deptId);

			List<Student> list = dept.getStudents();

			list.add(student);

			session.save(dept);

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
		}

	}

}
