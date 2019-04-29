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
public class InstruccionLeft extends Instruccion{
    private Integer n;

    public InstruccionLeft(Integer n, String token) {
        super(token);
        this.n = n;
    }
    

    @Override
    public void ejecutar(PanelGrafico panel) {
            if (panel.getmActual()==0) {//giramos a la izquierda
                    int nuevoValor = panel.getRotIzquierda()+n;
                    panel.setRotIzquierda(nuevoValor);
                    panel.setmActual(nuevoValor);
                    panel.setSobreY(false);
                    
            } else {
                    int nuevoValor = panel.getRotIzquierda()+n;
                    panel.setRotIzquierda(nuevoValor);
                    if (panel.getRotDerecha()>panel.getRotIzquierda()) {
                            panel.setmActual(panel.getRotDerecha()-panel.getRotIzquierda());
                            panel.setSobreY(true);
                    } else if (panel.getRotIzquierda()>panel.getRotDerecha()) {
                                panel.setmActual(panel.getRotIzquierda()-panel.getRotDerecha());
                                panel.setSobreY(false);
                                
                            } else {//son iguales
                                    panel.setmActual(0);
                                    panel.setSobreY(true);
                    }
            } 
            
            if (panel.getmActual()==360) {
                    panel.setRotDerecha(0);
                    panel.setRotIzquierda(0);
                    panel.setSobreY(true);
            
                    panel.setmActual(0);
            
            } else if(panel.getmActual()>360){
                    int nuevo = panel.getRotIzquierda()-360;
                    panel.setRotIzquierda(nuevo);
                    panel.setmActual(nuevo);
                    panel.setSobreY(false);
            }
    }
    
}
