/*
 * Clase Tarjeta de credito 
 */
package practicaformal2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class TarjetaDeCredito implements Serializable{
    //miembros obligatorios 
    private String numeroDeTarjeta;
    private String tipo;
    private int limiteDeCredito;
    private String propietario;
    private String direccionPropietario;
    private String fechaSolicitud;
    private String estado;
    
    // constructor principal de Tarjeta de Credito
    public TarjetaDeCredito(String numeroDeTarjeta,String tipo,int limiteDeCredito,String propietario
            ,String direccionPropietario,String fechaSolicitud,String estado){
        
        this.numeroDeTarjeta=numeroDeTarjeta;
        this.tipo=tipo;
        this.limiteDeCredito=limiteDeCredito;
        this.propietario=propietario;
        this.direccionPropietario=direccionPropietario;
        this.fechaSolicitud=fechaSolicitud;
        this.estado=estado;
    
    }
    //metodo generador de tarjetas
    public void generarNuevaTarjeta( String contador){
        
        //metodo para generar Nueva Tarjeta sin error alguno
        File file = new File("Tarjeta"+tipo.concat(contador)+".card");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			//Excepciones posibles
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			//e.printStackTrace();
		}
        
    
    }
    //metodos accesore para tarjeta de credito
    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccionPropietario() {
        return direccionPropietario;
    }

    public void setDireccionPropietario(String direccionPropietario) {
        this.direccionPropietario = direccionPropietario;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito(int limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }
    
    
    
}


