package com.elib.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.Book;
import com.elib.model.User;

@WebServlet(urlPatterns = "/user/action/book")
public class BookReturnIssueServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {
			String action = req.getParameter("action");
			String bookId = req.getParameter("bookId");
			User user = (User) req.getSession().getAttribute("user");
			
			if("return".equals(action)) {
				Book.returnBook(Integer.valueOf(bookId));
			} else if("issue".equals(action) && user != null) {
				Book.issueBook(user.getId(), Integer.valueOf(bookId));
			}
			
			res.sendRedirect(req.getContextPath() + "/user/books");
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
