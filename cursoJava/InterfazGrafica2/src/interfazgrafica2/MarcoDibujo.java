/*
 *Crando marco(Frame) para dibujo
 */
package interfazgrafica2;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class MarcoDibujo extends JFrame{
    
    //constructor de marco con dibujo
    public MarcoDibujo(){
    
        //title
        setTitle("Prueba de Dibujo");
        //location and size
        setBounds(300,300,400,400);
        
        //instanciacion de nueva lamina
        LaminaConFiguras miLamina=new LaminaConFiguras();
        add(miLamina);
    }
    
}
