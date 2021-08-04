<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elib-library management system</title>
<link href="../Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@include file="menuheader.jsp" %>
<div id="templatemo_content">

	
    

			
          <%--   <h2>AskQuestions</h2>
            
            <form action="www.javatpoint.com" method="get">
            <label>Please enter your email address to ask or post java Question Answer.</label>
            <input type="text" value="" name="username" size="10" id="input_field" title="usernmae" />
            <input type="submit" name="login" value="Ask" alt="login" id="submit_btn" title="Login" />
            </form>--%>
            
    
     <div id="content_box">

        	<c:set var="context" value="${pageContext.request.contextPath}" />
        
        <div class="content_box">
        
        	<h2>About Us</h2><br>
            
		<p>This is a Library Management System application developed for Java Project for the course
		 Java programming II having course ID 2021S_MAD 4463_1. Our instructor is Simrandeep Kaur. 
		 This application has all basic functionalities of a library system. An Admin has absolute
		 authority in this web site. Admin can add/delete books, add/update/delete subscribed member details. 
		 Upon user registration by admin, user will receive an email confirmation and password along with it.
		 User can login using the email and password and can issue or return issued books.</p>
         
         <p>The is a team project and the members who contributed to create this application are:
     		</p> 
<br>
     		<p>Akhila Jose - C0797217</p> 
     		<p>Anuth Karithalackal Asokan - C0808934</p> 
     		<p>Reeja Robert - C0806169</p> 
     		<p>Reshma Mary Johns - C0805242</p> 
        
        	<div class="cleaner"></div>
        </div><div class="content_box_bottom"></div>
    
    </div> <!-- end of content -->
    
    <div class="cleaner"></div>

</div>

<div id="templatemo_footer_wrapper">

    <div id="templatemo_footer">
    
        <ul class="footer_menu">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Adminstrator</a></li>
                    <li><a href="memberdetails.jsp">Library Member</a></li>
                    <li><a href="bookdetails.jsp">Book Details</a></li>
                     <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
            </ul>
                
                Copyright © 2021 <a href="#">e-lib library management system</a> | 
                
    </div>
</div>
</body>
</html>