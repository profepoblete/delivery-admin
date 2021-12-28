package listar;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.PuntoVentaDAO;
import modelo.PuntoVenta;
import modelo.Usuario;



@WebServlet(name = "/ServletListarPuntoVentas", urlPatterns = { "/ListarPuntoVentas" })
public class ServletListarPuntoVentas extends HttpServlet{
    
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
        PuntoVentaDAO tpDao = new PuntoVentaDAO();
        List<PuntoVenta> puntoVentas = tpDao.listar();  
        request.setAttribute("puntoVentas", puntoVentas );
        
        request.getRequestDispatcher("/WEB-INF/Listar/ListaPuntoVentas.jsp").forward(request, response);
    }
    
}
