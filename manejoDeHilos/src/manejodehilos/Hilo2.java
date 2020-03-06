/*
 * hilo 2 implementando la interfaz Runable pero cuando se desea iniciar se debe mandar como parametro
 * la insatncia del hilo
 */
package manejodehilos;

/**
 *
 * @author bryan
 */
public class Hilo2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(""+i+"//////////////////////");
            System.out.println("  //                  //");
        }
    }
    
}
