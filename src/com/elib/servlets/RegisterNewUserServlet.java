package com.elib.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.LibraryUser;

//@WebServlet(urlPatterns = "/admin/registernewuser")
public class RegisterNewUserServlet extends HttpServlet {
	
	private void doMethod(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String countrycode = req.getParameter("countrycode");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		
		/*try {
			//LibraryUser.insertRecord(lastName, firstName, email, password, countrycode+phone, address, 0);
			
			res.sendRedirect(req.getContextPath() + "/admin/members");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		doMethod(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		doMethod(req, res);
	}
	
	

}
