
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../include_files/head-dependences.jsp" %>
        <title>Listado Punto Ventas</title>
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
        
        
        <!-- MODAL IMAGEN -->
        <div class="modal fade" id="imgModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"><!-- title content --></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="modalContent">
                        <!--<p>Contenido de imagen se coloca aquí</p>-->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- MODAL ELIMINAR -->
        <div class="modal fade" id="confirmEliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header h6">
                        Eliminar Punto de venta
                    </div>
                    <div class="modal-body">
                        Está seguro que desea eliminar este Punto de venta?
                    </div>
                    <div class="modal-footer">
                        <form name="form" action="${pageContext.request.contextPath}/ModificarPuntoVenta" method="post">
                            <input type="hidden" id="idPuntoVentaDel" name="idPuntoVenta" value="" />
                            <input type="submit" class="btn btn-danger danger" name="Eliminar" value="Eliminar">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        
        <div class="container-fluid px-5 pb-5 pt-4 bg-white">
            
            <div class="pl-5 ml-5 pt-2 pb-1 navigation-links ">
                <a class="btn-link" href="${pageContext.request.contextPath}/RedirectMain" role="button">Inicio</a> >
            </div>

            <div class="pb-2 px-5">

                <div class="mx-5 mb-4 pb-3 border-bottom d-flex justify-content-between align-items-end">
                    <h3 class="mb-0 nav-item d-inline-block pl-2 py-0 font-weight-normal" style="border-style: solid; border-width: 0 0 0 7px; border-color: #FFB800;">
                        <span class="small text-muted font-italic">Gestionar</span><br><i class="bi bi-credit-card"></i> Puntos de venta
                    </h3>
                    <div class="text-right">
                        <a class="d-inline-block btn-addelem" href="${pageContext.request.contextPath}/AgregarPuntoVenta" role="button">
                            <i class="bi bi-plus-lg"></i> Agregar Nuevo
                        </a>
                    </div>    
                </div>

                <div class="px-5">

                    <div class="col-sm-12 px-0">

                        <table class="table w-100 table-striped" id="simpleTable">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Empresa</th>
                                    <th scope="col">Horario</th>
                                    <th scope="col">Sede</th>
                                    <th scope="col" style="width: 76px;">Acciones</th>
                                </tr>
                            </thead>
                            <tbody class="bg-white">
                                <c:forEach var="puntoVenta" items="${puntoVentas}">
                                    <tr class="border border-top-0">
                                        <th scope="row">${puntoVenta.idPuntoVenta}</th>
                                        <td>${puntoVenta.nombre}</td>
                                        <td>${puntoVenta.empresa}</td>
                                        <td>${puntoVenta.horaInicio.substring(0, 5)} - ${puntoVenta.horaFin.substring(0, 5)}</td>
                                        <td>${puntoVenta.sede.nombreSede}</td>
                                        <td class="d-flex justify-content-center action-buttons">
                                            <span class="d-inline-block" style="transform: rotate(0);" title="Editar">
                                                <a href="${pageContext.request.contextPath}/ModificarPuntoVenta?idPuntoVenta=${puntoVenta.idPuntoVenta}" class="text-primary  stretched-link"><i class="bi bi-pencil-square"></i></a>                                        
                                            </span>
                                            &nbsp;&nbsp;
                                            <span class="d-inline-block" style="transform: rotate(0);" title="Ver imagen">
                                                <a href="javascript:void(0)" class="text-primary stretched-link" onclick="imgValue('${puntoVenta.imagen}', '${puntoVenta.nombre}');" data-toggle="modal" data-target="#imgModal"><i class="bi bi-image"></i></a>
                                            </span>
                                            &nbsp;&nbsp;
                                            <span class="d-inline-block" style="transform: rotate(0);" title="Eliminar">
                                                <a href="javascript:void(0)" class="text-primary stretched-link" onclick="setValDel(${puntoVenta.idPuntoVenta})" data-toggle="modal" data-target="#confirmEliminar"><i class="bi bi-trash"></i></a>
                                            </span>
                                            &nbsp;&nbsp;
                                            <c:choose>
                                                <c:when test="${puntoVenta.activo=='true'}">
                                                    <span class="d-inline-block" style="transform: rotate(0);" title="Desactivar">
                                                        <a href="${pageContext.request.contextPath}/ModificarPuntoVenta?idPuntoVenta=${puntoVenta.idPuntoVenta}&valueActivo=false" class="stretched-link"><i class="text-success bi bi-circle-fill"></i></a>
                                                    </span>
                                                </c:when>    
                                                <c:otherwise>
                                                    <span class="d-inline-block" style="transform: rotate(0);" title="Activar">
                                                        <a href="${pageContext.request.contextPath}/ModificarPuntoVenta?idPuntoVenta=${puntoVenta.idPuntoVenta}&valueActivo=true" class="stretched-link"><i class="text-danger bi bi-circle-fill"></i></a>
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>
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
            function imgValue(nameImg, titleImg){
                $(".modal-title").html(titleImg);
                $("#modalContent").html("<img src='files/"+nameImg+"'  alt='not-found' style='width: 18vw;' class='img-thumbnail d-block border-0 mx-auto'>");
            }
            function setValDel(idPuntoVenta){
                $("#idPuntoVentaDel").val(idPuntoVenta);
            }
        </script>
    </body>
</html>