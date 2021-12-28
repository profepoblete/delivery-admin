
package dao;

import static dao.GenericDAO.em;
import java.util.List;
import javax.persistence.Query;
import modelo.HistorialAdmin;

public class HistorialAdminDAO extends GenericDAO {
    
    //Metodo que lista los datos usando las sentencias de hibernate(?)  
    public List<HistorialAdmin> listar() {
        String consulta = "SELECT h FROM HistorialAdmin h";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    
    //Metodo que inserta los datos usando las sentencias de hibernate(?)
    public String insertar(HistorialAdmin historialAdmin) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historialAdmin);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        } 
    }
    
}
