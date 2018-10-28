/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.Indicadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freddy
 */
public class Trio implements Serializable{
    private long nocId;
    private int currentValue;
    private int targetValue;
    private String resultado;
    private List<Indicadores> indicadores;
    private String escala;
    
    Trio(long nocId, int currentValue, int targetValue){
        this.nocId = nocId;
        this.currentValue = currentValue;
        this.targetValue = targetValue;
        indicadores = new ArrayList<>();
    }

    public long getNocId() {
        return nocId;
    }

    public void setNocId(long nocId) {
        this.nocId = nocId;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }
    
    public boolean valid(){
        return (targetValue != 0 && currentValue != 0);
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<Indicadores> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicadores> indicadores) {
        this.indicadores = indicadores;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }
    
}
