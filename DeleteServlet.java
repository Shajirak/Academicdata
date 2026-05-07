package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import util.DBConnection;

@WebServlet("/DeleteServlet")

public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)

    throws ServletException, IOException {

        String name = req.getParameter("name");

        System.out.println("DeleteServlet HIT");
        System.out.println("Deleting : " + name);

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(

            "DELETE FROM person WHERE name=?"

            );

            ps.setString(1, name);

            int i = ps.executeUpdate();

            System.out.println("Deleted rows : " + i);

            res.sendRedirect("view.jsp");

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }
}package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import util.DBConnection;

@WebServlet("/DeleteServlet")

public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)

    throws ServletException, IOException {

        String name = req.getParameter("name");

        System.out.println("DeleteServlet HIT");
        System.out.println("Deleting : " + name);

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(

            "DELETE FROM person WHERE name=?"

            );

            ps.setString(1, name);

            int i = ps.executeUpdate();

            System.out.println("Deleted rows : " + i);

            res.sendRedirect("view.jsp");

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }
}