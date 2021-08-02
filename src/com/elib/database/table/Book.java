package com.elib.database.table;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.elib.database.connection.DBConnection;

public class Book {
	
	/**
	 * Method to insert book details
	 * id will be autogenerated in DB
	 * @param bookName
	 * @param author
	 * @param publisher
	 */
	public static void insertRecord(String bookName, String author, String publisher ) {
		
		try(Connection conn = DBConnection.dbConnection();
			PreparedStatement stmnt = conn.prepareStatement("insert into books (BookName, Author, Publisher) values(?,?,?)");) {
			
			stmnt.setString(1, bookName);
			stmnt.setString(2, author);
			stmnt.setString(3, publisher);
			stmnt.executeUpdate();
			System.out.println("inserted Succesfully");
			
		} catch (Exception e) {
			System.out.println("Could not insert values : ");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method to delete a book by id
	 * @param id
	 */
	public static void deleteBook(int id) {
		try(Connection conn = DBConnection.dbConnection();
				PreparedStatement stmt = conn.prepareStatement("delete from books where Bookid=?");) {
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Deleted Succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to fetch a book details using its id
	 * @param id
	 * @return
	 */
	
	public static com.elib.model.Book getBookDetails(int id) {
		try(Connection conn = DBConnection.dbConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from books where Bookid=?");) {
			stmt.setInt(1, id);
			
			ResultSet resultSet = stmt.executeQuery();
			com.elib.model.Book book = null;
			
			while(resultSet.next()) {
				book = mapBook(resultSet);
			}
			
			return book;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * Method to get all book details
	 * @return
	 */
	public static List<com.elib.model.Book> getBookDetails() {
		try(Connection conn = DBConnection.dbConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from books");) {
			
			List<com.elib.model.Book> books = new ArrayList<com.elib.model.Book>();
			
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				com.elib.model.Book book = mapBook(resultSet);
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Method to search a book by its name
	 * @param bookName
	 * @return
	 */
	public static List<com.elib.model.Book> getBookDetailsByName(String bookName) {
		try(Connection conn = DBConnection.dbConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from books where BookName like ? ");) {
			stmt.setString(1, "%" + bookName + "%");
			List<com.elib.model.Book> books = new ArrayList<com.elib.model.Book>();
			
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				com.elib.model.Book book = mapBook(resultSet);
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static com.elib.model.Book mapBook(ResultSet resultSet) throws SQLException {
		com.elib.model.Book book = new com.elib.model.Book();
		book.setId(resultSet.getInt("BookId"));
		book.setBookName(resultSet.getString("BookName"));
		book.setAuthor(resultSet.getString("Author"));
		book.setBookName(resultSet.getString("BookName"));
		book.setPublisher(resultSet.getString("Publisher"));
		book.setIssuedMemberId(resultSet.getInt("Issuedmemberid"));
		book.setDate(resultSet.getDate("Issueddate"));
		if(book.getIssuedMemberId() == 0 && book.getDate()== null) {
			book.setAvailble(true);
		} else {
			book.setAvailble(false);
		}
		return book;
	}
	
	/**
	 * Method to issue a book
	 * While issuing a book, it is upadated with member's is and issued date
	 * @param memberId
	 * @param bookId
	 * @return
	 */
	public static boolean issueBook(int memberId, int bookId) {
		try(Connection conn = DBConnection.dbConnection();
				PreparedStatement stmt = conn.prepareStatement("update books set Issuedmemberid=?, Issueddate=? where Bookid=?;");) {
			
			stmt.setInt(1, memberId);
			stmt.setDate(2, new Date(Calendar.getInstance().getTime().getTime()));
			stmt.setInt(3, bookId);
			stmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Method to return a book.
	 * while returning a book, the member details and issued date is cleared
	 * @param bookId
	 * @return
	 */
	
	public static boolean returnBook(int bookId) {
		try(Connection conn = DBConnection.dbConnection();
				PreparedStatement stmt = conn.prepareStatement("update books set Issuedmemberid=?, Issueddate=? where Bookid=?;");) {
			
			stmt.setNull(1, Types.INTEGER);
			stmt.setDate(2, null);
			stmt.setInt(3, bookId);
			stmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void returnAllBooksForCustomer(String id) {
		try(Connection conn = DBConnection.dbConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from books where Issuedmemberid=?");) {
			stmt.setInt(1, Integer.valueOf(id));
			List<com.elib.model.Book> books = new ArrayList<com.elib.model.Book>();
			
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				returnBook(resultSet.getInt("BookId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
