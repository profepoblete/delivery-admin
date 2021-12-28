
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../include_files/head-dependences.jsp" %>
        <title>Listado Ubicaciones</title>
    </head>
    <body>
        <!--Barra de navegación-->
        <%@ include file="../../include_files/navigator.jsp" %>

        <!-- Mensajes -->
        <div class="px-5 bg-white">
            <div class="px-5">
                <%@ include file="../../include_files/message.jsp" %>
            </div>
        </div>
        
        <!-- MODAL ELIMINAR -->
        <div class="modal fade" id="confirmEliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header h6">
                        Eliminar Ubicación
                    </div>
                    <div class="modal-body">
                        Está seguro que desea eliminar esta Ubicación?
                    </div>
                    <div class="modal-footer">
                        <form name="form" action="${pageContext.request.contextPath}/ModificarUbicacion" method="post">
                            <input type="hidden" id="idUbicacionDel" name="idUbicacion" value="" />
                            <input type="hidden" name="idSede" value="${sede.idSede}" />
                            <input type="submit" class="btn btn-danger danger" name="Eliminar" value="Eliminar">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                    
        <div class="container-fluid px-5 pb-5 pt-4 bg-white ">
            
            <div class="pl-5 ml-5 pt-2 pb-1 navigation-links ">
                <a class="btn-link" href="${pageContext.request.contextPath}/RedirectMain" role="button">Inicio</a> >
                <a class="btn-link" href="${pageContext.request.contextPath}/ListarSedes" role="button">Gestionar Sedes</a> >
            </div>

            <div class="pb-2 px-5">

                <div class="mx-5 mb-4 pb-3 border-bottom d-flex justify-content-between align-items-end">
                    <h3 class="mb-0 nav-item d-inline-block pl-2 py-0 font-weight-normal" style="border-style: solid; border-width: 0 0 0 7px; border-color: #FFB800;">
                        <span class="small text-muted font-italic">Gestionar</span><br><i class="bi bi-geo-alt"></i> Ubicaciones
                    </h3>
                    <h5 class="mb-0 font-weight-normal text-dark d-inline-block text-center text-uppercase" >
                        <i class="bi bi-building"> </i>${sede.nombreSede}
                    </h5>
                    <div class="text-right" style="width: 198.83px;">
                        <form action="${pageContext.request.contextPath}/AgregarUbicacion" method="GET">
                            <input type="hidden" name="idSede" value="${sede.idSede}">
                            <button class="d-inline-block btn-addelem" href="" role="button">
                                <i class="bi bi-plus-lg"></i> Agregar Nueva
                            </button>
                        </form>
                    </div> 
                </div>


                <div class="px-5">

                    <div class="col-sm-12 px-0">

                        <table class="table w-100 table-striped" id="simpleTable">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Piso</th>
                                    <th scope="col" style="width: 76px;">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="ubicacion" items="${ubicaciones}">
                                    <tr class="border border-top-0 action-buttons">
                                        <th scope="row">${ubicacion.idUbicacion}</th>
                                        <td>${ubicacion.nombreEdificio}</td>
                                        <td>${ubicacion.piso}</td>
                                        <td class="d-flex justify-content-center">
                                            <span class="d-inline-block" style="transform: rotate(0);" title="Editar">
                                                <a href="${pageContext.request.contextPath}/ModificarUbicacion?idUbicacion=${ubicacion.idUbicacion}" class=" text-primary stretched-link"><i class="bi bi-pencil-square"></i></a>
                                            </span>
                                            &nbsp;&nbsp;
                                            <span class="d-inline-block " style="transform: rotate(0);" title="Eliminar">
                                                <a href="javascript:void(0)" class="text-primary stretched-link" onclick="setValDel(${ubicacion.idUbicacion})" data-toggle="modal" data-target="#confirmEliminar"><i class="bi bi-trash"></i></a>
                                            </span>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                        
                </div>
                
            </div> 
            
        </div>
        
        <%@ include file="../../include_files/footer.jsp" %>

        <script src="files/linkeds/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="files/linkeds/bootstrap4.3.1.bundle.min.js" type="text/javascript"></script>
        <script src="files/linkeds/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="files/linkeds/dataTables.bootstrap4.min.js" type="text/javascript"></script>

        <script>
            $(document).ready(function() {
                <%@ include file="../../include_files/listar-scripts.js" %>
                <%@ include file="../../include_files/general-scripts.js" %>
                if (${idFilter!=null}) {
                    table.search('${idFilter}').draw();
                }
            } );
            function setValDel(idUbicacion){
                $("#idUbicacionDel").val(idUbicacion);
            }
        </script>
    </body>
</html>