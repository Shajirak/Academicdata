<%@ page import="java.sql.*" %>
<%@ page import="util.DBConnection" %>

<%
String type = request.getParameter("type");
String name = request.getParameter("name");

String ageStr = request.getParameter("age");
int age = (ageStr == null || ageStr.isEmpty()) ? 0 : Integer.parseInt(ageStr);

String subject = request.getParameter("subject");

String salaryStr = request.getParameter("salary");
double salary = (salaryStr == null || salaryStr.isEmpty()) ? 0 : Double.parseDouble(salaryStr);

String markStr = request.getParameter("mark");
float mark = (markStr == null || markStr.isEmpty()) ? 0 : Float.parseFloat(markStr);

String admnoStr = request.getParameter("admno");
double admno = (admnoStr == null || admnoStr.isEmpty()) ? 0 : Double.parseDouble(admnoStr);

try {

    Connection con = DBConnection.getConnection();

    String id = request.getParameter("id");

    String sql = "UPDATE person SET name=?, age=?, role=?, subject=?, salary=?, mark=?, admno=? WHERE id=?";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setString(1, name);
    ps.setInt(2, age);
    ps.setString(3, type);
    ps.setString(4, subject);
    ps.setDouble(5, salary);
    ps.setFloat(6, mark);
    ps.setDouble(7, admno);
    ps.setInt(8, Integer.parseInt(id));

    ps.executeUpdate();

    ps.close();
    con.close();

    response.sendRedirect("view.jsp");

} catch(Exception e) {
    out.println(e);
}
%>