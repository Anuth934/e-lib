package com.elib.model;

import java.sql.Date;

public class Book {
	
	private int id;
	private String bookName;
	private String author;
	private String publisher;
	private int issuedMemberId;
	private boolean availble;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getIssuedMemberId() {
		return issuedMemberId;
	}
	public void setIssuedMemberId(int issuedMemberId) {
		this.issuedMemberId = issuedMemberId;
	}
	
	public boolean isAvailble() {
		return availble;
	}
	public void setAvailble(boolean availble) {
		this.availble = availble;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", publisher=" + publisher
				+ ", issuedMemberId=" + issuedMemberId + ", availble=" + availble + ", date=" + date + "]";
	}
	

}
