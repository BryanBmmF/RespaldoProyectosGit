/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspinner;


import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author bryan
 */
public class PanelSpinner extends JPanel{
    
    public PanelSpinner(){
    
        //crear JSpinner      
        JSpinner control= new JSpinner();
        add(control);
      
    }

    
}
