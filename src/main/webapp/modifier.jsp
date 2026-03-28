<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>

    <h2>Modifier un étudiant</h2>

    <form action="modifier" method="post">
        <input type="hidden" name="id" value="${param.id}"/>
        <input type="text" name="nom" placeholder="Nouveau nom"/>
        <input type="number" name="age" placeholder="Nouvel age"/>
        <button type="submit">Modifier</button>
    </form>

</body>
</html>