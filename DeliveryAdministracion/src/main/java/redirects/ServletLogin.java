package redirects;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Usuario;
import servicio.ServicioUsuarios;



@WebServlet(name = "/ServletLogin", urlPatterns = { "/ServletLogin" })
public class ServletLogin extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        processRequest(request, response);
        
    //---------------------------- CAPTURANDO LOS PARAMETROS ---------------    
        String email = "";
        String pass = "";
        email = (request.getParameter("email"));
        pass  = (request.getParameter("contrasena"));
        
    
    //------------- METODO PARA COMPROBAR EL LOGIN --------------------
        ServicioUsuarios ser = new ServicioUsuarios();
        HttpSession sesion = request.getSession();
        Usuario connUser = ser.logear(email, pass);
        if ( connUser.getIdUsuario() != null ) {
            sesion.setAttribute("logged", connUser);
            request.getRequestDispatcher("/WEB-INF/Main.jsp").forward(request, response);
        }else {
            //Aqui puede ir un mensaje de alerta para informar que las credenciales son incorrectas
            request.setAttribute("errorLogin", 1);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}
