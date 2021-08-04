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
        <div class="content_box">
        
        	<form method="post" action="${context}/admin/delete/book"> 

            <label><b>Book ID :</b>  </label>  
            <label>${bookById.id}</label> <br><br>
			<label><b> Book Name :</b> </label>         
			<label>${bookById.bookName}</label> <br><br>
			<label><b> Author :</b> </label>         
			<label>${bookById.author}</label> <br><br>  
			  
			<label>   
			<b>Publisher</b>  
			</label>  
			<label>${bookById.publisher}</label> <br><br>
	
			<label><b> Status :</b> </label>         
			<label>	<c:if test="${bookById.availble==true}">Available</c:if>
					<c:if test="${bookById.availble==false}">Issued</c:if>
			</label> <br><br>
			 
			<input type="hidden" value="${bookById.id}" name="id"/>
			<input type="submit" value="Delete"/> 
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
                    <li><a href="#">Library Member</a></li>
                    <li><a href="#">Book Details</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
            </ul>
                
                Copyright © 2021 <a href="#">e-lib library management system</a> | 
                
    </div>
</div>
</body>
</html>