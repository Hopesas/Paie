/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.PatronFuncional;
import SessionBeans.PatronFuncionalFacadeLocal;
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


@ManagedBean(name="PatternsBean")
@ViewScoped
public class PatternsBean {
    @EJB
    private PatronFuncionalFacadeLocal patronFuncionalFacade;
    private List<PatronFuncional> patronList;
    private PatronFuncional selectedPattern;
    private boolean carga;
    
    public PatternsBean(){
        carga = false;
        patronList = new ArrayList<>();
        selectedPattern = new PatronFuncional();
    }

    public List<PatronFuncional> getPatronList() {
        if(!carga){
            carga = true;
            patronList = patronFuncionalFacade.findAll();
        }
        return patronList;
    }

    public PatronFuncional getSelectedPattern() {
        return selectedPattern;
    }

    public void setSelectedPattern(PatronFuncional selectedPattern) {
        if(selectedPattern != null){
            this.selectedPattern = selectedPattern;
        }
    }
    
    public void onRowSelect(SelectEvent event){
        selectedPattern = patronFuncionalFacade.find(((PatronFuncional) event.getObject()).getId());
        System.err.println(selectedPattern == null);
    }
    
    public String continueStepOne(){
        if(selectedPattern.getId()==null){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }else{
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("paso1", selectedPattern.getId());
            System.out.println();
            return "step2.xhtml?faces-redirect=true";
        }
    }
}
