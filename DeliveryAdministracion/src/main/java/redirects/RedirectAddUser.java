
package redirects;

import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Usuario;

@WebServlet("/RedirectAddUser")
public class RedirectAddUser extends HttpServlet{
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        processRequest(request, response);
               
        UsuarioDAO u = new UsuarioDAO(); 
        
        List<Usuario> usuarios = u.listar(); 
        
        request.setAttribute("usuarios", usuarios);
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarUsuario.jsp").forward(request, response);
    }
}
