/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodememoria;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static juegodememoria.PlayerFrame.barra;

/**
 *
 * @author bryan
 */
public class FrameManual extends JFrame{
    
    //construcror
    public FrameManual(){
        
        PanelManual panel2 = new PanelManual();
        
        add(panel2);
        
        //colocacion de barra herramientas en PlayerFrame2
        add(barra, BorderLayout.SOUTH);
    }
    
}
