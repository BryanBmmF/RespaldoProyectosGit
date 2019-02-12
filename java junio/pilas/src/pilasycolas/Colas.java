/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author christian
 */
public class Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<String> cola1 = new LinkedList();
        Scanner entrada = new Scanner(System.in);
        String dato;
        System.out.println("COLAS");

        /*
            Métodos disponibles en una cola
            Insertar: (add, offer)
            Extraer: (remove,poll)
            Consultar: (element, peek)
        */
        for(int i=1; i<=5; i++){
            System.out.println("Ingrese dato #"+i);
            dato = entrada.nextLine();
            cola1.offer("dato #"+i+": "+dato);
        }
        System.out.println("Cola llena con:"+cola1);
        while(cola1.peek()!=null){
            System.out.println(cola1.peek());
            cola1.poll();
        }
        

        /**************ejemplo con la clase creada*********************/
//        Cola ejemplocola = new Cola();
//        for(int i=1; i<=5; i++){
//            System.out.println("Ingrese dato #"+i);
//            dato = entrada.nextLine();
//            ejemplocola.encolar("dato #"+i+": "+dato);
//        }
//        while(!ejemplocola.vacia()){
//            System.out.println(ejemplocola.frente());
//            ejemplocola.desencolar();
//        }
    }
    
}
