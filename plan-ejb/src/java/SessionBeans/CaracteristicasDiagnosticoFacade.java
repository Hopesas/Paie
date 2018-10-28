/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.CaracteristicasDiagnostico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Freddy
 */
@Stateless
public class CaracteristicasDiagnosticoFacade extends AbstractFacade<CaracteristicasDiagnostico> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaracteristicasDiagnosticoFacade() {
        super(CaracteristicasDiagnostico.class);
    }
    
}
