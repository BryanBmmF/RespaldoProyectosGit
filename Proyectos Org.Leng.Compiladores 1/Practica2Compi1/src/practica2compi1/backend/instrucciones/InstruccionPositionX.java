/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2compi1.backend.instrucciones;

import practica2compi1.frontend.PanelGrafico;

/**
 *
 * @author bryan
 */
public class InstruccionPositionX extends Instruccion{
    private Integer x;

    public InstruccionPositionX(Integer x, String token) {
        super(token);
        this.x = x;
    }

    
    

    @Override
    public void ejecutar(PanelGrafico panel) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        panel.agregarLinea(x, panel.getActualY(), x, panel.getActualY());
        panel.setActualX(x);
        panel.repaint();
    }
    
}
