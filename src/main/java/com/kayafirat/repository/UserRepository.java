package com.kayafirat.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kayafirat.model.User;

@Repository("userRepo")
public interface UserRepository extends CrudRepository<User,Long>{
	
	User findById(long id);
	
	User findByUsername(String username);
	
	User findByToken(String token);
	
	List<User> findAll();
	
	

}
