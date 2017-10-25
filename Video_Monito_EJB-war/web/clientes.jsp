<%-- 
    Document   : clientes
    Created on : 23-oct-2017, 17:48:19
    Author     : Ep77
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="co.edu.uniminuto.video_monito_ejb.entities.Tblcliente"%>
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
                <legend>Gestionar Clientes</legend>

                <form action="./Clientes" method="POST">
                    <div><input type="hidden" name="id" value="${cliente.getIdCliente()}"></div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputNombre" class="control-label labels">Nombre: </label> 
                            <input type="text" class="form-control form" id="inputNombre" name="nombre" value="${cliente.getNombre()}">
                        </div>                    
                    </div>
                    <div class="left">
                        <div class="form-group">
                            <label for="inputApellido" class="control-label labels">Apellido: </label> 
                            <input type="text" class="form-control form" id="inputApellido" name="apellido" value="${cliente.getApellido()}">
                        </div>                    
                    </div>

                    <div class="left">
                        <div class="form-group">
                            <label for="inputPass" class="control-label labels">Password: </label> 
                            <input type="text" class="form-control form" id="inputPass" name="password" value="${cliente.getPassword()}">
                        </div>                    
                    </div>

                    <div class="left">
                        <div class="form-group">
                            <label for="inputDocumento" class="control-label labels">Documento: </label> 
                            <input type="text" class="form-control form" id="inputDocumento" name="documento" value="${cliente.getDocumento()}">
                        </div>                    
                    </div>

                    <div class="left">
                        <div class="form-group">
                            <label for="inputCorreo" class="control-label labels">Correo: </label> 
                            <input type="text" class="form-control form" id="inputCorreo" name="correo" value="${cliente.getCorreo()}">
                        </div>                    
                    </div> 

                    <div class="left">
                        <div class="form-group">
                            <label for="inputReferido" class="control-label labels">Referido: </label> 
                            <input type="text" class="form-control form" id="inputReferido" name="referido" value="${cliente.getReferido()}">
                        </div>                    
                    </div> 
                    <div class="left">
                        <div class="form-group">
                            <label for="inputPuntos" class="control-label labels">Puntos: </label> 
                            <input type="text" class="form-control form" id="inputPuntos" name="puntos" value="${cliente.getPuntos()}">
                        </div>                    
                    </div> 

                    <div class="form-group">
                        <div class="col-lg-offset-2">
                            <input type="submit" class="btn btn-default boton" name="guardar" value="Agregar Cliente">
                        </div>
                    </div>

                </form>

            </fieldset>
        </div>
        
        <section>
            <table class="table">
                <thead>
                <th>id</th>
                <th>nombre</th>
                <th>apellido</th>
                <th>password</th>
                <th>documento</th>
                <th>fecha</th>
                <th>correo</th>
                <th>referido</th>
                <th>puntos</th>
                <th>acciones</th>

                </thead>
                <tbody>
                    <%
                        Vector<Tblcliente> listaClientes = (Vector<Tblcliente>) request.getAttribute("clientes");

                    %>


                    <%                        for (Tblcliente cliente : listaClientes) {%>

                    <tr>
                        <td><%=cliente.getIdCliente()%></td>
                        <td><%=cliente.getNombre()%></td>
                        <td><%=cliente.getApellido()%></td>
                        <td><%=cliente.getPassword()%></td>
                        <td><%=cliente.getDocumento()%></td>
                        <td><%=cliente.getFechaIngreso()%></td>
                        <td><%=cliente.getCorreo()%></td>
                        <td><%=cliente.getReferido()%></td>
                        <td><%=cliente.getPuntos()%></td>
                        <td><a href="./Clientes?id=<%=cliente.getIdCliente()%>">editar</a> |
                            <form action="./Clientes" method="POST">
                                <input type="hidden" name="id2" value="<%=cliente.getIdCliente()%>">
                                <input type="hidden" name="delete" value="true">
                                <input type="submit" value="Eliminar">
                                </td>

                            </form>
                    </tr>
                    <%
                        }
                    %>


                </tbody>


            </table>


        </section>
    </body>
</html>
