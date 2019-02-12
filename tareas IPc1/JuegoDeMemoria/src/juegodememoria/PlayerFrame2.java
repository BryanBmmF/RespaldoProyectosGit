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
public class PlayerFrame2 extends JFrame{
    
    //construcror
    public PlayerFrame2(int dificultad){
        
        this.dificultad=dificultad;
        FramePanel2 panel2 = new FramePanel2(dificultad);
        
        add(panel2);
        
        //colocacion de barra herramientas en PlayerFrame2
        add(barra, BorderLayout.SOUTH);
    }
    
    private int dificultad;

}


