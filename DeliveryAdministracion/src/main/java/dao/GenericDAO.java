
package dao;

import javax.persistence.*;


//CLASE ABSTRACTA PARA INSTANCIAR LOS ENTITYMANAGER
public abstract class GenericDAO {
    
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "HibernateJPA";
    
    public GenericDAO(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
