/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.*;

/**
 *
 * @author bryan
 */
public class MenuFrame extends JFrame{
    
    public MenuFrame(){
        
        setTitle("Ejemplo de Menu 1");
        setBounds(500,300,500,350);
        
        PanelMenu miPanel= new PanelMenu();
        
        add(miPanel);
    
    }
    
}
