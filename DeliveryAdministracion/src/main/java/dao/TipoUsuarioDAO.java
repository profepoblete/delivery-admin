
package dao;

import static dao.GenericDAO.em;
import java.util.List;
import javax.persistence.Query;
import modelo.TipoUsuario;
import dao.HistorialAdminDAO;


public class TipoUsuarioDAO extends GenericDAO {
    

    //Metodo que lista los datos usando las sentencias de hibernate(?)
    public List<TipoUsuario> listar() {
        String consulta = "SELECT t FROM TipoUsuario t";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    //Metodo que inserta los datos usando las sentencias de hibernate(?)
    public String insertar(TipoUsuario tipoUsuario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoUsuario);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        } 
    }
    
    
    //Metodo que lista los datos usando las sentencias de hibernate(?)
    public String actualizar(TipoUsuario tipoUsuario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(tipoUsuario);
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return ex.toString();
        } 
    }

    //Metodo para eliminar un tipoUsuario dando el tipoUsuario(1) => el constructor tiene un parametro que es el id
    public String eliminar(TipoUsuario tipoUsuario) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(tipoUsuario));
            em.getTransaction().commit();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            return ex.toString();
        }
    }
     
    
    //Metodo para buscar el tipoUsuario dandole el tipoUsuario(1)
    public TipoUsuario buscarTipoUsuarioPorId(TipoUsuario t) {
        return em.find(TipoUsuario.class, t.getIdTipoUsuario());
    }
    

    
    //Metodo para validar que exista el tipo de usuario en los registros 
    public boolean existeIdTipoUsuario(Integer id){
        TipoUsuarioDAO tpDao = new TipoUsuarioDAO();
        List<TipoUsuario> lista = tpDao.listar();
        boolean bo = false;
        for (TipoUsuario tp : lista) {
            if( tp.getIdTipoUsuario().equals(id) ) {
                bo = true;
            }
        }
        return bo;       
    }
    
    
    
}
