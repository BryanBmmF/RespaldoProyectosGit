
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.expresiones.EvaluarExpresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionSentIf extends Instruccion implements EvaluarExpresion{
    private InstruccionIf ifi;
    private InstruccionElsif elsifs;
    private InstruccionElse els;

    public InstruccionSentIf(InstruccionIf ifi, InstruccionElsif elsifs, InstruccionElse els, GeneradorCod generador) {
        super(generador);
        this.ifi = ifi;
        this.elsifs = elsifs;
        this.els = els;
    }
    @Override
    public void evaluar() {
        //cuatro posibilidades 
        if (elsifs==null && els==null) {
            // if simple
            ifi.evaluar();
        } else if (elsifs==null && els!=null) {
                //if else
                ifi.setAcomp(true);
                ifi.getRedir().setFin(this.getGenerador().getNuevaEtiq());
                ifi.evaluar();

                els.setRedir(ifi.getRedir());
                els.evaluar();

            } else if (els==null && elsifs!=null) {
                    //if elsifs
                    ifi.setAcomp(true);
                    //consulta del fin de etiqueta que genero la epresion del ultimo elsif para concatenarlo con cada uno
                    ifi.getRedir().setFin(elsifs.getListIf().get(elsifs.getListIf().size()-1).getExp().getEtiq1().f());
                    ifi.evaluar();
                    // else
                    elsifs.setRedir(ifi.getRedir());
                    elsifs.evaluar();

                } else if (els!=null && elsifs!=null) {
                        //if elsifs else
                        ifi.setAcomp(true);
                        ifi.getRedir().setFin(this.getGenerador().getNuevaEtiq());
                        ifi.evaluar();
                        // se agrega con final para concatenar el ultimo else con los elsif
                        elsifs.setRedir(ifi.getRedir());
                        elsifs.setConFinal(true);
                        elsifs.evaluar();
                        // else
                        els.setRedir(ifi.getRedir());
                        els.evaluar();

                    }
        
    }
    
    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarIfGlobal(ambito,sym);
        } else {
            verificarIfLocal(ambito, sym, sub);
        }
        
    }
    
    public void verificarIfGlobal(TipoVar ambito, TablaSimbolos sym){
        //cuatro posibilidades 
        if (elsifs==null && els==null) {
            // if simple
            ifi.evaluarExpresiones(ambito, sym, null);
        } else if (elsifs==null && els!=null) {
                //if else
                ifi.evaluarExpresiones(ambito, sym, null);
                els.evaluarExpresiones(ambito, sym, null);
            } else if (els==null && elsifs!=null) {
                    //if elsifs
                    ifi.evaluarExpresiones(ambito, sym, null);
                    elsifs.evaluarExpresiones(ambito, sym, null);
                } else if (els!=null && elsifs!=null) {
                        //if elsifs else
                        ifi.evaluarExpresiones(ambito, sym, null);
                        elsifs.evaluarExpresiones(ambito, sym, null);
                        els.evaluarExpresiones(ambito, sym, null);
                    }
    
    }
    
    public void verificarIfLocal(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub){
        //cuatro posibilidades 
        if (elsifs==null && els==null) {
            // if simple
            ifi.evaluarExpresiones(ambito, sym, sub);
        } else if (elsifs==null && els!=null) {
                //if else
                ifi.evaluarExpresiones(ambito, sym, sub);
                els.evaluarExpresiones(ambito, sym, sub);
            } else if (els==null && elsifs!=null) {
                    //if elsifs
                    ifi.evaluarExpresiones(ambito, sym, sub);
                    elsifs.evaluarExpresiones(ambito, sym, sub);
                } else if (els!=null && elsifs!=null) {
                        //if elsifs else
                        ifi.evaluarExpresiones(ambito, sym, sub);
                        elsifs.evaluarExpresiones(ambito, sym, sub);
                        els.evaluarExpresiones(ambito, sym, sub);
                    }
    }
 
    
}
