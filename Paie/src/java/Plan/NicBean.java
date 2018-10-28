/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.NicTipo;
import Entity.Interrelaciones;
import Entity.Nic;
import SessionBeans.InterrelacionesFacade;
import SessionBeans.NicFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Freddy
 */
@ManagedBean(name = "NicBean")
@ViewScoped
public class NicBean {
    @EJB
    private NicFacade nicFacade;
    @EJB
    private InterrelacionesFacade interrelacionesFacade;
    public List<NicTipo> nicList;
    public List<Nic> selectedNics;
    public List<NicTipo> nicsIndex;
    private boolean carga;
    
    public NicBean() {
        carga = false;
        nicsIndex = new ArrayList<>();
        selectedNics = new ArrayList<>();
        nicList = new ArrayList<>();
    }

    public List<Nic> getSelectedNics() {
        return selectedNics;
    }

    public void setSelectedNics(List<Nic> selectedNics) {
        if(selectedNics != null){
            this.selectedNics = selectedNics;
        }
    }

    
    public List<NicTipo> getNicList() {
        if (!carga) {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            long nanda = ((BigDecimal)session.getAttribute("paso2")).longValue();
            int end = 0;
            int opcional = 0;
            int sugerida = 0;
            int index = 0;
            int antiguoNoc = 0;
            for(Trio t : (List<Trio>)session.getAttribute("paso4")){
                List<Interrelaciones> aux = interrelacionesFacade.findByNoc(t.getNocId());
                antiguoNoc = end;
                sugerida = end;
                opcional = end;
                for(Interrelaciones inter : aux){
                    if (inter.getCodigoNanda() == nanda){
                        if(inter.getOrden() == 1){
                            index = 0 + antiguoNoc;
                            sugerida++;
                            opcional++;
                        }
                        if(inter.getOrden() == 2){
                            index = sugerida;
                            opcional++;
                        }
                        if(inter.getOrden() == 3){
                            index = end;
                        }
                        nicList.add(index, new NicTipo((inter.getCodigoNanda() + inter.getCodigoNoc() + inter.getCodigoNic() + ""), nicFacade.findByCodigo(inter.getCodigoNic()), t.getResultado(), inter.getTipo(), inter.getOrden(), inter.getCodigoNoc()));
                        end++;
                    }
                }
            }
            
            carga = true;
        }
        return nicList;
    }
    
    
    public void onRowSelectNicsOut(SelectEvent event) {
        nicsIndex = new ArrayList<>();
        NicTipo nt = (NicTipo)event.getObject();
        nicsIndex.add(nt);
    }
    
    public void onRowSelectNics(SelectEvent event){
        nicsIndex.add((NicTipo)event.getObject());
        System.err.println(((NicTipo)event.getObject()).getResultado());
    }
    
    public void onRowUnselectNics(UnselectEvent event){
        nicsIndex.remove((NicTipo) event.getObject());
    }
    
    
    public String continueStepSix(){
        if(nicsIndex.isEmpty()){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }else{
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("paso6", nicsIndex);
            return "step7.xhtml?faces-redirect=true";
        }
    }
    
    
    public String backStepFive(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("paso5");
        return "step5.xhtml?faces-redirect=true";
    }
}
