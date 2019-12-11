package com.quocbn.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.quocbn.dao.AccountDAO;
import com.quocbn.model.Account;

@Controller
public class AccountController {
	
	@Autowired(required = true)
	@Qualifier(value = "accountDao")
	private AccountDAO accountDao;
	
	@RequestMapping(value="/account/setting/{username}")
	public ModelAndView account(@PathVariable("username") String username){
		ModelAndView model = new ModelAndView("account/Account");
		Account account = this.accountDao.findAccountByName(username);
		model.addObject("username",account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("listAccountByUsername", this.accountDao.listAccountByUsername(username));
		return model;
	}
	
	@RequestMapping(value="/account/edit/{username}")
	public ModelAndView edit(@PathVariable("username") String username){
		ModelAndView model = new ModelAndView("account/editAccount");
		Account account = this.accountDao.findAccountByName(username);
		//model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("editProfile", this.accountDao.findAccountByName(username));
		return model;
	}
	
	@RequestMapping(value="/account/update/{username}")
	public String update(@ModelAttribute Account acc,@PathVariable("username") String username, ModelMap model, @RequestParam("imageUpload") CommonsMultipartFile[] imageUpload){
		Account account = this.accountDao.findAccountByName(username);
		model.addAttribute("username", account.getUserName());
		
		if (imageUpload != null && imageUpload.length > 0) {
			for (CommonsMultipartFile aFile : imageUpload) {
				String filePath = "D:\\JAVA\\FinalProject\\src\\main\\webapp\\resources\\images\\avatar\\";
				try {
					if (!aFile.getOriginalFilename().equals("")) {
						aFile.transferTo(new File(filePath + aFile.getOriginalFilename()));
						acc.setImageUrl(aFile.getOriginalFilename());
						this.accountDao.updateAccount(acc);
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		this.accountDao.updateAccount(acc);
		return "redirect:/account/setting/{username}";
	}
}
