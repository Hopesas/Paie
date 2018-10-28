/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

import Entity.Noc;

/**
 *
 * @author Freddy
 */
public class NOCValores extends Noc{
    private int valorDiana;
    private int valorActual;

    public NOCValores(Noc n){
        super(n.getId(),n.getCodigo(), n.getResultado(), n.getDefinicion(), n.getDominio(), n.getClase(), n.getExtra());
        this.valorDiana = 0;
        this.valorActual = 0;
    }
    
    public int getValorDiana() {
        return valorDiana;
    }

    public void setValorDiana(int valorDiana) {
        this.valorDiana = valorDiana;
    }

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }
    
    
    
}
