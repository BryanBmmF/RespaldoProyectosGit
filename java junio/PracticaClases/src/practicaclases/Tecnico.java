/*
 * Clase Tecnico hereda de Persona
 */
package practicaclases;

/**
 *
 * @author bryan
 */
public class Tecnico extends Persona{
    private String pais;
    private int experiencia;
    //constructor
    public Tecnico(String pais, int experiencia, String nombre, int edad) {
        super(nombre, edad);
        this.pais = pais;
        this.experiencia = experiencia;
    }
    //metodos accesores
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
}
