/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.Useras;
import SessionBeans.UserasFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;
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
@ManagedBean(name="UserAsBean")
@ViewScoped
public class UserAsBean implements Serializable{
    @EJB
    private UserasFacadeLocal userasFacade;
    private Useras selectedUsera;
    private Vector userasList;
    private String newPassword;
    private String newPassword2;
    private Useras newUsera;
    private boolean carga;
    
    public UserAsBean(){
        carga = false;
        userasList = new Vector();
        selectedUsera = new Useras();
        newUsera = new Useras();
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    public Useras getNewUsera() {
        return newUsera;
    }

    public void setNewUsera(Useras newUsera) {
        System.err.println("Será que no entra??");
        if(newUsera != null){
            System.err.println("Será que entra??");
            this.newUsera = newUsera;
        }
    }
    
    public Vector getUserasList() {
        if(!carga){
            carga = true;
            userasList = (Vector) userasFacade.findAll();
        }
        return userasList;
    }
    
    public Useras getSelectedUsera() {
        return selectedUsera;
    }

    public void setSelectedUsera(Useras selectedUsera) {
        if(selectedUsera != null){
            this.selectedUsera = selectedUsera;
        }
    }
 
    public void onRowSelect(SelectEvent event){
        selectedUsera = userasFacade.findByName(((Useras) event.getObject()).getUsername());
        System.err.println(selectedUsera == null);
    }
    
    public void showDialog(){
        RequestContext.getCurrentInstance().execute("PF('createDialog').show()");
    }
    
    public void showEditDialog(){
        if(selectedUsera.getNombre() == null){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
        }else{
            RequestContext.getCurrentInstance().execute("PF('modifyDialog').show()");
        }
    }
    
    public void showDeleteDialog(){
        if(selectedUsera.getNombre() == null){
            RequestContext.getCurrentInstance().execute("PF('errorDialog').show()");
        }else{
            RequestContext.getCurrentInstance().execute("PF('deleteDialog').show()");
        }
    }
    
    public String hasRights() throws IOException{
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(!(boolean)session.getAttribute("administrator")){
            FacesContext.getCurrentInstance().getExternalContext().redirect("errorAdminPage.xhtml");
        }
        return "";
    }
    public String createUseras(){
        try{
            userasFacade.create(newUsera);
        } catch (Exception ex) {
            System.err.println("No se puede crear el usuario");
        }
        return "administrarusuarios.xhtml?faces-redirect=true";
    }
        
    public void changePassword(){
        if(newPassword!= null && newPassword2 != null){
            if(newPassword.length() > 5 && newPassword.length() < 15 && newPassword.equals(newPassword2)){
                HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                Useras currentUser = userasFacade.find(session.getAttribute("id"));
                currentUser.setPassword(newPassword);
                userasFacade.edit(currentUser);
                System.err.println("Se cambió la contraseña");
            } else {
                System.err.println("No se puede cambiar la contraseña");
            }
        } else {
        System.err.println("Por favor escriba una contraseña");
        }
    }
    
    public void editUseras(){
        if(newPassword!= null && newPassword2 != null){
            if(newPassword.length() > 5 && newPassword.length() < 15 && newPassword.equals(newPassword2)){
                selectedUsera.setPassword(newPassword);
                userasFacade.edit(selectedUsera);
                System.err.println("Se cambió la contraseña");
            }else{
                System.err.println("No se puede cambiar la contraseña");
            }
        }else {
            System.err.println("Por favor escriba una contraseña");
        }
        RequestContext.getCurrentInstance().execute("PF('modifyDialog').hide()");
    }
    
    public void deleteUseras(){
        try {
            userasFacade.remove(selectedUsera);
        } catch (Exception e) {
            System.err.println("No se puede acceder a la base de datos");
        }
        RequestContext.getCurrentInstance().execute("PF('deleteDialog').hide()");
    }
}