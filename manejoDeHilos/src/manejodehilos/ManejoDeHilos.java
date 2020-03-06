/*
 * 
 */
package manejodehilos;

/**
 *
 * @author bryan
 */
public class ManejoDeHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // iniciando los hilos
        
        Hilo1 hilo1= new Hilo1();
        Hilo2 hilo2= new Hilo2();
        
         /*
         * Establecemos prioridad 
         * (podemos jugar con valores de 1 y 10
         * y veremos cual proceso termina primero
         * y cual segundo dependiendo de el valor
         * que asignemos aqui.
        */
        hilo1.setPriority(1);
        
        //arrancando hilo que hereda de thread
        hilo1.start();
        
        //arrancando hilo que implementa la interfaz Runnable
        new Thread(hilo2).start();
        
    }
    
}
