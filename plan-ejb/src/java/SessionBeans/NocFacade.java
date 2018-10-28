/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Noc;
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
public class NocFacade extends AbstractFacade<Noc> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NocFacade() {
        super(Noc.class);
    }
    
    public List<Noc> findByNanda(BigDecimal codigoNanda){
        try{
            Query nq = getEntityManager().createNamedQuery("Interrelaciones.findByCodigoNanda");
            nq.setParameter("codigoNanda", codigoNanda);

            List factoresList = nq.getResultList();
            if(factoresList == null){
                return null;
            }else{
                return factoresList;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    public Noc findByCodigo(Long codigo){
        try{
            Query nq = getEntityManager().createNamedQuery("Noc.findByCodigo");
            nq.setParameter("codigo", codigo);

            Noc nocList = (Noc)nq.getSingleResult();
            if(nocList == null){
                return null;
            }else{
                return nocList;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
