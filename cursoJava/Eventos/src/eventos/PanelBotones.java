/*
 * Panel para botones
 */
package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author bryan
 */

/**
 * Objeto Listener en este caso quien recibe la accion
 * es el panel porque tendra que cambiar de color el botn
 **/
public class PanelBotones extends JPanel{
    
    //Incluyendo butones con JButton
    
    /**
     * Objeto Fuente quien desencadena la accion
     * 
     **/  
    //creando otros botones
    JButton botonAzul=new JButton("Azul");
    JButton botonAmarillo=new JButton("Amarillo");
    JButton botonRojo= new JButton("Rojo");
    
    //constructor de PanelBotones
    public PanelBotones(){
        //agregando los demas botones al Panel 
        add(botonAzul); 
        add(botonAmarillo);
        add(botonRojo);
        
        //instanciacion de Objetos tipo ColorFondo
        ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
        ColorFondo Azul=new ColorFondo(Color.BLUE);
        ColorFondo Rojo=new ColorFondo(Color.RED);
        
        /**
        * Objeto Evento ,que hacce la accion 
        **/
        
        //Agregando a botones la accion Listener
        //reescribiendo el metodo (addActionListener)de la interfaz Action listener       
        //enviando como parametros los objetos colores
        botonAzul.addActionListener(Azul);
        botonAmarillo.addActionListener(Amarillo);
        botonRojo.addActionListener(Rojo);
       
    }
    
    /**
     * Objeto Listener Receptor(Quien recibe la aciion )
     **/
    //"creacion de clase Interna" Objeto que Implenta la accion ActionListener 
    private class ColorFondo implements ActionListener{
    
        //constructor de ColorFondo quien recibe un parametro de tipo Color
        public ColorFondo(Color nuevoColor){
            //cambiando y almacenando miembro ColorDeFondo por el parametro recibido
            colorDeFondo=nuevoColor;
            
        }
        
        @Override
        public void actionPerformed(ActionEvent nuevoEvento){
            
            //encargado de realizar el cambio de color
            setBackground(colorDeFondo);
        }
        //encapsulando miembro colorDeFondo de tipo color
        private Color colorDeFondo;

    }
}
