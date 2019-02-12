/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadrodetexto;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoTexto extends JFrame{
    
    public MarcoTexto(){
    
        setTitle("Cuadros De Texto");
        
        setBounds(600,300,600,350);
        
        PanelTexto miPanel= new PanelTexto();
        
        add(miPanel);
    
    }
    
}
