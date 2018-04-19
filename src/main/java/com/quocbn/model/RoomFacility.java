package com.quocbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOMFACILITES")
public class RoomFacility {
	private int roomFacilityId;
	private String roomFacilityName;
	private String roomFacilityStatus;

	@Id
    @Column(name = "ROOMFACILITYID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRoomFacilityId() {
		return roomFacilityId;
	}

	public void setRoomFacilityId(int roomFacilityId) {
		this.roomFacilityId = roomFacilityId;
	}

	@Column(name = "ROOMFACILITYNAME")
	public String getRoomFacilityName() {
		return roomFacilityName;
	}

	public void setRoomFacilityName(String roomFacilityName) {
		this.roomFacilityName = roomFacilityName;
	}

	@Column(name = "ROOMFACILITYSTATUS")
	public String getRoomFacilityStatus() {
		return roomFacilityStatus;
	}

	public void setRoomFacilityStatus(String roomFacilityStatus) {
		this.roomFacilityStatus = roomFacilityStatus;
	}

}
