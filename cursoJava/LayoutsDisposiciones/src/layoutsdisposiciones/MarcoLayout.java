/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutsdisposiciones;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoLayout extends JFrame{
    //constructor
    public MarcoLayout(){
        
        //atributos
        setTitle("Marco Para Layouts");   
        setBounds(300,300,400,250);
        
        //instanciando lamina PanelLayout
        PanelLayout lamina= new PanelLayout();
        
        //disposicion de elementos, modificacion  de posicion de los botones
        
        /*FlowLayout disposicion= new FlowLayout(FlowLayout.LEFT);
          lamina.setLayout(disposicion);*/
        
        //instanciando lamina Panellayout2
        PanelLayout2 lamina2= new PanelLayout2();
        
        //colocando laminas con bordes y zonas establecidas Nort south
        add(lamina,BorderLayout.NORTH);
        add(lamina2,BorderLayout.SOUTH);
    
    }
    
}
