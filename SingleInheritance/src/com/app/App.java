package com.app;

import java.time.LocalDate;

import com.dao.PaymentDAO;
import com.dao.PaymentDAOImpl;
import com.entity.Cheque;

public class App {

	public static void main(String[] args) {

		PaymentDAO dao = new PaymentDAOImpl();

		Cheque cheque = new Cheque();
		cheque.setDate(LocalDate.of(2026, 9, 30));
		cheque.setAmount(10000);
		cheque.setChNo(234211);
		cheque.setChType("OPEN");

		dao.saveCheque(cheque);
		System.out.println("(((((())))))))");

	}

}
