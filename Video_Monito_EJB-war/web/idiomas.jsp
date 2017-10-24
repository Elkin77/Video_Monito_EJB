<%-- 
    Document   : idiomas
    Created on : 16-oct-2017, 1:45:06
    Author     : Ep77
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar Idiomas</title>
    </head>
    <body>
        <h1>Gestión de Idiomas</h1>
        <form action="./Idiomas" method="POST">
            <div><input type="hidden" name="id" value=""></div>
            <div><label for="lenguaje">Lenguaje:</label><input type="text" name="lenguaje"></div>
            <div><label for="subtitulos">Subtitulos:</label><input type="text" name="subtitulos"></div>
            <div><label for="doblaje">Doblaje:</label><input type="text" name="doblaje"></div>
            <input type="submit" value="Registrar! ">
        </form>
    </body>
</html>