/*
 * Clase Jugador hereda de Persona
 */
package practicaclases;

/**
 *
 * @author bryan
 */
public class Jugador extends Persona{
    private String posicion;
    private int numero;
    //constructor
    public Jugador(String posicion, int numero, String nombre, int edad) {
        super(nombre, edad);
        this.posicion = posicion;
        this.numero = numero;
    }
    //metodos accesores
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
