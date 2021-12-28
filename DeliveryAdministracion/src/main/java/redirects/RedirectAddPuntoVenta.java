
package redirects;

import dao.PuntoVentaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.PuntoVenta;


@WebServlet("/RedirectAddPuntoVenta")
public class RedirectAddPuntoVenta extends HttpServlet{
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        processRequest(request, response);
        
        PuntoVentaDAO tpDao = new PuntoVentaDAO();
        
        List<PuntoVenta> puntoVentas = tpDao.listar();  
        
        request.setAttribute("puntoVentas", puntoVentas);    
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarPuntoVenta.jsp").forward(request, response);
    }
}