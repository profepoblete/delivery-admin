<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../include_files/head-dependences.jsp" %>
        <title>Delivery Duoc Administrativo</title>
    </head>
    
    <body class="bg-white">  
        
        <!--Barra de navegación-->
        <%@ include file="../include_files/navigator.jsp" %>

        <div class="">
            <div class='d-flex w-100 justify-content-around align-items-center p-0 px-2 big-home-box pt-2'>
                <div class='col-md-6 p-1 bg-light' style="height: 300px;">
                    <div class='text-white text-center h-100 home-box float-right w-100' style="background-image: url('assets/antonio-varas.jpg'); transform: rotate(0);">
                        <div class="icon-in-box-l" ><i class="bi bi-building text-white h2 float-right align-self-center"></i></div>
                        <div class='d-flex h-100 align-items-center justify-content-center div-home-box'>
                            <div class="pb-5">
                                <h1 class="font-weight-normal pb-4"> Sedes </h1>
                                <a href="${pageContext.request.contextPath}/ListarSedes" class='link-primary stretched-link'>GESTIONAR <i class="bi bi-chevron-right ml-3"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class='col-md-6 p-1 bg-light' style="height: 300px;">
                    <div class='text-white text-center h-100 home-box' style="background-image: url('assets/punto-venta.jpg'); transform: rotate(0);">
                        <div class="icon-in-box-r" ><i class="bi bi-credit-card text-white h2 float-left"></i></div>
                        <div class='d-flex h-100 align-items-center justify-content-center div-home-box'>
                            <div class="pb-5">
                                <h1 class="font-weight-normal pb-4"> Puntos de Venta </h1>
                                <a href="${pageContext.request.contextPath}/ListarPuntoVentas" class='link-primary stretched-link'>GESTIONAR <i class="bi bi-chevron-right ml-3"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class='d-flex w-100 justify-content-around align-items-center px-2 pb-2 big-home-box'>
                <div class='col-md-6 p-1 bg-light' style="height: 300px;">
                    <div class="text-white text-center h-100 home-box float-right w-100" style="background-image: url('assets/usuario.png'); transform: rotate(0);">
                        <div class="icon-in-box-l" ><i class="bi bi-person text-white h2 float-right"></i></div>
                        <div class="d-flex h-100 align-items-center justify-content-center div-home-box">
                            <div class="pb-5">
                                <h1 class="font-weight-normal pb-4"> Usuarios </h1>
                                <a href="${pageContext.request.contextPath}/ListarUsuarios" class='link-primary stretched-link'>GESTIONAR <i class="bi bi-chevron-right ml-3"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class='col-md-6 p-1 bg-light' style="height: 300px;">
                    <div class='text-white text-center h-100 home-box' style="background-image: url('assets/tipo-usuario.jpg'); transform: rotate(0);">
                        <div class="icon-in-box-r" ><i class="bi bi-people text-white h2 float-left"></i></div>
                        <div class='d-flex h-100 align-items-center justify-content-center div-home-box'>
                            <div class="pb-5">
                                <h1 class="font-weight-normal pb-4"> Tipos de Usuario </h1>
                                <a href="${pageContext.request.contextPath}/ListarTipoUsuarios" class='link-primary stretched-link'>GESTIONAR <i class="bi bi-chevron-right ml-3"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="box-stats">
                
            </div>
                            
        </div>
                

                
                

                <!--Footer-->
        <div id="layoutAuthentication_footer">
            <%@ include file="../include_files/footer.jsp" %>
        </div>

        <script src="files/linkeds/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="files/linkeds/bootstrap4.3.1.bundle.min.js" type="text/javascript"></script>
        
        
        <script>
            
            $(document).ready(function() {
                <%@ include file="../include_files/general-scripts.js" %>
             } );
        </script>
        
    </body>
    
</html>
