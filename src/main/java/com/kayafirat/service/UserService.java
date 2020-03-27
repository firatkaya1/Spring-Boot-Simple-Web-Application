package com.kayafirat.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kayafirat.model.User;
import com.kayafirat.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	UserRepository userRepository;
	
	public UserService(@Qualifier("userRepo") UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		User user = userRepository.findByUsername(username);
		
		
		if(null == user || !user.getUsername().equals(username)) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı." + username);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return new UserDetail(user);
		
	}

}
