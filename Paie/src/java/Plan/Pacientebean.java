/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.Paciente;
import SessionBeans.PacienteFacade;
import SessionBeans.ServicesBean;
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Freddy
 */
@ManagedBean(name="PacienteBean")
@ViewScoped
public class Pacientebean {

    @EJB
    private ServicesBean servicesBean;
    
    @EJB
    private PacienteFacade pacienteFacade;
    private Paciente paciente;
    private BigInteger documento;
    
    public Pacientebean(){
        paciente = new Paciente();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        if(paciente != null){
            this.paciente = paciente;
        }
    }

    public BigInteger getDocumento() {
        return documento;
    }

    public void setDocumento(BigInteger documento) {
        this.documento = documento;
    }
    
    public void buscarPaciente(){
        paciente = servicesBean.buscarPaciente(documento.toString());
                //pacienteFacade.findByDocumento(documento);
        if(paciente.getDocumento()== null){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
        }else{
            FacesContext.getCurrentInstance().addMessage("pacienteMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Se ha seleccionado el paciente: " + paciente.getNombre() + " " + paciente.getApellido() ,  
                    "Sample message"));
            RequestContext.getCurrentInstance().update("pacienteMessage");
        }
    }
    
    public void createPaciente(){
        Paciente p = pacienteFacade.findByDocumento(documento);
        System.err.println(p==null);
        if(p == null){
            pacienteFacade.create(paciente);
            paciente = pacienteFacade.findByDocumento(paciente.getDocumento());
            if(paciente != null){
                FacesContext.getCurrentInstance().addMessage("pacienteMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, 
                        "Se ha creado el paciente." ,  
                        "Sample message"));
                RequestContext.getCurrentInstance().update("pacienteMessage");
            }else {
                FacesContext.getCurrentInstance().addMessage("pacienteMessage", new FacesMessage(FacesMessage.SEVERITY_FATAL, 
                        "No se pudo crear el paciente." ,  
                        "Sample message"));
                RequestContext.getCurrentInstance().update("pacienteMessage");
            }
            paciente = null;
            documento = null;
        }else{
                FacesContext.getCurrentInstance().addMessage("pacienteMessage", new FacesMessage(FacesMessage.SEVERITY_FATAL, 
                        "El paciente ya existe." ,  
                        "Sample message"));
                RequestContext.getCurrentInstance().update("pacienteMessage");
            
        }
    }
    
    public String goStepOne(){
        if(paciente.getDocumento() == null){
            RequestContext.getCurrentInstance().execute("PF('errorSelDialog').show()");
            return "";
        }else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("paciente", paciente);
            return "step1.xhtml?faces-redirect=true";
        }
    }
}
