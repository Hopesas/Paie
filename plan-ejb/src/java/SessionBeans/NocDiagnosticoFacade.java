/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.NocDiagnostico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Freddy
 */
@Stateless
public class NocDiagnosticoFacade extends AbstractFacade<NocDiagnostico> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NocDiagnosticoFacade() {
        super(NocDiagnostico.class);
    }
    
}
