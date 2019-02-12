/*
 * Clase Autentica
 */
package proyecto2;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Autentica implements Serializable{
    //atributos de una autentica
    private Cliente cliente;
    private Abogado abogado;
    private LocalDate fecha;
    
    //constructor de clase Autentica
    public Autentica(Cliente cliente, Abogado abogado, LocalDate fecha) {
        this.cliente = cliente;
        this.abogado = abogado;
        this.fecha = fecha;
    }
    //metodos Accesores de Clase Autentica

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Abogado getAbogado() {
        return abogado;
    }

    public void setAbogado(Abogado abogado) {
        this.abogado = abogado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
