package listar;

import dao.SedeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Sede;
import modelo.Usuario;

@WebServlet(name = "/ServletListarSedes", urlPatterns = { "/ListarSedes" })
public class ServletListarSedes extends HttpServlet{
    
    
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
    
        //----------- FILTRO --------------------------------------------------------------------------
        String idFilter = request.getParameter("idFilter");
        if (idFilter!=null) {
            request.setAttribute("idFilter", idFilter);
        }
        //----------- INSTANCIO EL OBJETO Y LLAMO A SU CORRESPONDIENTE METODO LISTAR ------------------
        SedeDAO s = new SedeDAO();
        
        List<Sede> sedes = s.listar();
        
        request.setAttribute("sedes", sedes);
        
        
        request.getRequestDispatcher("/WEB-INF/Listar/ListaSedes.jsp").forward(request, response);

    }
}