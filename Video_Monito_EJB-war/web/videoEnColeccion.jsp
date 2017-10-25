<%-- 
    Document   : videoEnColeccion
    Created on : 25-oct-2017, 0:58:01
    Author     : Ep77
--%>

<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblcoleccion"%>
<%@page import="java.util.Vector"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblvideo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Agregar video a Colección </h1>
        <section>>
            <form action="./VideosPorColeccion" method="POST">
                <div><input type="hidden" name="id" value=""></div>
                    <%
                        Vector<Tblvideo> listaVideos = (Vector<Tblvideo>) request.getAttribute("listaCat");

                    %>
                <div><label for="video">Video: </label>
                    <SELECT name="videoId">
                        <%                        for (Tblvideo p : listaVideos) {%>
                        <option value="<%=p.getIdVideo()%>"><%=p.getTituloVideo()%></option>

                        <%
                            }
                        %>
                    </SELECT>
                </div>

                <%
                    Vector<Tblcoleccion> listaColecciones = (Vector<Tblcoleccion>) request.getAttribute("listaClasifi");

                %>
                <div><label for="video">Coleccion: </label>
                    <SELECT name="coleccionId">
                        <%                        for (Tblcoleccion colec : listaColecciones) {%>
                        <option value="<%=colec.getIdColeccion()%>"><%=colec.getColeccion()%> (<%=colec.getVersion()%>)</option>

                        <%
                            }
                        %>
                    </SELECT>
                </div>


                <input type="submit" value="Registrar! ">
            </form>
        </section>
    </body>
</html>
