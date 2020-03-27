package com.kayafirat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kayafirat.model.Log;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {

	List<Log> findAll();
	
	Log findById(long id);
	
}
