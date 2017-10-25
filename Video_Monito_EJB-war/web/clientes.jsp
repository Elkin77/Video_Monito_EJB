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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Clientes</title>
    </head>
    <body>
        <h1>Gestión de Clientes</h1>
        <section>
            <form action="./Clientes" method="POST">
                <div><input type="hidden" name="id" value="${cliente.getIdCliente()}"></div>
                <div><label for="nombre">Nombre: </label><input type="text" name="nombre" value="${cliente.getNombre()}"></div>
                <div><label for="apellido">Apellido: </label><input type="text" name="apellido" value="${cliente.getApellido()}"></div>
                <div><label for="password">Password:</label><input type="text" name="password" value="${cliente.getPassword()}"></div>
                <div><label for="documento">Documento: </label><input type="text" name="documento" value="${cliente.getDocumento()}"></div>

                <div><label for="correo">Correo: </label><input type="text" name="correo" value="${cliente.getCorreo()}"></div>
                <div><label for="referido">Referido: </label><input type="text" name="referido" value="${cliente.getReferido()}"></div>
                <div><label for="puntos">Puntos </label><input type="text" name="puntos" value="${cliente.getPuntos()}"></div>

                <input type="submit" value="Registrar! ">
            </form>
        </section>
        <section>
            <table>
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
                    <input type="hidden" name="id" value="<%=cliente.getIdCliente()%>">
                    <input type="hidden" name="eliminar" value="true">
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
