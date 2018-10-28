/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.FactoresRelacionado;
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
public class FactoresRelacionadoFacade extends AbstractFacade<FactoresRelacionado> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactoresRelacionadoFacade() {
        super(FactoresRelacionado.class);
    }
    
    public List<FactoresRelacionado> findByNanda(BigDecimal codigoNanda){
        try{
            Query nq = getEntityManager().createNamedQuery("FactoresRelacionado.findByCodigoNanda");
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
    
    public FactoresRelacionado findById(Long id) {
        try{
            Query nq = getEntityManager().createNamedQuery("FactoresRelacionado.findById");
            nq.setParameter("id", id);

            FactoresRelacionado factor = (FactoresRelacionado)nq.getSingleResult();
            if(factor == null){
                return null;
            }else{
                return factor;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
