package practica1comp2.backend.analizadores.simbolos;

import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author bryan
 */
public class TSymbol {
    private Hashtable tabla;
    protected TSymbol anterior;
    public TSymbol(TSymbol anterior){
        this.tabla = new Hashtable();
        this.anterior = anterior;
        
         
    }
    public void  put(Token token, Id id){
        tabla.put(token, id);
    
    }
 
    public Id getId(Token token){
        for(TSymbol e = this; e!=null; e = e.anterior){
            Id encontro  = (Id)(e.tabla.get(token));
            if (encontro!= null) {
                return encontro;
            }
            
        }
        return null;
    }
    
}
