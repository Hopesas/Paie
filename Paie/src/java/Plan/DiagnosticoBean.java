/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entities.ActividadesNic;
import Entities.Escala;
import Entities.IndicadorValor;
import Entities.NicTipo;
import Entity.ActividadesDiagnostico;
import Entity.CaracteristicasDefinitorias;
import Entity.CaracteristicasDiagnostico;
import Entity.Diagnostico;
import Entity.FactoresDiagnostico;
import Entity.FactoresRelacionado;
import Entity.IndicadoresDiagnostico;
import Entity.Nanda;
import Entity.NicDiagnostico;
import Entity.Noc;
import Entity.NocDiagnostico;
import Entity.Paciente;
import Entity.PatronFuncional;
import SessionBeans.ActividadesDiagnosticoFacade;
import SessionBeans.CaracteristicasDefinitoriasFacade;
import SessionBeans.CaracteristicasDiagnosticoFacade;
import SessionBeans.DiagnosticoFacade;
import SessionBeans.FactoresDiagnosticoFacade;
import SessionBeans.FactoresRelacionadoFacade;
import SessionBeans.IndicadoresDiagnosticoFacade;
import SessionBeans.NandaFacade;
import SessionBeans.NicDiagnosticoFacade;
import SessionBeans.NocDiagnosticoFacade;
import SessionBeans.NocFacade;
import SessionBeans.PatronFuncionalFacadeLocal;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@ManagedBean(name="DiagnosticoBean")
@ViewScoped
public class DiagnosticoBean {
    @EJB private ActividadesDiagnosticoFacade actividadesDiagnosticoFacade;
    @EJB private NicDiagnosticoFacade nicDiagnosticoFacade;
    @EJB private IndicadoresDiagnosticoFacade indicadoresDiagnosticoFacade;
    @EJB private NocDiagnosticoFacade nocDiagnosticoFacade;
    @EJB private FactoresDiagnosticoFacade factoresDiagnosticoFacade;
    @EJB private CaracteristicasDiagnosticoFacade caracteristicasDiagnosticoFacade;
    @EJB private DiagnosticoFacade diagnosticoFacade;
    @EJB private NocFacade nocFacade;
    @EJB private CaracteristicasDefinitoriasFacade caracteristicasDefinitoriasFacade;
    @EJB private FactoresRelacionadoFacade factoresRelacionadoFacade;
    @EJB private PatronFuncionalFacadeLocal patronFuncionalFacade;
    @EJB private NandaFacade nandaFacade;   
    
    private Diagnostico diagnostico;
    private Long codigo;
    private boolean isDiagnostico;
    
