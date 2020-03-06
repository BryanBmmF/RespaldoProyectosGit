/*
 * Instruccion If
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
public class InstruccionIf extends Instruccion implements GenerarCuarteto{
    private Expresion exp;
    private List<Instruccion> list;
    private EtiqRedireccion redir;
    private boolean acomp;

    public InstruccionIf(Expresion exp, List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.exp = exp;
        this.list = list;
        this.redir = new EtiqRedireccion(null, null);
        this.acomp = false;
    }
    
    @Override
    public void evaluar() {
        //cuartetos de exp
        if (exp.getList()!=null) {
            for(Cuarteto c: exp.getList()){
                this.getGenerador().addCuarteto(c);
            }
        }
        
        //etiqueta inicio
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().v(), null, null);
        
        //bloque de instrucciones
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }    
        
        if (acomp) {
             //iniciando etiqueta de redirieccion
            //redir.setFin(this.getGenerador().getNuevaEtiq());
            generarCuarteto(Operador.GOTO, redir.fin(), null, null);
        }
       
        generarCuarteto(Operador.ETIQ, exp.getEtiq1().f(), null, null);
        
        
        
        
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

    public boolean isAcomp() {
        return acomp;
    }

    public void setAcomp(boolean acomp) {
        this.acomp = acomp;
    }

    public Expresion getExp() {
        return exp;
    }

    public void setExp(Expresion exp) {
        this.exp = exp;
    }
    
    
    
}
