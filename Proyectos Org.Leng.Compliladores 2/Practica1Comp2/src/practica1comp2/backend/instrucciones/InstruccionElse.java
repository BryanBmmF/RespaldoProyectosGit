/*
 * Instruccion else
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.EtiqRedireccion;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionElse extends Instruccion implements GenerarCuarteto{
    private Expresion exp;
    private List<Instruccion> list;
    private EtiqRedireccion redir;

    public InstruccionElse(Expresion exp, List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.exp = exp;
        this.list = list;
        this.redir = new EtiqRedireccion(null, null);
    }

    public InstruccionElse(List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.list = list;
    }
    
    @Override
    public void evaluar() {
         //bloque de instrucciones
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }    
        //etiq final
        generarCuarteto(Operador.ETIQ, redir.fin(), null, null);
        
    }
    
    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }

    public EtiqRedireccion getRedir() {
        return redir;
    }

    public void setRedir(EtiqRedireccion redir) {
        this.redir = redir;
    }
    
    
}
