<%-- 
    Document   : colecciones
    Created on : 25-oct-2017, 0:16:44
    Author     : Ep77
--%>

<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblcoleccion"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Gestión de Colecciones</h1>
        <section>
        <form action="./Colecciones" method="POST">
            <div><input type="hidden" name="id" value=""></div>
            <div><label for="coleccion">Colección: </label><input type="text" name="coleccion"></div>
            <div><label for="version">Version: </label><input type="text" name="version"></div>
            <div><label for="fechaCreacion">fecha Creacion: </label><input type="text" name="fechaCreacion"></div>
            <div><label for="estado">Estado: </label><input type="text" name="estado"></div>
           
            <input type="submit" value="Registrar! ">
        </form>
        </section>
        <section>
            <table>
                <thead>
                <th>id</th>
                <th>coleccion</th>
                <th>version</th>
                <th>fecha creacion</th>
                <th>estado</th>
                    
               

                </thead>
                <tbody>
                    <%
                        Vector<Tblcoleccion> listaColecciones = (Vector<Tblcoleccion>) request.getAttribute("colecciones");

                    %>


                    <%                        for (Tblcoleccion serie : listaColecciones) {%>

                    <tr>
                        <td><%=serie.getIdColeccion()%></td>
                        <td><%=serie.getColeccion()%></td>
                        <td><%=serie.getVersion()%></td>
                        <td><%=serie.getFechacreacion()%></td>
                        <td><%=serie.getEstado()%></td>
                        
                        
               
                </tr>
                <%
                    }
                %>


                </tbody>


            </table>


        </section>
    </body>
</html>
