package com.quocbn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BOOKING")
public class Booking {
	private int bookingId;
	private Room r;
	private Account acc;
	private Homestay hs;
	private boolean bookingStatus;
	
	@Column(name = "BOOKINGSTATUS")
	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date bookingDate;
	
    @DateTimeFormat(pattern="dd/MM/yyyy") 
	private Date checkInDate;
	
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date checkOutDate;
    
	private double totalAmount;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @Column(name = "BOOKINGID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@ManyToOne
    @JoinColumn(name = "ROOMID")
	public Room getR() {
		return r;
	}

	public void setR(Room r) {
		this.r = r;
	}

	@ManyToOne
    @JoinColumn(name = "ACCOUNTID")
	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	@ManyToOne
    @JoinColumn(name = "HOMESTAYID")
	public Homestay getHs() {
		return hs;
	}

	public void setHs(Homestay hs) {
		this.hs = hs;
	}

	@JoinColumn(name = "BOOKINGDATE")
	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	@JoinColumn(name = "CHECKINDATE")
	public Date  getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	@JoinColumn(name = "CHECKOUTDATE")
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@JoinColumn(name = "TOTALAMOUNT")
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
