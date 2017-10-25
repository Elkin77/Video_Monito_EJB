<%-- 
    Document   : videoEnSerie
    Created on : 24-oct-2017, 20:51:43
    Author     : Ep77
--%>

<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblserie"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblserie"%>
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
       <h1>Agregar video a Serie </h1>
        <section>>
            <form action="./VideosPorSerie" method="POST">
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
                    Vector<Tblserie> listaSerie = (Vector<Tblserie>) request.getAttribute("listaClasifi");

                %>
                <div><label for="video">Serie: </label>
                    <SELECT name="serieId">
                        <%                        for (Tblserie clasif : listaSerie) {%>
                        <option value="<%=clasif.getIdSerie()%>"><%=clasif.getNombre()%> (<%=clasif.getTemporada()%>)</option>

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
