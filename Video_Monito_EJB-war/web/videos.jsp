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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar Videos</title>
    </head>
    <body>

        <h1>Gestión de Videos </h1>
        <section>>
            <form action="./Lista_Categorias" method="POST">
                <div><input type="hidden" name="id" value=""></div>
                <div><label for="yearProduccion">Año Produccion: </label><input type="text" name="yearProduccion"></div>
                <div><label for="duracion">Duracion: </label><input type="text" name="duracion"></div>
                <div><label for="titulo">Titulo Video: </label><input type="text" name="titulo"></div>
                <div><label for="descripcion">Descripcion: </label><input type="text" name="descripcion"></div>  
                <div><label for="imagen">Imagen: </label><input type="text" name="imagen"></div>
                <div><label for="video">Video: </label><input type="text" name="video"></div>
                    <%
                        Vector<Tblcategoria> listaCategorias = (Vector<Tblcategoria>) request.getAttribute("listaCat");

                    %>
                <div><label for="video">Categoria: </label>
                    <SELECT name="categoriaId">
                        <%                        for (Tblcategoria p : listaCategorias) {%>
                        <option value="<%=p.getIdCategoria()%>"><%=p.getCategoria()%></option>

                        <%
                            }
                        %>
                    </SELECT>
                </div>

                <%
                    Vector<Tblclasificacion> listaClasificacion = (Vector<Tblclasificacion>) request.getAttribute("listaClasifi");

                %>
                <div><label for="video">Clasificación: </label>
                    <SELECT name="clasificacionId">
                        <%                        for (Tblclasificacion clasif : listaClasificacion) {%>
                        <option value="<%=clasif.getIdClasificacion()%>"><%=clasif.getClasificacion()%></option>

                        <%
                            }
                        %>
                    </SELECT>
                </div>

                <%
                    Vector<Tblproveedor> listaProveedores = (Vector<Tblproveedor>) request.getAttribute("listaProve");

                %>
                <div><label for="video">Proveedor: </label>
                    <SELECT name="proveedorId">
                        <%                        for (Tblproveedor prove : listaProveedores) {%>
                        <option value="<%=prove.getIdProveedor()%>"><%=prove.getNombres()%></option>

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

