
package modificar;

import dao.PuntoVentaDAO;
import dao.SedeDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.PuntoVenta;
import modelo.Sede;
import modelo.TipoUsuario;
import modelo.Usuario;
import servicio.ServicioPasswordHash;
import servicio.ServicioUsuarios;
import servicio.ServiciosHistorialesAdmin;



@WebServlet(name = "/ServletModificarUsuario", urlPatterns = { "/ModificarUsuario" })
public class ServletModificarUsuario extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        HttpSession sess = request.getSession();
        try{
            
            Usuario ver = (Usuario) sess.getAttribute("logged");
            if (ver.getIdUsuario()==null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(Exception e ){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        //Obtengo el paramtero idUsuario desde la pagina del listado, y lo transformo en integer
        String idUsuarioS = request.getParameter("idUsuario");
        Integer idUsuario = Integer.parseInt(idUsuarioS);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);

        //Busco el objeto completo meidante el metodo buscar por id
        ServicioUsuarios servicioUsuarios = new ServicioUsuarios();
        usuario = servicioUsuarios.encontrarUsuario(usuario);

        //Verifico si es modificación unicamente de estado
        String valueActivo = request.getParameter("valueActivo");
        if (valueActivo != null) {
            
            if (valueActivo.equals("true")) {
                usuario.setActivo(true);
            }else if(valueActivo.equals("false")){
                usuario.setActivo(false);
            }
            
            String msj = servicioUsuarios.guardarUsuario(usuario);
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", msj);
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "El USUARIO se ha modificado correctamente.");
                
                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Usuario";
                String accionH = "";
                if (usuario.isActivo()) {
                    accionH = "Activar";
                }else{
                    accionH = "Desactivar";
                }
                String registroH = "ID:"+usuario.getIdUsuario()+", Nombre:"+usuario.getNombre()+" "+usuario.getApellido();
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }
            UsuarioDAO uDao = new UsuarioDAO();
            List<Usuario> usuarios = uDao.listar();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("/WEB-INF/Listar/ListaUsuarios.jsp").forward(request, response);
            
        }else{
            //Seteo el objeto como atributo para poner ponerlo en los input de modificar
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            SedeDAO s = new SedeDAO();
            List<Sede> sedes = s.listar();
            request.setAttribute("sedes", sedes);
            TipoUsuarioDAO tu = new TipoUsuarioDAO();
            List<TipoUsuario> tiposUsuario = tu.listar();
            request.setAttribute("tiposUsuario", tiposUsuario);
            PuntoVentaDAO pv = new PuntoVentaDAO();
            List<PuntoVenta> puntosVenta = pv.listar();
            request.setAttribute("puntosVenta", puntosVenta);
            request.getRequestDispatcher("/WEB-INF/Modificar/ModificarUsuario.jsp").forward(request, response);
        } 
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        processRequest(request, response);
        HttpSession sess = request.getSession();
        
        try{
            Usuario ver = (Usuario) sess.getAttribute("logged");
            if (ver.getIdUsuario()==null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(Exception e ){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    
    try {     
        ServicioUsuarios servicioUsuarios = new ServicioUsuarios();  
        
        //Verifico que el usuario preciono el boton "Modificar"
        String modificar = request.getParameter("Modificar");
        if (modificar != null) {

            //----------------- CAPTURANDO LOS PARAMETROS OBTENIDOS ------------------------------
            HttpSession sesion = request.getSession();
            Usuario us = (Usuario) sesion.getAttribute("usuario");
            String email = request.getParameter("email");
            if (servicioUsuarios.buscarCorreo(email)==null || servicioUsuarios.buscarCorreo(email)==us.getIdUsuario())
            {
                String rut = request.getParameter("rut");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String contrasena = request.getParameter("contrasena");
                String activoS = request.getParameter("activo");
                boolean activo;
                if( activoS == null ) {
                    activo = false;
                } else {
                    activo = true;
                }
                //Si esque el parametro ingresado es null 
                String telefonoS = request.getParameter("telefono");
                Integer telefono;
                if( !telefonoS.isEmpty() ) {
                    telefono = Integer.parseInt(telefonoS.replace(" ", ""));
                } else {
                    telefono =  null;
                }    

                String tipoUsuarioS = request.getParameter("tipoUsuario");
                Integer tipoUsuario = Integer.parseInt(tipoUsuarioS);

                String sedeS = request.getParameter("sede");
                Integer sede = Integer.parseInt(sedeS);

                //Si esque el parametro ingresado es null 
                String puntoVentaS = request.getParameter("puntoVenta");
                Integer puntoVenta;
                if ( puntoVentaS!="0" ) {
                    puntoVenta = Integer.parseInt(puntoVentaS);
                } else {
                    puntoVenta =  null;
                }
                //-------------------------- INSTANCIANDO LOS PARAMETROS OBTENIDOS ------------------------
                //Comprueba que el id entregado exista en la base de datos
                TipoUsuarioDAO tDAO = new TipoUsuarioDAO();
                TipoUsuario tp  = new TipoUsuario();
                TipoUsuario tp1 = new TipoUsuario();
                if ( tDAO.existeIdTipoUsuario(tipoUsuario) ) { 
                    tp.setIdTipoUsuario(tipoUsuario);
                    tp1 = tDAO.buscarTipoUsuarioPorId(tp);
                } else {
                 //tp.setIdTipoUsuario(3);                      //por el momento si no existe lo deja como colaborador
                 //tp1 = tDAO.buscarTipoUsuarioPorId(tp); 
                   throw new Exception();                      //Otra opcion es lanzar la exception
                }



                SedeDAO sDAO = new SedeDAO();
                Sede s = new Sede();
                Sede s1 = new Sede();
                if ( sDAO.existeIdSede(sede) ) {
                    s.setIdSede(sede);
                    s1 = sDAO.buscarSedePorId(s);
                }else {
                    throw new Exception();                    
                }
                //Si esque el punto de venta es null 
                if( puntoVenta != null ) {
                    PuntoVenta pv = new PuntoVenta();
                    pv.setIdPuntoVenta(puntoVenta);
                    PuntoVentaDAO pDAO = new PuntoVentaDAO();
                    PuntoVenta pv1 = pDAO.buscarPuntoVentaPorId(pv);
                    us.setPuntoVenta(pv1);
                } else {
                    us.setPuntoVenta(null);
                }
                //Si el telefono es null
                if( telefono != null ) {
                    us.setTelefono(telefono);
                }else {
                    us.setTelefono(null);
                }
                us.setRut(rut);
                us.setNombre(nombre);
                us.setApellido(apellido);
                us.setEmail(email);
                if(contrasena.length()>0){
                    /*us.setContrasena(ServicioPasswordHash.PasswordHashing(contrasena));*/
                    us.setContrasena(contrasena);
                }
                us.setActivo(activo);
                us.setTipoUsuario(tp1);
                us.setSede(s1);

                String msj = servicioUsuarios.guardarUsuario(us); 
                if (msj!="") {
                    request.setAttribute("errorVal", true);
                    request.setAttribute("msj", msj);
                }else{
                    request.setAttribute("errorVal", false);
                    request.setAttribute("msj", "El USUARIO se ha modificado correctamente.");

                    /*----------AGREGAR AL HISTORIAL----------*/
                    ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                    Usuario userH = (Usuario) sess.getAttribute("logged");
                    String tablaH = "Usuario";
                    String accionH = "Modificar";
                    String registroH = "ID:"+us.getIdUsuario()+", Nombre:"+us.getNombre()+" "+us.getApellido();
                    sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);

                }
                System.out.println("Usuario Modificado");
                sesion.removeAttribute("usuario");
            }else{
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", "El USUARIO no se ha podido actualizar, El correo que intenta ingresar ya existe.");
            }
        } else {
            //caso de eliminar
            String idUsuarioS = request.getParameter("idUsuario");
            Integer idUsuario = Integer.parseInt(idUsuarioS);

            Usuario usuario = new Usuario(idUsuario);
            Usuario uh = servicioUsuarios.encontrarUsuario(usuario);
            String nombreH = uh.getNombre()+" "+uh.getApellido();
            String msj = servicioUsuarios.eliminarUsuario(usuario);
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", "El USUARIO no se ha podido eliminar, revise que no tenga ningún PEDIDO que dependa de este. De lo contrario, opte por desactivarlo.");
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "El USUARIO se ha eliminado correctamente.");

                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Usuario";
                String accionH = "Eliminar";
                String registroH = "ID:"+usuario.getIdUsuario()+", Nombre:"+nombreH;
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }
        }
    } catch(Exception e ){
        e.printStackTrace(); 
        //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
        request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
    }
        UsuarioDAO uDao = new UsuarioDAO();
        List<Usuario> usuarios = uDao.listar();
        request.setAttribute("usuarios", usuarios);

        request.getRequestDispatcher("/WEB-INF/Listar/ListaUsuarios.jsp").forward(request, response);
    }
    
}
