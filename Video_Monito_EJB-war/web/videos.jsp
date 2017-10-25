<%-- 
    Document   : videos
    Created on : 16-oct-2017, 10:09:36
    Author     : Ep77
--%>

<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblproveedor"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblclasificacion"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblcategoria"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>VideoMONITO</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosGeneral.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosAgregarVideo.css">
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
                <legend>Agregar Video</legend>
                <form action="./Lista_Categorias" method="POST">
                    <div><input type="hidden" name="id" value=""></div>
                    <div class="arriba">
                        <div class="form-group">
                            <label for="inputTitulo" class="control-label labels">Titulo Original: </label>
                            <input type="text" class="form-control form" name="titulo" placeholder="Titulo Original">   
                        </div>
                    </div>
                    <div class="arriba">
                        <div class="form-group">
                            <label for="descripcion" class="control-label labels">Descripcion: </label>
                            <textarea class="form-control form" rows="3" id="descripcion" name="descripcion" placeholder="Descripcion Pelicula"></textarea>
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputYearProduccion" class="control-label labels">A&ntilde;o Produccion</label>
                            <input type="text" class="form-control form" id="inputYearProduccion" name="yearProduccion" placeholder="A&ntilde;o Produccion">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputDuracion" class="control-label labels">Duracion</label>
                            <input type="text" class="form-control form" id="inputDuracion" name="duracion" placeholder="Duracion">
                        </div>
                    </div>
                    <%
                        Vector<Tblcategoria> listaCategorias = (Vector<Tblcategoria>) request.getAttribute("listaCat");

                    %>
                    <div class="left">
                        <div class="form-group">
                            <label for="selectCategoria" class="control-label labels">Categoria</label>
                            <select class="form-control form" id="selectCategoria" name="categoriaId">
                                <%                        for (Tblcategoria p : listaCategorias) {%>
                                <option value="<%=p.getIdCategoria()%>"><%=p.getCategoria()%></option>

                                <%
                                    }
                                %>
                            </select><br>
                        </div>
                    </div>
                    <%
                        Vector<Tblclasificacion> listaClasificacion = (Vector<Tblclasificacion>) request.getAttribute("listaClasifi");

                    %>
                    <div class="left">
                        <div class="form-group">
                            <label for="selectClasificacion" class="control-label labels">Clasificacion</label>
                            <select class="form-control form" id="selectClasificacion" name="clasificacionId">
                                <%                        for (Tblclasificacion clasif : listaClasificacion) {%>
                                <option value="<%=clasif.getIdClasificacion()%>"><%=clasif.getClasificacion()%></option>

                                <%
                                    }
                                %>
                            </select><br>
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputImagen" class="control-label labels">Imagen:</label>
                            <input type="text" class="form-control form" id="inputImagen" name="imagen" placeholder="Imagen">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputLinkVideo" class="control-label labels">Link Video:</label>
                            <input type="text" class="form-control form" id="inputLinkVideo" name="video" placeholder="Imagen">
                        </div>
                    </div>

                    <%
                        Vector<Tblproveedor> listaProveedores = (Vector<Tblproveedor>) request.getAttribute("listaProve");

                    %>
                    <div class="left">
                        <div class="form-group">
                            <label for="selectClasificacion" class="control-label labels">Proveedor: </label>
                            <select class="form-control form" id="selectClasificacion" name="proveedorId">
                                <%                        for (Tblproveedor prove : listaProveedores) {%>
                                <option value="<%=prove.getIdProveedor()%>"><%=prove.getNombres()%></option>

                                <%
                                    }
                                %>
                            </select><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <input type="submit" class="btn btn-default boton" name="guardar" value="Agregar Video">
                        </div>
                    </div>




                </form>
            </fieldset>
        </div>

    </body>
</html>

