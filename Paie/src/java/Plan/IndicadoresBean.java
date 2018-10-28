/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.IndicadorValor;
import Entity.Indicadores;
import SessionBeans.IndicadoresFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Freddy
 */
@ManagedBean(name="IndicadoresBean")
@ViewScoped
public class IndicadoresBean {
    @EJB
    private IndicadoresFacade indicadoresFacade;
    private List<Trio> paso4;
    private List<IndicadorValor> indicadoresList;
    private boolean carga;
    private List listMenu;
    private List<IndicadorValor> paso5;
    public IndicadoresBean(){
        carga = false;
        indicadoresList = new ArrayList<>();
        paso5 = new ArrayList<>();
        paso4 = new ArrayList<>();
        listMenu = new ArrayList();
        listMenu.add(new Integer(1));
        listMenu.add(new Integer(2));
        listMenu.add(new Integer(3));
        listMenu.add(new Integer(4));
        listMenu.add(new Integer(5));
    }

    
    
    public List<IndicadorValor> getIndicadoresList() {
         if (!carga) {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            paso4 = (List<Trio>) session.getAttribute("paso4");
            int i = 0;
            for(Trio t : paso4){
                for(Indicadores ind : indicadoresFacade.findByNoc(t.getNocId())){
                    indicadoresList.add(new IndicadorValor(ind, t.getResultado(), 0));
                }
            }
            carga = true;
        }
        return indicadoresList;
    }

    public List getListMenu() {
        return listMenu;
    }

    public void setListMenu(List listMenu) {
        this.listMenu = listMenu;
    }
    
    public void selectionListener(UIComponent component, Object value){
        String arg[];
        try{
            arg = component.getClientId().split(":");
            indicadoresList.get(new Integer(arg[1])).setValue(new Integer((String)component.getAttributes().get("value")));
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.println("0");
        }
    }
        
    public String continueStepFive(){
        for(IndicadorValor iv : indicadoresList){
            if(iv.getValue() != 0){
                paso5.add(iv);
            }
        }
        if(paso5.isEmpty()){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }else{
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("paso5", paso5);
            return "step6.xhtml?faces-redirect=true";
        }
    }
    
    
    public String backStepFour(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("paso4");
        return "step4.xhtml?faces-redirect=true";
    }
    
}
