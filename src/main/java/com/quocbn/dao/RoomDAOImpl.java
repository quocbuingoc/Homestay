package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.Room;

@Transactional
public class RoomDAOImpl implements RoomDAO {

	private SessionFactory sessionFactory;

	public RoomDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Room> listAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Room");
		@SuppressWarnings("unchecked")
		List<Room> listRooms = query.list();
		return listRooms;
	}

	@Override
	public void addRoom(Room r) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
	}

	@Override
	public void deleteRoom(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Room where RoomId = :roomId");
		query.setParameter("roomId", id);
		query.executeUpdate();
	}

	@Override
	public Room findRoom(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Room where RoomId = :roomId");
		query.setParameter("roomId", id);
		Room r = (Room) query.uniqueResult();
		return r;
	}

	@Override
	public void updateRoom(Room r) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"update Room set RoomTypeId = :roomTypeId, RoomNumber = :roomNumber, ImageUrl = :imageUrl, NumberOfGuests = :numberOfGuests, HaveBathroom = :haveBathroom, RoomDescription = :roomDescription, RoomStatus = :roomStatus, createdDate = :createdDate, HomestayId = :homestayId where RoomId = :roomId");
		query.setParameter("roomTypeId", r.getRoomType().getRoomTypeId());
		query.setParameter("roomNumber", r.getRoomNumber());
		query.setParameter("imageUrl", r.getImageUrl());
		query.setParameter("numberOfGuests", r.getNumberOfGuest());
		query.setParameter("haveBathroom", r.getHaveBathroom());
		query.setParameter("roomDescription", r.getRoomDescription());
		query.setParameter("roomStatus", r.getRoomStatus());
		query.setParameter("createdDate", r.getCreatedDate());
		query.setParameter("homestayId", r.getHomestay().getHomestayId());
		query.setParameter("roomId", r.getRoomId());
		query.executeUpdate();
	}

	@Override
	public List<Room> listRoomByHomestayId(int homestayId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Room where HomestayId = :homestayId");
		query.setParameter("homestayId", homestayId);
		@SuppressWarnings("unchecked")
		List<Room> listRooms = query.list();
		return listRooms;
	}

	@Override
	public List<Room> listRoomByHomestayIdAndAvailable(int homestayId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Room where HomestayId = :homestayId AND RoomStatus = 'Available'");
		query.setParameter("homestayId", homestayId);
		@SuppressWarnings("unchecked")
		List<Room> listRooms = query.list();
		return listRooms;
	}

}
