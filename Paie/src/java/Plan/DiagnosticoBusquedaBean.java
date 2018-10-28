/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.Busqueda;
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
@ManagedBean(name="DiagnosticoBusquedaBean")
@ViewScoped
public class DiagnosticoBusquedaBean {
    @EJB private ServicesBean servicesBean;
    @EJB private PacienteFacade pacienteFacade;
    @EJB private DiagnosticoFacade diagnosticoFacade;
    @EJB private UserasFacadeLocal userasFacade;
    private List<DiagnosticoMP> diagnosticosMPList;
    private List<Diagnostico> diagnosticosList;
    private boolean carga;
    private DiagnosticoMP selectedDiagnosticoMP;
    
    public DiagnosticoBusquedaBean(){
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
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            if(((Busqueda)session.getAttribute("criterio")).getId() == 1){
                diagnosticosList = diagnosticoFacade.findByPatron(Long.valueOf((String)session.getAttribute("campo")));
                System.err.println(diagnosticosList == null);
            }
            if(((Busqueda)session.getAttribute("criterio")).getId() == 2){
                Long id = pacienteFacade.findByDocumento(new BigInteger((String)session.getAttribute("campo"))).getId();
                System.err.println(id);
                diagnosticosList = diagnosticoFacade.findByIdPaciente(id);
            }
            if(((Busqueda)session.getAttribute("criterio")).getId() == 3){
                String id = ((String)session.getAttribute("campo").toString());
                diagnosticosList = diagnosticoFacade.findByIdEnfermero(id);
            }
            if(diagnosticosList != null){
                System.err.println(diagnosticosList.size());
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
