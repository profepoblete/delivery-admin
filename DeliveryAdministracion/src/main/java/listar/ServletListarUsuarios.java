/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listar;

import dao.PuntoVentaDAO;
import dao.SedeDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.PuntoVenta;
import modelo.Sede;
import modelo.TipoUsuario;
import modelo.Usuario;



@WebServlet(name = "/ServletListarUsuarios", urlPatterns = { "/ListarUsuarios" })
public class ServletListarUsuarios extends HttpServlet{
    
    
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
        UsuarioDAO uDao = new UsuarioDAO();
        List<Usuario> usuarios = uDao.listar();
        request.setAttribute("usuarios", usuarios);

        request.getRequestDispatcher("/WEB-INF/Listar/ListaUsuarios.jsp").forward(request, response);

    }
}
