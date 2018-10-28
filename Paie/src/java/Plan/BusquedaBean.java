/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.Busqueda;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Freddy
 */
@ManagedBean(name="BusquedaBean")
@ViewScoped
public class BusquedaBean {
    private List<Busqueda> busquedaList;
    private Busqueda selectedCriterio;
    private String campo;
    
    public BusquedaBean(){
        selectedCriterio = new Busqueda(new Long(0), "No se ha seleccionado el criterio", "Seleccione");
        busquedaList = new ArrayList<>();
        busquedaList.add(new Busqueda(new Long(1), "Buscar por ID de Patrón", "Patrón"));
        busquedaList.add(new Busqueda(new Long(2), "Buscar por Documento de Paciente", "Documento del Paciente"));
        busquedaList.add(new Busqueda(new Long(3), "Buscar por Documento de Usuario", "Documento del Usuario"));
    }

    public Busqueda getSelectedCriterio() {
        return selectedCriterio;
    }

    public void setSelectedCriterio(Busqueda selectedCriterio) {
        if(selectedCriterio != null){
            this.selectedCriterio = selectedCriterio;
        }
    }

    public List<Busqueda> getBusquedaList() {
        return busquedaList;
    }

    public void setBusquedaList(List<Busqueda> busquedaList) {
        this.busquedaList = busquedaList;
    }
    
    public void onRowSelect(SelectEvent event){
        selectedCriterio = ((Busqueda) event.getObject());
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        if(campo != null){
            this.campo = campo;
        }
    }
    
    public String buscarDiagnosticos(){
        if(campo != null){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("campo", campo);
            System.out.println();
            return "listaPAIE.xhtml?faces-redirect=true";
        }else{
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }
    }
    
    public String continueToList(){
        if(selectedCriterio.getId()==null){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
            return "";
        }else{
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("criterio", selectedCriterio);
            System.out.println();
            return "campoPAIE.xhtml?faces-redirect=true";
        }
    }
}
