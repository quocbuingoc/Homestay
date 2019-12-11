package com.quocbn.dao;

import java.util.List;

import com.quocbn.model.Room;

public interface RoomDAO {
	public List<Room> listAll();
	public void addRoom(Room r);
	public void deleteRoom(int id);
	public Room findRoom(int id);
	public void updateRoom(Room r);
	public List<Room> listRoomByHomestayId(int homestayId);
	public List<Room> listRoomByHomestayIdAndAvailable(int homestayId);
}
