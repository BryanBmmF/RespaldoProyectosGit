
package interfazgrafica1;
import java.awt.*;
import javax.swing.*;

/**
 * Title: Interfaz grafica en java Fames(marcos)
 * @author bryan
 */
public class MarcoPrincipal extends JFrame{

    //constructor de marco principal
    public MarcoPrincipal() {
        
        //metodos para dimensiones del Frame principal
        //setSize(500,300);
        
        //metodo para ubicacion del Frame
        //setLocation(500,300);
        
        //metodo para combinar setSize y setlocation
        //primer parametro location y segundo dimensiones
        //setBounds(500,300,250,250);
        
        //metodo para impedir redimensionar ventana al usuario, true para permitir        
        setResizable(false);
        
        //metodo para mostrar dimension maxima de la ventana, o solamente poner 6 en el parent. que es equivalente al nombre        
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        
        //metodo para nombrar ventana principal       
        setTitle("FrameDePrueba1");
        
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
       
        //estableciendo icocono con getIconoImage()        
        setIconImage(icono);
        
        
        
        
        
    }
    
   
    
    
    
}
