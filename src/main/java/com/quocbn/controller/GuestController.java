package com.quocbn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quocbn.dao.AccountDAO;
import com.quocbn.dao.BookingDAO;
import com.quocbn.dao.HomestayDAO;
import com.quocbn.dao.HomestayTypeDAO;
import com.quocbn.dao.RoleDAO;
import com.quocbn.model.Account;

@Controller
public class GuestController {

	@Autowired(required = true)
	@Qualifier(value = "accountDao")
	private AccountDAO accountDao;

	@Autowired(required = true)
	@Qualifier(value = "homestayDao")
	private HomestayDAO homestayDao;
	
	@Autowired(required = true)
	@Qualifier(value = "roleDao")
	private RoleDAO roleDao;
	
	@Autowired(required = true)
	@Qualifier(value = "bookingDao")
	private BookingDAO bookingDao;
	
	@Autowired(required=true)
	@Qualifier(value="homestayTypeDao")
	private HomestayTypeDAO homestayTypeDao;
	
	
	@RequestMapping(value = "/guest/{username}")
	public ModelAndView guest(@ModelAttribute("username") String username) {
		ModelAndView model = new ModelAndView("guest/guest");
		Account account = this.accountDao.findAccountByName(username);
		model.addObject("AccountL", account);
		model.addObject("username", account.getUserName());
		model.addObject("accountId", account.getAccountId());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("email", account.getEmailAddress());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("listBooking", this.bookingDao.listCartByAccountId(account.getAccountId()));
		return model;
	}
	
	
}
