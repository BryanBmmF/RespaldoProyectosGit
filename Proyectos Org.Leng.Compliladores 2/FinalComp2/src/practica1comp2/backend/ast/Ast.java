/*Class Abstract Syntax Tree*/
package practica1comp2.backend.ast;

import java.util.List;
import practica1comp2.backend.instrucciones.Instruccion;
import practica1comp2.backend.instrucciones.InstruccionMain;
import practica1comp2.backend.instrucciones.InstruccionSub;

/**
 *
 * @author bryan
 */
public class Ast {
    private List<Instruccion> declaracionesGlobal;
    private List<Instruccion> subProgramas;
    private InstruccionMain instruccionesMain;
    private boolean subs;

    public Ast(List<Instruccion> declaracionesGlobal, List<Instruccion> subProgramas, InstruccionMain instruccionesMain) {
        this.declaracionesGlobal = declaracionesGlobal;
        this.subProgramas = subProgramas;
        this.instruccionesMain = instruccionesMain;
    }

    public Ast(List<Instruccion> declaracionesGlobal, InstruccionMain instruccionesMain) {
        this.declaracionesGlobal = declaracionesGlobal;
        this.instruccionesMain = instruccionesMain;
    }

    public Ast(List<Instruccion> subProgramas, InstruccionMain instruccionesMain, boolean subs) {
        this.subProgramas = subProgramas;
        this.instruccionesMain = instruccionesMain;
        this.subs = subs;
    }

    public Ast(InstruccionMain instruccionesMain) {
        this.instruccionesMain = instruccionesMain;
    }
    

    public List<Instruccion> getDeclaracionesGlobal() {
        return declaracionesGlobal;
    }

    public void setDeclaracionesGlobal(List<Instruccion> declaracionesGlobal) {
        this.declaracionesGlobal = declaracionesGlobal;
    }

   

    public InstruccionMain getInstruccionesMain() {
        return instruccionesMain;
    }

    public void setInstruccionesMain(InstruccionMain instruccionesMain) {
        this.instruccionesMain = instruccionesMain;
    }

    public List<Instruccion> getSubProgramas() {
        return subProgramas;
    }

    public void setSubProgramas(List<Instruccion> subProgramas) {
        this.subProgramas = subProgramas;
    }

    public boolean isSubs() {
        return subs;
    }

    public void setSubs(boolean subs) {
        this.subs = subs;
    }
    
    
    
    
    
}
