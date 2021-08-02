package com.elib.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.LibraryUser;
import com.elib.model.User;

@WebServlet(urlPatterns = "/admin/members")
public class ListMembersServlet extends HttpServlet{
	
	//Fetch all the details of members and keep it in the session
	
	private static final long serialVersionUID = 1L;

	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {
			String lastName = req.getParameter("lastname");
			String id = req.getParameter("id");
			
			boolean searchUsingLastName = (lastName != null && !lastName.isBlank());
			boolean searchUsingId = (id != null && !id.isBlank());
			
			if(searchUsingId) {
				User userDetail = LibraryUser.getUserDetails(Integer.valueOf(id));
				req.getSession().setAttribute("userById", userDetail);
				res.sendRedirect(req.getContextPath() + "/admin/SingleUserDetails.jsp");
				//redirect
				
			} else if(searchUsingLastName) {
				List<User> userDetailsByLastName = LibraryUser.getUserDetailsByLastName(lastName);
				req.getSession().setAttribute("userDetails", userDetailsByLastName);
				//redirect to member list page
				res.sendRedirect(req.getContextPath() + "/admin/members.jsp");
				
			} else {
				List<User> userDetails = LibraryUser.getUserDetails();
				req.getSession().setAttribute("userDetails", userDetails);
				//redirect to single member details page
				res.sendRedirect(req.getContextPath() + "/admin/members.jsp");
				
			}
		} catch (Exception e) {
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
