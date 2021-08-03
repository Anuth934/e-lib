<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elib-library management system</title>
<link href="../Styles/main.css" rel="stylesheet" type="text/css" />
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
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
        
        
        	<h2>Books List</h2><br>
            
            
	<span><a href="add_new_book.jsp">Add new book</a></span> <span></span>

           <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">

			<table id="myTable">
			  <tr class="header">
			    <th style="width:25%; text-align: center;">Book ID</th>
			    <th style="width:25%; text-align: center;">Book Name</th>
			    <th style="width:25%; text-align: center;">Author</th>
			    <!-- <th style="width:40%;">Published Date</th> -->
			    <th style="width:25%; text-align: center;">Issue Status</th>
			  </tr>
			  
			  <c:forEach items="${bookDetails}" var="book">
				<tr>
					<td style="text-align: center;"><a
						href="${context}/admin/books?id=${book.id}"><c:out
								value="${book.id}" /></a></td>
					<td style="text-align: center;"><c:out
							value="${book.bookName}" /></td>
					<td style="text-align: center;"><c:out
							value="${book.publisher}" /></td>
					<td style="text-align: center;">
					<c:if test="${book.availble==true}">Available</c:if>
					<c:if test="${book.availble==false}">Issued</c:if></td>
				</tr>
			</c:forEach>
						
			</table>
        
        	<div class="cleaner"></div>
        </div><div class="content_box_bottom"></div>
    
    
    <div class="cleaner"></div>

</div>

<div id="templatemo_footer_wrapper">

    <div id="templatemo_footer">
    
        <ul class="footer_menu">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Adminstrator</a></li>
                    <li><a href="memberdetails.jsp">Library Member</a></li>
                    <li><a href="book_details.jsp">Book Details</a></li>
                     <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
            </ul>
                
                Copyright © 2021 <a href="#">e-lib library management system</a> | 
                
    </div>
</div>
</body>