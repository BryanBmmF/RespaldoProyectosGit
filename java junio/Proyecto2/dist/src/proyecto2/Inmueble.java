/*
 * Clase Inmueble hereda de Propiedad
 */
package proyecto2;

import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Inmueble extends Propiedad implements Serializable {
    
    //Atributos para un Inmueble
    private String direccion;
    private double medidas;
    private int numeroDeNiveles;
    
    //constructor de clase Inmueble

    public Inmueble(String direccion, double medidas, int numeroDeNiveles, String nombrePropiedad, int costo) {
        super(nombrePropiedad, costo);
        this.direccion = direccion;
        this.medidas = medidas;
        this.numeroDeNiveles = numeroDeNiveles;
    }
    public Inmueble(String direccion,String nombrePropiedad, int costo){
        super(nombrePropiedad, costo);
        this.direccion = direccion;
    }
    //metodos accesores para clase Inmueble

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getMedidas() {
        return medidas;
    }

    public void setMedidas(double medidas) {
        this.medidas = medidas;
    }

    public int getNumeroDeNiveles() {
        return numeroDeNiveles;
    }

    public void setNumeroDeNiveles(int numeroDeNiveles) {
        this.numeroDeNiveles = numeroDeNiveles;
    }
    
}
