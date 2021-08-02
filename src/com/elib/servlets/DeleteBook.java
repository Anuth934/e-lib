package com.elib.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.Book;

@WebServlet(urlPatterns = "/admin/delete/book")
public class DeleteBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {
			String id = req.getParameter("id");
			
			if(id != null && !id.isBlank()) {
				Book.deleteBook(Integer.valueOf(id));
				res.sendRedirect(req.getContextPath()+"/admin/books"); 
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
