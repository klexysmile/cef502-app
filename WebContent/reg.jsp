
<%@ include file="header2.jsp" %>

  <div id="frontpage-content" >
    <div id="container">
      <div class="gallery-content" align="center"  style="vertical-align:bottom">
      <div><a href="home.jsp"></a> </div>
        <div class="slideshow-container">
          
          <div style="margin:0 auto" align=center>
          <br /><br /> <br />
          
          
        <form method="post" action="registration.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2"   style="font-weight: bold">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
        
        </div>
          
        </div>
        <!--end slideshow-container-->
      </div>
      <!--end gallery-content-->
    </div>
    <!--end container-->

    <!--end navigation-containter-->
  </div>
  <!--end frontpage-content-->

  
  <%@ include file="footer.jsp" %>