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
        <title>VideoMONITO</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosGeneral.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosAgregarVideoSerie.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script><!-- Codigo fuente Jquery -->
        <!-- <script src="{% static 'js/jQuery.js' %}"></script> -->
        <script src="js/ScriptsGeneral.js"></script>
        <script src="js/ScriptsIndex.js"></script>
        <script src="js/ScriptsPagPrincAdmin.js"></script>
    </head>
    <body class="cuerpo">

        <header>
            <div class="wrapper">
                <div class="titulo">VideoMONITO</div>
                <nav class="iconos">
                    <a href="#" ><i class="fa fa-user" aria-hidden="true"></i></a>
                    <a href="#" ><i class="fa fa-sign-out" aria-hidden="true"></i></a>
                </nav>
            </div>
        </header>

        <div class="contenedorAgregarVideo">
            <fieldset>
                <legend>Agregar Video a Serie</legend>
                <form action="./VideosPorSerie" method="POST">
                    <div><input type="hidden" name="id" value=""></div>
                        <%
                            Vector<Tblvideo> listaVideos = (Vector<Tblvideo>) request.getAttribute("listaCat");

                        %>
                    <div class="arriba">
                        <div class="form-group">
                            <label for="selectVideo" class="control-label labels">Video</label>
                            <select class="form-control form" id="selectVideo" name="videoId">
                                <%                        for (Tblvideo p : listaVideos) {%>
                                <option value="<%=p.getIdVideo()%>"><%=p.getTituloVideo()%></option>

                                <%
                                    }
                                %>
                            </select><br>
                        </div>
                    </div>
                    <%
                        Vector<Tblserie> listaSerie = (Vector<Tblserie>) request.getAttribute("listaClasifi");

                    %>
                    <div class="arriba">
                        <div class="form-group">
                            <label for="selectSerie" class="control-label labels">Serie</label>
                            <select class="form-control form" id="selectSerie" name="serieId">
                                <%                        for (Tblserie clasif : listaSerie) {%>
                                <option value="<%=clasif.getIdSerie()%>"><%=clasif.getNombre()%> (<%=clasif.getTemporada()%>)</option>

                                <%
                                    }
                                %>
                            </select><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <input type="submit" class="btn btn-default boton" name="guardar" value="Agregar Video a Serie">
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>
    </body>
</html>
