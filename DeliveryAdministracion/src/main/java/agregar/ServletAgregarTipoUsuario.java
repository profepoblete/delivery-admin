package agregar;

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



@WebServlet(name = "/ServletAgregarTipoUsuario", urlPatterns = { "/AgregarTipoUsuario" })
public class ServletAgregarTipoUsuario extends HttpServlet{
    
    
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
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarTipoUsuario.jsp").forward(request, response);
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
            String descripcion = request.getParameter("descripcion");

        //---------------- INSTANCIANDO LOS OBJETOS ---------------------
            TipoUsuario tp = new TipoUsuario();
            ServicioTipoUsuarios stp = new ServicioTipoUsuarios();
        
        //--------------- PROCEDIMIENTOS PARA GUARDAR EL TIPO USUARIO ----------------------
            tp.setDescripcion(descripcion);
            String msj = stp.guardarTipoUsuario(tp);
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", msj);
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "Un nuevo TIPO DE USUARIO se ha agregado correctamente.");
                
                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Tipo de usuario";
                String accionH = "Agregar";
                String registroH = "ID:"+tp.getIdTipoUsuario()+", Descripción:"+tp.getDescripcion();
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }

        //---------------- EN CASO DE EXCEPTION SE ENCAPSULA Y SE REDIRECCIONA A PAGINA ERROR -----------
        } catch(Exception e ){
            e.printStackTrace(); 
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
        }
        TipoUsuarioDAO tpDao = new TipoUsuarioDAO();
        List<TipoUsuario> tipoUsuarios = tpDao.listar();  
        request.setAttribute("tipoUsuarios", tipoUsuarios );
        
        request.getRequestDispatcher("/WEB-INF/Listar/ListaTipoUsuarios.jsp").forward(request, response);
    }
}