<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeetimetable",
            "root", "");
    Statement st = con.createStatement();
    //ResultSet rs;
//    int i = st.executeUpdate("insert into members(first_name, last_name, email, uname, pass, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE())");
String query = null;
String query2 = null;
String query3 = null;
query = "insert into users(username, password) values(user, pwd)";
query2 = "insert into users(username, password, Roles_id) values ('"  + user + "','" + pwd + "' ,9)";
query3 = "insert into users(username, Roles_id, password, first_name, last_name, email) values ('" + user + "',1 ,'" + pwd + "','" + fname + "','" + lname + "','" + email + "')";
//query3 = "insert into users(id, first_name, last_name, email, uname, pass, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE())";
 int i = st.executeUpdate(query3);
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>