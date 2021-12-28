
package redirects;

import dao.SedeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Sede;

@WebServlet("/RedirectAddSede")
public class RedirectAddSede extends HttpServlet{
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        processRequest(request, response);
    
        SedeDAO s = new SedeDAO();
        
        List<Sede> sedes = s.listar();
        
        request.setAttribute("sedes", sedes);    
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarSede.jsp").forward(request, response);
    }
}
