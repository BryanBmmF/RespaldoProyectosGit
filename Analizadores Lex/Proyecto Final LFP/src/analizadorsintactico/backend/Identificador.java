/*
 * Calse Identificador
 */
package analizadorsintactico.backend;

/**
 *
 * @author bryan
 */
public class Identificador {
        String nombre;
        int valor;

        public Identificador(String nombre, int valor) {
                this.nombre = nombre;
                this.valor = valor;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public int getValor() {
                return valor;
        }

        public void setValor(int valor) {
                this.valor = valor;
        }
        
        
}
