package com.quocbn.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.quocbn.dao.AccountDAO;
import com.quocbn.dao.BookingDAO;
import com.quocbn.dao.HomestayDAO;
import com.quocbn.dao.HomestayImageDAO;
import com.quocbn.dao.HomestayTypeDAO;
import com.quocbn.dao.PaymentDAO;
import com.quocbn.dao.RoleDAO;
import com.quocbn.dao.RoomDAO;
import com.quocbn.dao.RoomTypeDAO;
import com.quocbn.model.Account;
import com.quocbn.model.Booking;
import com.quocbn.model.Homestay;
import com.quocbn.model.HomestayImage;
import com.quocbn.model.Payment;
import com.quocbn.model.Room;

@Controller
public class HostController {

	@Autowired(required = true)
	@Qualifier(value = "accountDao")
	private AccountDAO accountDao;

	@Autowired(required = true)
	@Qualifier(value = "homestayDao")
	private HomestayDAO homestayDao;
	
	@Autowired(required = true)
	@Qualifier(value = "homestayImageDao")
	private HomestayImageDAO homestayImageDao;
	
	@Autowired(required = true)
	@Qualifier(value = "paymentDao")
	private PaymentDAO paymentDao;
	
	@Autowired(required = true)
	@Qualifier(value = "bookingDao")
	private BookingDAO bookingDao;

	@Autowired(required = true)
	@Qualifier(value = "roomDao")
	private RoomDAO roomDao;

	@Autowired(required = true)
	@Qualifier(value = "roleDao")
	private RoleDAO roleDao;

	@Autowired(required = true)
	@Qualifier(value = "homestayTypeDao")
	private HomestayTypeDAO homestayTypeDao;

	@Autowired(required = true)
	@Qualifier(value = "roomTypeDao")
	private RoomTypeDAO roomTypeDao;

	@RequestMapping(value = "/host/{username}")
	public ModelAndView host(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("host/host");
		Account account = this.accountDao.findAccountByName(username);
		//Homestay hs = this.homestayDao.findHomestayByAccountId(account.getAccountId());
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("phone", account.getPhoneNumber());
		model.addObject("HomeType", homestayTypeDao.listAll());
		model.addObject("accountId", account.getAccountId());
		model.addObject("listHomestay", this.homestayDao.listHomestayById(account.getAccountId()));
		//model.addObject("homestayId", hs.getHomestayId());
		return model;
	}

	// Homestay Management
	@RequestMapping(value = "/host/homestay/{username}")
	public ModelAndView hostHomestay(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("homestay/homestay");
		Account account = this.accountDao.findAccountByName(username);
		//Homestay hs = this.homestayDao.findHomestayByAccountId(account.getAccountId());
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("accountId", account.getAccountId());
		model.addObject("listHomestay", this.homestayDao.listHomestayById(account.getAccountId()));
		//model.addObject("homestayId", hs.getHomestayId());
		return model;
	}

	@RequestMapping(value = "/host/create/homestay/{username}")
	public ModelAndView createHomestay(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("homestay/newHomestay");
		Account account = this.accountDao.findAccountByName(username);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		model.addObject("newHome", new Homestay());
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("getDate", dateFormat.format(date));
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("HomeType", homestayTypeDao.listAll());
		model.addObject("accountId", account.getAccountId());
		model.addObject("listHomestay", this.homestayDao.listHomestayById(account.getAccountId()));
		return model;
	}

