package com.quocbn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quocbn.dao.AccountDAO;

@Controller
public class AdminController {
	
	@Autowired(required = true)
	@Qualifier(value = "accountDao")
	private AccountDAO accountDao;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String adminPage(ModelMap model){
		model.addAttribute("listAccount", this.accountDao.listAll());
		return "admin/admin";
	}
}
