
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionSentIf extends Instruccion{
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
 
    
}
