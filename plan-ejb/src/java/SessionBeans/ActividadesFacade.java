/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Actividades;
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
public class ActividadesFacade extends AbstractFacade<Actividades> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadesFacade() {
        super(Actividades.class);
    }
    
    public List<Actividades> findByNic(long codigoNic) {
        try{
            Query nq = getEntityManager().createNamedQuery("Actividades.findByCodigoNic");
            nq.setParameter("codigoNic", codigoNic);

            List actividadesNic = nq.getResultList();
            if(actividadesNic == null){
                return null;
            }else{
                return actividadesNic;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
