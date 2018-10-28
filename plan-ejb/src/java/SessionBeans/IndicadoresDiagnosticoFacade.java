/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.IndicadoresDiagnostico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Freddy
 */
@Stateless
public class IndicadoresDiagnosticoFacade extends AbstractFacade<IndicadoresDiagnostico> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndicadoresDiagnosticoFacade() {
        super(IndicadoresDiagnostico.class);
    }
    
}
