<%-- 
    Document   : categorias
    Created on : 16-oct-2017, 0:57:58
    Author     : Ep77
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar Categorias</title>
    </head>
    <body>
        <h1>Gestión de Categorias </h1>
        <form action="./Categorias" method="POST">
            <div><input type="hidden" name="id" value=""></div>
            <div><label for="nombre">Nombre:</label><input type="text" name="nombre"></div>
            <div><label for="descripcion">Descripcion:</label><input type="text" name="descripcion"></div>
            <input type="submit" value="Registrar! ">
        </form>
    </body>
</html>
