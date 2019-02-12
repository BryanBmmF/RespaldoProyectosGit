/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areadetexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author bryan
 */
public class PanelArea extends JPanel{
    
    public PanelArea(){
        
        //constructor JTextAre argumentos :filas de texto largo de texto
        
        miArea=new JTextArea(8,20);
        
        //creacion de segundo panel para barras de scroll
        JScrollPane panelBarras= new JScrollPane(miArea);
        
        //metodo para salto de linea en texto
        miArea.setLineWrap(true);
        
        //agregando barra scroll al panel
        add(panelBarras);
        
        //creacion de un boton               
        JButton miBoton= new JButton("Dale");
        
        //accion de boton 
        miBoton.addActionListener(new GestionaArea());
        
        //agregando boton
        add(miBoton);
          
    
    }
    //creacion de clase interna oyente
    private class GestionaArea implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //rescatando texto de area de texto e imprimir
            
            System.out.println(miArea.getText());
        }
    
    }
    //encapsulamiento de JText miArea
    private JTextArea miArea;
    
}
