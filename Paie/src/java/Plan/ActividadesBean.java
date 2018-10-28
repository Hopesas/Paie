/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.ActividadesNic;
import Entities.NicTipo;
import Entity.Actividades;
import SessionBeans.ActividadesFacade;
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
@ManagedBean(name = "ActividadesBean")
@ViewScoped
public class ActividadesBean {
    @EJB
    private ActividadesFacade actividadesFacade;
    private List<ActividadesNic> actividadesNic;
    private List<ActividadesNic> indexActividades;
    private List<Actividades> selectedActividades;
    private boolean carga;
    public ActividadesBean(){
        carga = false;
        indexActividades = new ArrayList<>();
        selectedActividades = new ArrayList<>();
        actividadesNic = new ArrayList<>();
    }

    public List<Actividades> getSelectedActividades() {
        return selectedActividades;
    }

    public void setSelectedActividades(List<Actividades> selectedActividades) {
        this.selectedActividades = selectedActividades;
    }
    
    public List<ActividadesNic> getActividadesNic() {
        if(!carga){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            for(NicTipo nc : (List<NicTipo>)session.getAttribute("paso6")){
                for(Actividades ac : actividadesFacade.findByNic(nc.getNic().getCodigo())){
                    actividadesNic.add(new ActividadesNic(ac, nc.getResultado(), nc.getNic()));
                }
            }
            carga = true;
        }
        return actividadesNic;
    }
    
    
    public void onRowSelectNicsOut(SelectEvent event) {
        indexActividades = new ArrayList<>();
        ActividadesNic an = (ActividadesNic)event.getObject();
        indexActividades.add(an);
    }
    
    public void onRowSelectNics(SelectEvent event){
        indexActividades.add((ActividadesNic)event.getObject());
        System.err.println(((ActividadesNic)event.getObject()).getIntervencion());
    }
    
    public void onRowUnselectNics(UnselectEvent event){
        indexActividades.remove((ActividadesNic) event.getObject());
    }
    
    public String continueEscalaStep(){
        if(!indexActividades.isEmpty() || actividadesNic.isEmpty()){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("paso7", indexActividades);
            return "escala.xhtml?faces-redirect=true";
        }else{
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }
    }
    
    public String backStepSix(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("paso6");
        return "step6.xhtml?faces-redirect=true";
    }
}
