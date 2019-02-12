/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica4;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class MarcoConImagen extends JFrame{
    
    public MarcoConImagen(){
        
        setBounds(750,300,400,400);
        setTitle("Marco con imagen");
    
        Panel nuevaLamina=new Panel();
        add(nuevaLamina);
        
    }
    
}
