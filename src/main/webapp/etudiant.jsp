<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, models.Etudiant" %>
<!DOCTYPE html>
<html>
<body>

    <h2>Liste des étudiants</h2>

    <%
        List<Etudiant> liste = (List<Etudiant>) request.getAttribute("etudiants");
        for (Etudiant e : liste) {
    %>
        <p><%= e.getNom() %> - <%= e.getAge() %> ans</p>
        <a href="modifier?id=<%= e.getId() %>">Modifier</a>
        <a href="supprimer?id=<%= e.getId() %>">Supprimer</a>
    <%
        }
    %>

</body>
</html>
