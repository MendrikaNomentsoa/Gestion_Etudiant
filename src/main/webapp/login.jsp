<%@ page language="java" contentType="text/html, charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Site de bienvenue</title>
</head>
<body>
    <h1>Login</h1>


    <% if ("1".equals(request.getParameter("erreur"))) { %>
        <p style="color:red;">Identifiants incorrects ❌</p>
    <% } %>

    <form action="login" method="post">
        <input type="text" name="username" placeholder="Nom">
        <input type="password" name="password" placeholder="Mot de passe">
        <button type="submit">Connexion</button>
    </form>
</body>
</html>