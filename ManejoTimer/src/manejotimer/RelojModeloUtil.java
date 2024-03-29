/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejotimer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author bryan
 */

/**
 * Modelo de reloj utilizando java.util.Timer
 */
public class RelojModeloUtil extends Observable {
     /**
      * Lanza un timer cada segundo.
      */
     public RelojModeloUtil()
     {
         Timer timer = new Timer();
         timer.scheduleAtFixedRate(timerTask, 0, 1000);
     }

     /**
      * main de prueba de esta clase.
      * No necesita una ventana para funcionar.
      */
     public static void main (String [] args)
     {
         RelojModeloUtil modelo = new RelojModeloUtil();
         modelo.addObserver (new Observer()
         {
             public void update (Observable unObservable, Object dato)
             {
                 System.out.println (dato);
             }
         });
     }
     
     /**
      * Clase que se mete en Timer, para que se le avise cada segundo.
      */
     TimerTask timerTask = new TimerTask()
     {
         /**
          * Método al que Timer llamará cada segundo. Se encarga de avisar
          * a los observadores de este modelo.
          */
         @Override
         public void run() 
         {
             setChanged();
             notifyObservers(new Date());
         }
     };
}
