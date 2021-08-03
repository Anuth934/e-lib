<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<div id="templatemo_content_wrapper">
    
    <div id="templatemo_content">
    
    	<div class="content_box" style="text-align: center;">
        <h2>Welcome Administrator</h2><br>
         <c:set var="context" value="${pageContext.request.contextPath}" />

		<form action ="${context}/admin/login">
	      <!-- user name: login, password: login123 -->
	      Email Id: <input type="text" name="username" /><br /><br />
	      Password: <input type="password" name="password" /><br /><br />
	
	      <input type="Submit" value="Login" />

	    </form>
    
        <div class="cleaner_h20"></div>
        	<div class="cleaner"></div>
        </div><div class="content_box_bottom"></div>
        
    
    </div> <!-- end of content -->
    
    <div class="cleaner"></div>

</div>

<div id="templatemo_footer_wrapper">

    <div id="templatemo_footer">
    
        <ul class="footer_menu">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Administrator</a></li>
                    <li><a href="admin/memberdetails.jsp">Library Member</a></li>
                    <li><a href="admin/book_details.jsp">Book Details</a></li>
                     <li><a href="admin/members.jsp">About Us</a></li>
                    <li><a href="admin/welcomeadmin.jsp">Contact Us</a></li>
            </ul>
                
                Copyright © 2021 <a href="#">e-lib library management system</a> | 
               
    
</div>
</div>
</body>
</html>