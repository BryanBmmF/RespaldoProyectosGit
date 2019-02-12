/*
 * Clase Vehiculo hereda de Propiedad
 */
package proyecto2;

import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Vehiculo extends Propiedad implements Serializable{
    //atributos de un vehiculo
    private String marca;
    private String modelo;
    private String placa;
    private String tipo;
    
    //constructor de Clase Vehiculo

    public Vehiculo(String marca, String modelo, String placa, String tipo, String nombrePropiedad, int costo) {
        super(nombrePropiedad, costo);
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tipo = tipo;
    }
    
    
    //metodos accesores para clase Vehiculo

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
    
}
