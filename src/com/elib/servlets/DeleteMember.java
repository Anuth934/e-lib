package com.elib.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.Book;
import com.elib.database.table.LibraryUser;
import com.elib.model.User;

@WebServlet(urlPatterns = "/admin/update")
public class DeleteMember extends HttpServlet{
	
	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {

			if (req.getParameter("update") != null) {
				//update button is clicked
				
				//member_update.jsp
				res.sendRedirect(req.getContextPath()+"/admin/member_update.jsp");

			} else if (req.getParameter("delete") != null) {
				//delete button is clicked
				String id = req.getParameter("id");
				
				if(id != null && !id.isBlank()) {
					Book.returnAllBooksForCustomer(id);
					
					LibraryUser.deleteRecord(Integer.valueOf(id));
					res.sendRedirect(req.getContextPath()+"/admin/members"); 
				}
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
