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

@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id  = Integer.parseInt(request.getParameter("id"));

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM etudiant WHERE id = ?")) {

                    ps.setInt(1, id);
                    ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("etudiants");

    }
    
}
