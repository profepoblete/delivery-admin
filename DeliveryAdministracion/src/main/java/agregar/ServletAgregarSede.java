package agregar;

import dao.SedeDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.*;
import servicio.*;


@WebServlet(name = "/ServletAgregarSede", urlPatterns = { "/AgregarSede" })
public class ServletAgregarSede extends HttpServlet{
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
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
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarSede.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
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
        //--------------CAPTURANDO LOS PARAMETROS -----------------------
            String sede = request.getParameter("sede");
            String direccion = request.getParameter("direccion");
        //---------------- INSTANCIANDO LOS OBJETOS ---------------------
            Sede se = new Sede();
            ServicioSedes s = new ServicioSedes();
        
        //--------------- PROCEDIMIENTOS PARA GUARDAR LA SEDE ----------------------
            se.setNombreSede(sede);
            se.setDireccion(direccion);
            String msj = s.guardarSede(se);
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", msj);
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "Se ha agregado una nueva SEDE correctamente.");
                
                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Sede";
                String accionH = "Agregar";
                String registroH = "ID:"+se.getIdSede()+", Nombre:"+se.getNombreSede();
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }
        
        //---------------- EN CASO DE EXCEPTION SE ENCAPSULA Y SE REDIRECCIONA A PAGINA ERROR -----------
        } catch(Exception e ){
            e.printStackTrace(); 
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
        }
        
        SedeDAO s = new SedeDAO();
        List<Sede> sedes = s.listar();
        request.setAttribute("sedes", sedes);
        request.getRequestDispatcher("/WEB-INF/Listar/ListaSedes.jsp").forward(request, response);
    }
}