package agregar;

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

@WebServlet(name = "/ServletAgregarUser", urlPatterns = { "/AgregarUsuario" })
public class ServletAgregarUser extends HttpServlet {
    
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        processRequest(request, response);
        try{
            HttpSession sess = request.getSession();
            Usuario ver = (Usuario) sess.getAttribute("logged");
            if (ver.getIdUsuario()==null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(Exception e ){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    
        //----------- INSTANCIO EL OBJETO Y LLAMO A SU CORRESPONDIENTE METODO LISTAR ------------------
        SedeDAO s = new SedeDAO();
        List<Sede> sedes = s.listar();
        request.setAttribute("sedes", sedes);
        TipoUsuarioDAO tu = new TipoUsuarioDAO();
        List<TipoUsuario> tiposUsuario = tu.listar();
        request.setAttribute("tiposUsuario", tiposUsuario);
        PuntoVentaDAO pv = new PuntoVentaDAO();
        List<PuntoVenta> puntosVenta = pv.listar();
        request.setAttribute("puntosVenta", puntosVenta);
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarUsuario.jsp").forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        
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
        ServicioUsuarios su = new ServicioUsuarios();
        //----------------- CAPTURANDO LOS PARAMETROS OBTENIDOS ------------------------------
        String email = request.getParameter("email");
        if (su.buscarCorreo(email)==null) {
            String rut = request.getParameter("rut");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            //String contrasena = ServicioPasswordHash.PasswordHashing(request.getParameter("contrasena"));
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

            //Creo la instancia del usuario
            Usuario us = new Usuario();
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
              //s.setIdSede(1);                            //por el momento si no existe lo deja como colaborador
              //s1 = sDAO.buscarSedePorId(s);
                throw new Exception();                     //Otra opcion es lanzar la exception
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
            us.setContrasena(contrasena);
            us.setActivo(activo);
            us.setTipoUsuario(tp1);
            us.setSede(s1);
            String msj = su.guardarUsuario(us); 
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", msj);
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "Un nuevo USUARIO se ha agregado correctamente.");

                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Usuario";
                String accionH = "Agregar";
                String registroH = "ID:"+us.getIdUsuario()+", Nombre:"+us.getNombre()+" "+us.getApellido();
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }
        }else{
            request.setAttribute("errorVal", true);
            request.setAttribute("msj", "El USUARIO no se ha podido agregar, El correo que intenta ingresar ya existe.");
        }
        //En caso de error redireccionar a pagina de error 
        } catch(Exception e ){
            e.printStackTrace(); 
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla           
        }
        
        //En caso de que el proceso sea correcto redirigir a página de Menú
        UsuarioDAO uDao = new UsuarioDAO();
        List<Usuario> usuarios = uDao.listar();
        request.setAttribute("usuarios", usuarios);

        request.getRequestDispatcher("/WEB-INF/Listar/ListaUsuarios.jsp").forward(request, response);
        
    }
}