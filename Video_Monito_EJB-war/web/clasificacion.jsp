<%-- 
    Document   : clasificacion
    Created on : 16-oct-2017, 1:24:30
    Author     : Ep77
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>VideoMONITO</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosGeneral.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/EstilosAgregarClasificacion.css">
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
                <legend>Agregar Clasificacion</legend>
                <form action="./Clasificacion" method="POST">
                    <div><input type="hidden" name="id" value=""></div>
                    <div class="arriba">
                        <div class="form-group">
                            <label for="inputClasificacion" class="control-label labels">Clasificacion</label>
                            <input type="text" class="form-control form" id="inputClasificacion" name="nombre" placeholder="Clasificacion">
                        </div>
                    </div>
                    <div class="arriba">
                        <div class="form-group">
                            <label for="descripcion" class="control-label labels">Descripcion</label>
                            <textarea class="form-control form" rows="3" id="descripcion" name="descripcion" placeholder="Descripcion"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <input type="submit" class="btn btn-default boton" name="guardar" value="Agregar Clasificacion">
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>


    </body>
</html>