
package servicio;

import dao.PuntoVentaDAO;
import java.util.List;
import modelo.PuntoVenta;


public class ServicioPuntoVentas {

    private PuntoVentaDAO puntoVentaDAO = new PuntoVentaDAO();
    
    public List<PuntoVenta> listarPuntoVentas(){
        return this.puntoVentaDAO.listar();
    }
    
    
    public String guardarPuntoVenta(PuntoVenta puntoVenta){
        if( puntoVenta != null && puntoVenta.getIdPuntoVenta() == null){
            return puntoVentaDAO.insertar(puntoVenta);
        }
        else{
            return puntoVentaDAO.actualizar(puntoVenta);
        }
    }
    
    
    public String eliminarPuntoVenta(PuntoVenta puntoVenta){
        return puntoVentaDAO.eliminar(puntoVenta);
    }
    
    public PuntoVenta encontrarPuntoVenta(PuntoVenta puntoVenta){
        return puntoVentaDAO.buscarPuntoVentaPorId(puntoVenta);
    }
    
  
}
