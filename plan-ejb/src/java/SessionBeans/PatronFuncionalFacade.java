/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.PatronFuncional;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Freddy
 */
@Stateless
public class PatronFuncionalFacade extends AbstractFacade<PatronFuncional> implements PatronFuncionalFacadeLocal {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatronFuncionalFacade() {
        super(PatronFuncional.class);
    }
    
    public PatronFuncional findById(BigDecimal id){
        try{
            Query nq = getEntityManager().createNamedQuery("PatronFuncional.findById");
            nq.setParameter("id", id);

            PatronFuncional nocList = (PatronFuncional)nq.getSingleResult();
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
