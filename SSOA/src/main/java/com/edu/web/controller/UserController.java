package com.edu.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.domain.User;
import com.edu.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login.do",method= {RequestMethod.POST})
	public String login(String no,String password,HttpSession session,HttpServletResponse resp) {
		User user = service.queryByNo(no, password);
		if(user!=null) {
			session.setAttribute("user", user);
			Cookie cookie = new Cookie("user", user.getNo());
			cookie.setMaxAge(-1);
			resp.addCookie(cookie);
			return "index";
		}else {
			return "login";
		}
	}
	
	
	@RequestMapping("/loginout.do")
	public String loginout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	
}
