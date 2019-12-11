package com.quocbn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROOMTYPES")
public class RoomType {
	private int roomTypeId;
	private String roomTypeName;
	private double roomPrice;
	private double roomDiscount;
	private String roomDescription;
	private Set<Room> rooms;
	
	@Id
    @Column(name = "ROOMETYPEID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	@Column(name = "ROOMTYPENAME")
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	@Column(name = "ROOMPRICE")
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	@Column(name = "ROOMDISCOUNT")
	public double getRoomDiscount() {
		return roomDiscount;
	}
	public void setRoomDiscount(double roomDiscount) {
		this.roomDiscount = roomDiscount;
	}
	@Column(name = "DESCRIPTION")
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	
	@OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	
}
