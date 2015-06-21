<%
session.setAttribute("identity", null);
session.setAttribute("role", null);
session.setAttribute("name", null);
session.setAttribute("message", "You are currently logged out");
session.invalidate();
response.sendRedirect("index.jsp");
%>