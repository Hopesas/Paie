/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Nic;
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
public class NicFacade extends AbstractFacade<Nic> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NicFacade() {
        super(Nic.class);
    }
        
    public Nic findByCodigo(Long codigo){
        try{
            Query nq = getEntityManager().createNamedQuery("Nic.findByCodigo");
            nq.setParameter("codigo", codigo);

            Nic nicList = (Nic)nq.getSingleResult();
            if(nicList == null){
                return null;
            }else{
                return nicList;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
