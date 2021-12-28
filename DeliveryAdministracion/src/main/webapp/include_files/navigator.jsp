<!--Barra de navegación-->
<nav class="navbar navbar-expand-lg navbar-light pl-1 pr-0 py-0 align-items-stretch fixed-top">

    <!--Icono Duoc [redirect inicio]-->
    <label for="" class="iconoDuoc p-1">
        <a href="${pageContext.request.contextPath}/RedirectMain"><img src="https://www.duoc.cl/wp-content/themes/wordpress-duoc-cl/images/logo-duoc.svg" alt="" style="width: 180px;"/></a>
    </label>

    <!--Opciones de barra de navegación-->
    <div class="navbar-collapse align-items-stretch" id="navbarSupportedContent"> <!--  .collapse   -->
        <ul class="navbar-nav ml-auto ms-2 mr-0">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle px-3 py-3" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Sedes 
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/AgregarSede">Agregar Sede</a>
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/ListarSedes">Gestionar Sedes</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle px-3 py-3" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuarios
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/AgregarUsuario">Agregar Usuario</a>
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/ListarUsuarios">Gestionar Usuarios</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle px-3 py-3" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Tipos de Usuario
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/AgregarTipoUsuario">Agregar Tipo de Usuario</a>
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/ListarTipoUsuarios">Gestionar Tipos de Usuario</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle px-3 py-3" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Puntos de Venta
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/AgregarPuntoVenta">Agregar Punto de Venta</a>
                    <a class="dropdown-item px-2" href="${pageContext.request.contextPath}/ListarPuntoVentas">Gestionar Puntos de Venta</a>
                </div>
            </li>
            <li class="nav-item active"> 
                <a class="nav-link px-3 py-3 h-100" href="${pageContext.request.contextPath}/ListarHistorialAdmin">
                    <i class="bi bi-clock-history"> </i>Historial
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle px-3 py-3" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="bi bi-person-circle"> </i>${sessionScope.logged.nombre}
                </a>
                <div class="dropdown-menu dropdown-menu-right text-white p-3" aria-labelledby="navbarDropdown">
                    <h4 class="text-center pt-0">${sessionScope.logged.nombre} ${sessionScope.logged.apellido}</h4>
                    <h6 class="text-center font-weight-light">${sessionScope.logged.email}</h6>
                    <h6 class="font-weight-light">${sessionScope.logged.sede.nombreSede}</h6>
                    <hr class="my-1">
                    <a data-toggle="modal" data-target="#confirmLogOut" class="w-100 text-center btn bg-danger text-white rounded font-weight-normal" href="#" style="font-size: .8rem; padding-left: 4px; padding-right: 4px;">
                        <i class="bi bi-box-arrow-right"> </i>Salir
                    </a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div style="height: 56px;"></div>

                    
                    <!-- CONFIRMAR LOGOUT -->
<div class="modal fade" id="confirmLogOut" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header h6">
                Salir
            </div>
            <div class="modal-body h6">
                Está seguro que desea desconectarse?
            </div>
            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/RedirectLogin" class="btn btn-primary">Desconectarse</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>