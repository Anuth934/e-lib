package com.elib.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.LibraryUser;
import com.elib.model.User;

@WebServlet("/user/profile")
public class ProfileServlet extends HttpServlet {
	
	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		
		
		try {
			User user;
			if(req.getSession().getAttribute("user") != null) {
				user = (User) req.getSession().getAttribute("user");
				User userDetail = LibraryUser.getUserDetails(Integer.valueOf(user.getId()));
				req.getSession().setAttribute("profile", userDetail);
				res.sendRedirect(req.getContextPath() + "/user/profile.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
