<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../include_files/head-dependences.jsp" %>
        <title>Modificar Ubicación</title>
    </head>
    <body>
        
    <!--Barra de navegación-->
        <%@ include file="../../include_files/navigator.jsp" %>
        
        
        <div class="container-fluid px-5 pb-5 pt-4 bg-white ">
            
            <div class="pl-5 ml-5 pt-2 pb-1 navigation-links ">
                <a class="btn-link" href="${pageContext.request.contextPath}/RedirectMain" role="button">Inicio</a> >
                <a class="btn-link" href="${pageContext.request.contextPath}/ListarSedes" role="button">Gestionar Sedes</a> >
                <form class="d-inline-block" action="${pageContext.request.contextPath}/ListarUbicaciones" method="post">
                    <input type="hidden" name="idSede" value="${sede.idSede}">
                    <button class="btn-link" href="${pageContext.request.contextPath}/ListarSedes" role="button">Gestionar Ubicaciones</button> >
                </form>
            </div>

            <div class="pb-2 px-5">

                <div class="mx-5 mb-4 pb-3 border-bottom d-flex justify-content-between align-items-end">
                    <h3 class="mb-0 nav-item d-inline-block pl-2 py-0 font-weight-normal" style="border-style: solid; border-width: 0 0 0 7px; border-color: #FFB800;">
                        <span class="small text-muted font-italic">Modificar</span><br><i class="bi bi-geo-alt"></i> Ubicaciones
                    </h3>
                    <h5 class="mb-0 font-weight-normal text-dark d-inline-block text-center text-uppercase" >
                        <i class="bi bi-building"> </i>${ubicacion.sede.nombreSede}
                    </h5>
                    <div class="text-right px-0" style="width: 198.83px;">
                    </div> 
                </div>

                <div class="px-4 mx-2">

                    <div class="col-sm-12 px-3">
                        <form id="formAdd" name="form" action="${pageContext.request.contextPath}/ModificarUbicacion" method="post">
                            <input type="hidden" name="idUbicacion" value="${ubicacion.idUbicacion}">
                            <input type="hidden" name="idSede" value="${ubicacion.sede.idSede}">
                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="nombreEdificio" class="col-form-label">Nombre Edificio <b class="text-secondary">*</b></label>
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" class="form-control" name="nombreEdificio" id="nombreEdificio" autocomplete="off" value="${ubicacion.nombreEdificio}" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="piso" class="col-form-label">Piso <b class="text-secondary">*</b></label>
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" class="form-control" name="piso" id="piso" autocomplete="off" value="${ubicacion.piso}" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col text-center pt-2">
                                <button type="submit" name="Modificar" class="btn btn-success mt-4">Modificar</button>
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
                    nombreEdificio: {
                        required: true,
                        minlength: 3,
                        maxlength: 50
                    },
                    piso: {
                        required: true,
                        maxlength: 50
                    }
                },
                messages: {
                    nombreEdificio: {
                        required: "Este campo es obligatorio.",
                        minlength: "Mínimo: 3 caracteres.",
                        maxlength: "Máximo: 50 caracteres."
                    },
                    piso: {
                        required: "Este campo es obligatorio.",
                        maxlength: "Máximo: 50 caracteres."
                    }
                }
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