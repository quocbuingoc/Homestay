package com.quocbn.dao;

import java.util.List;

import com.quocbn.model.Homestay;

public interface HomestayDAO {
	public List<Homestay> listAll();
	public void addHomestay(Homestay hs);
	public void deleteHomestay(int id);
	public Homestay findHomestayById(int id);
	public Homestay findHomestayByAccountId(int accountId);
	public void updateHomestay(Homestay hs);
	public List<Homestay> searchByCityOrAddress(String cityName, String address);
	List<Homestay> listHomestayById(int id);
	public List<String> listAddress(String term);
	public List<Homestay> listHomestayByHomestayId(int homestayId);
}
