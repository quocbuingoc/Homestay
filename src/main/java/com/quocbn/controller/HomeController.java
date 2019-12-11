package com.quocbn.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.quocbn.dao.AccountDAO;
import com.quocbn.dao.BookingDAO;
import com.quocbn.dao.CommentDAO;
import com.quocbn.dao.HomestayDAO;
import com.quocbn.dao.HomestayImageDAO;
import com.quocbn.dao.HomestayTypeDAO;
import com.quocbn.dao.RoleDAO;
import com.quocbn.dao.RoomDAO;
import com.quocbn.model.Account;
import com.quocbn.model.Comment;
import com.quocbn.validator.AccountValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired(required=true)
	@Qualifier(value="homestayDao")
	private HomestayDAO homestayDao;
	
	@Autowired(required=true)
	@Qualifier(value="homestayImageDao")
	private HomestayImageDAO homestayImageDao;
	
	@Autowired(required=true)
	@Qualifier(value="roomDao")
	private RoomDAO roomDao;
	
	@Autowired(required = true)
	@Qualifier(value = "roleDao")
	private RoleDAO roleDao;
	
	@Autowired(required = true)
	@Qualifier(value = "accountDao")
	private AccountDAO accountDao;
	
	@Autowired(required = true)
	@Qualifier(value = "bookingDao")
	private BookingDAO bookingDao;
	
	@Autowired(required = true)
	@Qualifier(value = "commentDao")
	private CommentDAO commentDao;
	
	@Autowired(required=true)
	@Qualifier(value="homestayTypeDao")
	private HomestayTypeDAO homestayTypeDao;
	
	@Autowired
	private AccountValidator accountValidator;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model, Principal principal){
		
		String name = principal.getName();
		Account account = this.accountDao.findAccountByName(name);
		
		model.addAttribute("username", name);
		model.addAttribute("authority", account.getRoles().getRoleName());
		model.addAttribute("accountId", account.getAccountId());
		model.addAttribute("fullname", account.getFullName());
		model.addAttribute("email", account.getEmailAddress());
		model.addAttribute("imageUrl", account.getImageUrl());
		model.addAttribute("listHomestay", homestayDao.listAll());
		model.addAttribute("listAccount", this.accountDao.listHostAccount());
		model.addAttribute("countAcc", this.accountDao.listHostAccount().size());
		return "home/home";
	}
	
	
	@RequestMapping(value="/detail/homestay/{homestayId}&{username}")
	public ModelAndView detailHomestay(@PathVariable("homestayId") int homestayId, @PathVariable("username") String username){
		Account account = this.accountDao.findAccountByName(username);
		ModelAndView model = new ModelAndView("home/detailHomestay");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		model.addObject("username", account.getUserName());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("accountId", account.getAccountId());
		model.addObject("email", account.getEmailAddress());
		model.addObject("getDate", dateFormat.format(date));
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("listHomestayById", this.homestayDao.listHomestayByHomestayId(homestayId));
		model.addObject("listRoomByHomestayIdAndAvailable", this.roomDao.listRoomByHomestayIdAndAvailable(homestayId));
		model.addObject("listComment", this.commentDao.listCommentByHomestayId(homestayId));
		model.addObject("countComment", this.commentDao.listCommentByHomestayId(homestayId).size());
		model.addObject("homestayImages", this.homestayImageDao.listImageByHomestayId(homestayId));
		model.addObject("newComment", new Comment());
		return model;
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search(String cityName, @RequestParam String address, Principal principal){
		ModelAndView model = new ModelAndView("home/listSearch");
		String name = principal.getName();
		Account account = this.accountDao.findAccountByName(name);
		int count = homestayDao.searchByCityOrAddress(cityName, address).size();
		model.addObject("search", homestayDao.searchByCityOrAddress(cityName, address));
		model.addObject("countSearch",count);
		model.addObject("address",address);
		model.addObject("city",cityName);
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("username", name);
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("fullname", account.getFullName());
		model.addObject("listAccount", this.accountDao.listAll());
		model.addObject("listHomestay", homestayDao.listAll());
		model.addObject("countAcc", this.accountDao.listAll().size());
		return model;
	}
	
	@RequestMapping(value = "/getAddressList",method = RequestMethod.GET)
	@ResponseBody 
    public List<String> getAddressList(HttpServletRequest request) {
        List<String> addressList = homestayDao.listAddress(request.getParameter("term"));
        return addressList;
   }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		return "login/login";

	}

	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login/login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		model.addAttribute("logout", "true");
		return "login/login";

	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView("home/403");

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
			"You do not have permission to access this page!");
		}

		return model;

	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(){
		ModelAndView model = new ModelAndView("register/register");
		model.addObject("newAccount", new Account());
		model.addObject("listRole",this.roleDao.listAll());
		return model;
	}
	
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("newAccount") Account acc, BindingResult result,ModelMap model) {
		accountValidator.validate(acc, result);
		
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "register/register";
		} else {
			BCryptPasswordEncoder passEncode = new BCryptPasswordEncoder();
			String cryptedPass = passEncode.encode(acc.getPassWord());
			acc.setPassWord(cryptedPass);
			acc.setEnabled(true);
			acc.setImageUrl("default-user-avatar.png");
			this.accountDao.addAccount(acc);
			model.addAttribute("regisSuccess", "true");
			return "login/login";
		}
	}
	
}
