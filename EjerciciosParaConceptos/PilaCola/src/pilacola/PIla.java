
package pilacola;

/**
 *
 * @author bryan
 */
public class PIla {
    public static final int VALOR_TOPE_INICIAL= -1;
    private int tope;
    private int[] datos;
    private int limite;
    
    
    //especificando cantidad de datos
    
    //constructor de pila
    
    public PIla(int dato){
        this.limite= limite;
        this.datos=new int[limite];
        this.tope= VALOR_TOPE_INICIAL;
    }
    
    public boolean estaVacia(){
        return this.tope==this.limite;
        
    }
    public boolean estaLlena(){
        
    }
    
    public void apilar(){
        this.tope++;
        
        datos[tope]= dato;
    }
    
    
}
