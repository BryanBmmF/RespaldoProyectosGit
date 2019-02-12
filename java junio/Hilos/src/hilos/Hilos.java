/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author christian
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se crean los clientes y los "segundos" de cada producto que comprarán
	Cliente cliente1 = new Cliente("Josué", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Roberto", new int[] { 1, 3, 5, 1, 1 });
        // Se crean las Cajeras
//        Cajera cajera1 = new Cajera("Sandra");
//        Cajera cajera2 = new Cajera("Daniela");
        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

//        cajera1.procesarCompra(cliente1, initialTime);
//        cajera2.procesarCompra(cliente2, initialTime);    

        /*** usando hilos ***/
        CajeraThread cajerath1 = new CajeraThread("Sandra", cliente1, initialTime);
        CajeraThread cajerath2 = new CajeraThread("Daniela", cliente2, initialTime);
        cajerath1.start();
        cajerath2.start();

    }
}
