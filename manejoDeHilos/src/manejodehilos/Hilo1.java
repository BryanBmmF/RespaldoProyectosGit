/*
 *
 */
package manejodehilos;

/**
 *
 * @author bryan
 */
//La primera manera de manehar hilos es heredando de thread
public class Hilo1 extends Thread {
    
    public void run(){
        //proceso a realizar
        for (int i = 0; i < 10000; i++) {
            System.out.println(""+i+"*************");
            System.out.println("  *             *");
        }
    
    }
    
}
