package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Etudiant;

@WebServlet("/etudiants")
public class EtudiantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Etudiant> liste = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";

        // Try-with-resources pour fermer automatiquement la connexion
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int age = rs.getInt("age");
                liste.add(new Etudiant(id, nom, age));
            }

            // Debug console
            System.out.println("Servlet appelée !");
            System.out.println("Nombre d'étudiants récupérés : " + liste.size());
            for (Etudiant e : liste) {
                System.out.println("Etudiant : " + e.getNom() + ", " + e.getAge());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Envoyer la liste à la JSP
        request.setAttribute("etudiants", liste);
        request.getRequestDispatcher("etudiant.jsp").forward(request, response);
    }
}