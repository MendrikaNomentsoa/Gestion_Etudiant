<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
</head>
<body>

    <%
        //recuperer la session
        String username = (String) session.getAttribute("user");
    %>

    <h1>Bonjour, bienvenue sur mon projet JSP !</h1>
    <p>Cette page est pour <%= username %></p>

</body>
</html>
