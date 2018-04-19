package com.quocbn.dao;

import java.util.List;

import com.quocbn.model.RoomType;

public interface RoomTypeDAO {
	public List<RoomType> listAll();
	public void addRoomType(RoomType rt);
	public void deleteRoomType(int id);
	public RoomType findRoomType(int id);
	public void updateRoomType(RoomType rt);
}
