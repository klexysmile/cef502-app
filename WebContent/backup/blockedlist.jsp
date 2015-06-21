<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.siple.tags" prefix="myTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Free List</title>
<script src="jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<h2>List of ${facultyName} members occupied for given periods</h2>
<!-- The table below contains the blocked list, each cell on the table has a custom tag which gives the lecturers who
are having their classes for that particular period -->

<!-- Java code here below -->

<table border=1>
<th></th><th>7:00 - 9:00</th><th>9:00 - 11:00</th><th>11:00 - 13:00</th><th>13:00 - 15:00</th><th>15:00 - 17:00</th><th>17:00 - 19:00</th>
<!-- Monday -->
<tr>
<td><strong>Monday</strong></td>
<td><myTag:bslot_tag fac="${fac_id}" day="1" slot="1"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="1" slot="2"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="1" slot="3"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="1" slot="4"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="1" slot="5"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="1" slot="6"/></td>
</tr>

<!-- Tuesday -->
<tr>
<td><strong>Tuesday</strong></td>
<td><myTag:bslot_tag fac="${fac_id}" day="2" slot="1"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="2" slot="2"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="2" slot="3"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="2" slot="4"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="2" slot="5"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="2" slot="6"/></td>
</tr>

<!-- Wednesday -->
<tr>
<td><strong>Wednesday</strong></td>
<td><myTag:bslot_tag fac="${fac_id}" day="3" slot="1"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="3" slot="2"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="3" slot="3"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="3" slot="4"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="3" slot="5"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="3" slot="6"/></td>
</tr>

<!-- Thursday -->
<tr>
<td><strong>Thursday</strong></td>
<td><myTag:bslot_tag fac="${fac_id}" day="4" slot="1"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="4" slot="2"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="4" slot="3"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="4" slot="4"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="4" slot="5"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="4" slot="6"/></td>
</tr>

<!-- Friday -->
<tr>
<td><strong>Friday</strong></td>
<td><myTag:bslot_tag fac="${fac_id}" day="5" slot="1"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="5" slot="2"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="5" slot="3"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="5" slot="4"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="5" slot="5"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="5" slot="6"/></td>
</tr>

<!-- Saturday -->
<tr>
<td><strong>Saturday</strong></td>
<td><myTag:bslot_tag fac="${fac_id}" day="6" slot="1"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="6" slot="2"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="6" slot="3"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="6" slot="4"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="6" slot="5"/></td>
<td><myTag:bslot_tag fac="${fac_id}" day="6" slot="6"/></td>
</tr>

</table>

</body>
</html>