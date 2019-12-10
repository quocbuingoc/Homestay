package com.quocbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOREIMAGES")
public class HomestayImage {
	
	private int imageId;
	private String imageUrl;
	private Homestay homestay;
	private String sortOrder;
	private String imageStatus;
	
	@Column(name = "IMAGESTATUS")
	public String getImageStatus() {
		return imageStatus;
	}

	public void setImageStatus(String imageStatus) {
		this.imageStatus = imageStatus;
	}

	public HomestayImage() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @Column(name = "IMAGEID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

    @Column(name = "IMAGEURL")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@ManyToOne
    @JoinColumn(name = "HOMESTAYID")
	public Homestay getHomestay() {
		return homestay;
	}

	public void setHomestay(Homestay homestay) {
		this.homestay = homestay;
	}

	 @Column(name = "SORTORDER")
	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	
}
=======
package com.quocbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOREIMAGES")
public class HomestayImage {
	
	private int imageId;
	private String imageUrl;
	private Homestay homestay;
	private String sortOrder;
	private String imageStatus;
	
	@Column(name = "IMAGESTATUS")
	public String getImageStatus() {
		return imageStatus;
	}

	public void setImageStatus(String imageStatus) {
		this.imageStatus = imageStatus;
	}

	public HomestayImage() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @Column(name = "IMAGEID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

    @Column(name = "IMAGEURL")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@ManyToOne
    @JoinColumn(name = "HOMESTAYID")
	public Homestay getHomestay() {
		return homestay;
	}

	public void setHomestay(Homestay homestay) {
		this.homestay = homestay;
	}

	 @Column(name = "SORTORDER")
	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}
