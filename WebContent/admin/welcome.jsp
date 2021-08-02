<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
           <a href="#" style="float:left;" target="_parent">
                <img src="../Images/e-lib.png" height="100px" alt="Site Title" />
            </a>
	         <ul style="background-color: white;">
	           <li><a href="memberlogin.html">Logout</a></li>
	         </ul>    	
        </div>
        <div class="menu">
        	    	<ul>
                    <li><a href="${context}/admin/welcome.jsp">Home</a></li>
                    <li><a href="${context}/admin/members">Member List</a></li>
                    <li><a href="${context}/admin/bookds">Book List</a></li>
                     <li><a href="${context}/admin/contactus">About Us</a></li>
       </ul>
        </div>
    
    </div>

</div>


<div id="templatemo_content_wrapper">
    
    <div id="templatemo_content">
    
    	<div class="content_box">
        
        	<h2 style="font-size:40px;">Welcome Admin</h2>
        	<div class="cleaner_h60"></div>
            
            
          <div class="cleaner_h20"></div>
            
            
            <div class="section_w250 float_r">
            
            
            </div>
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
                    <li><a href="memberdetails.jsp">Member Details</a></li>
                    <li><a href="bookingdetails.jsp">Book Details</a></li>
                     <li><a href="#">About Us</a></li>
                    <li><a href="welcomeadmin.jsp">Contact Us</a></li>
       </ul>
                
                Copyright @ 2021 <a href="#">e-lib library management system</a> | 
               
    
</div>
</div>
</body>
</html>