
package Objetos;

/**
 *
 * @author jpmazate
 */
public class Dato{
    private Token nombre;
    private String tipo;
    private Object lexema;
    

    public Dato(Token nombre, String tipo, Object lexema) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.lexema = lexema;
    }

    public Token getNombre() {
        return nombre;
    }

    public void setNombre(Token nombre) {
        this.nombre = nombre;
    }

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getLexema() {
        return lexema;
    }

    public void setLexema(Object lexema) {
        this.lexema = lexema;
    }

    
    
    
    
    
}