package com.mail.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mail.util.MailSender;


@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/mailTest")
	public String logout(Model model) throws MessagingException {
		MailSender m = new MailSender();
		model.addAttribute("result", "结束");
		return "result";
	}
	
	@RequestMapping("/sessionTest")
	public void getSession(HttpSession session){
		System.out.println(session.getAttribute("user"));
		session.setAttribute("user", "hehe1");
		System.out.println(session.getId());
	}
	
}
