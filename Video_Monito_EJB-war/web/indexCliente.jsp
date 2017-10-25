<%-- 
    Document   : indexCliente
    Created on : 25-oct-2017, 17:15:19
    Author     : Ep77
--%>

<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblidioma"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblcategoria"%>
<%@page import="java.util.Vector"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblvideo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente VideoMONITO</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosGeneral.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosPagPrincCliente.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrapCliente.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script><!-- Codigo fuente Jquery -->
        <script src="js/ScriptsGeneral.js"></script>

    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="titulo">VideoMONITO</div>
                <nav class="iconos">
                    <a href="#" ><i class="fa fa-user" aria-hidden="true"></i></a>
                    <a href="#" ><i class="fa fa-sign-out" aria-hidden="true"></i></a>
                </nav>
                <nav class="menu">
                    <a href="#" >Calificar Video</a>
                    <a href="#" >Referir Cliente</a>
                </nav>
            </div>
        </header>
        <div class="contenedor-menu">
            <form action="./IndexCliente" method="POST">
                <div class="busqueda">
                    <i class="fa fa-search searchImagen" aria-hidden="true"></i><input class="form-control control" id="inputBusqueda" name="busqueda" placeholder="Buscar Nombre Video" type="text">
                </div>
                <div class="caractIzq">
                    <select name ="tipoVideo" class="selectOption" >
                        <option value="#">Tipo Video</option>
                        <option value="#">Pelicula</option>
                        <option value="#">Serie</option>
                        <option value="#">Coleccion</option>
                    </select>
                    <select name ="year" class="selectOption">
                        <option value="year">A&ntilde;o</option>
                        <option value="2017">2017 - </option>
                        <option value="2016">2016 - </option>
                        <option value="2015">2015 - </option>
                        <option value="2014">2014 - </option>
                        <option value="2013">2013 - </option>
                        <option value="2012">2012 - </option>
                        <option value="2011">2011 - </option>
                        <option value="2010">2010 - </option>
                        <option value="2009">2009 - </option>
                        <option value="2008">2008 - </option>
                        <option value="2007">2007 - </option>
                        <option value="2006">2006 - </option>
                        <option value="2005">2005 - </option>
                        <option value="2004">2004 - </option>
                        <option value="2003">2003 - </option>
                        <option value="2002">2002 - </option>
                        <option value="2001">2001 - </option>
                        <option value="2000">2000 - </option>
                        <option value="1999">1999 - </option>
                        <option value="antiguos">Mas Antiguos</option>
                    </select>
                    <input type="number" min="0" max="5" class="selectOption" name="valoracion"  placeholder="Valoracion"><br>
                </div>
                <div class="caractDer">
                    <%
                        Vector<Tblcategoria> listaCategoria = (Vector<Tblcategoria>) request.getAttribute("listCategoria");

                    %>
                    <select name ="categoria" class="selectOption">
                        <option value="categoria">Categoria</option>
                        <%                        for (Tblcategoria categoria : listaCategoria) {%>
                        <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getCategoria()%></option>
                        <%
                        }
                    %>
                    </select>
                    <%
                        Vector<Tblidioma> listaIdiomas = (Vector<Tblidioma>) request.getAttribute("listIdiomas");

                    %>
                    <select name ="idioma" class="selectOption">
                        <option value="idioma">Idioma</option>
                        <%                        for (Tblidioma idioma : listaIdiomas) {%>
                        <option value="<%=idioma.getIdIdioma()%>"><%=idioma.getLenguaje()%>(<%=idioma.getSubtitulos()%>)</option>
                    <%
                        }
                    %>
                    </select>
                    <input type="number" min="60" max="240" class="selectOption" name="duracion" placeholder="Duracion(M)"><br>
                </div>

                <div class="btnBuscar">
                    <input type="submit" class="btn btn-default buscar" name="buscar" value="Buscar">
                </div>
            </form>
        </div>
         <%
                        Vector<Tblvideo> listaVideos = (Vector<Tblvideo>) request.getAttribute("listVideos");

                    %>
        
        
        <div class="contenedor-video">
            <h1 class="my-4">Videos
                <small>Registrados en el Sistema</small>
            </h1>
            <div class="row">
                <%                        for (Tblvideo video : listaVideos) {%>
                <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a> <!--Imagen -->
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#"><%=video.getTituloVideo()%></a> <!--Titulo video -->
                            </h4>
                        </div>
                    </div>
                </div>
                            <%
                        }
                    %>
            </div>
        </div>
    </body>
</html>
