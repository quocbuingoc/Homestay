package com.quocbn.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ROOMS")
public class Room {
	private int roomId;
	private String roomNumber;
	private String imageUrl;
	private int	numberOfGuest;
	private String haveBathroom;
	private String roomDescription;
	private String roomStatus;
	private RoomType roomType;
	private Homestay homestay;
	private Set<Booking> booking;
	
	
	@OneToMany(mappedBy = "r", cascade = CascadeType.ALL)
	public Set<Booking> getBooking() {
		return booking;
	}
	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date createdDate;
	
	@Id
    @Column(name = "ROOMID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	@Column(name = "CREATEDDATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "ROOMNUMBER")
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	@Column(name = "IMAGEURL")
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Column(name = "NUMBEROFGUESTS")
	public int getNumberOfGuest() {
		return numberOfGuest;
	}
	public void setNumberOfGuest(int numberOfGuest) {
		this.numberOfGuest = numberOfGuest;
	}
	@Column(name = "HAVEBATHROOM")
	public String getHaveBathroom() {
		return haveBathroom;
	}
	public void setHaveBathroom(String haveBathroom) {
		this.haveBathroom = haveBathroom;
	}
	@Column(name = "ROOMDESCRIPTION")
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	@Column(name = "ROOMSTATUS")
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	@ManyToOne
    @JoinColumn(name = "ROOMTYPEID")
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	@ManyToOne
    @JoinColumn(name = "HOMESTAYID")
	public Homestay getHomestay() {
		return homestay;
	}
	public void setHomestay(Homestay homestay) {
		this.homestay = homestay;
	}
	
	
}
