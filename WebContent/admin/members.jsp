<%@ page import="java.util.List"%>

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
		<div class="content_box">
			<div class="MemberDetails">
				<h2>Members</h2> 
			</div>
			<br>
			<div class="registrationlink">
				<a style="font-size:16px;" href="${context}/admin/memberregistration.jsp">Add new member</a>
			</div>

			 <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
			
			<div class="memberlist">
				<table id="myTable">

						<tr class="header">
							<th style="width: 10%">Id</th>
							<th style="width: 20%">Last Name</th>
							<th style="width: 20%">First Name</th>
							<th style="width: 20%">Email</th>
							<th style="width: 10%">Phone Number</th>
							<th style="width: 20%">Address</th>
						</tr>

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
				<li><a href="#">Member Details</a></li>
				<li><a href="#">Book Details</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>

			Copyright ? 2021 <a href="#">e-lib library management system</a> |


		</div>
	</div>
</body>
</html>