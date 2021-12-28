package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "punto_venta")
public class PuntoVenta {
      
    private static final long serialVersionUID = 1L;
 
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_punto_venta")
    private Integer idPuntoVenta;
    
    private String nombre;
    private String empresa;
    private String imagen;
    
    @Column(name="hora_inicio")
    private String horaInicio;
    
    @Column(name="hora_fin")
    private String horaFin;
    private boolean activo;
    
    @JoinColumn(name="id_sede",referencedColumnName = "id_sede")
    @ManyToOne
    private Sede sede;
   
    @OneToMany(mappedBy = "puntoVenta")
    private List<Usuario> usuarios;
    
    
    //CONSTRUCTORES

    public PuntoVenta() {
    }

    public PuntoVenta(Integer idPuntoVenta) {
        this.idPuntoVenta = idPuntoVenta;
    }
    
    //GETTERS AND SETTERS

    public Integer getIdPuntoVenta() {
        return idPuntoVenta;
    }

    public void setIdPuntoVenta(Integer idPuntoVenta) {
        this.idPuntoVenta = idPuntoVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    
    
    @Override
    public String toString() {
        return "PuntoVenta{" + "idPuntoVenta=" + idPuntoVenta + ", nombre=" + nombre + ", empresa=" + empresa + ", imagen=" + imagen + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", activo=" + activo + ", sede=" + sede + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idPuntoVenta);
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
        final PuntoVenta other = (PuntoVenta) obj;
        if (!Objects.equals(this.idPuntoVenta, other.idPuntoVenta)) {
            return false;
        }
        return true;
    }
    
    
    
}