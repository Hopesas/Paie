/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Nanda;
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
public class NandaFacade extends AbstractFacade<Nanda> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NandaFacade() {
        super(Nanda.class);
    }
    
    
    public List<Nanda> findByPattern(BigDecimal pattern) {
        try{
            Query nq = getEntityManager().createNamedQuery("Nanda.findByPatron");
            nq.setParameter("patron", pattern);

            List nandaList = nq.getResultList();
            if(nandaList == null){
                return null;
            }else{
                return nandaList;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    
    public Nanda findById(Long id) {
        try{
            Query nq = getEntityManager().createNamedQuery("Nanda.findById");
            nq.setParameter("id", id);

            Nanda nanda = (Nanda)nq.getSingleResult();
            if(nanda == null){
                return null;
            }else{
                return nanda;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
