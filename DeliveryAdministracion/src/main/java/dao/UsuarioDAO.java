package dao;

import com.mysql.cj.xdevapi.SessionFactory;
import modelo.TipoUsuario;
import modelo.Usuario;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.security.auth.login.Configuration;
import org.junit.platform.commons.util.CollectionUtils;
import dao.HistorialAdminDAO;

public class UsuarioDAO extends GenericDAO {

    
    //Metodo que lista los datos usando las sentencias de hibernate(?)
    public List<Usuario> listar() {
        String consulta = "SELECT u FROM Usuario u";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    
    //Metodo que inserta los datos usando las sentencias de hibernate(?)
    public String insertar(Usuario usuario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        }
    }

    //Metodo que actualiza los datos usando las sentencias de hibernate(?)
    public String actualizar(Usuario usuario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        }
    }

    
    //Metodo para eliminar un usuario dando el usuario(1), esto a que el constructor tiene un parametro que es el id
    public String eliminar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(usuario));
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            return ex.toString();
        }
    }

    
    //Metodo para buscar el usuario dandole el usuario(1)
    public Usuario buscarUsuarioPorId(Usuario u) {
        return em.find(Usuario.class, u.getIdUsuario());
    }

    
    
    //Metodo que devuelve el id del email que se ingreso
    public Integer buscarEmail(String email) {

        UsuarioDAO us = new UsuarioDAO();
        List<Usuario> lista = us.listar();
        Usuario user = new Usuario();
        Integer idUser = null;
        for (Usuario u : lista) {
            if (u.getEmail().trim().equals(email.trim())) {
                idUser = u.getIdUsuario();
            }
        }
        return idUser;
    }

    
    
    
    
    //METODO PARA CONFIRMAR QUE EXISTA EL CORREO Y LA PASSWORD EN LA BASE DE DATOS 
    public Usuario login(String email, String password) {

        UsuarioDAO us = new UsuarioDAO();
        Integer id = us.buscarEmail(email);
        Usuario user = new Usuario();
        Usuario user2 = new Usuario();
        Usuario finalU = new Usuario();
        boolean bol = false;
        
        try {
            if (id != null) {
                user.setIdUsuario(id);
                user2 = us.buscarUsuarioPorId(user);

                String pass = user2.getContrasena();
                TipoUsuario tp = user2.getTipoUsuario();
                Integer tipo = tp.getIdTipoUsuario();

                if (pass.equals(password) && tipo == 1) {
                    finalU = user2;
                } 
            }
            return finalU;
        } catch (Exception e) {
            return finalU;
        }
    }
    
    

}
