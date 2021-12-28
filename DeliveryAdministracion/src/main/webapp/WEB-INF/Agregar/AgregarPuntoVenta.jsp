<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../include_files/head-dependences.jsp" %>
        <title>Agregar Punto Venta</title>
        <script type="text/javascript" src="js/bootstrap-filestyle.min.js"> </script>
    </head>
    <body>
        <!--Barra de navegación-->
        <%@ include file="../../include_files/navigator.jsp" %>
            
            
        <div class="container-fluid px-5 pb-5 pt-4 bg-white ">
            
            <div class="pl-5 ml-5 pt-2 pb-1 navigation-links ">
                <a class="btn-link" href="${pageContext.request.contextPath}/RedirectMain" role="button">Inicio</a> >
                <a class="btn-link" href="${pageContext.request.contextPath}/ListarPuntoVentas" role="button">Gestionar puntos de venta</a> >
            </div>

            <div class="pb-2 px-5">

                <div class="mx-5 mb-4 pb-3 border-bottom">
                    <h3 class="mb-0 nav-item d-inline-block pl-2 py-0 font-weight-normal" style="border-style: solid; border-width: 0 0 0 7px; border-color: #FFB800;">
                        <span class="small text-muted font-italic">Agregar</span><br><i class="bi bi-credit-card"></i> Puntos de venta
                    </h3>
                </div>

                <div class="px-4 mx-2">

                    <div class="col-sm-12 px-3">
                        <form id="formAdd" name="form" action="${pageContext.request.contextPath}/AgregarPuntoVenta" enctype="multipart/form-data" method="post">

                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="nombre" class="col-form-label pb-1">Nombre <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" class="form-control" name="nombre" autocomplete="off" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="empresa" class="col-form-label pb-1">Empresa <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" class="form-control" name="empresa" autocomplete="off" required>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="imagen" class="col-form-label pb-1">Imagen <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="file" class="custom-file-input" id="inputImagen" name="imagen" accept="image/png, image/jpeg">
                                        <label class="custom-file-label" for="inputImagen">
                                            Seleccione un archivo
                                        </label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="sede" class="col-form-label pb-1">Sede <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <select class="form-control" name="sede" required>
                                            <c:forEach var="sede" items="${sedes}">
                                                <option value="${sede.idSede}">
                                                    ${sede.idSede}: ${sede.nombreSede}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="horaInicio" class="col-form-label pb-1">Hora inicio <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="time" class="form-control"  name="horaInicio" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="horaFin" class="col-form-label pb-1">Hora Fin <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="time" class="form-control" name="horaFin" required>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="col-sm-12 px-0">
                                        <label for="activo" class="col-form-label pb-1">Activo</label> 
                                        <input type="checkbox" class="align-middle d-inline-block ml-4" name="activo" checked="">
                                    </div>
                                </div>
                            </div>
                            <div class="col text-center">
                                <button type="submit" name="Agregar" class="btn btn-success">Agregar</button>
                            </div>
                            
                        </form>
                    </div>
                        
                </div>
                
            </div> 
        </div>

        <%@ include file="../../include_files/footer.jsp" %>
        <!--                
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/additional-methods.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/additional-methods.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>
        -->
        <script src="files/linkeds/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="files/linkeds/bootstrap4.3.1.bundle.min.js" type="text/javascript"></script>
        <script src="files/linkeds/jquery.validate.js" type="text/javascript"></script>
        <script src="files/linkeds/jquery.validate.min.js" type="text/javascript"></script>
        <script src="files/linkeds/additional-methods.js" type="text/javascript"></script>
        <script src="files/linkeds/additional-methods.min.js" type="text/javascript"></script>
        <script src="files/linkeds/jquery.mask.js" type="text/javascript"></script>
        <script src="files/linkeds/jquery.mask.min.js" type="text/javascript"></script>

        
    </body>
    <script>
        $(document).ready(function() {
            <%@ include file="../../include_files/general-scripts.js" %>
            <%@ include file="../../include_files/agregar-modificar-scripts.js" %>
            $("#formAdd").validate({
                rules: {
                    nombre: {
                        required: true,
                        maxlength: 100
                    },
                    empresa: {
                        required: true,
                        maxlength: 100
                    },
                    imagen: {
                        required: true,
                        extension: "jpg|jpeg|png"
                    },
                    horaInicio: {
                        required: true
                    },
                    horaFin: {
                        required: true
                    },
                    sede: {
                        required: true
                    }
                },
                messages: {
                    nombre: {
                        required: "Este campo es obligatorio.",
                        maxlength: "Máximo: 100 caracteres."
                    },
                    empresa: {
                        required: "Este campo es obligatorio.",
                        maxlength: "Máximo: 100 caracteres."
                    },
                    imagen: {
                        required: "Este campo es obligatorio.",
                        extension: "El archivo debe ser JPG o PNG."
                    },
                    horaInicio: {
                        required: "Este campo es obligatorio."
                    },
                    horaFin: {
                        required: "Este campo es obligatorio."
                    },
                    sede: {
                        required: "Este campo es obligatorio."
                    }
                }
            });
            $('.custom-file-input').on('change', function() { 
                let fileName = $(this).val().split('\\').pop(); 
                $(this).next('.custom-file-label').addClass("selected").html(fileName); 
            });
            
        } );
        $('input[type="text"]').change(function(){
            this.value = $.trim(this.value);
        });
        $('input[type="email"]').change(function(){
            this.value = $.trim(this.value);
        });
        $('input[type="tel"]').change(function(){
            this.value = $.trim(this.value);
        });
    </script>
</html>

