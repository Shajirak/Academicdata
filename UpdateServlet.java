package controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import util.DBConnection;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String role = req.getParameter("role");
        String subject = req.getParameter("subject");
        double salary = Double.parseDouble(req.getParameter("salary"));
        float mark = Float.parseFloat(req.getParameter("mark"));
        double admno = Double.parseDouble(req.getParameter("admno"));

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE person SET age=?, role=?, subject=?, salary=?, mark=?, admno=? WHERE name=?"
            );

            ps.setInt(1, age);
            ps.setString(2, role);
            ps.setString(3, subject);
            ps.setDouble(4, salary);
            ps.setFloat(5, mark);
            ps.setDouble(6, admno);
            ps.setString(7, name);

            ps.executeUpdate();

            res.sendRedirect("view.jsp");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}