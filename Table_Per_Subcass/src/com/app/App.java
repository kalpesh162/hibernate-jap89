package com.app;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.dao.PaymentDAO;
import com.dao.PaymentDAOImpl;
import com.entity.Cheque;
import com.entity.CreditCard;

public class App {

	public static void main(String[] args) {

		PaymentDAO dao = new PaymentDAOImpl();

		/*
		 * Cheque cheque = new Cheque(); cheque.setDate(LocalDate.of(2026, 9, 29));
		 * cheque.setAmount(20000); cheque.setChNo(98654); cheque.setChType("Order");
		 * 
		 * dao.saveCheque(cheque); System.out.println("(((((())))))))");
		 * 
		 * System.out.println("------------------------"); CreditCard card = new
		 * CreditCard(); card.setDate(LocalDate.of(2026, Month.SEPTEMBER, 27));
		 * card.setAmount(17500); card.setCcNo(2334455); card.setCcType("VISA");
		 * 
		 * dao.saveCreditCard(card);
		 */

		/*
		 * System.out.println("Read Data Payment");
		 * System.out.println(dao.getPaymentById(1));
		 * System.out.println(dao.getPaymentById(2));
		 * System.out.println(dao.getPaymentById(3));
		 * System.out.println("----------------------------");
		 * System.out.println(dao.getCreditCard(1));
		 * System.out.println(dao.getCreditCard(2));
		 * System.out.println(dao.getCreditCard(3));
		 * System.out.println("----------------------------");
		 * System.out.println(dao.getCheque(1)); System.out.println(dao.getCheque(2));
		 * System.out.println(dao.getCheque(3));
		 */

		List<Object[]> list = dao.getAllTransactions();

		for (Object object[] : list) {
			for (Object ob : object)
				System.out.print(ob + "     ");
			System.out.println();
		}

	}

}
