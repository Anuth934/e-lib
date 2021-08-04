package com.elib.database.table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.elib.database.connection.DBConnection;
import com.elib.model.User;
public class LibraryUser {
	
	/**
	 * Method to insert USer details. ID will be set automatically in DB. 
	 * @param lastName
	 * @param firstName
	 * @param email
	 * @param password
	 * @param phoneNumber
	 * @param address
	 * @param userType
	 * @throws SQLException
	 */
	public static void insertRecord(User user) throws SQLException
	{
		try (Connection con = DBConnection.dbConnection();
				PreparedStatement stmt = con.prepareStatement("insert into libraryuser(LastName, FirstName,Emailid, Userpassword, Phonenumber, Address, Usertype) "
						+ "values(?,?,?,?,?,?,?)");) {
			
			stmt.setString(1, user.getLastName());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getPhoneNumber());
			stmt.setString(6, user.getAddress());
			stmt.setInt(7, user.getUserType());
			stmt.executeUpdate();
			System.out.println("inserted Succesfully");
		} catch(Exception e) {
			System.out.println("Some error : " + e);
		}
	}
	
	public static void updateRecord(User user) throws SQLException
	{
		try (Connection con = DBConnection.dbConnection();
				PreparedStatement stmt = con.prepareStatement("update libraryuser set LastName=?, FirstName=?, Emailid=?,"
						+ " Userpassword=?,  Phonenumber=?,  Address=?, Usertype=? where Userid=?");) {
			
			stmt.setString(1, user.getLastName());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getPhoneNumber());
			stmt.setString(6, user.getAddress());
			stmt.setInt(7, user.getUserType());
			stmt.setInt(8, user.getId());
			stmt.executeUpdate();
			System.out.println("updates Succesfully");
		} catch(Exception e) {
			System.out.println("Some error : " + e);
		}
	}
	
	/**
	 * Method to delete a user by passing the id
	 * @param id
	 * @throws SQLException
	 */
	public static void deleteRecord(int id) throws SQLException {
		
		try (Connection con = DBConnection.dbConnection();
			PreparedStatement stmt = con.prepareStatement("delete from libraryuser where Userid=?"); ){
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println("Deleted Succesfully");
		} catch(Exception e) {
			System.out.println("Some error : " + e);
		} 
		
	}
	
	/**
	 * Method to get the details of a single user using id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static User getUserDetails(int id) throws SQLException {
		
		try (Connection con = DBConnection.dbConnection();
				PreparedStatement stmt = con.prepareStatement("select * from libraryuser where Userid=?");) {
			
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			
			User user = new User();
			while(resultSet.next()){
				
				mapUser(resultSet, user);
				
			}
			
			return user;
			
		} catch(Exception e) {
			System.out.println("Some error : " + e);
			return null;
		} 
	}
	/**
	 * Method to get the details of all the users
	 * @return
	 * @throws SQLException
	 */
	public static List<User> getUserDetails() throws SQLException {
		
		PreparedStatement stmt = null;
		List<User> users = new ArrayList<User>();
		
		try (Connection con = DBConnection.dbConnection()) {
			stmt = con.prepareStatement("select * from libraryuser");
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				
				User user = new User();
				
				mapUser(resultSet, user);
				if(!user.isAdmin()) {
					users.add(user);
				}
		}
			
			return users;
			
		} catch(Exception e) {
			System.out.println("Some error : " + e);
			return null;
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {
				System.out.println("Some error : " + e);
			}
		}
		
	}
	
	/**
	 * Method to search users by their last name
	 * @param name
	 * @return
	 */
	public static List<User> getUserDetailsByLastName(String name) {
		
		PreparedStatement stmt = null;
		List<User> users = new ArrayList<User>();
		
		try (Connection con = DBConnection.dbConnection()) {
			stmt = con.prepareStatement("select * from libraryuser where LastName like ?");
			
			stmt.setString(1, "%" + name + "%");	
			
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				
				User user = new User();
				
				mapUser(resultSet, user);
				
				users.add(user);
			}
			
			return users;
			
		} catch(Exception e) {
			System.out.println("Some error : " + e);
			return null;
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {
				System.out.println("Some error : " + e);
			}
		}
		
	}
	
	/**
	 * Method to search users by their email
	 * @param name
	 * @return
	 */
	public static User getUserDetailsByEmail(String email) {
		
		PreparedStatement stmt = null;
		
		try (Connection con = DBConnection.dbConnection()) {
			stmt = con.prepareStatement("select * from libraryuser where Emailid=?");
			
			stmt.setString(1, email);	
			
			ResultSet resultSet = stmt.executeQuery();
			
			User user = new User();
			
			while(resultSet.next()){
				mapUser(resultSet, user);
			}
			
			return user;
			
		} catch(Exception e) {
			System.out.println("Some error : " + e);
			return null;
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {
				System.out.println("Some error : " + e);
			}
		}
		
	}
	
	
	
	/**
	 * Method to map the values from resultset to a user object
	 * @param resultSet
	 * @param user
	 * @throws SQLException
	 */
	private static void mapUser(ResultSet resultSet, User user) throws SQLException {
		user.setId(resultSet.getInt("Userid"));
		user.setLastName(resultSet.getString("LastName"));
		user.setFirstName(resultSet.getString("FirstName"));
		user.setEmail(resultSet.getString("Emailid"));
		user.setPassword(resultSet.getString("Userpassword"));
		user.setPhoneNumber(resultSet.getString("Phonenumber"));
		user.setAddress(resultSet.getString("Address"));
		user.setUserType(resultSet.getInt("Usertype"));
	}
}
