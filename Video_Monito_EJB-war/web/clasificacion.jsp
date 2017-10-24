<%-- 
    Document   : clasificacion
    Created on : 16-oct-2017, 1:24:30
    Author     : Ep77
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar Clasificacion</title>
    </head>
    <body>
        <h1>Gestión de Clasificación</h1>
        <form action="./Clasificacion" method="POST">
            <div><input type="hidden" name="id" value=""></div>
            <div><label for="nombre">Nombre:</label><input type="text" name="nombre"></div>
            <div><label for="descripcion">Descripcion:</label><input type="text" name="descripcion"></div>
            <input type="submit" value="Registrar! ">
        </form>
    </body>
</html>