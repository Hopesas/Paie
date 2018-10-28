/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entity.Actividades;
import Entity.Nic;

/**
 *
 * @author Freddy
 */
public class ActividadesNic {
    private Actividades actividad;
    private Nic nic;
    private String intervencion;
    
    public ActividadesNic (Actividades actividad, String intervencion, Nic nic) {
        this.actividad = actividad;
        this.intervencion = intervencion;
        this.nic = nic;
    }

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    public String getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(String intervencion) {
        this.intervencion = intervencion;
    }

    public Nic getNic() {
        return nic;
    }

    public void setNic(Nic nic) {
        this.nic = nic;
    }
    
}
