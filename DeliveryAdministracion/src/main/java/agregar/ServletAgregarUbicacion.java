package agregar;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;
import servicio.*;

@WebServlet(name = "ServletAgregarUbicacion", urlPatterns = {"/AgregarUbicacion"})
public class ServletAgregarUbicacion extends HttpServlet {

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

        String idSede = request.getParameter("idSede");
        ServicioSedes sSede= new ServicioSedes();
        Sede sede = new Sede(Integer.parseInt(idSede));
        sede = sSede.encontrarSede(sede);
        request.setAttribute("sede", sede );

        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarUbicacion.jsp").forward(request, response);
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
        //--------------CAPTURANDO LOS PARAMETROS -----------------------
            String nombreEdificio = request.getParameter("nombreEdificio");
            String piso = request.getParameter("piso");
            String idSede = request.getParameter("idSede");
        //---------------- INSTANCIANDO LOS OBJETOS ---------------------
            Sede sede = new Sede(Integer.parseInt(idSede));
            ServicioSedes sSede = new ServicioSedes();
            Ubicacion ubicacion = new Ubicacion();
            ServicioUbicaciones sUbicacion = new ServicioUbicaciones();
        
        //--------------- PROCEDIMIENTOS PARA GUARDAR LA SEDE ----------------------
            sede = sSede.encontrarSede(sede);
            ubicacion.setNombreEdificio(nombreEdificio);
            ubicacion.setPiso(piso);
            ubicacion.setSede(sede);
            String msj = sUbicacion.guardarUbicacion(ubicacion);
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", msj);
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "Se ha agregado una nueva UBICACIÓN correctamente.");
                
                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Ubicación";
                String accionH = "Agregar";
                String registroH = "ID:"+ubicacion.getIdUbicacion()+", Nombre:"+ubicacion.getNombreEdificio();
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }
        //--------------- SE REDIRECCIONA A LISTA DE UBICACIONES DE LA SEDE
        List<Ubicacion> ubicaciones = sUbicacion.listarUbicaciones();
        ubicaciones.removeIf(n -> ( n.getSede().getIdSede() != Integer.parseInt(idSede) ));
        request.setAttribute("ubicaciones", ubicaciones );
        request.setAttribute("sede", sede );
        request.getRequestDispatcher("/WEB-INF/Listar/ListaUbicaciones.jsp").forward(request, response);
        } catch(Exception e ){//---------------- EN CASO DE EXCEPTION SE ENCAPSULA Y SE REDIRECCIONA A PAGINA ERROR -----------
            e.printStackTrace(); 
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
        }
        
    }

}
