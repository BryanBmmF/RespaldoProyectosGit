/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoBotones extends JFrame{
    
    //constructor de MarcoBotones
    public MarcoBotones(){
    
        //title
        setTitle("Botones y Eventos");
        
        setBounds(700,300,500,300);
        
        //instanciacion de nuevo panel
        PanelBotones miPanel= new PanelBotones();
        
        add(miPanel);
    
    }
    
}
