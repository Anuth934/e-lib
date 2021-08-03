package com.elib.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/admin/logout", "/user/logout"})
public class Logout extends HttpServlet {
	
	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession session = req.getSession(false);
			if (req.isRequestedSessionIdValid() && session != null) {
			session.invalidate();
			}
			handleLogOutResponse(req, res);
			
			res.sendRedirect(req.getContextPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void handleLogOutResponse(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setValue(null);
			cookie.setPath("/");
			res.addCookie(cookie);
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