    public DiagnosticoBean(){
        diagnostico = new Diagnostico();
        isDiagnostico = false;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("diagnostico", "-1");
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public boolean isIsDiagnostico() {
        return isDiagnostico;
    }
    
    public void createDiagnostico(){
    try{
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            Paciente paciente = (Paciente)session.getAttribute("paciente");
            PatronFuncional patron =  patronFuncionalFacade.findById((BigDecimal)session.getAttribute("paso1"));
            Nanda n = nandaFacade.find(session.getAttribute("paso2"));

            List<Long> features = (List<Long>) session.getAttribute("paso3Feature");
            List<Long> factors = (List<Long>) session.getAttribute("paso3Factor");
            List<Trio> nocList = (List<Trio>) session.getAttribute("paso4");
            List<IndicadorValor> indicadores = (List<IndicadorValor>)session.getAttribute("paso5");
            List<NicTipo> nics = (List<NicTipo>)session.getAttribute("paso6");
            List<ActividadesNic> actividades = (List<ActividadesNic>)session.getAttribute("paso7");
            
            
            List<CaracteristicasDiagnostico> caracteristicasListd = new ArrayList<>();
            List<FactoresDiagnostico> factoresListd = new ArrayList<>();
            List<ActividadesDiagnostico> actividadesListd = new ArrayList<>();
            List<IndicadoresDiagnostico> indicadoresListd = new ArrayList<>();
            List<NicDiagnostico> nicListd = new ArrayList<>();
            List<NocDiagnostico> nocListd = new ArrayList<>();
            
            
            diagnostico.setIdUseras(session.getAttribute("nombre").toString());
            diagnostico.setIdPaciente(paciente.getDocumento().toString());
            diagnostico.setIdPatron(patron.getId().longValue());
            diagnostico.setIdNanda(n.getId().longValue());
            diagnostico.setCaida(Long.valueOf(((Escala)session.getAttribute("escala")).getId()));
            diagnostico.setFecha(new Date());
            
            for(Long l : features){
                CaracteristicasDefinitorias cds = caracteristicasDefinitoriasFacade.find(l);
                CaracteristicasDiagnostico cd = new CaracteristicasDiagnostico();
                cd.setIdCaracteristica(cds);
                cd.setIdDiagnostico(diagnostico);
                caracteristicasListd.add(cd);
            }

            for(Long l : factors){
                FactoresRelacionado fds = factoresRelacionadoFacade.find(l);
                FactoresDiagnostico fd = new FactoresDiagnostico();
                fd.setIdDiagnostico(diagnostico);
                fd.setIdFactor(fds);
                factoresListd.add(fd);
            }

            for(Trio t : nocList){
                NocDiagnostico nds = new NocDiagnostico();
                Noc noc = nocFacade.findByCodigo(t.getNocId());
                nds.setIdNoc(noc);
                nds.setIdDiagnostico(diagnostico);
                nds.setValorActual(t.getCurrentValue());
                nds.setValorDiana(t.getTargetValue());
                nocListd.add(nds);
            }

            for(IndicadorValor iv : indicadores){
                IndicadoresDiagnostico ids = new IndicadoresDiagnostico();
                ids.setIdIndicador(iv.getIndicador());
                ids.setIdDiagnostico(diagnostico);
                ids.setValor(BigInteger.valueOf(iv.getValue()));
                indicadoresListd.add(ids);
            }

            for(NicTipo nt : nics){
                NicDiagnostico nds = new NicDiagnostico();
                nds.setIdNic(nt.getNic());
                nds.setIdDiagnostico(diagnostico);
                nds.setIdPatron(patron);
                nds.setIdNoc(nocFacade.findByCodigo(nt.getNocCodigo()));
                nicListd.add(nds);
            }

            for(ActividadesNic an : actividades){
                ActividadesDiagnostico ads = new ActividadesDiagnostico();
                ads.setIdDiagnostico(diagnostico);
                ads.setIdActividad(an.getActividad());
                ads.setIdNic(an.getNic());
                actividadesListd.add(ads);
            }
            
            diagnostico.setActividadesDiagnosticoCollection(actividadesListd);
            diagnostico.setCaracteristicasDiagnosticoCollection(caracteristicasListd);
            diagnostico.setFactoresDiagnosticoCollection(factoresListd);
            diagnostico.setIndicadoresDiagnosticoCollection(indicadoresListd);
            diagnostico.setNicDiagnosticoCollection(nicListd);
            diagnostico.setNocDiagnosticoCollection(nocListd);
            
            diagnosticoFacade.create(diagnostico);
            session.setAttribute("diagnostico", diagnostico.getId());
            isDiagnostico = true;
            RequestContext.getCurrentInstance().update("createPdflink");
            
        }catch (javax.persistence.RollbackException ex){
            System.err.println("Error");
        }
    }
    
    public void buscarDiagnostico(){
        Diagnostico d = diagnosticoFacade.find(codigo);
        if(d != null){
           HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
           session.setAttribute("diagnostico", d.getId());
            isDiagnostico = true;
            RequestContext.getCurrentInstance().update("createPdflink");
            FacesContext.getCurrentInstance().addMessage("diagnosticoMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Se encontró el diagnóstico." ,  
                    "Sample message"));
            RequestContext.getCurrentInstance().update("diagnosticoMessage");
        }else{
            FacesContext.getCurrentInstance().addMessage("diagnosticoMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "No se ha encontrado el diagnóstico." ,  
                    "Sample message"));
            RequestContext.getCurrentInstance().update("diagnosticoMessage");
        }
    }
    
    public void crearPdf() throws IOException{
        Diagnostico d = diagnosticoFacade.find(codigo);
        if(d != null){
           HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
           session.setAttribute("diagnostico", d.getId());
           FacesContext context = FacesContext.getCurrentInstance();  
           context.getExternalContext().dispatch("PdfDiagnostico");
        }else{
            FacesContext.getCurrentInstance().addMessage("diagnosticoMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "No se ha encontrado el diagnóstico." ,  
                    "Sample message"));
            RequestContext.getCurrentInstance().update("diagnosticoMessage");
        }
    }
}