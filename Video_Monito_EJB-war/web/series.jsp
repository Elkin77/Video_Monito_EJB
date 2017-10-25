<%-- 
    Document   : series
    Created on : 24-oct-2017, 10:32:33
    Author     : Ep77
--%>

<%@page import="java.util.Vector"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblserie"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblcliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestión de Series</h1>
        <section>
        <form action="./Series" method="POST">
            <div><input type="hidden" name="id" value=""></div>
            <div><label for="temporada">Temporada:</label><input type="text" name="temporada"></div>
            <div><label for="nombre">Nombre:</label><input type="text" name="nombre"></div>
            <div><label for="estado">Estado:</label><input type="text" name="estado"></div>
            <div><label for="fechaIn">Fecha Inicio: </label><input type="text" name="fechaIn"></div>
            <div><label for="fechaFi">Fecha Fin: </label><input type="text" name="fechaFi"></div>
            <input type="submit" value="Registrar! ">
        </form>
        </section>
        <section>
            <table>
                <thead>
                <th>id</th>
                <th>temporada</th>
                <th>nombre</th>
                <th>estado</th>
                <th>fechaInicio</th>
                <th>fechaFin</th>
               

                </thead>
                <tbody>
                    <%
                        Vector<Tblserie> listaSeries = (Vector<Tblserie>) request.getAttribute("series");

                    %>


                    <%                        for (Tblserie serie : listaSeries) {%>

                    <tr>
                        <td><%=serie.getIdSerie()%></td>
                        <td><%=serie.getTemporada()%></td>
                        <td><%=serie.getNombre()%></td>
                        <td><%=serie.getEstado()%></td>
                        <td><%=serie.getFechaInicio()%></td>
                        <td><%=serie.getFechaFinal()%></td>
                        
               
                </tr>
                <%
                    }
                %>


                </tbody>


            </table>


        </section>
    </body>
</html>
