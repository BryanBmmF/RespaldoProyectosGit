/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasdobles;

/**
 *
 * @author christian
 */
public class Listasdobles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lista lg=new lista();
//        System.out.println(lg.valorraiz());
        lg.insertar (1, 10);
        lg.insertar (2, 20);
        lg.insertar (3, 30);
        lg.imprimir ();
        lg.insertar (2, 15);
        lg.imprimir ();
        lg.insertar (1, 115);
        lg.imprimir ();
        System.out.println(lg.valorraiz());
        System.out.println ("Luego de Borrar el primero");
        lg.borrar (1);
        lg.imprimir ();
        System.out.println(lg.valorraiz());
        System.out.println ("Luego de Extraer el segundo");
        System.out.println("Se extrajo: " +lg.extraer (2));
        lg.imprimir ();
        System.out.println ("Luego de Intercambiar el primero con el tercero");
        lg.intercambiar (1, 3);
        lg.imprimir ();
        System.out.println(lg.valorraiz());
        lg.insertar(4, 75);
        if (lg.existe(75)) 
            System.out.println("Se encuentra el 75 en la lista");
        else
            System.out.println("No se encuentra el 75 en la lista");
        lg.imprimir();
        
        lg.intercambiar(1,3);
        System.out.println("La posición del mayor es: "+lg.posMayor());
        System.out.println("El valor es: " +lg.mayor());
        lg.imprimir();
        if (lg.ordenada())
            System.out.println("La lista está ordenada de menor a mayor");
        else
            System.out.println("La lista no está ordenada de menor a mayor");            

    }
    
}
