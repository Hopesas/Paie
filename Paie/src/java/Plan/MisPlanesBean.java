/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.DiagnosticoMP;
import Entity.Diagnostico;
import Entity.Paciente;
import SessionBeans.DiagnosticoFacade;
import SessionBeans.PacienteFacade;
import SessionBeans.ServicesBean;
import SessionBeans.UserasFacadeLocal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Freddy
 */
@ManagedBean(name="MisPlanesBean")
@ViewScoped
public class MisPlanesBean {
    @EJB private PacienteFacade pacienteFacade;
    @EJB private DiagnosticoFacade diagnosticoFacade;
    @EJB private UserasFacadeLocal userasFacade;
    @EJB private ServicesBean servicesBean;
    private List<DiagnosticoMP> diagnosticosMPList;
    private List<Diagnostico> diagnosticosList;
    private boolean carga;
    private DiagnosticoMP selectedDiagnosticoMP;
    
    public MisPlanesBean(){
        carga = false;
        selectedDiagnosticoMP = new DiagnosticoMP();
        diagnosticosMPList = new ArrayList<>();
        diagnosticosList = new ArrayList<>();
    }

    public void setDiagnosticosMPList(List<DiagnosticoMP> diagnosticosMPList) {
        this.diagnosticosMPList = diagnosticosMPList;
    }
    
    public List<DiagnosticoMP> getDiagnosticosMPList() {
        if(!carga){
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            String idEnfermero = session.getAttribute("usuario").toString();
            diagnosticosList = diagnosticoFacade.findByIdEnfermero(idEnfermero);
            for(Diagnostico d: diagnosticosList){
                DiagnosticoMP dmp = new DiagnosticoMP();
                Paciente paciente = servicesBean.buscarPaciente(d.getIdPaciente());
                BigInteger docpaciente = paciente.getDocumento();
                String nombre = paciente.getNombre() + " " + paciente.getSegundoNombre() + " " + paciente.getApellido()
                        + " " + paciente.getSegundoApellido();
                dmp.setDocumentoPaciente(docpaciente);
                dmp.setNombre(nombre);
                
                Date fecha = d.getFecha();
                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                String fechaStr = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
                
                
                dmp.setFecha(fechaStr);
                dmp.setId(d.getId());
                 
                diagnosticosMPList.add(dmp);
            }
            carga = true;
        }
        return diagnosticosMPList;
    }    

    public DiagnosticoMP getSelectedDiagnosticoMP() {
        return selectedDiagnosticoMP;
    }

    public void onRowSelect(SelectEvent event){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("diagnostico", ((DiagnosticoMP)event.getObject()).getId());
    }
    
    public void setSelectedDiagnosticoMP(DiagnosticoMP selectedDiagnosticoMP) {
        if(selectedDiagnosticoMP != null){
            this.selectedDiagnosticoMP = selectedDiagnosticoMP;
        }
    }
}
