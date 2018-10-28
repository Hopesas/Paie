/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.Useras;
import SessionBeans.ParametrosFacade;
import SessionBeans.ServicesBean;
import SessionBeans.UserasFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Freddy
 */

@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean implements Serializable{

    @EJB
    private ServicesBean servicesBean;

    @EJB
    private UserasFacadeLocal userasFacade;
    
    
    private String userName;
    private String password;
    
    public String getNombre() { return userName; }
    public void setNombre(String nuevoValor) { userName = nuevoValor; }
    // ATRIBUTO: password
    
    public String getPassword() { return password; }
    public void setPassword(String nuevoValor) { password = nuevoValor; }  
    
    public String login(HttpServletRequest request) throws IOException{
        boolean accesoExitoso = servicesBean.loguearUsuarioMonserrat(userName, Crypt.cryptWithMD5(password));
        
        if(accesoExitoso){
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("nombre", userName);
            session.setAttribute("usuario", userName);
            session.setAttribute("apellido", "");
            session.setAttribute("documento", "");
            session.setAttribute("administrator", false);
            return "home.xhtml?faces-redirect=true";
        }
        
        password = "";
        FacesContext.getCurrentInstance().addMessage("loginMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Error de usuario y contraseña, por favor intente de nuevo o contacte a su administrador",  
                "Sample error message"));
        RequestContext.getCurrentInstance().update("loginMessage");
        return "";
    }
}