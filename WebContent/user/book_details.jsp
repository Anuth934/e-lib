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
	<%@include file="user_menu_header.jsp" %>

<div id="templatemo_content">

	
    

			
          <%--   <h2>AskQuestions</h2>
            
            <form action="www.javatpoint.com" method="get">
            <label>Please enter your email address to ask or post java Question Answer.</label>
            <input type="text" value="" name="username" size="10" id="input_field" title="usernmae" />
            <input type="submit" name="login" value="Ask" alt="login" id="submit_btn" title="Login" />
            </form>--%>
        <div class="content_box">
        
        	<form method="post" action="${context}/user/action/book"> 

            <label> Book ID : </label>  
            <label>${bookById.id}</label> <br><br>
			<label> Book Name : </label>         
			<label>${bookById.bookName}</label> <br><br>
			<label> Author : </label>         
			<label>${bookById.author}</label> <br><br>  
			  
			<label>   
			Publisher  
			</label>  
			<label>${bookById.publisher}</label> <br><br>
	
			<label> Status : </label>         
			<label>	<c:if test="${bookById.availble==true}">Available</c:if>
					<c:if test="${bookById.availble==false}">Issued</c:if>
			</label> <br><br>
			
			<c:if test="${bookById.availble==true}">
				<input type="hidden" value="issue" name="action"/>
				<input type="hidden" value="${bookById.id}" name="bookId"/>
				<input type="submit" value="Issue Book"/> 
			</c:if>
			<c:if test="${bookById.availble==false}">
				<c:if test="${bookById.issuedMemberId==user.id}">
					<input type="hidden" value="return" name="action"/>
					<input type="hidden" value="${bookById.id}" name="bookId"/>
					<input type="submit" value="Return Book"/> 
				</c:if>
			</c:if>
			</form>  
           
           
        
        	<div class="cleaner"></div>
        </div><div class="content_box_bottom"></div>
    
    
    <div class="cleaner"></div>

</div>

<div id="templatemo_footer_wrapper">

    <div id="templatemo_footer">
    
        <ul class="footer_menu">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Administrator</a></li>
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