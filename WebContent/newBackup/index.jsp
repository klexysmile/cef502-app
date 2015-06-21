<%@ include file="header1.jsp" %>
<% //response.sendRedirect("login/index.jsp"); %>
					
					                        
						<div class="panel" id="home">
                                <h2>Time Table Application</h2>    
                                
                                <p><em>Brought to you by <b>Fonyuy T. Isidore [FE11A076]</b> & <b>Semi Clayton [FE11A]</b>.</em></p>	
                                <div class="cleaner_h20"></div>

								<div>								
									<form id="loginForm"  action="loginServlet" method="post">
										<fieldset style="width: 300px">
											<legend id="legend"> Please, fill the form </legend>
											<table>
												<tr>
													<td>User ID</td>
													<td><input type="text" name="username" required="required" /></td>
												</tr>
												<tr>
													<td>Password</td>
													<td><input type="password" name="userpass" required="required" /></td>
												</tr>
												<tr>
													<td><input type="submit" value="Login" /></td>
												</tr>
											</table>
										</fieldset>
									</form>								
								</div>
								
                        </div> <!-- end of home -->
						                    
<%@ include file="footer.jsp" %>