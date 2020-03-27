package com.kayafirat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kayafirat.model.Book;
import com.kayafirat.repository.BookRepository;
import com.kayafirat.repository.UserRepository;

@RestController()
@RequestMapping("api/v1")
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(path = "/{token}/book")
	public List<Book> getBook() {
		return bookRepo.findAll();
	}
	
	@GetMapping(path = "/{token}/book/{bookId}")
	public Book getBook(@PathVariable("token") String token, @PathVariable("bookId") long userId) {
		if(userRepo.findByToken(token) != null) {
		return bookRepo.findById(userId);
		}
		
		return null;
	}
	
	@PostMapping(path = "/{token}/book")
	public Book addBook(@PathVariable("token") String token,@RequestBody Book book) {
		if(userRepo.findByToken(token) != null) {
			return bookRepo.save(book);
			}
		return null;
	}
	
	@PutMapping(path = "/{token}/book")
	public Book updateBook(@PathVariable("token") String token,@RequestBody Book book) {
		if(userRepo.findByToken(token) != null) {
			return bookRepo.save(book);
			}
		return null;
	}
	
	@DeleteMapping(path = "/{token}/book/{bookId}")
	public List<Book> deleteBook(@PathVariable("token") String token,@PathVariable("bookId") long bookId) {
		if(userRepo.findByToken(token) != null) 
			bookRepo.deleteById(bookId);
			
		return bookRepo.findAll();
	}
	
}