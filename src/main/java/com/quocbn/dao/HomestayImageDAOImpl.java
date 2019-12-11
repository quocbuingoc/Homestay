package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.HomestayImage;

@Transactional
public class HomestayImageDAOImpl implements HomestayImageDAO {

	private SessionFactory sessionFactory;
	
	public HomestayImageDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<HomestayImage> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HomestayImage> listImageByHomestayId(int homestayId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from HomestayImage where HomestayId = :homestayId");
		query.setParameter("homestayId", homestayId);
		return query.list();
	}

	@Override
	public void addImage(HomestayImage image) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(image);
	}

	@Override
	public HomestayImage findHomestayImage(int imageId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from HomestayImage where ImageId = :imageId");
		query.setParameter("imageId", imageId);
		return (HomestayImage) query.uniqueResult();
	}

	@Override
	public void updateHomestayImage(HomestayImage image) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(image);
	}

	@Override
	public void deteteHomestayImage(int imageId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from HomestayImage where ImageId = :imageId");
		query.setParameter("imageId", imageId);
		query.executeUpdate();
	}

}
