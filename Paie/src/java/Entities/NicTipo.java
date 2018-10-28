/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entity.Nic;
import Entity.Noc;
import java.io.Serializable;

/**
 *
 * @author Freddy
 */
public class NicTipo implements Serializable{
    private String id;
    private Long nocCodigo;
    private Nic nic;
    private String resultado;
    private String tipo;
    private Long orden;
    
    public NicTipo(String id, Nic nic, String resultado, String tipo, Long orden, Long noc){
        this.nic = nic;
        this.id = id;
        this.tipo = tipo;
        this.resultado = resultado;
        this.orden = orden;
        this.nocCodigo = noc;
    }

    public Nic getNic() {
        return nic;
    }

    public void setNic(Nic nic) {
        this.nic = nic;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }  

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getNocCodigo() {
        return nocCodigo;
    }

    public void setNocCodigo(Long nocCodigo) {
        this.nocCodigo = nocCodigo;
    }

}
