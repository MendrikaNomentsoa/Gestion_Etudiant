package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import connexion.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouts")
public class AjoutServlet extends HttpServlet{
    
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.sendRedirect("ajout.jsp");
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException{

                // Empêcher le cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
        
        String nom = request.getParameter("nom");
        int age = Integer.parseInt(request.getParameter("age"));

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO etudiant (nom, age) VALUES (?, ?)")) {

                    ps.setString(1, nom);
                    ps.setInt(2, age);
                    ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("etudiants");


    }
}
