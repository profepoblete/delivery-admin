package modelo;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer idUsuario;
    
    @Column(name="rut")
    private String rut;
    
    @Column(name="nombre")
    private String nombre;  
    
    @Column(name="apellido")
    private String apellido; 
    
    @Column(name="email")
    private String email; 
    
    @Column(name="telefono")
    private Integer telefono; 
    
    @Column(name="contrasena")
    private String contrasena;  
    
    @Column(name="activo")
    private boolean activo;
    
    @JoinColumn(name="id_tipo_usuario",referencedColumnName = "id_tipo_usuario")
    @ManyToOne
    private TipoUsuario tipoUsuario;
    
    @JoinColumn(name="id_punto_venta",referencedColumnName = "id_punto_venta")
    @ManyToOne
    private PuntoVenta puntoVenta;
    
    
    @JoinColumn(name="id_sede",referencedColumnName = "id_sede")
    @ManyToOne
    private Sede sede;
    
   
    //CONSTRUCTORES
    public Usuario(){}

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


    //GETTERS AND SETTERS
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", contrasena=" + contrasena + ", activo=" + activo + ", tipoUsuario=" + tipoUsuario + ", puntoVenta=" + puntoVenta + ", sede=" + sede + '}';
    }

    
    
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }
}

