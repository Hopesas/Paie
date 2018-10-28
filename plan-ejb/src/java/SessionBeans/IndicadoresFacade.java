/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Indicadores;
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
public class IndicadoresFacade extends AbstractFacade<Indicadores> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndicadoresFacade() {
        super(Indicadores.class);
    }
    
    public List<Indicadores> findByNoc(long codigoNoc){
        try{
            Query nq = getEntityManager().createNamedQuery("Indicadores.findByCodigoNoc");
            nq.setParameter("codigoNoc", codigoNoc);

            List indicadoresList = nq.getResultList();
            if(indicadoresList == null){
                return null;
            }else{
                return indicadoresList;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
