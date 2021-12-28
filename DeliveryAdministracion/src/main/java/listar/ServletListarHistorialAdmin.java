
package listar;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servicio.*;
import modelo.*;

@WebServlet(name = "ServletListarHistorialAdmin", urlPatterns = {"/ListarHistorialAdmin"})
public class ServletListarHistorialAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            HttpSession sess = request.getSession();
            Usuario ver = (Usuario) sess.getAttribute("logged");
            if (ver.getIdUsuario()==null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(Exception e ){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
    //----------- INSTANCIO EL OBJETO Y LLAMO A SU CORRESPONDIENTE METODO LISTAR ------------------
        ServiciosHistorialesAdmin sHa = new ServiciosHistorialesAdmin();
        List<HistorialAdmin> historialAdmin = sHa.listarHistorialesAdmin();
        for (HistorialAdmin hist : historialAdmin)
        {
            Calendar c = Calendar.getInstance();
            c.setTime(hist.getFecha());
            c.add(Calendar.DATE, 1);
            hist.setFecha(c.getTime());
        }
        request.setAttribute("historialAdmin", historialAdmin );
        
        request.getRequestDispatcher("/WEB-INF/Listar/ListaHistorialAdmin.jsp").forward(request, response);
    }

}
