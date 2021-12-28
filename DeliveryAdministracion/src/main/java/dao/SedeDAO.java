
package dao;

import static dao.GenericDAO.em;
import java.util.List;
import javax.persistence.Query;
import modelo.Sede;
import dao.HistorialAdminDAO;

public class SedeDAO extends GenericDAO {
    
    
    //Metodo que lista los datos usando las sentencias de hibernate(?)
    public List<Sede> listar() {
        String consulta = "SELECT s FROM Sede s";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    

    //Metodo que inserta los datos usando las sentencias de hibernate(?)
    public String insertar(Sede sede) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sede);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        }
    }
    
    

    //Metodo que actualiza los datos usando las sentencias de hibernate(?)
    public String actualizar(Sede sede) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(sede);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        }
    }

    
    //Metodo para eliminar un sede dando el sede(1), esto a que el constructor tiene un parametro que es el id
    public String eliminar(Sede sede) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(sede));
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            return ex.toString();
        }
    }
    
    
    //Metodo para buscar el usuario dandole el sede(1)
    public Sede buscarSedePorId(Sede s) {
        em = getEntityManager();
        return em.find(Sede.class, s.getIdSede());
    }
    
    
    //Metodo para validar que exista el tipo de usuario en los registros 
    public boolean existeIdSede(Integer id){
        SedeDAO sedeDao = new SedeDAO();
        List<Sede> lista = sedeDao.listar();
        boolean bo = false;
        for (Sede s : lista) {
            if( s.getIdSede().equals(id) ) {
                bo = true;
            }
        }
        return bo;       
    }
 
    
}
