/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Interrelaciones;
import java.math.BigDecimal;
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
public class InterrelacionesFacade extends AbstractFacade<Interrelaciones> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InterrelacionesFacade() {
        super(Interrelaciones.class);
    }
    
    public List<Interrelaciones> findByNanda(BigDecimal codigoNanda){
        try{
            Query nq = getEntityManager().createNamedQuery("Interrelaciones.findByCodigoNanda");
            nq.setParameter("codigoNanda", codigoNanda);

            List interrelacionesList = nq.getResultList();
            if(interrelacionesList == null){
                return null;
            }else{
                return interrelacionesList;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    public List<Interrelaciones> findByNoc(long codigoNoc){
        try{
            Query nq = getEntityManager().createNamedQuery("Interrelaciones.findByCodigoNoc");
            nq.setParameter("codigoNoc", codigoNoc);

            List interrelacionesList = nq.getResultList();
            if(interrelacionesList == null){
                return null;
            }else{
                return interrelacionesList;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
