<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CEF502 TIme Table Project</title>
<script src="jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>

<body>
<!-- Form for free list -->
<form action="FreeListServlet" method="post">
<label for="fac">Select Faculty: </label>
<select name = "fac" id = "fac_id">
<option value="1">Faculty</option>
</select>
<input type="submit" value="Generate Free List"/>
</form>

<br/>
<!-- Form for blocked List -->
<form action="BlockedListServlet" method="post">
<label for="fac">Select Faculty: </label>
<select name = "faculty" id = "fac_id1">
<option value="1">Faculty</option>
</select>
<input type="submit" value="Generate Blocked List"/>
</form>

<br/>
<!-- Form for individual list -->
<form action="IndividualListServlet" method="post">
<label for="fac">Select Faculty: </label>
<select name = "faculty_id" id = "fac_id2">
<option value="1">Faculty</option>
</select>
<label for="lec">Select Lecturer: </label>
<select name = "lecturer" id = "lec">
<option value="1">Faculty</option>
</select>
<input type="submit" value="Generate Individual List"/>
</form>

</body>
</html>