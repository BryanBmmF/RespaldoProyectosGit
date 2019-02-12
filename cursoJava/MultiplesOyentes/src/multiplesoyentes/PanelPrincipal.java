/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesoyentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bryan
 */
public class PanelPrincipal extends JPanel{
    
    //constructor
    public PanelPrincipal(){
    
        //creacion de botones
    JButton botonNuevo= new JButton("Nuevo");
    add(botonNuevo);
    
    botonCerrar=new JButton("Cerrar");
    add(botonCerrar);
    
    //instanciacion de oyente (llamandolo)
    OyenteNuevo miOyente= new OyenteNuevo();
    
    //desencadena el evento y mandar a clase Oyente
    botonNuevo.addActionListener(miOyente);
    
    }
    
    //se declara afuera ya que se tendra que utilizar afuera n otras clases
    JButton botonCerrar;
    
    //clase interna Oyente 
    private class OyenteNuevo implements ActionListener{
        //metodo de ActionListener
        @Override
        public void actionPerformed(ActionEvent e) {
            
            /**
             * Al momento de instanciar a MarcoEmergente
             * se enviara como parametro
             * el OBJETO FUENTE que desencadeno la accion
             * en este caso botonCerrar
             **/
            MarcoEmergente marco= new MarcoEmergente(botonCerrar);
            
            marco.setVisible(true);
        }
    
    }
    
    
}
