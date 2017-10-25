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
       <head>
        <title>VideoMONITO</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosGeneral.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosAgregarSerie.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script><!-- Codigo fuente Jquery -->
        <!-- <script src="{% static 'js/jQuery.js' %}"></script> -->
        <script src="js/ScriptsGeneral.js"></script>
        <script src="js/ScriptsIndex.js"></script>
        <script src="js/ScriptsPagPrincAdmin.js"></script>
    </head>
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
                <legend>Agregar Serie</legend>
                <form action="./Series" method="POST">
                    <div><input type="hidden" name="id" value=""></div>
                    <div class="arriba">
                        <div class="form-group">
                            <label for="inputNombre" class="control-label labels">Nombre</label>
                                <input type="text" class="form-control form" id="inputNombre" name="nombre" placeholder="Nombre">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputTemporada" class="control-label labels">Temporada</label>
                                <input type="number" class="form-control form" id="inputTemporada" name="temporada" min="1" max="16" placeholder="Temporada">
                        </div>
                    </div>

                    <div class="left">
                        <div class="form-group">
                            <label for="inputEstado" class="control-label labels">Estado</label>
                                <input type="text" class="form-control form" id="inputEstado" name="estado" placeholder="Estado">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputFechaInicio" class="control-label labels">Fecha Inicio</label>
                                <input type="text" class="form-control form" id="inputFechaInicio" name="fechaIn" placeholder="Fecha Inicio">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputFechaFinal" class="control-label labels">Fecha Final</label>
                                <input type="text" class="form-control form" id="inputFechaFinal" name="fechaFi" placeholder="Fecha Final">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <input type="submit" class="btn btn-default boton" name="guardar" value="Agregar Serie">
                        </div>
                    </div>
                </form>
            </fieldset>
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
        </div>
        
        
      
    </body>
</html>
