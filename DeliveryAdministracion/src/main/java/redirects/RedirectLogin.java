
package redirects;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RedirectLogin")
public class RedirectLogin extends HttpServlet{
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        processRequest(request, response);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("logged", false);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
