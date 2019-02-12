/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesoyentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoEmergente extends JFrame{
    
    //el constructor de MarcoEmergente recibe como parametro
    //el objeto Fuente que desencadena la accion
    public MarcoEmergente(JButton botonDePrincipal){
        
        //contador de ventanas en accion
        contador++;
    
        setTitle("Ventana"+contador);
        
        //posicion y size para cada ventana emergente        
        setBounds(40*contador,40*contador,300,150);   
        
        //llamando a CierraTodos
        CierraTodos oyenteCerrar = new CierraTodos();
        
        //avisando que botonDeprincipal recibido es la fuente desencadenante
        botonDePrincipal.addActionListener(oyenteCerrar);
        
        
        
    }
    //variable contador comun para todas las instancias creadas
    //static para que sea compartida para todas las instancias creadas en el futuro      
    //ademas encapsulada con private
    private static int contador=0;
    
    //creacion de clase interna para cerrar ventanas (Clase Oyente)
    //implementa ActionListener
    private class CierraTodos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //accion que cierra la ventana
            dispose();
            
        }

    }
    
    
}
