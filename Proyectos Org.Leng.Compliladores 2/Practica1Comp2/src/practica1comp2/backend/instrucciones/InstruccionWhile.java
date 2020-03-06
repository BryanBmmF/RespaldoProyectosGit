/*
 * Instruccion While
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
public class InstruccionWhile extends Instruccion implements GenerarCuarteto{
    private Expresion exp;
    private List<Instruccion> list;
    private EtiqRedireccion redir;

    public InstruccionWhile(Expresion exp, List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.exp = exp;
        this.list = list;
        this.redir = new EtiqRedireccion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
    }
    @Override
    public void evaluar() {
        //generar etiqueta inicial
        generarCuarteto(Operador.ETIQ, redir.ini(), null, null);
        //agregando condicion while
        if (exp.getList()!=null) {
                for(Cuarteto c: exp.getList()){
                    this.getGenerador().addCuarteto(c);
                }
            }
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().v(), null, null);
        //evaluando instrucciones bloque
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }
        generarCuarteto(Operador.GOTO, redir.ini(), null, null);
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().f(), null, null);        
        
    }

    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2)); 
    }
    
    
    
}
