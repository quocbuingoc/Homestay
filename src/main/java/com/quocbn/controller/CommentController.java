package com.quocbn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quocbn.dao.AccountDAO;
import com.quocbn.dao.CommentDAO;
import com.quocbn.dao.HomestayDAO;
import com.quocbn.model.Comment;

@Controller
public class CommentController {
	
	@Autowired(required=true)
	@Qualifier(value="homestayDao")
	private HomestayDAO homestayDao;
	
	@Autowired(required = true)
	@Qualifier(value = "accountDao")
	private AccountDAO accountDao;
	
	@Autowired(required = true)
	@Qualifier(value = "commentDao")
	private CommentDAO commentDao;
	
	
	@RequestMapping(value="/comment/add/{homestayId}&{username}",method=RequestMethod.POST)
	public String addComment(Comment cm,@PathVariable("homestayId") int homestayId,@PathVariable("username") String username){
		this.commentDao.addComment(cm);
		return "redirect:/detail/homestay/{homestayId}&{username}";
	}
	
	
}
