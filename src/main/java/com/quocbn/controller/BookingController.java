package com.quocbn.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quocbn.dao.AccountDAO;
import com.quocbn.dao.BookingDAO;
import com.quocbn.dao.HomestayDAO;
import com.quocbn.dao.RoomDAO;
import com.quocbn.model.Account;
import com.quocbn.model.Booking;
import com.quocbn.model.Homestay;
import com.quocbn.model.Room;

@Controller
public class BookingController {
	
	@Autowired(required=true)
	@Qualifier(value="roomDao")
	private RoomDAO roomDao;
	
	@Autowired(required=true)
	@Qualifier(value="accountDao")
	private AccountDAO accountDao;
	
	@Autowired(required=true)
	@Qualifier(value="bookingDao")
	private BookingDAO bookingDao;
	
	@Autowired(required=true)
	@Qualifier(value="homestayDao")
	private HomestayDAO homestayDao;
	
	@RequestMapping(value = "/booking/{homestayId}&{username}&{roomId}")
	public ModelAndView bookingPage(@PathVariable("homestayId") int homestayId,
			@PathVariable("username") String username, @PathVariable("roomId") int roomId) {
		
		ModelAndView model = new ModelAndView("booking/booking");
		Account account = this.accountDao.findAccountByName(username);
		Homestay hs = this.homestayDao.findHomestayById(homestayId);
		Room room = this.roomDao.findRoom(roomId);
		double roomPrice = room.getRoomType().getRoomPrice();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		model.addObject("price",roomPrice);
		model.addObject("newBooking", new Booking());
		model.addObject("HostName", hs.getAcc().getFullName());
		model.addObject("HsTitle", hs.getHomestayTitle());
		model.addObject("getDate", dateFormat.format(date));
		model.addObject("RoomNumber", room.getRoomNumber());
		model.addObject("AccountId", account.getAccountId());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		return model;
	}
	
	@RequestMapping(value="/booking/add/{roomId}",method=RequestMethod.POST)
	public String bookingSuccess(@ModelAttribute Booking bk,@ModelAttribute Room room,@PathVariable("roomId") int roomId){
		this.bookingDao.addCart(bk);
		room = this.roomDao.findRoom(roomId);
		room.setRoomStatus("Not Available");
		this.roomDao.updateRoom(room);
		return "booking/success";
	}
	
	@RequestMapping(value="booking/checkin")
	public String checkIn(){
		
		
		return "redirect:/host/booked/{username}";
	}
	
	@RequestMapping(value="/booking/delete/{bookingId}&{username}&{roomId}",method=RequestMethod.GET)
	public String deleteBooking(@PathVariable("bookingId") int bookingId,@PathVariable("username") String username,@PathVariable("roomId") int roomId,@ModelAttribute Room room){
		this.bookingDao.deleteCart(bookingId);
		room = this.roomDao.findRoom(roomId);
		room.setRoomStatus("Available");
		this.roomDao.updateRoom(room);
		return "redirect:/guest/{username}";
	}
	
	@RequestMapping(value="/downloadPdf/{bookingId}",method=RequestMethod.GET)
	public ModelAndView downloadPdf(@PathVariable("bookingId") int bookingId){
		Booking booking = this.bookingDao.findBookingById(bookingId);
		return new ModelAndView("pdfView","listBooking",booking);
	}
	
}
