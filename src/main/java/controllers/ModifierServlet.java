package controllers;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexion.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifier")
public class ModifierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Afficher le formulaire de modification
        request.getRequestDispatcher("modifier.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        int age = Integer.parseInt(request.getParameter("age"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                 "UPDATE etudiant SET nom=?, age=? WHERE id=?")) {

            ps.setString(1, nom);
            ps.setInt(2, age);
            ps.setInt(3, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("etudiants");
    }
}