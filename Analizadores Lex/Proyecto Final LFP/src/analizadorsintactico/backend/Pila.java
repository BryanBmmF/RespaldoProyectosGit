/*
 * Clase Pila para el manejo de memoria de un anakizador sintactico 
 */
package analizadorsintactico.backend;
import java.util.ArrayList;
/**
 *
 * @author bryan
 */
public class Pila extends ArrayList {
 
        //se añade un elemento a la pila.(push)
        public void apilar(Object dato){
            if(dato != null) {
                    this.add(dato);
            } else {
                    System.out.println("Introduzca un dato no nulo");
                }  
        }
 
        //se elimina el elemento frontal de la pila.(pop)
        public void desapilar(){
            if(size() > 0){
                    this.remove(this.size()-1);
            }
        }
 
        //devuelve el elemento que esta en la cima de la pila. (top o peek)
        public Object cima(){
            Object datoAuxiliar = null;
            if(this.size() > 0){
                    datoAuxiliar = this.get(this.size()-1);
            }
            return datoAuxiliar;  
        }
 
        //devuelve cierto si la pila está vacía o falso en caso contrario (empty).
        public boolean vacia(){
            return this.isEmpty();
        }
        //se vacia toda la pila
        public void vaciarPila(){
            if(size() > 0){
                    this.clear();
            } else {
                    System.out.println("Ya esta vacia");
                }
        }
}
