/*
 * Clase Cliente
 */
package proyecto2;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Cliente extends Persona implements Serializable{
    //atributos que necesita un cliente
    private Long numeroCui;
    private String estadoCivil;
    private String genero;
    private String residencia;
    private String municipio;
    private String departamento;
    
    //constructor de clase Cliente

    public Cliente(Long numeroCui, String estadoCivil, String genero, String residencia, String municipio, 
            String departamento, String nombre, String apellido){
        super(nombre, apellido);
        this.numeroCui = numeroCui;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.residencia = residencia;
        this.municipio = municipio;
        this.departamento = departamento;
    }
    public Cliente(){
    
    }
    
    //metodos accesores para la clase Cliente
    public Long getNumeroCui() {
        return numeroCui;
    }

    public void setNumeroCui(Long numeroCui) {
        this.numeroCui = numeroCui;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {        
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
}
