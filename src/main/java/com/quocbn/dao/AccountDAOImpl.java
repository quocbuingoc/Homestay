package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.Account;

@Transactional
public class AccountDAOImpl implements AccountDAO {

	private SessionFactory sessionFactory;

	public AccountDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> listAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account");
		return query.list();
	}

	@Override
	public Account findAccountByName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account where user_name = :username");
		query.setParameter("username", name);
		Account acc = (Account) query.uniqueResult();
		return acc;
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(account);
	}

	@Override
	public void updateAccount(Account acc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"update Account set fullName = :fullname, emailAddress = :email, gender = :gen, imageUrl = :image, placeOfBirth = :place, dateOfBirth = :date, phoneNumber = :phone where accountId = :accId");
		
		query.setParameter("fullname", acc.getFullName());
		query.setParameter("email", acc.getEmailAddress());
		query.setParameter("gen", acc.getGender());
		query.setParameter("image", acc.getImageUrl());
		query.setParameter("place", acc.getPlaceOfBirth());
		query.setParameter("date", acc.getDateOfBirth());
		query.setParameter("phone", acc.getPhoneNumber());
		query.setParameter("accId", acc.getAccountId());
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> listAccountByUsername(String username) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account where user_name = :username");
		query.setParameter("username", username);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> listHostAccount() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account where role_id = '1'");
		return query.list();
	}

}
