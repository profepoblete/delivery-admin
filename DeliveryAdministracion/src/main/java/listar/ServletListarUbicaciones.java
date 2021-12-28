package listar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;
import modelo.*;
import servicio.*;
import dao.*;

@WebServlet(name = "ServletListarUbicaciones", urlPatterns = {"/ListarUbicaciones"})
public class ServletListarUbicaciones extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            HttpSession sess = request.getSession();
            Usuario ver = (Usuario) sess.getAttribute("logged");
            if (ver.getIdUsuario()==null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(Exception e ){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        processRequest(request, response);
        request.getRequestDispatcher("/WEB-INF/Main.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        
        //----------- FILTRO --------------------------------------------------------------------------
        String idFilter = request.getParameter("idFilter");
        if (idFilter!=null) {
            request.setAttribute("idFilter", idFilter);
        }
        //----------- INSTANCIO EL OBJETO Y LLAMO A SU CORRESPONDIENTE METODO LISTAR ------------------
        
        try{
            String idSede = request.getParameter("idSede");

            ServicioSedes sSed = new ServicioSedes();
            ServicioUbicaciones sUbi = new ServicioUbicaciones();

            Sede sede = new Sede(Integer.parseInt(idSede));
            sede = sSed.encontrarSede(sede);
            request.setAttribute("sede", sede );

            /*List<Ubicacion> ubicaciones = sUbi.listarUbicacionesPorSede(idSede);  
            request.setAttribute("ubicaciones", ubicaciones );
            List<Ubicacion> ubicaciones = uDao.listar();  
            request.setAttribute("ubicaciones", ubicaciones );*/
            List<Ubicacion> ubicaciones = sUbi.listarUbicaciones();
            ubicaciones.removeIf(n -> ( n.getSede().getIdSede() != Integer.parseInt(idSede) ));
            request.setAttribute("ubicaciones", ubicaciones );        

            request.getRequestDispatcher("/WEB-INF/Listar/ListaUbicaciones.jsp").forward(request, response);
        }
        catch(Exception e){
            SedeDAO s = new SedeDAO();
            List<Sede> sedes = s.listar();
            request.setAttribute("sedes", sedes);
            request.setAttribute("errorVal", true);
            request.setAttribute("msj", "Ha ocurrido un error al mostrar las Ubicaciones de un Punto de venta. Por favor, reintente...");
            request.getRequestDispatcher("/WEB-INF/Listar/ListaSedes.jsp").forward(request, response);
        }
    }

}
