package com.elib.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.database.table.LibraryUser;
import com.elib.model.User;

@WebServlet(urlPatterns = "/admin/modifyMember")
public class UpdateMemberDetailsServlet extends HttpServlet {
	
	private void doMethod(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.setContentType("text/html"); 
			PrintWriter out = res.getWriter();
			
			User user = new User();

			user.setFirstName(req.getParameter("firstname"));
			user.setLastName(req.getParameter("lastname"));
			user.setPhoneNumber(req.getParameter("phone"));
			user.setAddress(req.getParameter("address"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setId(Integer.valueOf(req.getParameter("id")));
			user.setUserType(0);
			String repass = req.getParameter("repassword");
			
			//Validation password and retype password should be same
			if(!user.getPassword().equals(repass)) {
						out.print("<span style='color:red;'>Sorry, your passwords are not same. Please try again.</span>");
						RequestDispatcher requestDispatcher = 
								req.getRequestDispatcher("/register.jsp");
						
						requestDispatcher.include(req, res);
			}
			//Redirecting to Welcome page and displaying result
			else {
						
						LibraryUser.updateRecord(user);
						
						//EmailSender.sendMail(req, res, user);
						
						res.sendRedirect(req.getContextPath() + "/admin/members");
			}
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
