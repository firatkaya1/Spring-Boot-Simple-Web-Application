package com.kayafirat.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "bookprice")
	private String bookprice;
	
	@Column(name = "bookname")
	private String bookname;
	
	@Column(name = "bookowner")
	private String bookowner;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "page")
	private long page;
	
	@Column(name = "number")
	private long number;
	
	public Book() {}

	public Book(String bookprice, String bookname, String bookowner, String publisher, long page, long number) {
		this.bookprice = bookprice;
		this.bookname = bookname;
		this.bookowner = bookowner;
		this.publisher = publisher;
		this.number = number;
	}

	public long getBookId() {
		return id;
	}

	public void setBookId(long id) {
		this.id = id;
	}

	public String getBookprice() {
		return bookprice;
	}

	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookowner() {
		return bookowner;
	}

	public void setBookowner(String bookowner) {
		this.bookowner = bookowner;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookprice=" + bookprice + ", bookname=" + bookname + ", bookowner=" + bookowner
				+ ", publisher=" + publisher + ", page=" + page + ", number=" + number + "]";
	}

	
	
}
