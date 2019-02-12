/*
 * Clase Abogado
 */
package proyecto2;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Abogado extends Persona implements Serializable{
    private String titulo;
    private int numeroColegiado;
    
    //constructor de la clase abogado
    public Abogado(String titulo, int numeroColegiado, String nombre, String apellido) {
        super(nombre, apellido);
        this.titulo = titulo;
        this.numeroColegiado = numeroColegiado;
    }

    //metodos Accesores para clase Abogado
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }
    
}

