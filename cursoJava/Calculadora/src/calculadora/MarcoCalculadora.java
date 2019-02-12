/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javax.swing.*; //importa todo el paquete

/**
 *
 * @author bryan
 */
public class MarcoCalculadora extends JFrame{
    
    //constructor
    public MarcoCalculadora(){
    
        setTitle("Calculadora");
        
        setBounds(500,300,450,300);
        
        //instanciando Panel
        PanelCalculadora miPanel=new PanelCalculadora();
        add(miPanel);
        
        //pack(); para adaptacion por defecto para sustituir a bounds
        
        //pack();
    }
    
}
