/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areadetexto;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoArea extends JFrame{
    
    public MarcoArea(){
        
        setTitle("Areas De texto");
        setBounds(500,300,500,350);
        
        PanelArea miPanel= new PanelArea();
        
        add(miPanel);
    
    }
    
}
