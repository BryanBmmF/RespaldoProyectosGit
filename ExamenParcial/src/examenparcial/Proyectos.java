/*
 * clase proyectos
 */
package examenparcial;

/**
 *
 * @author bryan
 */
public class Proyectos {
    private String nombre;
    private int numeroDePersonas;
    private String edades;
    private int costoPorPersona;
    private String medios;

    public Proyectos(String nombre, int numeroDePersonas, String edades, int costoPorPersona, String medios) {
        this.nombre = nombre;
        this.numeroDePersonas = numeroDePersonas;
        this.edades = edades;
        this.costoPorPersona = costoPorPersona;
        this.medios = medios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDePersonas() {
        return numeroDePersonas;
    }

    public void setNumeroDePersonas(int numeroDePersonas) {
        this.numeroDePersonas = numeroDePersonas;
    }

    public String getEdades() {
        return edades;
    }

    public void setEdades(String edades) {
        this.edades = edades;
    }

    public int getCostoPorPersona() {
        return costoPorPersona;
    }

    public void setCostoPorPersona(int costoPorPersona) {
        this.costoPorPersona = costoPorPersona;
    }

    public String getMedios() {
        return medios;
    }

    public void setMedios(String medios) {
        this.medios = medios;
    }
    
    
}
