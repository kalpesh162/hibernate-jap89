package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Cheque;
import com.entity.CreditCard;
import com.util.HibernateUtility;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void saveCreditCard(CreditCard card) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			session.persist(card);
			tx.commit();

		} catch (Exception e) {
			if (tx != null || tx.isActive()) {
				tx.rollback();
			}
			throw e;
		}

	}

	@Override
	public void saveCheque(Cheque cheque) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			session.persist(cheque);
			tx.commit();

		} catch (Exception e) {
			if (tx != null || tx.isActive()) {
				tx.rollback();
			}
			throw e;
		}

	}

}
