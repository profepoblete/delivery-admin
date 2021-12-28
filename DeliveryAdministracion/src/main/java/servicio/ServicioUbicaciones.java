
package servicio;

import java.util.List;
import modelo.Ubicacion;
import dao.UbicacionDAO; 


public class ServicioUbicaciones {
    
    private UbicacionDAO ubicacionDAO = new UbicacionDAO();
    //encontrarPuntoVenta ptoVenta
    public List<Ubicacion> listarUbicaciones(){
        return ubicacionDAO.listar();
    }
    
    public List<Ubicacion> listarUbicacionesPorSede(String idSede){
        return ubicacionDAO.listarPorSede(idSede);
    }
    
    public String guardarUbicacion(Ubicacion ubicacion){
        if( ubicacion != null && ubicacion.getIdUbicacion()== null){
            return ubicacionDAO.insertar(ubicacion);
        }
        else{
            return ubicacionDAO.actualizar(ubicacion);
        }
    }
    
    public String eliminarUbicacion(Ubicacion ubicacion){
        return ubicacionDAO.eliminar(ubicacion);
    }
    
    public Ubicacion encontrarUbicacion(Ubicacion ubicacion){
        return ubicacionDAO.buscarUbicacionPorId(ubicacion);
    }
    
}
