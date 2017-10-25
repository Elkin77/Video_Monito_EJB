<%-- 
    Document   : personas
    Created on : 25-oct-2017, 1:49:57
    Author     : Ep77
--%>

<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblpersona"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>VideoMONITO</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosGeneral.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosAgregarVideoColeccion.css">
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
                <form action="./PersonasVideo" method="POST">
                    
                    <div class="left">
                        <div class="form-group">
                            <label for="inputColeccion" class="control-label labels">Id: </label>
                            <input type="text" class="form-control form" id="inputColeccion" name="id" placeholder="Nombre">
                        </div>
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputColeccion" class="control-label labels">Nombre: </label>
                            <input type="text" class="form-control form" id="inputColeccion" name="nombre" placeholder="Nombre">
                        </div>
                    </div>

                    <div class="left">
                        <div class="form-group">
                            <label for="inputVersion" class="control-label labels">Apellido: </label>
                            <input type="text" class="form-control form" id="inputVersion" name="apellido" placeholder="Apellido">
                        </div>
                    </div>

                    <div class="left">
                        <div class="form-group">
                            <label for="selectSerie" class="control-label labels">Rol: </label>
                            <select class="form-control form" id="papel" name="papel">
                                <option>Director</option>
                                <option>Productor</option>
                                <option>Actor</option>

                            </select><br>
                        </div>
                    </div>



                        <div class="left">
                            <div class="form-group">
                                <label for="inputFechaCreacion" class="control-label labels">Descripcion: </label>
                                <input type="text" class="form-control form" id="inputFechaCreacion" name="descripcion" placeholder="descripcion">
                            </div>
                        </div>
                        <div class="left">
                            <div class="form-group">
                                <label for="inputEstado" class="control-label labels">Edad: </label>
                                <input type="text" class="form-control form" id="inputEstado" name="edad" placeholder="edad">
                            </div>
                        </div>

                        <div class="left">
                            <div class="form-group">
                                <label for="inputEstado" class="control-label labels">Páis: </label>
                                <input type="text" class="form-control form" id="inputEstado" name="pais" placeholder="pais">
                            </div>
                        </div>

                        <div class="left">
                            <div class="form-group">
                                <label for="inputEstado" class="control-label labels">Premios: </label>
                                <input type="text" class="form-control form" id="inputEstado" name="premios" placeholder="premios">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <input type="submit" class="btn btn-default boton" name="guardar" value="Agregar Coleccion">
                            </div>
                        </div>
                </form>
            </fieldset>

            <h1>Lista de Personas Creadas</h1>

            <section>
                <table class="table">
                    <thead>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Rol</th>
                    <th>Descripción</th>
                    <th>Edad</th>    
                    <th>Pais</th>
                    <th>Premios</th>


                    </thead>
                    <tbody>
                        <%
                            Vector<Tblpersona> listaPersonas = (Vector<Tblpersona>) request.getAttribute("listPersonas");

                        %>


                        <%                        for (Tblpersona perso : listaPersonas) {%>

                        <tr>
                            <td><%=perso.getIdPersona()%></td>
                            <td><%=perso.getNombre()%></td>
                            <td><%=perso.getApellido()%></td>
                            <td><%=perso.getPapelVideo()%></td>
                            <td><%=perso.getDescripcion()%></td>
                            <td><%=perso.getEdad()%></td>
                            <td><%=perso.getPais()%></td>
                            <td><%=perso.getPremios()%></td>   

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
