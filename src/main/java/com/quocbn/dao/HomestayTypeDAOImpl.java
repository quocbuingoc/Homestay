package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.HomestayType;

@Transactional
public class HomestayTypeDAOImpl implements HomestayTypeDAO {
	
	private SessionFactory sessionFactory;
	
	public HomestayTypeDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<HomestayType> listAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from HomestayType");
		@SuppressWarnings("unchecked")
		List<HomestayType> listType = query.list();
		return listType;
	}

}
