
package modificar;

import dao.SedeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Sede;
import modelo.Usuario;
import servicio.ServicioSedes;
import servicio.ServiciosHistorialesAdmin;



@WebServlet(name = "/ServletModificarSede", urlPatterns = { "/ModificarSede" })
public class ServletModificarSede  extends HttpServlet {
    
    
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
        String idSedeS = request.getParameter("idSede");
        Integer idSede = Integer.parseInt(idSedeS);

        Sede sede = new Sede();
        sede.setIdSede(idSede);
        
        //Busco el objeto completo meidante el metodo buscar por id
        ServicioSedes servicioSedes = new ServicioSedes();
        sede = servicioSedes.encontrarSede(sede);

        //Seteo el objeto como atributo para poner ponerlo en los input de modificar
        HttpSession sesion = request.getSession();
        sesion.setAttribute("sede", sede);

        request.getRequestDispatcher("/WEB-INF/Modificar/ModificarSede.jsp").forward(request, response);
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

            ServicioSedes servicioSedes = new ServicioSedes();
            HttpSession sesion = request.getSession();
            //Verifico que el usuario preciono el boton "Modificar"
            String modificar = request.getParameter("Modificar");
            if (modificar != null) {

                //------------- CAPTURO LOS PARÁMETROS ---------------
                String nombreSede = request.getParameter("sede");
                String direccion = request.getParameter("direccion");


                Sede sede = (Sede) sesion.getAttribute("sede");

                sede.setNombreSede(nombreSede);
                sede.setDireccion(direccion);

                //Guardo los nuevos datos ingresado
                String msj = servicioSedes.guardarSede(sede); 
                if (msj!="") {
                    request.setAttribute("errorVal", true);
                    request.setAttribute("msj", msj);
                }else{
                    request.setAttribute("errorVal", false);
                    request.setAttribute("msj", "La SEDE se ha actualizado correctamente.");
                    
                    /*----------AGREGAR AL HISTORIAL----------*/
                    ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                    Usuario userH = (Usuario) sess.getAttribute("logged");
                    String tablaH = "Sede";
                    String accionH = "Modificar";
                    String registroH = "ID:"+sede.getIdSede()+", Nombre:"+sede.getNombreSede();
                    sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
                }
                System.out.println("Sede Modificada");
                sesion.removeAttribute("sede");
            } else {
                //Caso de eliminar
                String idSedeS = request.getParameter("idSede");
                Integer idSede = Integer.parseInt(idSedeS);

                Sede sede = new Sede(idSede);
                Sede sedeH = servicioSedes.encontrarSede(sede);
                String nombreH = sedeH.getNombreSede();
                String msj = servicioSedes.eliminarSede(sede);
                if (msj!="") {
                    request.setAttribute("errorVal", true);
                    request.setAttribute("msj", "La SEDE no se ha podido eliminar, revise que no tenga ningún PUNTO DE VENTA que dependa de esta.");
                }else{
                    request.setAttribute("errorVal", false);
                    request.setAttribute("msj", "La SEDE se ha eliminado correctamente.");
                    
                    /*----------AGREGAR AL HISTORIAL----------*/
                    ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                    Usuario userH = (Usuario) sess.getAttribute("logged");
                    String tablah = "Sede";
                    String accionh = "Eliminar";
                    String registroh = "ID:"+sede.getIdSede()+", Nombre:"+nombreH;
                    sh.guardarHistorialAdmin(userH, tablah, accionh, registroh);
                }
                System.out.println("Sede Eliminada");
            }

        } catch(Exception e ){
            e.printStackTrace();
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        SedeDAO s = new SedeDAO();
        List<Sede> sedes = s.listar();
        request.setAttribute("sedes", sedes);
        request.getRequestDispatcher("/WEB-INF/Listar/ListaSedes.jsp").forward(request, response);
    }
 
}
