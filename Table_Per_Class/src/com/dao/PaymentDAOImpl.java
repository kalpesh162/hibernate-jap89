package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Cheque;
import com.entity.CreditCard;
import com.entity.Payment;
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

	@Override
	public void deleteCreditCard(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			// read if record exist
			CreditCard card = getCreditCard(id);
			if (card != null) {
				session.delete(card);
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null || tx.isActive()) {
				tx.rollback();
			}
			throw e;
		}

	}

	@Override
	public void deleteCheque(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			// read if record exist
			Cheque cheque = getCheque(id);
			if (cheque != null) {
				session.delete(cheque);
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null || tx.isActive()) {
				tx.rollback();
			}
			throw e;
		}

	}

	@Override
	public Payment getPaymentById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Payment payment = null;
		try (Session session = factory.openSession()) {
			payment = session.get(Payment.class, id);

		} catch (Exception e) {

			throw e;
		}

		return payment;
	}

	@Override
	public CreditCard getCreditCard(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		CreditCard card = null;
		try (Session session = factory.openSession()) {
			card = session.get(CreditCard.class, id);

		} catch (Exception e) {

			throw e;
		}

		return card;
	}

	@Override
	public Cheque getCheque(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Cheque cheque = null;
		try (Session session = factory.openSession()) {
			cheque = session.get(Cheque.class, id);

		} catch (Exception e) {

			throw e;
		}

		return cheque;
	}

}
