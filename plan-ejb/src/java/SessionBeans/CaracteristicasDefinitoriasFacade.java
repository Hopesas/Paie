/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.CaracteristicasDefinitorias;
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
public class CaracteristicasDefinitoriasFacade extends AbstractFacade<CaracteristicasDefinitorias> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaracteristicasDefinitoriasFacade() {
        super(CaracteristicasDefinitorias.class);
    }
    
        
    public List<CaracteristicasDefinitorias> findByNanda(BigDecimal codigoNanda){
        try{
            Query nq = getEntityManager().createNamedQuery("CaracteristicasDefinitorias.findByCodigoNanda");
            nq.setParameter("codigoNanda", codigoNanda);

            List caracteristicasList = nq.getResultList();
            if(caracteristicasList == null){
                return null;
            }else{
                return caracteristicasList;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    
    public CaracteristicasDefinitorias findById(Long id) {
        try{
            Query nq = getEntityManager().createNamedQuery("CaracteristicasDefinitorias.findById");
            nq.setParameter("id", id);

            CaracteristicasDefinitorias feature = (CaracteristicasDefinitorias)nq.getSingleResult();
            if(feature == null){
                return null;
            }else{
                return feature;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
