/*
 * Clase Alquiler
 */
package proyecto2;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Alquiler implements Serializable {
    //Atributos para un Alquiler de Inmueble
    private Cliente clienteAdquisisor;
    private Cliente clientePrestador;
    private Abogado abogadoIntermediario;
    private Propiedad propiedadEnAlquiler;
    private String fechaInicialDeAlquiler;
    private String fechaFinalDeAlquiler;
    private String diaDePago;
    private LocalDate fechaDeAlquiler;
    
    //constructor de clase Alquiler

    public Alquiler(Cliente clienteAdquisisor, Cliente clientePrestador, Abogado abogadoIntermediario, Propiedad propiedadEnAlquiler, String fechaInicialDeAlquiler, String fechaFinalDeAlquiler, String diaDePago, LocalDate fechaDeAlquiler) {
        this.clienteAdquisisor = clienteAdquisisor;
        this.clientePrestador = clientePrestador;
        this.abogadoIntermediario = abogadoIntermediario;
        this.propiedadEnAlquiler = propiedadEnAlquiler;
        this.fechaInicialDeAlquiler = fechaInicialDeAlquiler;
        this.fechaFinalDeAlquiler = fechaFinalDeAlquiler;
        this.diaDePago = diaDePago;
        this.fechaDeAlquiler = fechaDeAlquiler;
    }
    
    
    //metodos accesores de clase Alquiler

    public Cliente getClienteAdquisisor() {
        return clienteAdquisisor;
    }

    public void setClienteAdquisisor(Cliente clienteAdquisisor) {
        this.clienteAdquisisor = clienteAdquisisor;
    }

    public Cliente getClientePrestador() {
        return clientePrestador;
    }

    public void setClientePrestador(Cliente clientePrestador) {
        this.clientePrestador = clientePrestador;
    }

    public Abogado getAbogadoIntermediario() {
        return abogadoIntermediario;
    }

    public void setAbogadoIntermediario(Abogado abogadoIntermediario) {
        this.abogadoIntermediario = abogadoIntermediario;
    }

    public Propiedad getPropiedadEnAlquiler() {
        return propiedadEnAlquiler;
    }

    public void setPropiedadEnAlquiler(Propiedad propiedadEnAlquiler) {
        this.propiedadEnAlquiler = propiedadEnAlquiler;
    }

    public String getFechaInicialDeAlquiler() {
        return fechaInicialDeAlquiler;
    }

    public void setFechaInicialDeAlquiler(String fechaInicialDeAlquiler) {
        this.fechaInicialDeAlquiler = fechaInicialDeAlquiler;
    }

    public String getFechaFinalDeAlquiler() {
        return fechaFinalDeAlquiler;
    }

    public void setFechaFinalDeAlquiler(String fechaFinalDeAlquiler) {
        this.fechaFinalDeAlquiler = fechaFinalDeAlquiler;
    }

    public String getDiaDePago() {
        return diaDePago;
    }

    public void setDiaDePago(String diaDePago) {
        this.diaDePago = diaDePago;
    }

    public LocalDate getFechaDeAlquiler() {
        return fechaDeAlquiler;
    }

    public void setFechaDeAlquiler(LocalDate fechaDeAlquiler) {
        this.fechaDeAlquiler = fechaDeAlquiler;
    }
    
    
    
}
