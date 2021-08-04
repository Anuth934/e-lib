package com.elib.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.LibraryUser;
import com.elib.model.User;

@WebServlet(urlPatterns = {"/admin/login", "/user/login"})
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doMethod(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//user name is the users email id. So need to fetch details from DB 
		User user = LibraryUser.getUserDetailsByEmail(username);
		
		if(user != null && user.getPassword() != null && user.getPassword().equals(password)) {
			req.getSession().setAttribute("user", user);
			
			if(user.isAdmin()) {
				res.sendRedirect(req.getContextPath() + "/admin/welcome.jsp"); //admin login page
			} else {
				res.sendRedirect(req.getContextPath() + "/user/welcome.jsp"); //member login page
			}
		} else {
			req.setAttribute("errorMesssage", "Incorrect Login Details");
			if(user.isAdmin()) {
				req.getRequestDispatcher("/admin/login.jsp").forward(req,res);
			} else {
				req.getRequestDispatcher("/user/login.jsp").forward(req,res);
			}
		}
		
	}	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doMethod(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doMethod(req, res);
	}

}
