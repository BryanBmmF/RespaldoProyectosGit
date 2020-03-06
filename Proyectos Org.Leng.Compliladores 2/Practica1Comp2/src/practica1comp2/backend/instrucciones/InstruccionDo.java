/*
 * Instruccion Do While
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
public class InstruccionDo extends Instruccion implements GenerarCuarteto{
    private List<Instruccion> list;
    private Expresion exp;
    //private EtiqRedireccion redir;

    public InstruccionDo(List<Instruccion> list, Expresion exp, GeneradorCod generador) {
        super(generador);
        this.list = list;
        this.exp = exp;
        //this.redir = new EtiqRedireccion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
    }

    @Override
    public void evaluar() {
        //generar etiqueta inicial
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().v(), null, null);
        //evaluando instrucciones bloque
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }
        //agregando condicion while
        if (exp.getList()!=null) {
                for(Cuarteto c: exp.getList()){
                    this.getGenerador().addCuarteto(c);
                }
            }
        //etiquta de salto
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().f(), null, null); 
        
    }

    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2)); 
    }
    
    
}
