package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Etudiant;

@WebServlet("./etudiants")
public class EtudiantServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //Creation de donnees
         List<Etudiant> liste = new ArrayList<>();
         liste.add(new Etudiant("Rakoto", 15));
         liste.add(new Etudiant("Bema", 14));
         liste.add(new Etudiant("Soa", 16));

         //Envoyer les donner au view

         // On stocke dans request
         request.setAttribute("etudiants", liste);
         //Envoier le request complet à la JSP
        request.getRequestDispatcher("etudiant.jsp")
                .forward(request, response);

    }
    
}
