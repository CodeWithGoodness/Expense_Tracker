package com.goodness.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodness.core.dao.PaymentDAO;
@Service

public class PaymentServiceImpl implements PaymentService {
	@Autowired
	
	private PaymentDAO dao;

	public PaymentDAO getDao() {
		return dao;
	}

	public void setDao(PaymentDAO dao) {
		this.dao = dao;
	}

}
