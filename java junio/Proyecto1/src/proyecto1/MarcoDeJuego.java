/*
 * ventana que muestra el avance del juego
 */
package proyecto1;
import javax.swing.JFrame;
/**
 *
 * @author bryan
 */
public class MarcoDeJuego extends JFrame{
    
    public  MarcoDeJuego(){
        setTitle("Juego de la Fortuna");
        setBounds(100,0,700,650);
    
        //instanciando nuevo Panel
        PanelDeJuego tablero= new PanelDeJuego();
        tablero.colocarCasillas();
        tablero.colocarIdentificadores();
        //agregando tablero al Marco       
        add(tablero);
    }

}

