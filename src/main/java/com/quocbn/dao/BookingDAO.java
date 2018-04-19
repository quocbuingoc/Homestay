package com.quocbn.dao;

import java.util.List;

import com.quocbn.model.Booking;

public interface BookingDAO {
	
	public List<Booking> listCartByAccountId(int accountId);
	public List<Booking> listCartByHomestayId(int homestayId);
	public void addCart(Booking bk);
	public void deleteCart(int bookingId);
	public Booking findBookingById(int bookingId);
	public void updateCart(Booking bk);
	
}
