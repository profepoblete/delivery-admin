
package dao;

import static dao.GenericDAO.em;
import java.util.List;
import javax.persistence.Query;
import modelo.Ubicacion;
import dao.HistorialAdminDAO;

public class UbicacionDAO extends GenericDAO {
    
    //Metodo que lista los datos usando las sentencias de hibernate(?)  
    public List<Ubicacion> listar() {
        String consulta = "SELECT u FROM Ubicacion u";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    
    //Metodo que lista los datos usando las sentencias de hibernate(?)  
    public List<Ubicacion> listarPorSede(String idSede) {
        String consulta = "SELECT u FROM Ubicacion u WHERE u.sede.idSede="+idSede;
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    
    
    //Metodo que inserta los datos usando las sentencias de hibernate(?)
    public String insertar(Ubicacion ubicacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ubicacion);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        } 
    }
    
    
    
    //Metodo que actualiza los datos usando las sentencias de hibernate(?)
    public String actualizar(Ubicacion ubicacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(ubicacion);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        } 
    }

    
    
    //Metodo para eliminar una Ubicacion dando la Ubicacion(1),=> el constructor tiene un parametro que es el id
    public String eliminar(Ubicacion ubicacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(ubicacion));
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            return ex.toString();
        }
    }
    
    
    //Metodo para buscar la Ubicacion dandole la Ubicacion(1)
    public Ubicacion buscarUbicacionPorId(Ubicacion ubicacion) {
        em = getEntityManager();
        return em.find(Ubicacion.class, ubicacion.getIdUbicacion());
    }
    
    
}
