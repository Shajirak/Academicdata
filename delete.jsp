<%@ page import="java.sql.*" %>
<%@ page import="util.DBConnection" %>

<%
try {

    Connection con = DBConnection.getConnection();

    String idStr = request.getParameter("id");

    String sql = "DELETE FROM person WHERE id=?";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setInt(1, Integer.parseInt(idStr));

    ps.executeUpdate();

    ps.close();
    con.close();

    response.sendRedirect("view.jsp");

} catch(Exception e) {
    out.println(e);
}
%>