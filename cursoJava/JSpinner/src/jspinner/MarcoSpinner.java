/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspinner;

import javax.swing.*;

/**
 *
 * @author bryan
 */
public class MarcoSpinner extends JFrame{
    
    public MarcoSpinner(){
    
        setTitle("Ejemplo de JSpinner");
        setBounds(500,300,500,350);
        
        add(new PanelSpinner());
        
    }
}
