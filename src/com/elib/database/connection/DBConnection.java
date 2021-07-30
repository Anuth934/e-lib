package com.elib.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection dbConnection() throws ClassNotFoundException, SQLException
	{
		Connection conn =null;
		
		Class.forName("com.mysql.jdbc.Driver");  
		conn= DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/elib","root","");  
		
		return conn;
	}

}
