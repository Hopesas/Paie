/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Freddy
 */
@ManagedBean(name="LogoutBean")
@SessionScoped
public class LogoutBean implements Serializable{
    
    public String logout(HttpServletRequest request){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "login.xhtml?faces-redirect=true";
    }
    
    public String displayName(HttpServletRequest request) throws IOException {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session.getAttribute("nombre") == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            return "";
        } else {
            return (String)session.getAttribute("nombre") + " " + (String)session.getAttribute("apellido");
        }
    }
    
    public String isSessionActive(HttpServletRequest request) throws IOException{
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session.getAttribute("nombre") == null){
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
        return (String)session.getAttribute("nombre") + " " + (String)session.getAttribute("apellido");
    }
    
    public boolean isAdministrator(HttpServletRequest request){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session.getAttribute("nombre") == null){
            try {
                session.invalidate();
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LogoutBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (boolean)session.getAttribute("administrator");
    }
}
