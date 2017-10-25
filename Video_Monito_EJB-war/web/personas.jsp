<%-- 
    Document   : personas
    Created on : 25-oct-2017, 1:49:57
    Author     : Ep77
--%>

<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblpersona"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion de Personas</h1>
        <form action="./PersonasVideo" method="POST">
            <div><input type="text" name="id"></div>
            <div><label for="nombre">nombre: </label><input type="text" name="nombre"></div>
            <div><label for="apellido">apellido: </label><input type="text" name="apellido"></div>
            <div><label for="papel">Papel: </label><input type="text" name="papel"></div>
            <div><label for="descripcion">Descripción: </label><input type="text" name="descripcion"></div>
            <div><label for="edad">Edad: </label><input type="text" name="edad"></div>
            <div><label for="pais">Pais: </label><input type="text" name="pais"></div>
            <div><label for="premios">premios: </label><input type="text" name="premios"></div>
            <input type="submit" value="Registrar! ">
        </form>
    </body>
</html>
