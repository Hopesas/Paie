/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.Interrelaciones;
import Entity.Noc;
import SessionBeans.InterrelacionesFacade;
import SessionBeans.NocFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Freddy
 */
@ManagedBean(name="NOCBean")
@ViewScoped
public class NOCBean implements Serializable{
    @EJB
    private InterrelacionesFacade interrelacionesFacade;
    @EJB
    private NocFacade nocFacade;
    private List<Interrelaciones> interList;
    private List<Trio> trios;
    private List<NOCValores> nocList;
    private boolean carga;
    private boolean valores;
    private Noc selectedNoc;
    private List listMenu;
    private int i;
    
    public NOCBean() {
        trios = new ArrayList<>();
        nocList = new ArrayList<>();
        valores = false;
        carga = false;
        selectedNoc = new Noc();
        interList = new ArrayList<>();
        listMenu = new ArrayList();
        listMenu.add(new Integer(1));
        listMenu.add(new Integer(2));
        listMenu.add(new Integer(3));
        listMenu.add(new Integer(4));
        listMenu.add(new Integer(5));
    }

    public List getListMenu() {
        return listMenu;
    }

    public void setListMenu(List listMenu) {
        this.listMenu = listMenu;
    }
    
    public Noc getSelectedNoc() {
        return selectedNoc;
    }

    public void setSelectedNoc(Noc selectedNoc) {
        if(selectedNoc != null) {
            this.selectedNoc = selectedNoc;
        }
    }
    
    public List<NOCValores> getNocList() {
        if (!carga) {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            interList = interrelacionesFacade.findByNanda((BigDecimal)session.getAttribute("paso2"));
            
            
            nocList.add(new NOCValores(nocFacade.findByCodigo(interList.get(0).getCodigoNoc())));
            for(Interrelaciones u : interList){
                if(nocFacade.findByCodigo(u.getCodigoNoc()).getCodigo() != nocList.get(nocList.size() - 1).getCodigo()){
                    nocList.add(new NOCValores(nocFacade.findByCodigo(u.getCodigoNoc())));
                }
            }
            carga = true;
        }
        return nocList;
    }
    
    public String getIdSelectOne(UIComponent component){
        i++;
        component.setId("valorActual"+i);
        return "valorActual"+i;
    }
       
    public String continueStepFour(){
        for(NOCValores nv : nocList){
            if(nv.getValorActual() != 0 && nv.getValorDiana() != 0){
                Trio t = new Trio(nv.getId(), nv.getValorActual(), nv.getValorDiana());
                t.setResultado(nv.getResultado());
                trios.add(t);
                valores = true;
            }
        }
        
        if(valores){
            List<Trio> paso4 = new ArrayList<>();
            for(Trio t : trios){
                if(t.valid()){
                    paso4.add(t);
                }
            }
            if(paso4.isEmpty()){
                RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
                return "";
            }else{
                HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("paso4", paso4);
                return "step5.xhtml?faces-redirect=true";
            }
        }else{
            return "";
        }
    }
    
    
    public String backStepThree(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("paso3");
        return "step3.xhtml?faces-redirect=true";
    }
    
}
