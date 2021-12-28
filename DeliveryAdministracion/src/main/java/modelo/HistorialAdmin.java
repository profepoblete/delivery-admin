package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "historial_admin")
public class HistorialAdmin implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historial_admin")
    private Integer idHistorialAdmin;
    
    @JoinColumn(name="id_usuario",referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    @Column(name="tabla")
    private String tabla;
    
    @Column(name="accion")
    private String accion;
    
    @Column(name="registro")
    private String registro;
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="time")
    private String time;

    //CONSTRUCTORS
    
    public HistorialAdmin() {
    }

    public HistorialAdmin(Integer idHistorialAdmin) {
        this.idHistorialAdmin = idHistorialAdmin;
    }

    public HistorialAdmin(Integer idHistorialAdmin, Usuario usuario, String tabla, String accion, String registro, Date fecha, String time) {
        this.idHistorialAdmin = idHistorialAdmin;
        this.usuario = usuario;
        this.tabla = tabla;
        this.accion = accion;
        this.registro = registro;
        this.fecha = fecha;
        this.time = time;
    }
    
    //GETERS AND SETERS

    public Integer getIdHistorialAdmin() {
        return idHistorialAdmin;
    }

    public void setIdHistorialAdmin(Integer idHistorialAdmin) {
        this.idHistorialAdmin = idHistorialAdmin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HistorialAdmin{" + "idHistorialAdmin=" + idHistorialAdmin + ", usuario=" + usuario + ", tabla=" + tabla + ", accion=" + accion + ", registro=" + registro + ", fecha=" + fecha + ", time=" + time + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idHistorialAdmin);
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
        final HistorialAdmin other = (HistorialAdmin) obj;
        if (!Objects.equals(this.idHistorialAdmin, other.idHistorialAdmin)) {
            return false;
        }
        return true;
    }
    
}
