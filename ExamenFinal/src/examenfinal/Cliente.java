/*
 * clase Cliente
 */
package examenfinal;

/**
 *
 * @author bryan
 */
public class Cliente {
    private String nombre;
    private String tipoCarro;
    private String servicioSolicitado;

    public Cliente(String nombre, String tipoCarro, String servicioSolicitado) {
        this.nombre = nombre;
        this.tipoCarro = tipoCarro;
        this.servicioSolicitado = servicioSolicitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(String tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public String getServicioSolicitado() {
        return servicioSolicitado;
    }

    public void setServicioSolicitado(String servicioSolicitado) {
        this.servicioSolicitado = servicioSolicitado;
    }
    
}
