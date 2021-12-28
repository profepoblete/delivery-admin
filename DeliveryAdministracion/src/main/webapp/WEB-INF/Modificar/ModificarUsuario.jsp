<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../include_files/head-dependences.jsp" %>
        <title>Modificar Usuario</title>
    </head>
    <body>
        <!--Barra de navegación-->
        <%@ include file="../../include_files/navigator.jsp" %>
        
        <div class="container-fluid px-5 pb-5 pt-4 bg-white ">
            
            <div class="pl-5 ml-5 pt-2 pb-1 navigation-links ">
                <a class="btn-link" href="${pageContext.request.contextPath}/RedirectMain" role="button">Inicio</a> >
                <a class="btn-link" href="${pageContext.request.contextPath}/ListarUsuarios" role="button">Gestionar usuarios</a> >
            </div>

            <div class="pb-2 px-5">

                <div class="mx-5 mb-4 pb-3 border-bottom">
                    <h3 class="mb-0 nav-item d-inline-block pl-2 py-0 font-weight-normal" style="border-style: solid; border-width: 0 0 0 7px; border-color: #FFB800;">
                        <span class="small text-muted font-italic">Modificar</span><br><i class="bi bi-person"></i> Usuarios
                    </h3>
                </div>

                <div class="px-4 mx-2">

                    <div class="col-sm-12 px-3">
                        <form id="formAdd" name="form" action="${pageContext.request.contextPath}/ModificarUsuario" method="post">
                            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}" />
                            
                            <div class="row">    
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="rut" class="col-form-label">Rut <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" id="rut" class="form-control" name="rut" value="${usuario.rut}" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="nombre" class="col-form-label">Nombre <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" class="form-control" name="nombre" value="${usuario.nombre}" required>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="apellido" class="col-form-label">Apellido <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" class="form-control" name="apellido" value="${usuario.apellido}" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="email" class="col-form-label">Email <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="email" class="form-control" name="email" value="${usuario.email}" required>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="contrasena" class="col-form-label">Contraseña</label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="password" id="password" class="form-control" name="contrasena" autocomplete="new-password">
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="contrasena2" class="col-form-label">Repetir Contraseña</label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="password" class="form-control" name="contrasena2" autocomplete="new-password">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col">  
                                    <div class="col-sm-12 px-0">
                                        <label for="telefono" class="col-form-label">Teléfono</label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="tel" id="telefono" class="form-control" name="telefono" value="${usuario.telefono}">
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="tipoUsuario" class="col-form-label">Tipo usuario <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <select class="form-control" name="tipoUsuario" required>
                                            <c:forEach var="tipoUsuario" items="${tiposUsuario}">
                                                <option value="${tipoUsuario.idTipoUsuario}" <c:if test="${tipoUsuario.idTipoUsuario==usuario.tipoUsuario.idTipoUsuario}">selected</c:if>>
                                                    ${tipoUsuario.idTipoUsuario}: ${tipoUsuario.descripcion}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="puntoVenta" class="col-form-label">Punto venta</label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <select class="form-control" name="puntoVenta">
                                            <option value="0">
                                                Sin punto de venta asociado.
                                            </option>
                                            <c:forEach var="puntoVenta" items="${puntosVenta}">
                                                <option value="${puntoVenta.idPuntoVenta}" <c:if test="${puntoVenta.idPuntoVenta==usuario.puntoVenta.idPuntoVenta}">selected</c:if>>
                                                    ${puntoVenta.idPuntoVenta}: ${puntoVenta.nombre}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    
                                </div>
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="sede" class="col-form-label">Sede <b class="text-secondary">*</b></label> 
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <select class="form-control " name="sede" required>
                                            <c:forEach var="sede" items="${sedes}">
                                                <option value="${sede.idSede}" <c:if test="${sede.idSede==usuario.sede.idSede}">selected</c:if>>
                                                    ${sede.idSede}: ${sede.nombreSede}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="col-sm-12 px-0">
                                        <label for="activo" class="col-form-label pb-1">Activo</label> 
                                        <input type="checkbox" class="align-middle d-inline-block ml-4" name="activo" <c:if test="${usuario.activo==true}">checked=""</c:if>>
                                    </div>
                                </div>
                            </div>

                            <div class="col text-center">
                                <button type="submit" name="Modificar" class="btn btn-success">Modificar</button>
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
        
        $("#rut").mask("00.000.000-A", {reverse: true});
        $("#telefono").mask("0 0000 0000");
        
        $(document).ready(function() {
            <%@ include file="../../include_files/general-scripts.js" %>
            <%@ include file="../../include_files/agregar-modificar-scripts.js" %>
            $("#formAdd").validate({
                rules: {
                    rut: {
                        required: true,
                        minlength: 11,
                        maxlength: 12
                    },
                    nombre: {
                        required: true,
                        minlength: 2,
                        maxlength: 50
                    },
                    apellido: {
                        required: true,
                        minlength: 2,
                        maxlength: 50
                    },
                    email: {
                        required: true,
                        maxlength: 50,
                        email: true
                    },
                    telefono: {
                        minlength: 11
                    },
                    contrasena: {
                        maxlength: 30
                    },
                    contrasena2: {
                        equalTo: '#password'
                    },
                    tipoUsuario: {
                        required: true
                    },
                    puntoVenta: {
                        required: true
                    },
                    sede: {
                        required: true
                    }
                },
                messages: {
                    rut: {
                        required: "Este campo es obligatorio.",
                        minlength: "Complete rut. Ej: 12.345.678-9.",
                        maxlength: "Complete rut. Ej: 12.345.678-9."
                    },
                    nombre: {
                        required: "Este campo es obligatorio.",
                        minlength: "Mínimo: 2.",
                        maxlength: "Máximo: 50."
                    },
                    apellido: {
                        required: "Este campo es obligatorio.",
                        minlength: "Mínimo: 2",
                        maxlength: "Máximo: 50"
                    },
                    email: {
                        required: "Este campo es obligatorio.",
                        maxlength: "Máximo: 50.",
                        email: "Formato erroneo: email (Ej: usuario@duoc.cl)."
                    },
                    telefono: {
                        minlength: "Teléfono: 9 dígitos."
                    },
                    contrasena: {
                        maxlength: "Máximo: 30."
                    },
                    contrasena2: {
                        equalTo: "Contraseña no coincide."
                    },
                    tipoUsuario: {
                        required: "Este campo es obligatorio."
                    },
                    puntoVenta: {
                        required: "Este campo es obligatorio."
                    },
                    sede: {
                        required: "Este campo es obligatorio."
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
