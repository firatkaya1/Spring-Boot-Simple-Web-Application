package com.kayafirat.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kayafirat.model.User;
import com.kayafirat.repository.UserRepository;

@RestController()
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping(path = "/{token}/user")
	public List<User> getUser(@PathVariable("token") String token) {
		if(userRepo.findByToken(token) != null) {
			return userRepo.findAll();
		}
		return null;
	}
	
	@GetMapping(path = "/{token}/user/{userId}")
	public User getUser(@PathVariable("token") String token,@PathVariable("userId") long userId) {
		if(userRepo.findByToken(token) != null) {
			return userRepo.findById(userId);
		}
		return null;
	}
	
	@PostMapping(path = "/{token}/user")
	public User addUser(@PathVariable("token") String token,@RequestBody User user) {
		if(userRepo.findByToken(token) != null) {
			user.setToken(UUID.randomUUID().toString());
			return userRepo.save(user);
		}
		return null;
	}
	
	@PutMapping(path = "/{token}/user")
	public User updateUser(@PathVariable("token") String token,@RequestBody User user) {
		if(userRepo.findByToken(token) != null) {
			return userRepo.save(user);
		}
		return null;
	}
	
	@DeleteMapping(path = "/{token}/user/{userId}")
	public void deleteUser(@PathVariable("token") String token,@PathVariable("userId") long userId) {
		if(userRepo.findByToken(token)!=null) {
			userRepo.deleteById(userId);
		}
		
	}
	
}

