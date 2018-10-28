/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Useras;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Freddy
 */
@Stateless
public class UserasFacade extends AbstractFacade<Useras> implements UserasFacadeLocal {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
    
    public UserasFacade() {
        super(Useras.class);
    }
   
    
    @Override
    public Useras findByName(String username) {
        try{
            Query nq = getEntityManager().createNamedQuery("Useras.findByUsername");
            nq.setParameter("username", username);

            List userasList = nq.getResultList();
            if(userasList == null){
                return null;
            }else{
                return (Useras)userasList.get(0);
            }
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Useras findById(long idUseras) {
        try{
            Query nq = getEntityManager().createNamedQuery("Useras.findById");
            nq.setParameter("id", idUseras);

            Useras paciente = (Useras)nq.getSingleResult();
            if(paciente == null){
                return null;
            }else{
                return paciente;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
