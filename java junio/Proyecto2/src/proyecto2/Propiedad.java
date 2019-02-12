/*
 * Clase Propiedad, contempla bienes muebles e inmuebles de un cliente
 */
package proyecto2;

import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Propiedad implements Serializable {
    private String nombrePropiedad;
    private int costo;
    
    //constructores de Clase Propiedad
    public Propiedad(String nombrePropiedad, int costo) {
        this.nombrePropiedad = nombrePropiedad;
        this.costo = costo;
    }
    public Propiedad(){
    
    }
    
    //metodos Accesores de Clase Propiedad

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
