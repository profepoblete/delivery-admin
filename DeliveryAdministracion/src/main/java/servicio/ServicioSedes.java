
package servicio;

import dao.SedeDAO;
import java.util.List;
import modelo.Sede;


public class ServicioSedes {

    private SedeDAO sedeDAO = new SedeDAO();
    
    public List<Sede> listarSedes(){
        return this.sedeDAO.listar();
    }
    
    
    public String guardarSede(Sede sede){
        if( sede != null && sede.getIdSede() == null){
            return sedeDAO.insertar(sede);
        }
        else{
            return sedeDAO.actualizar(sede);
        }
    }
    
    
    public String eliminarSede(Sede sede){
        return (sedeDAO.eliminar(sede));
    }
    
    public Sede encontrarSede(Sede sede){
        return sedeDAO.buscarSedePorId(sede);
    }
    
    
    public boolean buscaIdSede(Integer idSede){
        return sedeDAO.existeIdSede(idSede);
    }
    
  
}
