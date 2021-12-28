
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;



@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_usuario")
    private Integer idTipoUsuario;
    
    private String descripcion;
    
    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;
    
    
    
    //CONSTRUCTORES
    public TipoUsuario() {
    }
    
    public TipoUsuario(Integer idTipoUsuario) {
    this.idTipoUsuario = idTipoUsuario;
    }
    
    
    //GETTERS AND SETTERS


    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
  

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoUsuario=" + idTipoUsuario + ", descripcion=" + descripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idTipoUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoUsuario other = (TipoUsuario) obj;
        if (!Objects.equals(this.idTipoUsuario, other.idTipoUsuario)) {
            return false;
        }
        return true;
    }
    
    
    
     
    
     
    
  
   

    
    
}