/*
 *Clase Persona
 */
package proyecto2;

import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Persona implements Serializable{
    //Atributos generales para una persona
    private String nombre;
    private String apellido;
    //constructor de clase Persona

    public Persona(String nombre, String apellido) {
        
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //constructor sin parametros
    public Persona(){
    }
    //metodos Accesores para la clase Persona 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
