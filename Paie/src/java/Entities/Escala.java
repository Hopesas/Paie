/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Freddy
 */
public class Escala {
    private int id;
    private String escala;
    
    public Escala(int id, String escala){
        this.id = id;
        this.escala = escala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }
    
}
