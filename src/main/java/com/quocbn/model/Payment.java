package com.quocbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENTS")
public class Payment {
	
	private int paymentId;
	private int bookingId;
	private double totalAmount;
	private boolean paymentStatus;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @Column(name = "PAYMENTID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	@Column(name = "BOOKINGID")
	public int getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	@Column(name = "TOTALAMOUNT")
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "PAYMENTSTATUS")
	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
}
