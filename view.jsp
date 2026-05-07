<%@ page import="java.sql.*" %>
<%@ page import="util.DBConnection" %>

<html>
<head>
    <title>All Records</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="dashboard">
<div class="main">
<div class="table-card">

<h2>All Records</h2>

<table class="input-table">

<thead>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Role</th>
    <th>Subject</th>
    <th>Salary</th>
    <th>Mark</th>
    <th>Admno</th>
    <th>Update</th>
    <th>Delete</th>
</tr>
</thead>

<tbody>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM person");

while(rs.next()){
%>

<tr>

<!-- ================= UPDATE FORM ================= -->
<form action="save.jsp" method="post">

    <!-- ID (VERY IMPORTANT) -->
    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">

    <td><%= rs.getInt("id") %></td>

    <td>
        <input type="text" name="name" value="<%= rs.getString("name") %>">
    </td>

    <td>
        <input type="text" name="age" value="<%= rs.getInt("age") %>">
    </td>

    <td>
        <input type="text" name="role" value="<%= rs.getString("role") %>">
    </td>

    <td>
        <input type="text" name="subject" value="<%= rs.getString("subject") %>">
    </td>

    <td>
        <input type="text" name="salary" value="<%= rs.getDouble("salary") %>">
    </td>

    <td>
        <input type="text" name="mark" value="<%= rs.getFloat("mark") %>">
    </td>

    <td>
        <input type="text" name="admno" value="<%= rs.getDouble("admno") %>">
    </td>

    <td>
        <button type="submit">Update</button>
    </td>

</form>

<!-- ================= DELETE FORM ================= -->
<td>

<form action="delete.jsp" method="post">

    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">

    <button type="submit">Delete</button>

</form>

</td>

</tr>

<%
}
%>

</tbody>

</table>

<br>

<a class="btn" href="index.jsp">
    <h2>Back to home page</h2>
</a>

</div>
</div>
</div>

</body>
</html>