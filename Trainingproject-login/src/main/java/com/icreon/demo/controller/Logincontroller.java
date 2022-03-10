package com.icreon.demo.controller;

import java.sql.SQLException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.icreon.demo.model.User;
import com.icreon.demo.repository.userDao;
import com.icreon.demo.service.Emailservice;
//import com.icreon.demo.service.Userservice;
import com.icreon.demo.service.Userservice;

@Controller
public class Logincontroller {
	Random random = new Random(1000);
	
	@Autowired
	private Emailservice emailservice;
	
	@Autowired
	userDao ud;
	
	@Autowired
	User u;
	
	@Autowired
	Userservice use;
//	@Autowired
//	Userservice userservice;
	
	
//	@PostMapping("/adduser")
//   
//	public String login(User u) throws SQLException {
////		ModelAndView modelAndView=new ModelAndView();
////		modelAndView.addObject("user",);
//		
////		User us=userservice.login(u.getUsername(),u.getPassword());
////		
////		if(u!=(us)) {
////			return "add.jsp";
////			
////		}else {
////			return "add.jsp";
////		}
//		
//		userDao ud=new userDao();
//	 
//		User user=new User();
//		user=ud.validateuser(user);
////		if(ud.validateuser(user)) {
////			return "add.jsp";
////		}else {
////			return "success.jsp";
////		}
//		if(user== null) {
//			return "add.jsp";
//		}else {
//			return"success.jsp";
//		}
		
	@GetMapping("/add")
	public String logIn(String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception   {
		
		
	
		u	= use.getUsersByEmailandPassword(username, password);
		

		
		if(u==null) {
			
			

			return "index.jsp";
		} else {
			
			return "success.jsp";

		}
	}
	
	@GetMapping("/forgot")
	public String openEmail() {
		
		
		return "forgotform.jsp";
		
		
	}
	
	@PostMapping("/sendOtp")
	public String send(@RequestParam("email")String email,HttpSession session) throws MessagingException {
		System.out.println("email"+email);
		
		
		
		int otp = random.nextInt(999999);
		System.out.println("otp"+otp);
		
		
		//code for send otp
		String subject="OTP FROM SYSTEM";
		String message="<h1>OTP="+otp+"</h1>";
		String to=email;
		
		
		
	boolean flag = this.emailservice.sendEmail(subject,message,to);
	if(flag) {
		return "changepass.jsp";
	}else {
	
	
		session.setAttribute("message","check your emailid");
		
		
		return "verifyotp.jsp";
		
	}
	

	}
	
	
}

