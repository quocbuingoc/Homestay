package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.Role;

@Transactional
public class RoleDAOImpl implements RoleDAO {
	
	private SessionFactory sessionFactory;
	
	public RoleDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role");
		return query.list();
	}

}
