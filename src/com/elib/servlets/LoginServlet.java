package com.elib.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.LibraryUser;
import com.elib.model.User;

@WebServlet(urlPatterns = {"/admin/login", "/user/login"})
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doMethod(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//user name is the users email id. So need to fetch details from DB 
		User user = LibraryUser.getUserDetailsByEmail(username);
		
		if(user != null) {
			if(user.getPassword().equals(password)) {
				req.getSession().setAttribute("user", user);
				
				if(user.isAdmin()) {
					res.sendRedirect(req.getContextPath() + "/admin/welcome.jsp"); //admin login page
				} else {
					res.sendRedirect(req.getContextPath() + "/user/welcome.jsp"); //member login page
				}
			} else {
				if(user.isAdmin()) {
					res.sendRedirect("Error.jsp"); //admin login page error page
				} else {
					res.sendRedirect("Error.jsp"); //member login page error page
				}
			}
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
