
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "sede")
public class Sede implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sede")
    private Integer idSede;
    
    @Column(name="nombre_sede")
    private String nombreSede;
    
    private String direccion;
    
    @OneToMany(mappedBy = "sede")
    private List<PuntoVenta> puntoVentas;
    
    @OneToMany(mappedBy = "sede")
    private List<Usuario> usuarios;
    
    @OneToMany(mappedBy = "sede")
    private List<Ubicacion> ubicaciones;
   

    //CONSTRUCTORES
    public Sede() {
    }

    public Sede(Integer idSede) {
        this.idSede = idSede;
    }
    
    
    //GETTERS AND SETTERS
    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<PuntoVenta> getPuntoVentas() {
        return puntoVentas;
    }

    public void setPuntoVentas(List<PuntoVenta> puntoVentas) {
        this.puntoVentas = puntoVentas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    
    
    
    
    
    @Override
    public String toString() {
        return "Sede{" + "idSede=" + idSede + ", nombreSede=" + nombreSede + ", direccion=" + direccion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idSede);
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
        final Sede other = (Sede) obj;
        if (!Objects.equals(this.idSede, other.idSede)) {
            return false;
        }
        return true;
    }

}  