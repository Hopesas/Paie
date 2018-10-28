/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entity.Indicadores;

/**
 *
 * @author Freddy
 */
public class IndicadorValor {
    private Indicadores indicador;
    private String noc;
    private int value;
    
    public IndicadorValor(Indicadores indicador, String noc, int value){
        this.indicador = indicador;
        this.noc = noc;
        this.value = value;
    }

    public Indicadores getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicadores indicador) {
        this.indicador = indicador;
    }

    public String getNoc() {
        return noc;
    }

    public void setNoc(String noc) {
        this.noc = noc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
