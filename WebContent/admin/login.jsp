<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elib-library management system</title>
<link href="../Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_header_wrapper">
    <div id="templatemo_menu">
    	<div id="site_title">
           <a href="#" style="float:left;" target="_parent">
                <img src="../Images/e-lib.png" height="100px" alt="Site Title" />

            </a>	
     
        </div>
    
    </div>

</div>

<div id="templatemo_menu_wrapper">
    <div id="templatemo_menu">
        <ul>
           <li><a href="index.html">Home</a></li>
                    <li><a href="members.jsp">Member Details</a></li>
                    <li><a href="bookingdetails.jsp">Book Details</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
                     <li><a href="adminlogin.html">Logout</a></li>
                   </ul>    	
     
    </div> <!-- end of templatemo_menu -->
</div>

<div id="templatemo_content_wrapper">

	
    

			
          <%--   <h2>AskQuestions</h2>
            
            <form action="www.javatpoint.com" method="get">
            <label>Please enter your email address to ask or post java Question Answer.</label>
            <input type="text" value="" name="username" size="10" id="input_field" title="usernmae" />
            <input type="submit" name="login" value="Ask" alt="login" id="submit_btn" title="Login" />
            </form>--%>
            
    
     <div id="templatemo_content">

        
        <div class="content_box">
        
        	<h2>Welcome Admin</h2>
            
          
           
        
        	<div class="cleaner"></div>
        </div><div class="content_box_bottom"></div>
    
    </div> <!-- end of content -->
    
    <div class="cleaner"></div>

</div>

<c:set var="context" value="${pageContext.request.contextPath}" />

<form action ="${context}/admin/login">

email: <input type ="text" name ="username"/><br>
Password: <input type ="text" name ="password"/><br>

<input type ="Submit" value ="Login"/>


</form>

<div id="templatemo_footer_wrapper">

    <div id="templatemo_footer">
    
        <ul class="footer_menu">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Adminstrator</a></li>
                    <li><a href="memberdetails.jsp">Library Member</a></li>
                    <li><a href="bookingdetails.jsp">Book Details</a></li>
                     <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
            </ul>
                
                Copyright © 2021 <a href="#">e-lib library management system</a> | 
                
    </div>
</div>
</body>
</html>