package com.quocbn.dao;

import java.util.List;

import com.quocbn.model.HomestayImage;

public interface HomestayImageDAO {
	public List<HomestayImage> listAll();
	public List<HomestayImage> listImageByHomestayId(int homestayId);
	public void addImage(HomestayImage image);
	public HomestayImage findHomestayImage(int imageId);
	public void updateHomestayImage(HomestayImage image);
	public void deteteHomestayImage(int homestayImageId);
}
