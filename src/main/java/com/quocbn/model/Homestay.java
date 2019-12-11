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
@Table(name = "HOMESTAYS")
public class Homestay {
	private int homestayId;
	private String homestayTitle;
	private String homestayCity;
	private String homestayAddress;
	private	String imageUrl;
	private String homestayAbout;
	private String homestayRule;
	private String homestaySmoke;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	private Date createdDate;
	
	private HomestayType type;
	private Account acc;
	private Set<Room> rooms;
	private Set<Booking> booking;
	private Set<Comment> comments;
	private Set<HomestayImage> hsImage;
	
	
	
	@OneToMany(mappedBy = "homestay", cascade = CascadeType.ALL)
	public Set<HomestayImage> getHsImage() {
		return hsImage;
	}
	public void setHsImage(Set<HomestayImage> hsImage) {
		this.hsImage = hsImage;
	}
	
	
	@OneToMany(mappedBy = "homestay", cascade = CascadeType.ALL)
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	@OneToMany(mappedBy = "hs", cascade = CascadeType.ALL)
	public Set<Booking> getBooking() {
		return booking;
	}
	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}
	
	@OneToMany(mappedBy = "homestay", cascade = CascadeType.ALL)
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	@ManyToOne
    @JoinColumn(name = "ACCOUNTID")
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	
	@Column(name = "createdDate")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne
    @JoinColumn(name = "HOMESTAYTYPEID")
	public HomestayType getType() {
		return type;
	}
	public void setType(HomestayType type) {
		this.type = type;
	}
	
	@Id
    @Column(name = "HOMESTAYID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getHomestayId() {
		return homestayId;
	}
	public void setHomestayId(int homestayId) {
		this.homestayId = homestayId;
	}
	@Column(name = "HOMESTAYTITLE")
	public String getHomestayTitle() {
		return homestayTitle;
	}
	public void setHomestayTitle(String homestayTitle) {
		this.homestayTitle = homestayTitle;
	}
	
	@Column(name = "HOMESTAYCITY")
	public String getHomestayCity() {
		return homestayCity;
	}
	
	public void setHomestayCity(String homestayCity) {
		this.homestayCity = homestayCity;
	}
	
	@Column(name = "HOMESTAYADDRESS")
	public String getHomestayAddress() {
		return homestayAddress;
	}
	public void setHomestayAddress(String homestayAddress) {
		this.homestayAddress = homestayAddress;
	}
	
	@Column(name = "IMAGEURL")
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	@Column(name = "HOMESTAYABOUT")
	public String getHomestayAbout() {
		return homestayAbout;
	}
	public void setHomestayAbout(String homestayAbout) {
		this.homestayAbout = homestayAbout;
	}
	
	@Column(name = "HOMESTAYRULE")
	public String getHomestayRule() {
		return homestayRule;
	}
	public void setHomestayRule(String homestayRule) {
		this.homestayRule = homestayRule;
	}
	
	@Column(name = "SMOKEOPTION")
	public String getHomestaySmoke() {
		return homestaySmoke;
	}
	public void setHomestaySmoke(String homestaySmoke) {
		this.homestaySmoke = homestaySmoke;
	}
	
	

	
	
}
