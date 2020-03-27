package com.kayafirat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kayafirat.model.User;
import com.kayafirat.repository.BookRepository;
import com.kayafirat.repository.UserRepository;
import com.kayafirat.service.MailService;

@Controller
public class ViewController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	
	@RequestMapping(value = {"","/","/home"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String home() {
		return "/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("email") String email,@RequestParam("password")String password) throws Exception {
		
		if(userRepo.findByUsername(email) == null) {
			userRepo.save(new User(email,password));
			MailService mailService = new MailService(email,userRepo.findByUsername(email).getToken());
			mailService.sendMail();
			return "/login";
		}
		return "/register";
	}
	@RequestMapping(value = "/main",method = RequestMethod.POST)
	public String main() {
		return "/main";
	}
	
	@RequestMapping(value = "/main",method = RequestMethod.GET)
	public String main(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("users", userRepo.findByUsername(authentication.getName()));
		return "/main";
	}
	
	@RequestMapping(value = "/confirm", method = {RequestMethod.GET, RequestMethod.POST})
	public String confirm(@RequestParam("token") String token) {
		userRepo.findByToken(token).setVerification(true);
		userRepo.save(userRepo.findByToken(token));
		return "/login";
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout() {
		return "/logout";
	}
	
	
	@RequestMapping(value = "/books",method = RequestMethod.POST)
	public String books(Model model) {
		model.addAttribute("books",bookRepo.findAll());
		return "/books";
	}
	@RequestMapping(value = "/books",method = RequestMethod.GET)
	public String books() {
		return "/books";
	}
	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public String users(Model model) {
		model.addAttribute("users",userRepo.findAll());
		return "/users";
	}
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public String users() {
		return "/users";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
