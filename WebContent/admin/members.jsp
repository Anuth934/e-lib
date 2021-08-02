<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
           <li><a href="../index.html">Home</a></li>
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
        
        	<h2>Member List</h2><br>
            
	<span><a href="admin/register.html">Add new member</a></span> <span></span>

           <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">

			<table id="myTable">
			  <tr class="header">
			    <th style="width:60%;">Member ID</th>
			    <th style="width:40%;">Member Name</th>
			    <th style="width:40%;">Member Phone</th>
			    <th style="width:40%;">Member Address</th>
			    <th style="width:40%;">Member Email</th>
			  </tr>
			  <tr>
			    <td><a href="memberdetails.jsp">1</a></td>
			    <td>abc</td>
			    <td>abc</td>
			    <td>abc</td>
			    <td>abc</td>
			    
			  </tr>
			  <tr>
			    <td>1</td>
			    <td>abc</td>
			    <td>abc</td>
			    <td>abc</td>
			    <td>abc</td>
			  </tr>
			  
			</table>
        
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