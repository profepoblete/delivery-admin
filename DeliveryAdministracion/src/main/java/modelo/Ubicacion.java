package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "ubicacion")
public class Ubicacion implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ubicacion")
    private Integer idUbicacion;
    
    @Column(name="nombre_edificio")
    private String nombreEdificio;
    
    @Column(name="piso")
    private String piso;
    
    @JoinColumn(name="id_sede",referencedColumnName = "id_sede")
    @ManyToOne
    private Sede sede;
    
    //CONSTRUCTORES

    public Ubicacion() {
    }

    public Ubicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    //GETTERS AND SETTERS
    
    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "idUbicacion=" + idUbicacion + ", nombreEdificio=" + nombreEdificio + ", piso=" + piso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idUbicacion);
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
        final Ubicacion other = (Ubicacion) obj;
        if (!Objects.equals(this.idUbicacion, other.idUbicacion)) {
            return false;
        }
        return true;
    }
    
}
