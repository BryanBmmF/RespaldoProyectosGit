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
public class InstruccionPositionXY extends Instruccion{
    private Integer x;
    private Integer y;

    public InstruccionPositionXY(Integer x, Integer y, String token) {
        super(token);
        this.x = x;
        this.y = y;
    }
    
    
    @Override
    public void ejecutar(PanelGrafico panel) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        panel.agregarLinea(x, y, x, y);
        panel.setActualX(x);
        panel.setActualY(y);
        panel.repaint();
    }
    
}
