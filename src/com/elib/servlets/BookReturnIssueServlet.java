package com.elib.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
				
				JOptionPane.showMessageDialog(null,
						"The request to return the book '"+req.getParameter("bookName")+"' has been recorded. The book will be picked up from your address in 2-3 business days.");
				
			} else if("issue".equals(action) && user != null) {
				Book.issueBook(user.getId(), Integer.valueOf(bookId));
				
				JOptionPane.showMessageDialog(null,
						"The book '"+req.getParameter("bookName")+"' has been successfully issued. The book will be delivered to your address in 5-10 business days.");
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
