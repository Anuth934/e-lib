package com.elib.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.Book;

@WebServlet(urlPatterns = "/admin/books")
public class ListBooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void doMethod(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String bookName = req.getParameter("bookName");
		String bookId = req.getParameter("id");
		
		boolean searchBookName = (bookName != null && !bookName.isBlank());
		boolean searchUsingId = (bookId != null && !bookId.isBlank());
		
		if(searchUsingId) {
			com.elib.model.Book bookDetailsByID = Book.getBookDetails(Integer.valueOf(bookId));
			req.getSession().setAttribute("bookById", bookDetailsByID);
			res.sendRedirect(req.getContextPath() + "/admin/bookdetails.jsp");
			//redirect
			
		} else if(searchBookName) {
			List<com.elib.model.Book> bookDetailsByName = Book.getBookDetailsByName(bookName);
			req.getSession().setAttribute("bookDetails", bookDetailsByName);
			//redirect to member list page
			res.sendRedirect(req.getContextPath() + "/admin/books.jsp");
			
		} else {
			List<com.elib.model.Book> bookDetails = Book.getBookDetails();
			req.getSession().setAttribute("bookDetails", bookDetails);
			//redirect to member list page
			res.sendRedirect(req.getContextPath() + "/admin/books.jsp");
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