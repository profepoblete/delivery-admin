
package modificar;

import dao.TipoUsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.TipoUsuario;
import modelo.Usuario;
import servicio.ServicioTipoUsuarios;
import servicio.ServiciosHistorialesAdmin;



@WebServlet(name = "/ServletModificarTipoUsuario", urlPatterns = { "/ModificarTipoUsuario" })
public class ServletModificarTipoUsuario  extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
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
    
        //Obtengo el paramtero idSede desde la pagina del listado, y lo transformo en integer
        String idTipoUsuarioS = request.getParameter("idTipoUsuario");
        Integer idTipoUsuario = Integer.parseInt(idTipoUsuarioS);

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(idTipoUsuario);
        
        //Busco el objeto completo meidante el metodo buscar por id
        ServicioTipoUsuarios servicioTipoUsuarios = new ServicioTipoUsuarios();
        tipoUsuario = servicioTipoUsuarios.encontrarTipoUsuario(tipoUsuario);


        //Seteo el objeto como atributo para poner ponerlo en los input de modificar
        HttpSession sesion = request.getSession();
        sesion.setAttribute("tipoUsuario", tipoUsuario);

        request.getRequestDispatcher("/WEB-INF/Modificar/ModificarTipoUsuario.jsp").forward(request, response);
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

            ServicioTipoUsuarios servicioTipoUsuarios = new ServicioTipoUsuarios();

            //Verifico que el usuario preciono el boton "Modificar"
            String modificar = request.getParameter("Modificar");
            if (modificar != null) {

                //------------- CAPTURO LOS PARÁMETROS ---------------
                String descripcion = request.getParameter("descripcion");


                HttpSession sesion = request.getSession();
                TipoUsuario tipoUsuario = (TipoUsuario) sesion.getAttribute("tipoUsuario");

                tipoUsuario.setDescripcion(descripcion);

                //Guardo los nuevos datos ingresado
                String msj = servicioTipoUsuarios.guardarTipoUsuario(tipoUsuario);
                if (msj!="") {
                    request.setAttribute("errorVal", true);
                    request.setAttribute("msj", msj);
                }else{
                    request.setAttribute("errorVal", false);
                    request.setAttribute("msj", "El TIPO DE USUARIO se ha modificado correctamente.");
                    
                    /*----------AGREGAR AL HISTORIAL----------*/
                    ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                    Usuario userH = (Usuario) sess.getAttribute("logged");
                    String tablaH = "Tipo de usuario";
                    String accionH = "Modificar";
                    String registroH = "ID:"+tipoUsuario.getIdTipoUsuario()+", Descripción:"+tipoUsuario.getDescripcion();
                    sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
                }
                System.out.println("Tipo Usuario Modificado");
                sesion.removeAttribute("tipoUsuario");
            } else {
                //Caso de eliminar
                String idTipoUsuarioS = request.getParameter("idTipoUsuario");
                Integer idTipoUsuario = Integer.parseInt(idTipoUsuarioS);

                TipoUsuario tipoUsuario = new TipoUsuario(idTipoUsuario);
                TipoUsuario tuH = servicioTipoUsuarios.encontrarTipoUsuario(tipoUsuario);
                String descripcionH = tuH.getDescripcion();
                String msj = servicioTipoUsuarios.eliminarTipoUsuario(tipoUsuario);
                if (msj!="") {
                    request.setAttribute("errorVal", true);
                    request.setAttribute("msj", "El TIPO DE USUARIO no se ha podido eliminar, revise que no tenga ningún USUARIO que dependa de este.");
                }else{
                    request.setAttribute("errorVal", false);
                    request.setAttribute("msj", "El TIPO DE USUARIO se ha eliminado correctamente.");
                    
                    /*----------AGREGAR AL HISTORIAL----------*/
                    ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                    Usuario userH = (Usuario) sess.getAttribute("logged");
                    String tablaH = "Tipo de usuario";
                    String accionH = "Eliminar";
                    String registroH = "ID:"+tipoUsuario.getIdTipoUsuario()+", Descripción:"+descripcionH;
                    sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
                }
                System.out.println("Tipo Usuario Eliminado");
            }
    
        } catch(Exception e ){
            e.printStackTrace();
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        TipoUsuarioDAO tpDao = new TipoUsuarioDAO();
        List<TipoUsuario> tipoUsuarios = tpDao.listar();  
        request.setAttribute("tipoUsuarios", tipoUsuarios );

        request.getRequestDispatcher("/WEB-INF/Listar/ListaTipoUsuarios.jsp").forward(request, response);
    }
 
}