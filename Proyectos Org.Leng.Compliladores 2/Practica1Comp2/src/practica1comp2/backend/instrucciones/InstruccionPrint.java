/*
 * Instruccion Print
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionPrint extends Instruccion implements GenerarCuarteto{
    private boolean salto;
    private List<Expresion> list;

    public InstruccionPrint(boolean salto, List<Expresion> list, GeneradorCod generador) {
        super(generador);
        this.salto = salto;
        this.list = list;
    }
    
    @Override
    public void evaluar() {
        if (salto) {
            for (Expresion ex: list){
                evalExpres(ex.getList());
                generarCuarteto(Operador.PRINTLN, ex.getLugarTemp(), null, null); 
            }
            
        } else {
            for (Expresion ex: list){
                evalExpres(ex.getList());
                generarCuarteto(Operador.PRINT, ex.getLugarTemp(), null, null); 
            }
        }
        
        
    }
    
    public void evalExpres( List<Cuarteto> ex){
        if (ex!=null) {
            for(Cuarteto c: ex){
                this.getGenerador().addCuarteto(c);
            }
        }
    }

    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
}
