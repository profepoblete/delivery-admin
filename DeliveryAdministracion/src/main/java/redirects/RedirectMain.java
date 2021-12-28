
package redirects;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Usuario;

@WebServlet(name = "/RedirectMain", urlPatterns = { "/RedirectMain" })
public class RedirectMain extends HttpServlet{
    
    
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
        
        request.getRequestDispatcher("/WEB-INF/Main.jsp").forward(request, response);
    }
}
