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
public class InstruccionRight extends Instruccion{
    private Integer n;

    public InstruccionRight(Integer n, String token) {
        super(token);
        this.n = n;
    }
    

    @Override
    public void ejecutar(PanelGrafico panel) {
            int nuevoValor = panel.getRotDerecha()+n;
            //panel.setRotDerecha(nuevoValor);
            if (panel.getRotIzquierda()==0) {
                    panel.setRotDerecha(nuevoValor);
                    panel.setmActual(nuevoValor);
                    panel.setSobreY(true);
            } else {
                    //int nuevoV = panel.getRotIzquierda()+n;
                    panel.setRotDerecha(nuevoValor);
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
                    int nuevo = panel.getRotDerecha()-360;
                    panel.setRotDerecha(nuevo);
                    panel.setmActual(nuevo);
                    panel.setSobreY(true);
            }
//            double m =(double)Math.tan(panel.getRotDerecha()) ;
//            panel.setmActual(m);//pendiente actual
//            System.out.println("m actual: "+panel.getmActual());
            
//            if (panel.getRotDerecha()==90) {
//                    if (panel.isSobreY()) {
//                            panel.setSobreY(false);
//                            panel.setSobreX(true);
//                    } else if (panel.isSobreX()){
//                            panel.setSobreY(true);
//                            panel.setSobreX(false);
//                    }
//            }
            
            
    }
    
}
