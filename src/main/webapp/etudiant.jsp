
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="java.util.*, models.Etudiant" %>--%>
<!DOCTYPE html>
<html>
<body>

    <h2>Liste des étudiants</h2>
    <a href="ajout.jsp">Ajouter un étudiant</a>

    <c:forEach var="e" items="${etudiants}">
        <p>
            ${e.nom} — ${e.age} ans
            <a href="modifier?id=${e.id}">Modifier</a>
            <a href="supprimer?id=${e.id}">Supprimer</a>
        </p>
    </c:forEach>

<%--
    <%
        List<Etudiant> liste = (List<Etudiant>) request.getAttribute("etudiants");
        for (Etudiant e : liste) {
    %>
        <p><%= e.getNom() %> - <%= e.getAge() %> ans</p>
        <a href="modifier?id=<%= e.getId() %>">Modifier</a>
        <a href="supprimer?id=<%= e.getId() %>">Supprimer</a>p
    <%
        }
    %>
--%>
</body>
</html>