	@RequestMapping(value = "/host/add/homestay/{username}", method = RequestMethod.POST)
	public String addHomestay(@ModelAttribute Homestay hs, ModelMap model, @PathVariable("username") String username,
			@RequestParam("imageUpload") CommonsMultipartFile[] imageUpload) throws Exception {
		Account account = this.accountDao.findAccountByName(username);
		model.addAttribute("username", account.getUserName());
		/* RedirectView redirectView = new RedirectView(); */

		if (imageUpload != null && imageUpload.length > 0) {
			for (CommonsMultipartFile aFile : imageUpload) {
				String filePath = "D:\\JAVA\\FinalProject\\src\\main\\webapp\\resources\\images\\homestay\\";
				try {
					if (!aFile.getOriginalFilename().equals("")) {
						aFile.transferTo(new File(filePath + aFile.getOriginalFilename()));
						hs.setImageUrl(aFile.getOriginalFilename());

					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		homestayDao.addHomestay(hs);
		return "redirect:/host/homestay/{username}";
	}

	@RequestMapping(value = "/host/edit/homestay/{username}&{homestayId}")
	public ModelAndView editHomestay(@PathVariable("homestayId") int homestayId,
			@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("homestay/editHomestay");
		Account account = this.accountDao.findAccountByName(username);
		model.addObject("editHome", this.homestayDao.findHomestayById(homestayId));
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("typeHome", homestayTypeDao.listAll());
		model.addObject("accountId", account.getAccountId());
		return model;
	}

	@RequestMapping(value = "/host/update/homestay/{username}&{homestayId}", method = RequestMethod.POST)
	public String updateHomestay(@ModelAttribute Homestay hs, ModelMap model,
			@RequestParam("imageUpload") CommonsMultipartFile[] imageUpload, @PathVariable("homestayId") int homestayId,
			@PathVariable("username") String username) {
		Account account = this.accountDao.findAccountByName(username);
		model.addAttribute("username", account.getUserName());

		if (imageUpload != null && imageUpload.length > 0) {
			for (CommonsMultipartFile aFile : imageUpload) {
				String filePath = "D:\\JAVA\\FinalProject\\src\\main\\webapp\\resources\\images\\homestay\\";
				try {
					if (!aFile.getOriginalFilename().equals("")) {
						aFile.transferTo(new File(filePath + aFile.getOriginalFilename()));
						hs.setImageUrl(aFile.getOriginalFilename());
						this.homestayDao.updateHomestay(hs);
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		this.homestayDao.updateHomestay(hs);
		return "redirect:/host/homestay/{username}";
	}

	@RequestMapping(value = "/host/delete/homestay/{username}&{homestayId}")
	public String deleteHomestay(@PathVariable("homestayId") int homestayId, ModelMap model,
			@PathVariable("username") String username) {
		Account account = this.accountDao.findAccountByName(username);
		model.addAttribute("username", account.getUserName());
		this.homestayDao.deleteHomestay(homestayId);
		return "redirect:/host/homestay/{username}";
	}

	// Room Management
	@RequestMapping(value = "/host/room/{username}")
	public ModelAndView hostRoom(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("room/room");
		Account account = this.accountDao.findAccountByName(username);
		Homestay homestay = this.homestayDao.findHomestayByAccountId(account.getAccountId());
		model.addObject("homestayId", homestay.getHomestayId());
		model.addObject("listRoomByHomestayId", roomDao.listRoomByHomestayId(homestay.getHomestayId()));
		model.addObject("listHomestay", this.homestayDao.listHomestayById(account.getAccountId()));
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		return model;
	}

	@RequestMapping(value = "/host/create/room/{username}&{homestayId}")
	public ModelAndView createRoom(@PathVariable("username") String username,
			@PathVariable("homestayId") int homestayId) {
		ModelAndView model = new ModelAndView("room/newRoom");
		Account account = this.accountDao.findAccountByName(username);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		model.addObject("newRoom", new Room());
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("getDate", dateFormat.format(date));
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("email", account.getEmailAddress());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("homestayId", homestayId);
		model.addObject("roomType", this.roomTypeDao.listAll());
		return model;
	}
	
	

	@RequestMapping(value = "/host/add/room/{username}")
	public String addRoom(@ModelAttribute Room room, @PathVariable("username") String username, ModelMap model, @RequestParam("imageUpload") CommonsMultipartFile[] imageUpload) {
		Account account = this.accountDao.findAccountByName(username);
		model.addAttribute("username", account.getUserName());
		if (imageUpload != null && imageUpload.length > 0) {
			for (CommonsMultipartFile aFile : imageUpload) {
				String filePath = "D:\\JAVA\\FinalProject\\src\\main\\webapp\\resources\\images\\room\\";
				try {
					if (!aFile.getOriginalFilename().equals("")) {
						aFile.transferTo(new File(filePath + aFile.getOriginalFilename()));
						room.setImageUrl(aFile.getOriginalFilename());

					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		room.setRoomStatus("Available");
		this.roomDao.addRoom(room);
		return "redirect:/host/room/{username}";
	}

	@RequestMapping(value = "/host/edit/room/{username}&{roomId}")
	public ModelAndView editRoom(@PathVariable("roomId") int roomId, @PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("room/editRoom");
		Account account = this.accountDao.findAccountByName(username);
		model.addObject("editRoom", this.roomDao.findRoom(roomId));
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("roomType", this.roomTypeDao.listAll());
		return model;
	}

	@RequestMapping(value = "/host/update/room/{username}&{roomId}", method = RequestMethod.POST)
	public String updateRoom(@ModelAttribute Room room,@PathVariable("roomId") int roomId, @PathVariable("username") String username, ModelMap model, @RequestParam("imageUpload") CommonsMultipartFile[] imageUpload) {
		Account account = this.accountDao.findAccountByName(username);
		model.addAttribute("username", account.getUserName());
		
		if (imageUpload != null && imageUpload.length > 0) {
			for (CommonsMultipartFile aFile : imageUpload) {
				String filePath = "D:\\JAVA\\FinalProject\\src\\main\\webapp\\resources\\images\\room\\";
				try {
					if (!aFile.getOriginalFilename().equals("")) {
						aFile.transferTo(new File(filePath + aFile.getOriginalFilename()));
						room.setImageUrl(aFile.getOriginalFilename());
						this.roomDao.updateRoom(room);
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		this.roomDao.updateRoom(room);
		return "redirect:/host/room/{username}";

	}
	
	@RequestMapping(value="/host/booked/{username}")
	public ModelAndView listBooked(@PathVariable("username") String username){
		ModelAndView model = new ModelAndView("host/listBooking");
		Account account = this.accountDao.findAccountByName(username);
		Homestay homestay = this.homestayDao.findHomestayByAccountId(account.getAccountId());
		model.addObject("listBooking", this.bookingDao.listCartByHomestayId(homestay.getHomestayId()));
		model.addObject("listHomestay", this.homestayDao.listHomestayById(account.getAccountId()));
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("newPayment", new Payment());
		return model;
	}
	

	@RequestMapping(value="/checkin/{username}&{bookingId}&{roomId}")
	public String CheckIn(@ModelAttribute Booking bk, @ModelAttribute Room r, @PathVariable("username") String username, @PathVariable("bookingId") int bookingId, @PathVariable("roomId") int roomId){
		
		bk = this.bookingDao.findBookingById(bookingId);
		r = this.roomDao.findRoom(roomId);
		if(bk.isBookingStatus() == false){
			bk.setBookingStatus(true);
			this.bookingDao.updateCart(bk);
		}
		else {
			this.bookingDao.deleteCart(bookingId);
			r.setRoomStatus("Available");
			this.roomDao.updateRoom(r);
		}
		return "redirect:/host/booked/{username}";
	}
	
	@RequestMapping(value = "/host/homestay-image/{username}")
	public ModelAndView imageHomestay(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("moreimage/homestayImage");
		Account account = this.accountDao.findAccountByName(username);
		Homestay hs = this.homestayDao.findHomestayByAccountId(account.getAccountId());
		model.addObject("username", account.getUserName());
		model.addObject("fullname", account.getFullName());
		model.addObject("authority", account.getRoles().getRoleName());
		model.addObject("email", account.getEmailAddress());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("phone", account.getPhoneNumber());
		model.addObject("accountId", account.getAccountId());
		model.addObject("listImage", this.homestayImageDao.listImageByHomestayId(hs.getHomestayId()));
		model.addObject("homestayId", hs.getHomestayId());
		return model;
	}
	
	@RequestMapping(value = "/host/create/homestay-image/{username}&{homestayId}")
	public ModelAndView createHomestayImage(@PathVariable("username") String username,
			@PathVariable("homestayId") int homestayId) {
		ModelAndView model = new ModelAndView("moreimage/newImage");
		Account account = this.accountDao.findAccountByName(username);
		model.addObject("newImage", new HomestayImage());
		model.addObject("fullname", account.getFullName());
		model.addObject("imageUrl", account.getImageUrl());
		model.addObject("email", account.getEmailAddress());
		model.addObject("authority", account.getRoles().getRoleName());
		return model;
	}
	
	@RequestMapping(value = "/host/add/homestay-image/{username}")
	public String addHomestayImage(@ModelAttribute HomestayImage image, @PathVariable("username") String username, ModelMap model, @RequestParam("imageUpload") CommonsMultipartFile[] imageUpload) {
		Account account = this.accountDao.findAccountByName(username);
		if (imageUpload != null && imageUpload.length > 0) {
			for (CommonsMultipartFile aFile : imageUpload) {
				String filePath = "D:\\JAVA\\FinalProject\\src\\main\\webapp\\resources\\images\\homestay\\";
				try {
					if (!aFile.getOriginalFilename().equals("")) {
						aFile.transferTo(new File(filePath + aFile.getOriginalFilename()));
						image.setImageUrl(aFile.getOriginalFilename());

					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		this.homestayImageDao.addImage(image);
		return "redirect:/host/homestay-image/{username}";
	}
	
	@RequestMapping(value = "/host/edit/homestay-image/{username}&{imageId}&{homestayId}")
	public ModelAndView editHomestayImage(@PathVariable("username") String username,
			@PathVariable("imageId") int imageId, @PathVariable("homestayId") int homestayId) {
		ModelAndView model = new ModelAndView("moreimage/editImage");
		HomestayImage hsImage = this.homestayImageDao.findHomestayImage(imageId);
		Account account = this.accountDao.findAccountByName(username);
		model.addObject("editImage", this.homestayImageDao.findHomestayImage(imageId));
		model.addObject("fullname", account.getFullName());
		model.addObject("imageUrl", hsImage.getImageUrl());
		model.addObject("email", account.getEmailAddress());
		model.addObject("authority", account.getRoles().getRoleName());
		return model;
	}
	
	@RequestMapping(value = "/host/update/homestay-image/{username}")
	public String updateHomestayImage(@ModelAttribute HomestayImage image, @PathVariable("username") String username, ModelMap model, @RequestParam("imageUpload") CommonsMultipartFile[] imageUpload) {
		//Account account = this.accountDao.findAccountByName(username);
		if (imageUpload != null && imageUpload.length > 0) {
			for (CommonsMultipartFile aFile : imageUpload) {
				String filePath = "D:\\JAVA\\FinalProject\\src\\main\\webapp\\resources\\images\\homestay\\";
				try {
					if (!aFile.getOriginalFilename().equals("")) {
						aFile.transferTo(new File(filePath + aFile.getOriginalFilename()));
						image.setImageUrl(aFile.getOriginalFilename());
						this.homestayImageDao.updateHomestayImage(image);
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		this.homestayImageDao.updateHomestayImage(image);
		return "redirect:/host/homestay-image/{username}";
	}
	
	@RequestMapping(value = "/host/delete/homestay-image/{username}&{imageId}")
	public String deleteHomestayImage(@PathVariable("imageId") int imageId,
			@PathVariable("username") String username) {
		this.homestayImageDao.deteteHomestayImage(imageId);
		return "redirect:/host/homestay-image/{username}";
	}

}
