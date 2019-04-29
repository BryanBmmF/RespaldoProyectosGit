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
public class InstruccionHideTurtle extends Instruccion{

    public InstruccionHideTurtle(String token) {
        super(token);
    }
    

    @Override
    public void ejecutar(PanelGrafico panel) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        panel.setTortuga(false);
        panel.agregarLinea(panel.getActualX(), panel.getActualY(), panel.getActualX(), panel.getActualY());
        panel.repaint();
    }
    
}
