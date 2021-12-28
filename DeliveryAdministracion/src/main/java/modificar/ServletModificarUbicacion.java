package modificar;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;
import servicio.*;



@WebServlet(name = "ServletModificarUbicacion", urlPatterns = {"/ModificarUbicacion"})
public class ServletModificarUbicacion extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    
        //Obtengo el paramtero id desde la pagina del listado, y lo transformo en integer
        String idUbicacionS = request.getParameter("idUbicacion");
        Integer idUbicacion = Integer.parseInt(idUbicacionS);

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setIdUbicacion(idUbicacion);
        
        //Busco el objeto completo meidante el metodo buscar por id
        ServicioUbicaciones sUbicacion = new ServicioUbicaciones();
        ubicacion = sUbicacion.encontrarUbicacion(ubicacion);

        //Seteo el objeto como atributo para poner ponerlo en los input de modificar
        request.setAttribute("ubicacion", ubicacion);
        
        request.getRequestDispatcher("/WEB-INF/Modificar/ModificarUbicacion.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession sess = request.getSession();
        
        try{
            Usuario ver = (Usuario) sess.getAttribute("logged");
            if (ver.getIdUsuario()==null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch(Exception e ){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        try {

            ServicioUbicaciones sUbicacion = new ServicioUbicaciones();
            String modificar = request.getParameter("Modificar");
            
            if (modificar != null) {

                //------------- CAPTURO LOS PARÁMETROS ---------------
                
                String idUbicacionS = request.getParameter("idUbicacion");
                
                String nombreEdificio = request.getParameter("nombreEdificio");
                String piso = request.getParameter("piso");
                Integer idUbicacion = Integer.parseInt(idUbicacionS);
                
                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setIdUbicacion(idUbicacion);

                //Busco el objeto completo meidante el metodo buscar por id
                ubicacion = sUbicacion.encontrarUbicacion(ubicacion);

                ubicacion.setNombreEdificio(nombreEdificio);
                ubicacion.setPiso(piso);

                //Guardo los nuevos datos ingresado
                Ubicacion uH = sUbicacion.encontrarUbicacion(ubicacion);
                String nombreH = uH.getNombreEdificio();
                
                String msj = sUbicacion.guardarUbicacion(ubicacion);
                if (msj!="") {
                    request.setAttribute("errorVal", true);
                    request.setAttribute("msj", msj);
                }else{
                    request.setAttribute("errorVal", false);
                    request.setAttribute("msj", "La UBICACIÓN se ha actualizado correctamente.");
                    
                    /*----------AGREGAR AL HISTORIAL----------*/
                    ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                    Usuario userH = (Usuario) sess.getAttribute("logged");
                    String tablaH = "Ubicación";
                    String accionH = "Modificar";
                    String registroH = "ID:"+ubicacion.getIdUbicacion()+", Nombre:"+nombreH;
                    sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
                }
                System.out.println("Ubicacion Modificada");
            } else {

                String idUbicacionS = request.getParameter("idUbicacion");
                Integer idUbicacion = Integer.parseInt(idUbicacionS);

                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setIdUbicacion(idUbicacion);
                Ubicacion uH = sUbicacion.encontrarUbicacion(ubicacion);
                String nombreH = uH.getNombreEdificio();
                String msj = sUbicacion.eliminarUbicacion(ubicacion);
                if (msj!="") {
                    request.setAttribute("errorVal", true);
                    request.setAttribute("msj", "La UBICACIÓN no se ha podido eliminar, Puede que ya esté asociada a algún pedido.");
                }else{
                    request.setAttribute("errorVal", false);
                    request.setAttribute("msj", "La UBICACIÓN se ha eliminado correctamente.");
                    
                    /*----------AGREGAR AL HISTORIAL----------*/
                    ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                    Usuario userH = (Usuario) sess.getAttribute("logged");
                    String tablaH = "Ubicación";
                    String accionH = "Eliminar";
                    String registroH = "ID:"+ubicacion.getIdUbicacion()+", Nombre:"+nombreH;
                    sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
                }
                System.out.println("Ubicacion Eliminada");
            }

        } catch(Exception e ){
            e.printStackTrace();
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        
        try{
            String idSede = request.getParameter("idSede");
            ServicioSedes sSed = new ServicioSedes();
            ServicioUbicaciones sUbi = new ServicioUbicaciones();
            Sede sede = new Sede(Integer.parseInt(idSede));
            sede = sSed.encontrarSede(sede);
            request.setAttribute("sede", sede );
            List<Ubicacion> ubicaciones = sUbi.listarUbicaciones();
            ubicaciones.removeIf(n -> ( n.getSede().getIdSede() != Integer.parseInt(idSede) ));
            request.setAttribute("ubicaciones", ubicaciones );
            request.getRequestDispatcher("/WEB-INF/Listar/ListaUbicaciones.jsp").forward(request, response);
        }
        catch(Exception e){
            request.getRequestDispatcher("/WEB-INF/Listar/ListaUbicaciones.jsp").forward(request, response);
        }
    }


}
