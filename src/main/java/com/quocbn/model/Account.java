package com.quocbn.model;

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

import com.quocbn.model.Homestay;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
	private int accountId;
	private String userName;
	private String passWord;
	private String confirmPassword;
	private String fullName;
	private String imageUrl;
	private String emailAddress;
	private String phoneNumber;
	private String placeOfBirth;
	private String dateOfBirth;
	private boolean isEnabled;
	private String gender;
	private Role roles;
	private Set<Homestay> homestays;
	private Set<Booking> booking;
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "acc", cascade = CascadeType.ALL)
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(mappedBy = "acc", cascade = CascadeType.ALL)
	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	@Column(name = "PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "PLACEOFBIRTH")
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	@Column(name = "DATEOFBIRTH")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Account(){
	}
	
	@OneToMany(mappedBy = "acc", cascade = CascadeType.ALL)
	public Set<Homestay> getHomestays() {
		return homestays;
	}
	public void setHomestays(Set<Homestay> homestays) {
		this.homestays = homestays;
	}
	
	@Column(name = "CONFIRM_PASSWORD")
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD")
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Column(name = "FULLNAME")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Column(name = "IMAGEURL")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "EMAIL_ADDRESS")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Column(name = "ENABLED")
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	@ManyToOne
    @JoinColumn(name = "ROLE_ID")
	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}
}
