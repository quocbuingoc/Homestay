package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.RoomType;

@Transactional
public class RoomTypeDAOImpl implements RoomTypeDAO {
	
	private SessionFactory sessionFactory;
	
	public RoomTypeDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<RoomType> listAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from RoomType");
		@SuppressWarnings("unchecked")
		List<RoomType> listRoomTypes = query.list();
		return listRoomTypes;
	}

	@Override
	public void addRoomType(RoomType rt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoomType(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoomType findRoomType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRoomType(RoomType rt) {
		// TODO Auto-generated method stub
		
	}

}
