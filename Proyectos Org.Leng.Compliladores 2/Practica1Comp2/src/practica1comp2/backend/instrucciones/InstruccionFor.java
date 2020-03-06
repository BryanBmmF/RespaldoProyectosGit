/*
 * Instruccion for
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
public class InstruccionFor extends Instruccion implements GenerarCuarteto{
    private InstruccionAsig asig;
    private Expresion exp;
    private Incremento in;
    private List<Instruccion> list;
    private EtiqRedireccion redir;

    public InstruccionFor(InstruccionAsig asig, Expresion exp, Incremento in, List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.asig = asig;
        this.exp = exp;
        this.in = in;
        this.list = list;
        this.redir = new EtiqRedireccion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
    }

    @Override
    public void evaluar() {
        //genear etiqueta inicial
        generarCuarteto(Operador.ETIQ, redir.ini(), null, null);
        //agregando condicion for
        if (exp.getList()!=null) {
                for(Cuarteto c: exp.getList()){
                    this.getGenerador().addCuarteto(c);
                }
            }
        //redirigir a etiq
        generarCuarteto(Operador.ETIQ, redir.fin(), null, null);
        
        //agregando incremento
        if (in.getExp().getList()!=null) {
                for(Cuarteto c: in.getExp().getList()){
                    this.getGenerador().addCuarteto(c);
                }
            }
        //redirigir a goto etiq
        generarCuarteto(Operador.GOTO, redir.ini(), null, null);
        //redirigir a etiq
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().v(), null, null);
        
        //bloque de intrucciones
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }
        
        //redirigir a goto etiq
        generarCuarteto(Operador.GOTO, redir.fin(), null, null);
        //redirigir a etiq
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().f(), null, null);
        
        
    }

    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
    
}
