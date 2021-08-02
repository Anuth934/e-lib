<%@ page import="java.util.List"%>

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
	<div id="templatemo_header_wrapper">
		<div id="templatemo_menu">
			<div id="site_title">
				<a href="#" style="float: left;" target="_parent"> <img
					src="../Images/e-lib.png" height="100px" alt="Site Title" />
				</a>
				<ul style="background-color: white;">
					<li><a href="memberlogin.html">Logout</a></li>
				</ul>
			</div>
			<div class="menu">
				<ul>
					<li><a href="${context}/admin/welcome.jsp">Home</a></li>
					<li><a href="${context}/admin/members">Member Details</a></li>
					<li><a href="${context}/admin/bookdetails.jsp">Book Details</a></li>
					<li><a href="${context}/admin/contactus">About Us</a></li>
				</ul>
			</div>

		</div>
	</div>

	<div id="templatemo_content">

		<c:set var="context" value="${pageContext.request.contextPath}" />

		<div class="content_box">
			<div class="MemberDetails">
				<label>Members</label> 
			</div>

			<div class="registrationlink">
				<a href="${context}/admin/memberregistration.jsp">Register new member</a>
			</div>

			</br>
			<div class="memberlist">
				<table style="width: 100%">
					<thead>
						<tr>
							<th style="width: 10%">Id</th>
							<th style="width: 10%">Last Name</th>
							<th style="width: 10%">First Name</th>
							<th style="width: 10%">Email</th>
							<th style="width: 10%">Phone Number</th>
							<th style="width: 20%">Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userDetails}" var="member">
							<tr>
								<td style="text-align: center;"><a
									href="${context}/admin/members?id=${member.id}"><c:out
											value="${member.id}" /></a></td>
								<td style="text-align: center;"><c:out
										value="${member.lastName}" /></td>
								<td style="text-align: center;"><c:out
										value="${member.firstName}" /></td>
								<td style="text-align: center;"><c:out
										value="${member.email}" /></td>
								<td style="text-align: center;"><c:out
										value="${member.phoneNumber}" /></td>
								<td style="text-align: center;"><c:out
										value="${member.address}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="cleaner"></div>
		</div>
		<div class="content_box_bottom"></div>

	</div>






	<div id="templatemo_footer_wrapper">

		<div id="templatemo_footer">

			<ul class="footer_menu">
				<li><a href="#">Home</a></li>
				<li><a href="#">Administrator</a></li>
				<li><a href="memberdetails.jsp">Member Details</a></li>
				<li><a href="bookingdetails.jsp">Book Details</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="welcomeadmin.jsp">Contact Us</a></li>
			</ul>

			Copyright © 2021 <a href="#">e-lib library management system</a> |


		</div>
	</div>
</body>
</html>