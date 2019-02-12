/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventosdefoco;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoFoco extends JFrame{
    
    public MarcoFoco(){
    
         setVisible(true);
         setBounds(300,300,600,450);
         
         add(new PanelFoco());
         
    }
    
}
