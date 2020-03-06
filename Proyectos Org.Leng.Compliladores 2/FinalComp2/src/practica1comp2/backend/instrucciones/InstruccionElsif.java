/*
 * Insruccion elsif
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.expresiones.EvaluarExpresion;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.EtiqCondicion;
import practica1comp2.backend.generadores.EtiqRedireccion;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionElsif extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private List<InstruccionIf> listIf;
    //private InstruccionElse els;
    private EtiqRedireccion redir;
    private boolean conFinal;

    public InstruccionElsif(List<InstruccionIf> listIf, GeneradorCod generador) {
        super(generador);
        this.listIf = listIf;
        this.redir = new EtiqRedireccion(null, null);
        this.conFinal = false;
    }
    @Override
    public void evaluar() {
        //recorriendo ifs
        int cont =1;
        for(InstruccionIf ifi: listIf){
            ifi.setRedir(redir);
            if (cont != listIf.size() || conFinal) {
                ifi.setAcomp(true); //para no generar una etiqueta sobrante en el ultiumo elsif salvo si lleva else final
            }
            
            ifi.evaluar();
            cont ++;
        }
        
    }


    public EtiqRedireccion getRedir() {
        return redir;
    }

    public void setRedir(EtiqRedireccion redir) {
        this.redir = redir;
    }

    public List<InstruccionIf> getListIf() {
        return listIf;
    }

    public void setListIf(List<InstruccionIf> listIf) {
        this.listIf = listIf;
    }

    public boolean isConFinal() {
        return conFinal;
    }

    public void setConFinal(boolean conFinal) {
        this.conFinal = conFinal;
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarElsifGlobal(ambito, sym);
        } else {
            verificarElsifLocal(ambito, sym, sub);
        }
        
    }
    
    public void verificarElsifGlobal(TipoVar ambito, TablaSimbolos sym){
        /*evaluar cada instruccion*/
        for(InstruccionIf ifi: listIf){
            ifi.evaluarExpresiones(ambito, sym, null);
        }
    
    }
    
    public void verificarElsifLocal(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub){
        /*evaluar cada instruccion*/
        for(InstruccionIf ifi: listIf){
            ifi.evaluarExpresiones(ambito, sym, sub);
        }
    }
    
    
    
}
