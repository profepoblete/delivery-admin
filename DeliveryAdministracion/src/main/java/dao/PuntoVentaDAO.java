
package dao;

import static dao.GenericDAO.em;
import java.util.List;
import javax.persistence.Query;
import modelo.PuntoVenta;
import dao.HistorialAdminDAO;
import modelo.HistorialAdmin;

public class PuntoVentaDAO extends GenericDAO {
    
    //Metodo que lista los datos usando las sentencias de hibernate(?)  
    public List<PuntoVenta> listar() {
        String consulta = "SELECT p FROM PuntoVenta p";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    
    
    //Metodo que inserta los datos usando las sentencias de hibernate(?)
    public String insertar(PuntoVenta puntoVenta) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(puntoVenta);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        } 
    }
    
    
    
    //Metodo que actualiza los datos usando las sentencias de hibernate(?)
    public String actualizar(PuntoVenta puntoVenta) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(puntoVenta);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        } 
    }

    
    
    //Metodo para eliminar un puntoVenta dando el puntoVenta(1),=> el constructor tiene un parametro que es el id
    public String eliminar(PuntoVenta puntoVenta) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(puntoVenta));
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            return ex.toString();
        }
    }
    
    
    //Metodo para buscar el puntoVenta dandole el puntoVenta(1)
    public PuntoVenta buscarPuntoVentaPorId(PuntoVenta p) {
        em = getEntityManager();
        return em.find(PuntoVenta.class, p.getIdPuntoVenta());
    }
    
    
}
