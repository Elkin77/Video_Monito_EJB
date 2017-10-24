<%-- 
    Document   : proveedores
    Created on : 16-oct-2017, 1:33:01
    Author     : Ep77
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar Proveedores</title>
    </head>
    <body>
        <h1>Gestión de Proveedores</h1>
        <form action="./Proveedores" method="POST">
            <div><input type="hidden" name="id" value=""></div>
            <div><label for="nit">Nit:</label><input type="text" name="nit"></div>
            <div><label for="nombre">Nombres:</label><input type="text" name="nombre"></div>
            <div><label for="sede">Sede:</label><input type="text" name="sede"></div>
            <div><label for="password">Password:</label><input type="text" name="password"></div>
            <input type="submit" value="Registrar! ">
        </form>
    </body>
</html>
