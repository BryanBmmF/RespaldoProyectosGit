/*
 * Clase Venta
 */
package proyecto2;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Venta implements Serializable {
    
    //Atributos para una venta de Propiedad
    private Cliente clienteComprador;
    private Cliente clienteVendedor;
    private Abogado abogadoIntermediario;
    private Propiedad propiedadEnVenta;
    private LocalDate fechaDeVenta;
    
    //constructor de clase Venta

    public Venta(Cliente clienteComprador, Cliente clienteVendedor, Abogado abogadoIntermediario,
            Propiedad propiedadEnVenta, LocalDate fechaDeVenta) {
        this.clienteComprador = clienteComprador;
        this.clienteVendedor = clienteVendedor;
        this.abogadoIntermediario = abogadoIntermediario;
        this.propiedadEnVenta = propiedadEnVenta;
        this.fechaDeVenta = fechaDeVenta;
    }
    
    //metodos Accesores para clase Venta

    public Cliente getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(Cliente clienteComprador) {
        this.clienteComprador = clienteComprador;
    }

    public Cliente getClienteVendedor() {
        return clienteVendedor;
    }

    public void setClienteVendedor(Cliente clienteVendedor) {
        this.clienteVendedor = clienteVendedor;
    }

    public Abogado getAbogadoIntermediario() {
        return abogadoIntermediario;
    }

    public void setAbogadoIntermediario(Abogado abogadoIntermediario) {
        this.abogadoIntermediario = abogadoIntermediario;
    }

    public Propiedad getPropiedadEnVenta() {
        return propiedadEnVenta;
    }

    public void setPropiedadEnVenta(Propiedad propiedadEnVenta) {
        this.propiedadEnVenta = propiedadEnVenta;
    }

    public LocalDate getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(LocalDate fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }
    
}
