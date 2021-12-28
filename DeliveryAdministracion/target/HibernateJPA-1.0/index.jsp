<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include_files/head-dependences.jsp" %>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Delivery Administrativo Duoc UC</title>
    </head><!-- COLORES: [azul:012c56]   [negro:1a1a1a]  -->
    <body style="background-color: #F4F4F4;">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>

                    <div class="container-fluid mx-0 px-0 w-100">
                        
                        <div class="w-100 pb-3 pt-2">
                            <center class="py-1"><img src="https://www.duoc.cl/wp-content/themes/wordpress-duoc-cl/images/logo-duoc.svg" alt="" style="width:270px;"/></center>
                            <div class="h3 font-weight-light mb-0 text-light text-center">Administración: Sistema delivery</div>
                        </div>
                        
                        <div class="text-center py-5" style="background-color: #F4F4F4;">

                            <div class="d-inline-block" style="max-width: 600px; min-width: 550px;">
                                <c:if test="${errorLogin==1}">
                                    <div class="card-header h6 alert alert-danger">
                                        <label class="mt-1">Las credenciales son erroneas. Login rechazado.</label>
                                        <button type="button" class="close stretched-link" data-dismiss="alert" aria-label="Close">
                                            &times;
                                        </button>
                                    </div>
                                </c:if>
                                <div class="card border-0 shadow">
                                    <!--
                                    <div class="card-body pt-3 px-4 pb-1 text-center login-header border-0 " style="background-color: rgba(230,230,230,1);">
                                        
                                         Botones de redes sociales (Evaluar si quitarlos o dejarlos))
                                        <a class="btn-icon mx-2" href="https://es-la.facebook.com/DuocUC/" target="_blank"><i class="bi bi-facebook"></i></a>
                                        <a class="btn-icon mx-2" href="https://www.duoc.cl/" target="_blank"><i class="bi bi-google "></i></a>
                                        <a class="btn-icon mx-2" href="https://twitter.com/DuocUC" target="_blank"><i class="bi bi-twitter"></i></a>
                                        <a class="btn-icon mx-2" href="https://www.instagram.com/duocuc_cl/" target="_blank"><i class="bi bi-instagram"></i></a>
                                        <a class="btn-icon mx-2" href="https://www.linkedin.com/company/duocuc/" target="_blank"><i class="bi bi-linkedin"></i></a>
                                        <a class="btn-icon mx-2" href="https://www.youtube.com/user/DuocUCvideos" target="_blank"><i class="bi bi-youtube"></i></a>
                                        
                                    </div>
                                    -->
                                    <div class="card-body p-4 text-uppercase">
                                        <form action="${pageContext.request.contextPath}/ServletLogin" method="POST">
                                            <div class="form-group">
                                                <label class="" for="txtUsuario">
                                                    Email
                                                </label>
                                                <input class="form-control p-4" name="email" id="txtUsuario" type="text" placeholder="" aria-label="Email Address" aria-describedby="emailExample" />
                                            </div>
                                            <div class="form-group">
                                                <label class="" for="txtContrasena">
                                                    Contraseña
                                                </label>
                                                <input class="form-control p-4" type="password" name="contrasena" id="txtContrasena" placeholder="" aria-label="Password" aria-describedby="passwordExample" />
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mb-0">
                                                <input class="btn btn-success" style="margin: auto" type="submit" name="btnAccion" value="Ingresar">
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <%@ include file="include_files/footer.jsp" %>
            </div>
        </div>
        <!--
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        -->
        <script src="files/linkeds/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="files/linkeds/bootstrap4.3.1.bundle.min.js" type="text/javascript"></script>
        <script src="files/linkeds/scripts.js"></script>
    </body>
</html>


