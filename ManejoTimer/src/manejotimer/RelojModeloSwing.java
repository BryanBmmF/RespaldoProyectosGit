/*
 * Reloj con swin.timer
 */
package manejotimer;
import java.util.Observer;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.Date;
import java.util.Observable;

/**
 *
 * @author bryan
 */
public class RelojModeloSwing {
    
     /**
      * Lanza un timer cada segundo, avisando a los observadores de este
      * modelo del cambio. 
      */
     public RelojModeloSwing()
     {                            //manda parametro en milisegundos osea cada segundo en este caso del 1000
         Timer timer = new Timer (1000, new ActionListener ()
         {
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 //metodo oyente que desencadena las acciones 
                 setChanged();
                 notifyObservers(new Date());
             }

             private void setChanged() {
                 System.out.println("changed");
             }

             private void notifyObservers(Date date) {
                 System.out.println(date);
             }
         });
         timer.start();
     }
    
     
     /**
      * Main para prueba de esta clase.
      */
     public static void main (String [] args)
     {
         RelojModeloSwing modelo = new RelojModeloSwing();
         modelo.addObserver(new Observer()
         {
             public void update (Observable unObservable, Object dato)
             {
                 System.out.println (dato);
             }
         });
         
         // Espera de 10 segundos para que el programa no termine
         // inmediatamente
         try
         {
            Thread.currentThread().sleep (10000);
         } catch (Exception e)
         {
         }
     }

    void addObserver(Observer observer) {
        System.out.println(observer);
    }
}
