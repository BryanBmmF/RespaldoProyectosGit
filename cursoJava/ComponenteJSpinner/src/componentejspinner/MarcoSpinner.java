/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentejspinner;

import javax.swing.*;

/**
 *
 * @author bryan
 */
public class MarcoSpinner extends JFrame{
    
        public MarcoSpinner(){
            
            setTitle("Ejemplo de Spinner");
            setBounds(500,300,500,350);
            
            PanelSpinner miPanel= new PanelSpinner();
            add(miPanel);
        
        }
    
}
