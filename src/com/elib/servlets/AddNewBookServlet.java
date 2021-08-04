package com.elib.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.model.Book;

@WebServlet(urlPatterns = "/admin/addNewBook")
public class AddNewBookServlet extends HttpServlet {

	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {
			Book book = new Book();
			book.setBookName(req.getParameter("bookName"));
			book.setAuthor(req.getParameter("author"));
			book.setPublisher(req.getParameter("publisher"));
			
			com.elib.database.table.Book.insertRecord(book.getBookName(), book.getAuthor(), book.getPublisher());
			
			res.sendRedirect(req.getContextPath() + "/admin/books");
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
