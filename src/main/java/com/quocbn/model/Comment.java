package com.quocbn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "COMMENTS")
public class Comment {
	private int commentId;
	private String textContent;
	private Date timeStamp;
	private String commentStatus;
	
	private Account acc;
	private Homestay homestay;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @Column(name = "COMMENTID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	@Column(name = "TEXTCONTENT")
	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	
	@Column(name = "TIMESTAMP")
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Column(name = "COMMENTSTATUS")
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	
	@ManyToOne
    @JoinColumn(name = "ACCOUNTID")
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
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
