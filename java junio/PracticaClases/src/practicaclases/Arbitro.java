/*
 * Clase Arbitro hereda de Persona
 */
package practicaclases;

/**
 *
 * @author bryan
 */
public class Arbitro extends Persona{
    private String posicion;
    private String nacionalidad;
    //constructor
    public Arbitro(String posicion, String nacionalidad, String nombre, int edad) {
        super(nombre, edad);
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
    }
    //metodos accesores
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    
    
}
