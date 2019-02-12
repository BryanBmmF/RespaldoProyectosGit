/*
 * Este Frame es directamente para la interfazGrafica con Panel
 */
package interfazgrafica1;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author bryan
 */
public class MarcoParaPanel extends JFrame{
    
    //constructor de marco para panel
    
    public MarcoParaPanel(){
        
        //visualizando marco 1
        setVisible(true);
    
        /*Agregacion de Atributos**/
        
        //centrando ventana en pantalla
        //clase toolkit devuelve la resolucion nativa del sistema huesped        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();   //importante importar clase
        
        //clase Dimension para devolver el Size del monitor
        Dimension sizePantalla= miPantalla.getScreenSize(); //importante importar clase
        
        //atributos de la clase dimension para size height and widht 
        //declarando alto y ancho de pantalla
        
        int alturaPantalla=sizePantalla.height;
        int anchoPantalla=sizePantalla.width;
        
        //centrando ventana y colocando Size = a la mitad de la pantalla completa
        
        setSize(anchoPantalla/2,alturaPantalla/2);  //size a la mitad  primero toma el ancho
        setLocation(anchoPantalla/4,alturaPantalla/4);  //location en un cuarto
        
        //colocacion de icono a la pantalla
        Image icono=miPantalla.getImage("icono.jpg");//importante importar hereda directamente de object
       
        //estableciendo icono con getIconoImage()        
        setIconImage(icono);
        
        //nombre de ventana
        setTitle("Nuevo Texto");
        
        /*
        Agregando nuevo panel para mostrar el nuevo texto etc
        **/
        //instanciando nuevo panel o lamina
        Lamina nuevaLamina= new Lamina();
        
        //agregando nuevaLamina a marcoParaPanel
        add(nuevaLamina);
        
        
    }
    
}
