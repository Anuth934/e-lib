package com.elib.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elib.model.User;


public class RegistrationEmailSender {
	
	private static final long serialVersionUID = 1L;

	public static void sendMail(HttpServletRequest req, HttpServletResponse res, User user) {
		String subject = "Registration with e-Lib Successful";
		
		StringBuilder builder = new StringBuilder("Dear ");
		builder.append(user.getFirstName()).append(" ").append(user.getLastName()).append(",")
			.append("\n")
			.append("\n")
			.append("You registration with e-Lib is Successfull.")
			.append("\n")
			.append("\n")
			.append("You can now browse a wide variety of books available in our e-Lib.")
			.append("You can login using your email id and password and issue the books from your account. "
					+ "The books will be delivered to the address you have provided at the time of registration.")
			.append("\n")
			.append("\n")
			.append("Your password is : ").append(user.getPassword())
			.append("\n")
			.append("\n")
			.append("Happy Reading!!")
			.append("\n")
			.append("\n")
			.append("Thanks,")
			.append("\n")
			.append("Team e-Lib");
		
		String [] bccRecepients =new String[]{};
		
		String [] recepients =new String[]{user.getEmail()};
		
		new SendEmail().sendMail(recepients, bccRecepients, subject, builder.toString());
		
	}
	
}
