/*
 * modificando componentes en el panel o paneles
 */
package layoutsdisposiciones;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bryan
 */
public class PanelLayout extends JPanel{
    
    //constructor
    public PanelLayout(){
        
         /**
         * 1. Constructores De FlowLayout 
         * posicion, ancho, alto del borde superior de la ventana entre elemento
         **/
        /*
        setLayout(new FlowLayout(FlowLayout.CENTER,75,100));
        
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        add(new JButton("Azul"));
        */
        ////////////////////////////////////////////////////
        /**
         * 2. Constructores de BorderLayout
         * para zona de cada boton en los bordes
         * separacion entre botonnes(10,10)
         **/
        /*
        setLayout(new BorderLayout(10,10));
        
        add(new JButton("Amarillo"),BorderLayout.NORTH);
        add(new JButton("Rojo"),BorderLayout.SOUTH);
        add(new JButton("Azul"),BorderLayout.WEST);
        add(new JButton("Verde"),BorderLayout.EAST);
        add(new JButton("Negro"),BorderLayout.CENTER); 
        */
        /////////////////////////////////////////////////////
        /**
         * Ejemplo utilizando dos laminas         
         **/
        //posicion de los elementos left(izquierda)
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
    
    }
    
}
