package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.Booking;

@Transactional
public class BookingDAOImpl implements BookingDAO {
	
	private SessionFactory sessionFactory;
	
	public BookingDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> listCartByAccountId(int accountId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking where AccountId = :accountId");
		query.setParameter("accountId", accountId);
		
		return query.list();
	}

	@Override
	public void addCart(Booking bk) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bk);
	}

	@Override
	public void deleteCart(int bookingId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Booking where BookingId = :bookingId");
		query.setParameter("bookingId", bookingId);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> listCartByHomestayId(int homestayId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking where HomestayId = :homestayId");
		query.setParameter("homestayId", homestayId);
		return query.list();
	}

	@Override
	public Booking findBookingById(int bookingId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking where BookingId = :bookingId");
		query.setParameter("bookingId", bookingId);
		return (Booking) query.uniqueResult();
	}

	@Override
	public void updateCart(Booking bk) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Booking set bookingStatus = :status where BookingId = :bookingId");
		query.setParameter("status", bk.isBookingStatus());
		query.setParameter("bookingId", bk.getBookingId());
		query.executeUpdate();
		
	}

}
