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
public class InstruccionColor extends Instruccion{
    
    private Integer n;
    private String hexa;
    

    public InstruccionColor(Integer n, String token) {
        super(token);
        this.n = n;
    }

    public InstruccionColor(String hexa, String token) {
        super(token);
        this.hexa = hexa;
    }
    
    

    @Override
    public void ejecutar(PanelGrafico panel) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (n!=null) {
            panel.establecerColor(n);
        }
        if (hexa!=null) {
            panel.establecerColorHexa(hexa);
        }
        
    }
    
}
