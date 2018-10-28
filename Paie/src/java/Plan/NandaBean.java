/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.Nanda;
import SessionBeans.InterrelacionesFacade;
import SessionBeans.NandaFacade;
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

/**
 *
 * @author Freddy
 */
@ManagedBean(name="NandaBean")
@ViewScoped
public class NandaBean {
    @EJB
    private InterrelacionesFacade interrelacionesFacade;
    @EJB
    private NandaFacade nandaFacade;
    private List<Nanda> nandaList;
    private Nanda selectedNanda;
    private boolean carga;
    
    public NandaBean(){
        carga = false;
        nandaList = new ArrayList<>();
        selectedNanda = new Nanda();
    }

    public List<Nanda> getNandaList() {
        if(!carga){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            List<Nanda> nandaL = nandaFacade.findByPattern((BigDecimal)session.getAttribute("paso1"));
            for(Nanda n : nandaL){
                if(!interrelacionesFacade.findByNanda(n.getId()).isEmpty()){
                    nandaList.add(n);
                }
            }
            carga = true;
        }
        return nandaList;
    }

    public Nanda getSelectedNanda() {
        return selectedNanda;
    }

    public void setSelectedNanda(Nanda selectedNanda) {
        if(selectedNanda != null){
            this.selectedNanda = selectedNanda;
        }
    }
    
    public void onRowSelect(SelectEvent event){
        selectedNanda = nandaFacade.find(((Nanda) event.getObject()).getId());
    }
    
    public String continueStepTwo(){
        if(selectedNanda.getId()==null){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }else{
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("paso2", selectedNanda.getId());
            System.out.println();
            return "step3.xhtml?faces-redirect=true";
        }
    }
    
    
    public String backStepOne(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("paso1");
        return "step1.xhtml?faces-redirect=true";
    }
}

