/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entity.Diagnostico;
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
public class DiagnosticoFacade extends AbstractFacade<Diagnostico> {
    @PersistenceContext(unitName = "Plan-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticoFacade() {
        super(Diagnostico.class);
    }
    
    public Diagnostico findById(Long id) {
        try{
            Query nq = getEntityManager().createNamedQuery("Diagnostico.findById");
            nq.setParameter("id", id);

            Diagnostico diagnostico = (Diagnostico)nq.getSingleResult();
            if(diagnostico == null){
                return null;
            }else{
                return diagnostico;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    public List<Diagnostico> findByIdEnfermero(String id) {
        try{
            Query nq = getEntityManager().createNamedQuery("Diagnostico.findByIdUseras");
            nq.setParameter("idUseras", id);

            List<Diagnostico> diagnostico = (List<Diagnostico>)nq.getResultList();
            if(diagnostico == null){
                return null;
            }else{
                return diagnostico;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    public List<Diagnostico> findByPatron(Long patron) {
        try{
            Query nq = getEntityManager().createNamedQuery("Diagnostico.findByIdPatron");
            nq.setParameter("idPatron", patron);

            List<Diagnostico> diagnostico = (List<Diagnostico>)nq.getResultList();
            if(diagnostico == null){
                return null;
            }else{
                return diagnostico;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
    public List<Diagnostico> findByIdPaciente(Long id) {
        try{
            Query nq = getEntityManager().createNamedQuery("Diagnostico.findByIdPaciente");
            nq.setParameter("idPaciente", id);

            List<Diagnostico> diagnostico = (List<Diagnostico>)nq.getResultList();
            if(diagnostico == null){
                return null;
            }else{
                return diagnostico;
            }
        }catch (Exception ex){
            return null;
        }
    }
    
}
