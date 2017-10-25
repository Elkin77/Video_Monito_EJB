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
        <title>VideoMONITO</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosGeneral.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosAgregarColeccion.css">
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
                <legend>Agregar Coleccion</legend>
                <form action="./Colecciones" method="POST">
                    <div><input type="hidden" name="id" value=""></div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputColeccion" class="control-label labels">Colección</label>
                                <input type="text" class="form-control form" id="inputColeccion" name="coleccion" placeholder="Coleccion">
                        </div>
                    </div>

                    <div class="left">
                        <div class="form-group">
                            <label for="inputVersion" class="control-label labels">Version</label>
                                <input type="text" class="form-control form" id="inputVersion" name="version" placeholder="Version">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputFechaCreacion" class="control-label labels">Fecha Creacion</label>
                                <input type="text" class="form-control form" id="inputFechaCreacion" name="fechaCreacion" placeholder="Fecha Creacion">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputEstado" class="control-label labels">Estado</label>
                                <input type="text" class="form-control form" id="inputEstado" name="estado" placeholder="Estado">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <input type="submit" class="btn btn-default boton" name="guardar" value="Agregar Coleccion">
                        </div>
                    </div>
                </form>
            </fieldset>
             
       <h1>Lista</h1>
        
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
        </div>
        
       
    </body>
</html>
