package com.test;

import java.sql.SQLException;
import java.util.List;

import com.elib.database.table.Book;
import com.elib.database.table.LibraryUser;
import com.elib.model.User;

public class Test {

	public static void main(String[] args) throws SQLException {
		LibraryUser user = new LibraryUser();
		
		LibraryUser.insertRecord("Last1", "First1", "l1.f1@gmail.com", "password", "1234567", "address", 0);
		LibraryUser.insertRecord("Last2", "First2", "l2.f2@gmail.com", "password", "1234567", "address", 0);
		LibraryUser.insertRecord("Last3", "First3", "l3.f3@gmail.com", "password", "1234567", "address", 0);
		LibraryUser.insertRecord("Last4", "First4", "l4.f4@gmail.com", "password", "1234567", "address", 0);
		LibraryUser.insertRecord("Last5", "First5", "l5.f5@gmail.com", "password", "1234567", "address", 0);
		
		
		//LibraryUser.deleteRecord(5);
		
		/*List<User> userDetails = LibraryUser.getUserDetails();
		
		for(User user1: userDetails) {
			System.out.println(user1);
		}*/
		
		//System.out.println(LibraryUser.getUserDetails(2));
		
		//LibraryUser.insertRecord("Jose", "Betssey", "betssyjose@gmail.com", "password", "1234567", "address", 1);
		
		/*List<User> userDetails = LibraryUser.getUserDetailsByLastName("Jo");
		
		for(User user1: userDetails) {
			System.out.println(user1);
		}*/
		
		/*List<User> userDetails = LibraryUser.getUserDetailsByEmail("betssyjose@gmail.com");
		
		for(User user1: userDetails) {
			System.out.println(user1);
		}*/
		
		/*
		Book.insertRecord("Book1", "Author1", "Publisher1");
		Book.insertRecord("Book2", "Author2", "Publisher2");
		Book.insertRecord("Book3", "Author3", "Publisher3");
		Book.insertRecord("Book4", "Author4", "Publisher4"); */
		
		/*List<com.elib.model.Book> bookDetails = Book.getBookDetails();
		for(com.elib.model.Book book: bookDetails) {
			System.out.println(book);
		}*/
		
		//System.out.println(Book.getBookDetails(5));
		
//		System.out.println();
		
		//Book.issueBook(2, 8);
		
		//Book.returnBook(8);
		//System.out.println(Book.getBookDetailsByName("ok"));
		
		
		
		

	}

}
