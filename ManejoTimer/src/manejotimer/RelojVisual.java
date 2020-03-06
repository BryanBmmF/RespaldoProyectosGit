/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejotimer;
import javax.swing.JLabel;
import java.util.Observer;
import java.util.Observable;
import java.util.Date;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import java.text.SimpleDateFormat;

/**
 *
 * @author bryan
 */

/**
 * Visual para mostrar el reloj.
 * Es un JLabel que recibe un Observable de cambio de fecha.
 */
public class RelojVisual extends JLabel{
     /**
      * Se pasa un observable de fecha/hora. El Observable debe pasar un
      * Date a esta visual para que la presente.
      */
     public RelojVisual(Observable modelo)
     {
         // La fecha/hora se pinta en el centro de este JLabel
         this.setHorizontalAlignment((SwingConstants.CENTER));
         
         // Suscripción al cambio de fecha/hora en el modelo recibido.
         modelo.addObserver (new Observer ()
         {
             // Método al que el Observable llamará cuando se cambie
             // la fecha/hora. El arg se espera que sea un Date.
             @Override
             public void update(java.util.Observable o, Object arg) 
             {
                 final Object fecha = arg;
                 
                 // Se actualiza en pantalla la fecha/hora.
                 SwingUtilities.invokeLater (new Runnable()
                 {
                     @Override
                     public void run()
                     {
                         setText (format.format(fecha));
                     }
                 });
             }
         });
         
         // Se da una dimension al JLabel.
         this.setPreferredSize(new Dimension (200, 50));
     }
     
     /**
      * Cambia el formato de presentacion de la fecha/hora en pantalla.
      */
     public void setFormat (SimpleDateFormat unFormato)
     {
         format = unFormato;
     }
     
     /**
      * Clase para mostrar una fecha/hora en formato texto.
      */
    SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");
    
}
