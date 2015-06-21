
<%@ include file="header.jsp" %>

  <div id="main">
    <div id="content">
      <div id="contact-page">
        <!-- The Contact Form -->
        <h2 class="page-title">Get In Touch</h2>
        <p>Please get in touch with us using the form below if you have any questions or would like to discuss the possibility of hiring us for a project.</p>
        <form id="contact-form" method="post" action="contactProcess.jsp">
          <fieldset>
            <input id="form_name" type="text" name="name" value="Name" onFocus="if(this.value=='Name'){this.value=''};" onBlur="if(this.value==''){this.value='Name'};" />
            <input id="form_email" type="text" name="email" value="Email" onFocus="if(this.value=='Email'){this.value=''};" onBlur="if(this.value==''){this.value='Email'};" />
            <input id="form_subject" type="text" name="subject" value="Subject" onFocus="if(this.value=='Subject'){this.value=''};" onBlur="if(this.value==''){this.value='Subject'};" />
            <textarea id="form_message" rows="10" cols="40" name="message"></textarea>
            <input id="form_submit" class="submit" type="submit" name="submit" value="submit" />
            <div class="hide">
              <label>Do not fill out this field</label>
              <input name="spam_check" type="text" value="" />
            </div>
          </fieldset>
        </form>
      </div>
      <!--end contact-page-->
    </div>
    <!--end content-->



<%@ include file="sidebar2.jsp" %>



  </div>
  <!--end main-->
  
  
  <%@ include file="footer.jsp" %>