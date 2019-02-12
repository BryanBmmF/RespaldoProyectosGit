/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesfuentes;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoAccion extends JFrame{
    public MarcoAccion(){
        
    setTitle("Prueba acciones");
    setBounds(600,350,600,300);
    
    
    PanelAccion nuevoPanel= new PanelAccion();
    
    add(nuevoPanel);
    }
}
