package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.Homestay;

@Transactional
public class HomestayDAOImpl implements HomestayDAO {

	private SessionFactory sessionFactory;

	public HomestayDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Homestay> listAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Homestay ORDER BY homestayId DESC");
		@SuppressWarnings("unchecked")
		List<Homestay> listHome = query.list();
		return listHome;
	}

	@Override
	public void addHomestay(Homestay hs) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hs);
	}

	@Override
	public void deleteHomestay(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Homestay where HomestayId = :homestayId");
		query.setParameter("homestayId", id);
		query.executeUpdate();
	}

	@Override
	public Homestay findHomestayById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Homestay where HomestayId = :homestayId");
		query.setParameter("homestayId", id);
		Homestay hs = (Homestay) query.uniqueResult();
		return hs;
	}

	@Override
	public void updateHomestay(Homestay hs) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"update Homestay set HomestayTypeId = :homestayType, HomestayTitle = :homestayTitle, HomestayCity = :homestayCity, HomestayAddress = :homestayAddress, ImageUrl = :imageUrl, HomestayAbout = :homestayAbout, HomestayRule = :homestayRule, SmokeOption = :smokeOption, CreatedDate = :createdDate where HomestayId = :homestayId");
		query.setParameter("homestayType", hs.getType().getTypeId());
		query.setParameter("homestayTitle", hs.getHomestayTitle());
		query.setParameter("homestayCity", hs.getHomestayCity());
		query.setParameter("homestayAddress", hs.getHomestayAddress());
		query.setParameter("imageUrl", hs.getImageUrl());
		query.setParameter("homestayAbout", hs.getHomestayAbout());
		query.setParameter("homestayRule", hs.getHomestayRule());
		query.setParameter("smokeOption", hs.getHomestaySmoke());
		query.setParameter("createdDate", hs.getCreatedDate());
		query.setParameter("homestayId", hs.getHomestayId());
		query.executeUpdate();
	}


	@Override
	public List<Homestay> listHomestayById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Homestay where AccountId = :accountId");
		query.setParameter("accountId", id);
		@SuppressWarnings("unchecked")
		List<Homestay> listHome = query.list();
		return listHome;
	}

	@Override
	public List<Homestay> searchByCityOrAddress(String cityName, String address) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Homestay where HomestayCity = :cityName or HomestayAddress like :address");
		query.setParameter("cityName", cityName);
		query.setParameter("address", "%"+address+"%");
		@SuppressWarnings("unchecked")
		List<Homestay> listSearch = query.list();
		return listSearch;
	}

	@Override
	public Homestay findHomestayByAccountId(int accountId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Homestay where AccountId = :accountId");
		query.setParameter("accountId", accountId);
		Homestay Home = (Homestay) query.uniqueResult();
		return Home;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listAddress(String term) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("select homestayAddress from Homestay where homestayAddress like :term");
		query.setParameter("term", "%"+term+"%");
		return query.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Homestay> listHomestayByHomestayId(int homestayId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Homestay where HomestayId = :homestayId");
		query.setParameter("homestayId", homestayId);
		return query.list();
	}

}
