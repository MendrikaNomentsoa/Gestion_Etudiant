package controllers;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //Recuper les donner du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Verifier l'indentifiant si correcte
        if("admin".equals(username) && "1234".equals(password)){
            //Stocker dans une session
            request.getSession().setAttribute("user", username);
            //Rediriger vers acceuil
            response.sendRedirect("accueil.jsp");
        }else{
            // 5. Rediriger vers login avec erreur
            response.sendRedirect("login.jsp?erreur=1");
        }
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Afficher le formulaire login
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    
}