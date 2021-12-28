
package servicio;

import java.util.List;
import dao.UsuarioDAO;
import modelo.Usuario;

public class ServicioUsuarios{
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public List<Usuario> listarUsuarios(){
        return this.usuarioDAO.listar();
    }
    
    
    public String guardarUsuario(Usuario usuario){
        if( usuario != null && usuario.getIdUsuario() == null){
            return usuarioDAO.insertar(usuario);
        }
        else{
            return usuarioDAO.actualizar(usuario);
        }
    }
    
    
    public String eliminarUsuario(Usuario usuario){
        return usuarioDAO.eliminar(usuario);
    }
    
    public Usuario encontrarUsuario(Usuario usuario){
        return usuarioDAO.buscarUsuarioPorId(usuario);
    }
    
    
    public Integer buscarCorreo(String email){
        return usuarioDAO.buscarEmail(email);
    }
    
    
    public Usuario logear( String email, String password ){
        return usuarioDAO.login(email, password);
    }
}
