import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import util.DBConnection;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("=== SaveServlet HIT ===");

        String type = request.getParameter("type");
        String name = request.getParameter("name");

        String ageStr = request.getParameter("age");
        int age = (ageStr == null || ageStr.isEmpty()) ? 0 : Integer.parseInt(ageStr);

        String subject = request.getParameter("subject");
        String salaryStr = request.getParameter("salary");
        String markStr = request.getParameter("mark");
        String admnoStr = request.getParameter("admno");

        double salary = (salaryStr == null || salaryStr.isEmpty()) ? 0 : Double.parseDouble(salaryStr);
        float mark = (markStr == null || markStr.isEmpty()) ? 0 : Float.parseFloat(markStr);
        double admno = (admnoStr == null || admnoStr.isEmpty()) ? 0 : Double.parseDouble(admnoStr);

        Connection con = null;

        try {
            con = DBConnection.getConnection();
            System.out.println("Connection: " + con);

            String sql = "INSERT INTO person(name, age, role, subject, salary, mark, admno) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, type);
            ps.setString(4, subject);
            ps.setDouble(5, salary);
            ps.setFloat(6, mark);
            ps.setDouble(7, admno);

            int i = ps.executeUpdate();
            System.out.println("Inserted: " + i);

            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (con != null) con.close(); } catch (Exception e) {}
        }

        response.sendRedirect("view.jsp");
    }
}