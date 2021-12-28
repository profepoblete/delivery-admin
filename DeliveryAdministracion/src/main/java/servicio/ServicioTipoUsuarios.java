
package servicio;

import dao.TipoUsuarioDAO;
import java.util.List;
import modelo.TipoUsuario;


public class ServicioTipoUsuarios {

    private TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
    
    public List<TipoUsuario> listarTipoUsuarios(){
        return this.tipoUsuarioDAO.listar();
    }
    
    
    //En caso de que no exista el tipo de usuario se agrega, sino se actualiza
    public String guardarTipoUsuario(TipoUsuario tipoUsuario){
        if( tipoUsuario != null && tipoUsuario.getIdTipoUsuario() == null){
            return tipoUsuarioDAO.insertar(tipoUsuario);
        }
        else{
            return tipoUsuarioDAO.actualizar(tipoUsuario);
        }
    }
    
    
    
    public String eliminarTipoUsuario(TipoUsuario tipoUsuario){
        return tipoUsuarioDAO.eliminar(tipoUsuario);
    }
    
    
    
    public TipoUsuario encontrarTipoUsuario(TipoUsuario tipoUsuario){
        return tipoUsuarioDAO.buscarTipoUsuarioPorId(tipoUsuario);
    }
    
    
    
    public boolean buscaIdTipoUsuario(Integer idTipoUsuario){
        return tipoUsuarioDAO.existeIdTipoUsuario(idTipoUsuario);
    }
  
}
