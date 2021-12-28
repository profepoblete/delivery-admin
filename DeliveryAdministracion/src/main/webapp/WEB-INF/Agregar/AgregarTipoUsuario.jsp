<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../include_files/head-dependences.jsp" %>
        <title>Agregar Tipo Usuario</title>
    </head>
    <body>
        <!--Barra de navegación-->
        <%@ include file="../../include_files/navigator.jsp" %>
               
        <div class="container-fluid px-5 pb-5 pt-4 bg-white ">
            
            <div class="pl-5 ml-5 pt-2 pb-1 navigation-links ">
                <a class="btn-link" href="${pageContext.request.contextPath}/RedirectMain" role="button">Inicio</a> >
                <a class="btn-link" href="${pageContext.request.contextPath}/ListarTipoUsuarios" role="button">Gestionar tipos de usuario</a> >
            </div>

            <div class="pb-2 px-5">

                <div class="mx-5 mb-4 pb-3 border-bottom">
                    <h3 class="mb-0 nav-item d-inline-block pl-2 py-0 font-weight-normal" style="border-style: solid; border-width: 0 0 0 7px; border-color: #FFB800;">
                        <span class="small text-muted font-italic">Agregar</span><br><i class="bi bi-people"></i> Tipos de usuario
                    </h3>
                </div>

                <div class="px-4 mx-2">

                    <div class="col-sm-12 px-3">
                        <form id="formAdd" name="form" action="${pageContext.request.contextPath}/AgregarTipoUsuario" method="post">
                            <div class="row">
                                <div class="col">
                                    <div class="col-sm-12 px-0">
                                        <label for="descripcion" class="col-form-label">Descripción Tipo Usuario <b class="text-secondary">*</b></label><br>
                                    </div>
                                    <div class="col-sm-12 px-0">
                                        <input type="text" class=" form-control" name="descripcion" autocomplete="off" required>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col text-center pt-2">
                                <button type ="submit" name="Agregar" class="btn btn-success mt-4">Agregar</button>
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
                    descripcion: {
                        required: true,
                        minlength: 3,
                        maxlength: 40
                    }
                },
                messages: {
                    descripcion: {
                        required: "Este campo es obligatorio.",
                        minlength: "Mínimo: 3 caracteres.",
                        maxlength: "Máximo: 40 caracteres."
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