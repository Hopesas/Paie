/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.CaracteristicasDefinitorias;
import Entity.FactoresRelacionado;
import SessionBeans.CaracteristicasDefinitoriasFacade;
import SessionBeans.FactoresRelacionadoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Freddy
 */
@ManagedBean(name="FeatureFactorBean")
@ViewScoped
public class FeatureFactorBean {
    @EJB
    private CaracteristicasDefinitoriasFacade caracteristicasDefinitoriasFacade;
    @EJB
    private FactoresRelacionadoFacade factoresRelacionadoFacade;
    private List<CaracteristicasDefinitorias> caracteristicasList;
    private List<FactoresRelacionado> factoresList;
    private List<CaracteristicasDefinitorias> selectedCaracteristicas;
    private List<Long> caracteristicasIndex;
    private List<Long> factoresIndex;
    private List<FactoresRelacionado> selectedFactores;
    private boolean cargaFactores;
    private boolean cargaCaracteristicas;
    
    public FeatureFactorBean() {
        System.err.println("Yey");
        cargaFactores = false;
        caracteristicasList = new ArrayList<>();
        caracteristicasIndex = new ArrayList<>();
        factoresIndex = new ArrayList<>();
        factoresList = new ArrayList<>();
        selectedFactores = new ArrayList<>();
        selectedCaracteristicas = new ArrayList<>();
    }

    public List<CaracteristicasDefinitorias> getSelectedCaracteristicas() {
        return selectedCaracteristicas;
    }

    public void setSelectedCaracteristicas(List<CaracteristicasDefinitorias> selectedCaracteristicas) {
        this.selectedCaracteristicas = selectedCaracteristicas;
    }

    public List<FactoresRelacionado> getSelectedFactores() {
        return selectedFactores;
    }

    public void setSelectedFactores(List<FactoresRelacionado> selectedFactores) {
        this.selectedFactores = selectedFactores;
    }

    public List<CaracteristicasDefinitorias> getCaracteristicasList() {
        if(!cargaCaracteristicas){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            caracteristicasList = caracteristicasDefinitoriasFacade.findByNanda((BigDecimal)session.getAttribute("paso2"));
            cargaCaracteristicas = true;
        }
        return caracteristicasList;
    }

    public List<FactoresRelacionado> getFactoresList() {
        if(!cargaFactores) {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            factoresList = factoresRelacionadoFacade.findByNanda((BigDecimal)session.getAttribute("paso2"));
            cargaFactores = true;
        }
        return factoresList;
    }
    
    public void onRowSelectFactorsOut(SelectEvent event) {
        factoresIndex = new ArrayList<>();
        factoresIndex.add(((FactoresRelacionado) event.getObject()).getId());
    }
    
    public void onRowSelectFactores(SelectEvent event){
        factoresIndex.add(((FactoresRelacionado) event.getObject()).getId());
    }
    
    public void onRowUnselectFactores(UnselectEvent event){
        factoresIndex.remove(((FactoresRelacionado) event.getObject()).getId());
    }
    
    public void onRowSelectCaracteristicasOut(SelectEvent event) {
        caracteristicasIndex = new ArrayList<>();
        caracteristicasIndex.add(((CaracteristicasDefinitorias) event.getObject()).getId());
    }
    
    public void onRowSelectCaracteristicas(SelectEvent event){
        caracteristicasIndex.add(((CaracteristicasDefinitorias) event.getObject()).getId());
    }
    
    public void onRowUnselectCaracteristicas(UnselectEvent event){
        caracteristicasIndex.remove(((CaracteristicasDefinitorias) event.getObject()).getId());
    }
    
    public String continueStepThree(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("paso3Feature", caracteristicasIndex);
        session.setAttribute("paso3Factor", factoresIndex);
        System.out.println();
        return "step4.xhtml?faces-redirect=true";
    }
    
    public String backStepTwo(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("paso2");
        return "step2.xhtml?faces-redirect=true";
    }
}
