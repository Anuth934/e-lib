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

			<div class="content_box">

				<h2>Member Details</h2>
				<br>

				<form method="post" action="${context}/admin/update">

					<label> <b>Id :</b>  </label> <label>${userById.id}</label> <br> <br>
					<label> <b>First Name :</b> </label> <label>${userById.lastName}</label> <br> <br>
					<label> <b>Last Name :</b> </label> <label>${userById.firstName}</label> <br> <br>
					<label> <b>Address :</b> </label> <label>${userById.address}</label> <br> <br>
					<label> <b>Phone Number :</b> </label> <label>${userById.phoneNumber}</label> <br> <br>
					<label> <b>Email :</b>  </label> <label>${userById.email}</label> <br> <br>
					<input type="hidden" value="${userById.id}" name="id"/>
					<input type="submit" name="update" value="Update User">
					<input type="submit" name="delete" value="Delete User">
				</form>
				<div class="cleaner"></div>
			</div>
			<div class="content_box_bottom"></div>

		</div>
		<!-- end of content -->

		<div class="cleaner"></div>

	</div>

	<div id="templatemo_footer_wrapper">

		<div id="templatemo_footer">

			<ul class="footer_menu">
				<li><a href="#">Home</a></li>
				<li><a href="#">Adminstrator</a></li>
				<li><a href="#">Library Member</a></li>
				<li><a href="#">Book Details</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>

			Copyright ?? 2021 <a href="#">e-lib library management system</a> |

		</div>
	</div>
</body>
</html>