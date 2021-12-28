
package servicio;

import java.util.List;
import dao.HistorialAdminDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modelo.HistorialAdmin;
import modelo.Usuario;

public class ServiciosHistorialesAdmin {
    private HistorialAdminDAO histDAO = new HistorialAdminDAO();
    
    public List<HistorialAdmin> listarHistorialesAdmin(){
        return this.histDAO.listar();
    }
    
    public String guardarHistorialAdmin(Usuario usuario, String tabla, String accion, String registro){
        HistorialAdmin hist = new HistorialAdmin();
        hist.setUsuario(usuario);
        hist.setTabla(tabla);
        hist.setAccion(accion);
        hist.setRegistro(registro);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -3);
        hist.setFecha(calendar.getTime());
        /*String time = (Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);*/
        String time =dateFormat.format(date);
        System.out.println(time);
        hist.setTime(time);
        return histDAO.insertar(hist);
    }
    
}
