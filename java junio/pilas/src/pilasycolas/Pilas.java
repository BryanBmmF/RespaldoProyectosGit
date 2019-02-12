/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

// importar la librería que ya maneja los métodos de Pila (push, pop, empty)
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author christian
 */
public class Pilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();
        Scanner entrada = new Scanner(System.in);
        String dato;
        System.out.println("PILAS");
        
        for(int i=1; i<=5; i++){
            System.out.println("Ingrese dato #"+i);
            dato = entrada.nextLine();
            pila.push("dato #"+i+": "+dato);
        }
        System.out.println("Pila llena con:"+pila);        
        while(!pila.empty()){
            System.out.println(pila.pop());
        }
        
        /********Usando la clase construida************/
//        Pila p1 = new Pila();
//        for(int i=1; i<=5; i++){
//            System.out.println("Ingrese dato #"+i);
//            dato = entrada.nextLine();
//            p1.apilar("dato #"+i+": "+dato);
//        }
//        while(!p1.vacia()){
//            System.out.println(p1.cima());
//            p1.desapilar();
//        }
        
        
    }
    
}
