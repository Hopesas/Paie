/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.Escala;
import java.util.ArrayList;
import java.util.List;
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
@ManagedBean(name="EscalaBean")
@ViewScoped
public class EscalaBean {
    private List<Escala> escalaList;
    private Escala selectedEscala;
    
    public EscalaBean(){
        escalaList = new ArrayList<>();
        escalaList.add(new Escala(1, "Riesgo Extremo, Calificación Mayor a 11 Puntos"));
        escalaList.add(new Escala(2, "Riesgo Alto, Calificación Entre  6 y 10 puntos"));
        escalaList.add(new Escala(3, "Riesgo Medio, Calificación Entre  3 y 5 puntos"));
        escalaList.add(new Escala(4, "Riesgo Bajo, Calificación Entre  0 y 2 puntos"));
    }

    public Escala getSelectedEscala() {
        return selectedEscala;
    }

    public void setSelectedEscala(Escala selectedEscala) {
        if(selectedEscala != null){
            this.selectedEscala = selectedEscala;
        }
    }
    
    public List<Escala> getEscalaList() {
        return escalaList;
    }

    public void setEscalaList(List<Escala> escalaList) {
        this.escalaList = escalaList;
    }
    
    public void onRowSelect(SelectEvent event){
        selectedEscala = ((Escala) event.getObject());
    }
    
    public String continueFinalStep(){
        if(selectedEscala == null){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }else{
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("escala", selectedEscala);
            return "finalStep.xhtml?faces-redirect=true";
        }
    }
    
    public String backStepSeven(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("paso7");
        return "step7.xhtml?faces-redirect=true";
    }
}
