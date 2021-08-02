package com.elib.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.Book;
import com.elib.database.table.LibraryUser;

@WebServlet(urlPatterns = "/admin/delete")
public class DeleteMember extends HttpServlet{
	
	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {
			String id = req.getParameter("id");
			
			if(id != null && !id.isBlank()) {
				Book.returnAllBooksForCustomer(id);
				
				LibraryUser.deleteRecord(Integer.valueOf(id));
				res.sendRedirect(req.getContextPath()+"/admin/members"); 
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
