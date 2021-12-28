
package redirects;

import dao.TipoUsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.TipoUsuario;


@WebServlet("/RedirectAddTipoUser")
public class RedirectAddTipoUser extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        
        processRequest(request, response);
        
        TipoUsuarioDAO tpDao = new TipoUsuarioDAO();
        
        List<TipoUsuario> tipoUsuarios = tpDao.listar();  
        
        request.setAttribute("tipoUsuarios", tipoUsuarios );
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarTipoUsuario.jsp").forward(request, response);
    }
}