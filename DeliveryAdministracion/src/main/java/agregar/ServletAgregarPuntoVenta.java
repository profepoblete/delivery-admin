package agregar;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

@WebServlet(name = "/ServletAgregarPuntoVenta", urlPatterns = { "/AgregarPuntoVenta" })
@MultipartConfig (
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ServletAgregarPuntoVenta extends HttpServlet{
  
    
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
    
        //----------- INSTANCIO EL OBJETO Y LLAMO A SU CORRESPONDIENTE METODO LISTAR ------------------
        SedeDAO s = new SedeDAO();
        List<Sede> sedes = s.listar();
        request.setAttribute("sedes", sedes);
        
        request.getRequestDispatcher("/WEB-INF/Agregar/AgregarPuntoVenta.jsp").forward(request, response);

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
            throw new Exception();                //en caso de no encontrar lanzo excepction
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
        LocalDateTime now = LocalDateTime.now();
        
        Part archivo = request.getPart("imagen");
        Usuario usr = (Usuario) sess.getAttribute("logged");
        String fileName = "IMGPVENTA"+usr.getIdUsuario()+dtf.format(now)+archivo.getSubmittedFileName().substring(archivo.getSubmittedFileName().lastIndexOf("."));
        /*String fileName = archivo.getSubmittedFileName();*/
        InputStream is = archivo.getInputStream();
        
        //Este Archivo al momento de correr las 2 applicaciones debe ser uno en comun
        
        
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
        
        
        //Obtengo el parametro y le agrego los segundos
        String horaIni = request.getParameter("horaInicio");   
        String horaIn = horaIni +":00";  
        //Obtengo el parametro y le agrego los segundos
        String horaF = request.getParameter("horaFin");   
        String horaFi = horaF +":00";

        //---------------- INSTANCIANDO LOS OBJETOS ---------------------
        PuntoVenta pv = new PuntoVenta();

        pv.setNombre(nombre);
        pv.setEmpresa(empresa);
        pv.setImagen(fileName);
        pv.setHoraInicio(horaIn);
        pv.setHoraFin(horaFi);
        pv.setActivo(activo);
        pv.setSede(s1);
        
            
        //--------------- PROCEDIMIENTOS PARA GUARDAR EL TIPO USUARIO ----------------------
        ServicioPuntoVentas spv = new ServicioPuntoVentas();
        String msj = spv.guardarPuntoVenta(pv);
        if (msj!="") {
            request.setAttribute("errorVal", true);
            request.setAttribute("msj", msj);
        }else{
            request.setAttribute("errorVal", false);
            request.setAttribute("msj", "Un nuevo PUNTO DE VENTA se ha agregado correctamente.");
            
            /*----------AGREGAR AL HISTORIAL----------*/
            ServiciosHistorialesAdmin sh = new ServiciosHistorialesAdmin();
            Usuario userH = (Usuario) sess.getAttribute("logged");
            String tablaH = "Punto de venta";
            String accionH = "Agregar";
            String registroH = "ID:"+pv.getIdPuntoVenta()+", Nombre:"+pv.getNombre()+", Sede:"+pv.getSede().getNombreSede();
            sh.guardarHistorialAdmin(userH, tablaH, accionH, registroH);
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
    
    
    
         

