/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combobox;

import javax.swing.*;

/**
 *
 * @author bryan
 */
public class MarcoCombo extends JFrame {
    
    public MarcoCombo(){
        
        setTitle("Ejemplo de Combo Box");
        setBounds(500,300,500,350);
        
        PanelCombo miPanel=new PanelCombo();
        
        add(miPanel);
    }
    
}
