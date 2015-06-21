<% if ((session.getAttribute("identity") == null) || (session.getAttribute("name") == null) || (session.getAttribute("role") == null)) {response.sendRedirect("index.jsp"); }%>
        
        	<div id="menu">
                <ul class="navigation">
                    <li><a href="#home" class="selected">Home<span class="ui_icon home"></span></a></li>
                    <li><a href="#about">About Us<span class="ui_icon aboutus"></span></a></li>
                    <li><a href="#services">Services<span class="ui_icon services"></span></a></li>
                    <li><a href="#gallery">Gallery<span class="ui_icon gallery"></span></a></li>
                    <li><a href="#contact">Contact<span  class="ui_icon contactus"></span></a></li>
                    <li><a href="logout.jsp">Logout<span  class="ui_icon contactus"></span></a></li>
                </ul>
            </div>
        
        
        