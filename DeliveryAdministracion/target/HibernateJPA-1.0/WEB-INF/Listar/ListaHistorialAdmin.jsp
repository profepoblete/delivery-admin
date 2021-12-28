
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../include_files/head-dependences.jsp" %>
        <title>Historial de cambios</title>
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

        
        <div class="container-fluid px-5 pb-5 pt-4 bg-white">
            
            <div class="pl-5 ml-5 pt-2 pb-1 navigation-links ">
                <a class="btn-link" href="${pageContext.request.contextPath}/RedirectMain" role="button">Inicio</a> >
            </div>

            <div class="pb-2 px-5">

                <div class="mx-5 mb-2 pb-3 border-bottom d-flex justify-content-between align-items-end">
                    <h3 class=" nav-item d-inline-block pl-2 py-2 font-weight-normal mb-0" style="border-style: solid; border-width: 0 0 0 7px; border-color: #FFB800;">
                        <i class="bi bi-clock-history"></i> Historial de cambios
                    </h3>
                    <div class="float-right row" style="width: 600px;">
                        <div class="col-2 text-right align-middle pt-2">
                            Filtros:
                        </div>
                        <div class="col-5">
                            <select class="form-control" id="tablaFilter">
                                <option value="">Seleccione Módulo</option>
                                <option value="Sede">Sede</option>
                                <option value="Ubicación">Ubicación</option>
                                <option value="Usuario">Usuario</option>
                                <option value="Tipo de usuario">Tipo de usuario</option>
                                <option value="Punto de venta">Punto de venta</option>
                            </select>
                        </div>
                        <div class="col-5">
                            <select class="form-control" id="accionFilter">
                                <option value="">Seleccione Acción</option>
                                <option value="Agregar">Agregar</option>
                                <option value="Modificar">Modificar</option>
                                <option value="Eliminar">Eliminar</option>
                                <option value="Activar">Activar</option>
                                <option value="Desactivar">Desactivar</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="w-100 text-right pb-2 pr-5">
                    <button id="clearFilters" class="btn-clear-filters mr-4">Limpiar filtros</button>
                </div>
                <div class="px-5">

                    <div class="col-sm-12 px-0">

                        <table class="table w-100 table-striped" id="simpleTable">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Usuario</th>
                                    <th scope="col">Tabla</th>
                                    <th scope="col">Acción</th>
                                    <th scope="col">Registro</th>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Hora</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="historialAdmin" items="${historialAdmin}">
                                    <tr class="border border-top-0">
                                        <th scope="row">${historialAdmin.idHistorialAdmin}</th>
                                        <td>${historialAdmin.usuario.nombre} ${historialAdmin.usuario.apellido}</td>
                                        <td>${historialAdmin.tabla}</td>
                                        <td>${historialAdmin.accion}</td>
                                        <td>${historialAdmin.registro}</td>
                                        <td><fmt:formatDate value="${historialAdmin.fecha}" pattern="dd-MM-yyyy" /></td>
                                        <td>${historialAdmin.time}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                        
                </div>
                
            </div> 
        </div>
        
        <%@ include file="../../include_files/footer.jsp" %>
        <!--                
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
        -->
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
                $('#tablaFilter').on('change', function(){
                    table.columns(2).search(this.value ? '^'+this.value+'$' : '', true, false).draw();
                });
                $('#accionFilter').on('change', function(){
                    table.columns(3).search(this.value ? '^'+this.value+'$' : '', true, false).draw();
                });
                $('#clearFilters').on('click', function(){
                    $('#tablaFilter').val("");
                    $('#accionFilter').val("");
                    $('#tablaFilter').change();
                    $('#accionFilter').change();
                    table.search('').draw();
                });
            } );
        </script>
    </body>
</html>