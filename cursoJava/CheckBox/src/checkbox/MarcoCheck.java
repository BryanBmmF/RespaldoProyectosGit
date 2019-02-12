/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox;

import javax.swing.*;

/**
 *
 * @author bryan
 */
public class MarcoCheck extends JFrame{
    
    public MarcoCheck(){
    
        setTitle("Manejo de Check Box");
        setBounds(500,300,500,350);
        
        PanelCheck miPanel= new PanelCheck();
        
        add(miPanel);
    }
    
}
