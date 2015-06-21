<%@ include file="header2.jsp" %>

<body>
<h2>List of ${facultyName} members free for given period</h2>
<!-- The table below contains the free list, each cell on the table has a custom tag which gives the lecturers free
for that particular period -->
<div class="CSSTableGenerator">
<table border=1>
<th></th><th>7:00 - 9:00</th><th>9:00 - 11:00</th><th>11:00 - 13:00</th><th>13:00 - 15:00</th><th>15:00 - 17:00</th><th>17:00 - 19:00</th>
<!-- Monday -->
<tr>
<td><strong>Monday</strong></td>
<td><myTag:fslot_tag fac="${fac_id}" day="1" slot="1"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="1" slot="2"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="1" slot="3"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="1" slot="4"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="1" slot="5"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="1" slot="6"/></td>
</tr>

<!-- Tuesday -->
<tr>
<td><strong>Tuesday</strong></td>
<td><myTag:fslot_tag fac="${fac_id}" day="2" slot="1"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="2" slot="2"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="2" slot="3"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="2" slot="4"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="2" slot="5"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="2" slot="6"/></td>
</tr>

<!-- Wednesday -->
<tr>
<td><strong>Wednesday</strong></td>
<td><myTag:fslot_tag fac="${fac_id}" day="3" slot="1"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="3" slot="2"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="3" slot="3"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="3" slot="4"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="3" slot="5"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="3" slot="6"/></td>
</tr>

<!-- Thursday -->
<tr>
<td><strong>Thursday</strong></td>
<td><myTag:fslot_tag fac="${fac_id}" day="4" slot="1"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="4" slot="2"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="4" slot="3"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="4" slot="4"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="4" slot="5"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="4" slot="6"/></td>
</tr>

<!-- Friday -->
<tr>
<td><strong>Friday</strong></td>
<td><myTag:fslot_tag fac="${fac_id}" day="5" slot="1"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="5" slot="2"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="5" slot="3"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="5" slot="4"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="5" slot="5"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="5" slot="6"/></td>
</tr>

<!-- Saturday -->
<tr>
<td><strong>Saturday</strong></td>
<td><myTag:fslot_tag fac="${fac_id}" day="6" slot="1"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="6" slot="2"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="6" slot="3"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="6" slot="4"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="6" slot="5"/></td>
<td><myTag:fslot_tag fac="${fac_id}" day="6" slot="6"/></td>
</tr>

</table>
</div>
<%@ include file="footer.jsp" %>