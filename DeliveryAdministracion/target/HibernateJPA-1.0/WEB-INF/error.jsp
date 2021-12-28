<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../include_files/head-dependences.jsp" %>
        <title>Error</title>
    </head>
    
    <body class="bg-white" style="background-image: url('files/pagina_404_horizontal2.jpg'); background-size: 1800px 750px; background-position: center top;">  
        
        <!--Barra de navegación-->
        <%@ include file="../include_files/navigator.jsp" %>

        <div class="p-5" style="background-color: rgba(255, 255, 255, .4);" id="error-container">
            <div class="p-5 w-50">
                <br><br><br>
                <div class="p-2">
                    <h2 class="text-left mb-3">Ha ocurrido un error inesperado.</h2>
                    <h4 class="text-left pb-0">Favor vuelva a intentar, si el problema persiste, comuníquese con la Mesa de Ayuda.</h4>
                    <br>
                    <a href="${pageContext.request.contextPath}/RedirectMain" class='link-primary'><i class="bi bi-chevron-left mr-3"> </i>VOLVER AL INICIO</a>
                </div>
                <br><br><br>
            </div>                
        </div>
                

                
                


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
