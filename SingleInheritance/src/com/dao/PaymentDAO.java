package com.dao;

import com.entity.Cheque;
import com.entity.CreditCard;

public interface PaymentDAO {
	void saveCreditCard(CreditCard card);

	void saveCheque(Cheque cheque);

}
