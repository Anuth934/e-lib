/**
 * 
 */
package com.elib.servlets;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.LibraryUser;
import com.elib.model.User;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;



/**
 * @author Anuth,Reeja,Ashish,Akhila,Reshma
 *
 */

@WebServlet(urlPatterns = "/admin/registernewuser")
public class Registration extends HttpServlet {
	
	  private static final long serialVersionUID = 1L;

	/**
	 *Gets values from HTML and redirects to welcome page and displays the values
	 * @param req - request parameter
	 * @param res - response parameter
	 * @throws ServletException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void doMethod(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, 
	ClassNotFoundException, SQLException
	{
		res.setContentType("text/html"); 
    	PrintWriter out = res.getWriter();
    	
    	User user = new User();

    	user.setFirstName(req.getParameter("firstname"));
    	user.setLastName(req.getParameter("lastname"));
    	user.setPhoneNumber(req.getParameter("phone"));
    	user.setAddress(req.getParameter("address"));
    	user.setEmail(req.getParameter("email"));
    	user.setPassword(req.getParameter("password"));
    	user.setUserType(0);
    	String repass = req.getParameter("repassword");
		
		//Validation password and retype password should be same
	if(!user.getPassword().equals(repass))
	{
		out.print("<span style='color:red;'>Sorry, your passwords are not same. Please try again.</span>");
		RequestDispatcher requestDispatcher = 
				req.getRequestDispatcher("/register.jsp");
		
		requestDispatcher.include(req, res);
	}
	//Redirecting to Welcome page and displaying result
	else
	{
		
		LibraryUser.insertRecord(user);
		
		EmailSender.sendMail(req, res, user);
		
		res.sendRedirect(req.getContextPath() + "/admin/members");
	}
		


	}	
	
	/**
	 *Get method overridden from HttpServlet class. It's called when action is get
	 *@param req - request parameter
	 *@param res - response parameter
	 * @throws ServletException 
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		System.out.println("doget");
		try {
			doMethod(req, res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *Post method overridden from HttpServlet class. It's called when action is post
	 *@param req - request parameter
	 *@param res - response parameter
	 * @throws ServletException 
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		try {
			doMethod(req, res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
