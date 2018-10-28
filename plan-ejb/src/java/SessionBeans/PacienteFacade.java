/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Paciente;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Freddy
 */
@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteFacade() {
        super(Paciente.class);
    }
    
    public Paciente findByDocumento(BigInteger documento) {
        try{
            Query nq = getEntityManager().createNamedQuery("Paciente.findByDocumento");
            nq.setParameter("documento", documento);

            Paciente paciente = (Paciente)nq.getSingleResult();
            if(paciente == null){
                return null;
            }else{
                return paciente;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    
    public Paciente findById(Long id) {
        try{
            Query nq = getEntityManager().createNamedQuery("Paciente.findById");
            nq.setParameter("id", id);

            Paciente paciente = (Paciente)nq.getSingleResult();
            if(paciente == null){
                return null;
            }else{
                return paciente;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
}
