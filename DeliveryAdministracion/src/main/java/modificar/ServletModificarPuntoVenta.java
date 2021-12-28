package modificar;

import dao.PuntoVentaDAO;
import dao.SedeDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.PuntoVenta;
import modelo.Sede;
import modelo.Usuario;
import servicio.ServicioPuntoVentas;
import servicio.ServiciosHistorialesAdmin;




@WebServlet(name = "/ServletModificarPuntoVenta", urlPatterns = { "/ModificarPuntoVenta" })
@MultipartConfig (
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ServletModificarPuntoVenta extends HttpServlet{
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
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
        
        //Obtengo el paramtero idUsuario desde la pagina del listado, y lo transformo en integer
        String idPuntoVentaS = request.getParameter("idPuntoVenta");
        Integer idPuntoVenta = Integer.parseInt(idPuntoVentaS);

        PuntoVenta puntoVenta = new PuntoVenta();
        puntoVenta.setIdPuntoVenta(idPuntoVenta);

        //Busco el objeto completo meidante el metodo buscar por id
        ServicioPuntoVentas spv = new ServicioPuntoVentas();
        puntoVenta = spv.encontrarPuntoVenta(puntoVenta);
        
        //Verifico si es modificación unicamente de estado
        String valueActivo = request.getParameter("valueActivo");
        if (valueActivo != null) {
            
            if (valueActivo.equals("true")) {
                puntoVenta.setActivo(true);
            }else if(valueActivo.equals("false")){
                puntoVenta.setActivo(false);
            }
            String msj = spv.guardarPuntoVenta(puntoVenta);
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", msj);
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "El PUNTO DE VENTA se ha modificado correctamente.");
                
                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Punto de venta";
                String accionH = "";
                if (puntoVenta.isActivo()) {
                    accionH = "Activar";
                    
                }else{
                    accionH = "Desactivar";
                }
                String registroH = "ID:"+puntoVenta.getIdPuntoVenta()+", Nombre:"+puntoVenta.getNombre()+", Sede:"+puntoVenta.getSede().getNombreSede();
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }
            PuntoVentaDAO tpDao = new PuntoVentaDAO();
            List<PuntoVenta> puntoVentas = tpDao.listar();  
            request.setAttribute("puntoVentas", puntoVentas );
            request.getRequestDispatcher("/WEB-INF/Listar/ListaPuntoVentas.jsp").forward(request, response);
            
        }else{
            puntoVenta.setHoraInicio(puntoVenta.getHoraInicio().substring(0, 5));
            puntoVenta.setHoraFin(puntoVenta.getHoraFin().substring(0, 5));
            //Seteo el objeto como atributo para poner ponerlo en los input de modificar
            HttpSession sesion = request.getSession();
            sesion.setAttribute("puntoVenta", puntoVenta);

            SedeDAO s = new SedeDAO();
            List<Sede> sedes = s.listar();
            request.setAttribute("sedes", sedes);

            request.getRequestDispatcher("/WEB-INF/Modificar/ModificarPuntoVenta.jsp").forward(request, response);
        }

    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
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
        
        ServicioPuntoVentas servicioPuntoVentas = new ServicioPuntoVentas();
        
        //Verifico que el usuario preciono el boton "Modificar"
        String modificar = request.getParameter("Modificar");
        if (modificar != null) {
        
        //--------------CAPTURANDO LOS PARAMETROS -----------------------
        
        String nombre = request.getParameter("nombre");
        String empresa = request.getParameter("empresa");
        String sedeS = request.getParameter("sede");
        Integer sede = Integer.parseInt(sedeS);
        
        String activoS = request.getParameter("activo");
        boolean activo;
        if( activoS == null ) {
            activo = false;
        } else {
            activo = true;
        }
        
        SedeDAO sDAO = new SedeDAO();
        Sede s = new Sede();
        Sede s1 = new Sede();
        if ( sDAO.existeIdSede(sede) ) {
            s.setIdSede(sede);
            s1 = sDAO.buscarSedePorId(s);
        }else {
          //s.setIdSede(1);                            //por el momento si no existe lo deja como colaborador
          //s1 = sDAO.buscarSedePorId(s);
            throw new Exception();                     //Otra opcion es lanzar la exception
        }
        
        Part archivo;
        String fileName = "";
        try{
            
            archivo = request.getPart("imagen");
            fileName = archivo.getSubmittedFileName();
            //lo transforma en una cadena de datos
            InputStream is = archivo.getInputStream();
            //crea un archivo en la locacion indicada.
            Path p = Paths.get(this.getServletContext().getRealPath(""));
            String ruta = p.getParent().getParent()+"\\src\\main\\webapp\\files\\";
            File f = new File(ruta + fileName);
            //lee los datos y los guarda en el archivo
            FileOutputStream ous = new FileOutputStream(f);
            int dato = is.read();
            while (dato != -1) {
                ous.write(dato);
                dato = is.read();
            }
            ous.close();
            is.close();
        }catch(Exception e){
            fileName = "";
        }
        
        //Obtengo el parametro y le agrego los segundos
        String horaIni = request.getParameter("horaInicio");   
        String horaIn = horaIni +":00";  
        
        //Obtengo el parametro y le agrego los segundos
        String horaF = request.getParameter("horaFin");   
        String horaFi = horaF +":00";  

        //---------------- INSTANCIANDO LOS OBJETOS ---------------------
        HttpSession sesion = request.getSession();
        PuntoVenta pv = (PuntoVenta) sesion.getAttribute("puntoVenta");
        
        pv.setNombre(nombre);
        pv.setEmpresa(empresa);
        if (fileName!=""){
            pv.setImagen(fileName);
        }
        pv.setHoraInicio(horaIn);
        pv.setHoraFin(horaFi);
        pv.setActivo(activo);
        pv.setSede(s1);
        
            
        //--------------- PROCEDIMIENTOS PARA GUARDAR EL PUNTO DE VENTA ----------------------
        ServicioPuntoVentas spv = new ServicioPuntoVentas();
        String msj = spv.guardarPuntoVenta(pv);
        if (msj!="") {
            request.setAttribute("errorVal", true);
            request.setAttribute("msj", msj);
        }else{
            request.setAttribute("errorVal", false);
            request.setAttribute("msj", "El PUNTO DE VENTA se ha modificado correctamente.");
            
            /*----------AGREGAR AL HISTORIAL----------*/
            ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
            Usuario userH = (Usuario) sess.getAttribute("logged");
            String tablaH = "Punto de venta";
            String accionH = "Modificar";
            String registroH = "ID:"+pv.getIdPuntoVenta()+", Nombre:"+pv.getNombre()+", Sede:"+pv.getSede().getNombreSede();
            sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
        }
        
        } else {
            //Caso de eliminar
            String idPuntoVentaS = request.getParameter("idPuntoVenta");
            Integer idPuntoVenta = Integer.parseInt(idPuntoVentaS);

            PuntoVenta pv = new PuntoVenta(idPuntoVenta);
            PuntoVenta pvH = servicioPuntoVentas.encontrarPuntoVenta(pv);
            String nombreH = pvH.getNombre();
            String sedeH = pvH.getSede().getNombreSede();
            String msj = servicioPuntoVentas.eliminarPuntoVenta(pv);
            if (msj!="") {
                request.setAttribute("errorVal", true);
                request.setAttribute("msj", "El PUNTO DE VENTA no se ha podido eliminar, revise que no tenga ningún USUARIO, PRODUCTO o PROMOCIÓN que dependa de este. De lo contrario, opte por desactivarlo.");
            }else{
                request.setAttribute("errorVal", false);
                request.setAttribute("msj", "El PUNTO DE VENTA se ha eliminado correctamente.");
                
                /*----------AGREGAR AL HISTORIAL----------*/
                ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
                Usuario userH = (Usuario) sess.getAttribute("logged");
                String tablaH = "Punto de venta";
                String accionH = "Eliminar";
                String registroH = "ID:"+pv.getIdPuntoVenta()+", Nombre:"+nombreH+", Sede:"+sedeH;
                sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
            }
            System.out.println("Punto Venta Eliminado");
        }
          
        //---------------- EN CASO DE EXCEPTION SE ENCAPSULA Y SE REDIRECCIONA A PAGINA ERROR -----------
        } catch(Exception e ){
            e.printStackTrace(); 
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            //Esta opcion de redireccionar, puede ser cambiada a otra como un mensaje de alerta en pantalla
        }
        PuntoVentaDAO tpDao = new PuntoVentaDAO();
        List<PuntoVenta> puntoVentas = tpDao.listar();  
        request.setAttribute("puntoVentas", puntoVentas );
        request.getRequestDispatcher("/WEB-INF/Listar/ListaPuntoVentas.jsp").forward(request, response);
    }


}

    
    
         


