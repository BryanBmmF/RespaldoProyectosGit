/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsdisposiciones;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bryan
 */

//segunda lamina
public class PanelLayout2  extends JPanel{
    
    public PanelLayout2(){
        
        //bordes para pisicion de elemntos
        setLayout(new BorderLayout());
        
        add(new JButton("Azul"),BorderLayout.WEST);
        add(new JButton("Verde"),BorderLayout.EAST);
        add(new JButton("Negro"),BorderLayout.CENTER);    
    
    }
    
}
