<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="header.jsp" %>

<html>

<head>

<title>Add Record</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="dashboard">

<div class="main">

<div class="card">

<h2>Add Teacher / Student</h2>

<form action="${pageContext.request.contextPath}/SaveServlet"
method="post">

<label>Type</label>

<select name="type"
id="type"
onchange="toggleFields()">

<option value="Teacher">Teacher</option>

<option value="Student">Student</option>

</select>

<label>Name</label>

<input type="text" name="name">

<label>Age</label>

<input type="number" name="age">

<!-- Teacher Fields -->

<div id="teacherFields">

<label>Subject</label>

<input type="text" name="subject">

<label>Salary</label>

<input type="text" name="salary">

</div>

<!-- Student Fields -->

<div id="studentFields"
style="display:none;">

<label>Mark</label>

<input type="text" name="mark">

<label>Admno</label>

<input type="text" name="admno">

</div>

<button type="submit">Save</button>

</form>

</div>

</div>

</div>

<script>

function toggleFields() {

    var type =
    document.getElementById("type").value;

    var teacherFields =
    document.getElementById("teacherFields");

    var studentFields =
    document.getElementById("studentFields");

    if(type === "Teacher") {

        teacherFields.style.display = "block";

        studentFields.style.display = "none";

    }

    else {

        teacherFields.style.display = "none";

        studentFields.style.display = "block";
    }
}

window.onload = toggleFields;

</script>

</body>

</html>