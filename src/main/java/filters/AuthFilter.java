package filters;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements jakarta.servlet.Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
             throws IOException, ServletException {

        //pour accéder à la session.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();//Récupère l'URL que l'utilisateur demande 
        
        // Pages accessibles sans connexion
        boolean estPagePublique = uri.endsWith("login.jsp") ||
                                uri.endsWith("/login");


        // Vérifier si connecté
        HttpSession session = req.getSession(false);
        boolean estConnecte = session != null &&
                              session.getAttribute("user") != null;

        if (estPagePublique || estConnecte) {
            // Laisser passer
            chain.doFilter(request, response);
        } else {
            // Rediriger vers login
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }

    
}
