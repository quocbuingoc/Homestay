package com.quocbn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.Payment;

@Transactional
public class PaymentDAOImpl implements PaymentDAO {
	
	private SessionFactory sessionFactory;
	
	public PaymentDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void CheckIn(Payment pm) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(pm);
	}

}
