/*
 * Instruccion for
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.analizadores.simbolos.Token;
import practica1comp2.backend.expresiones.EvaluarExpresion;
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
public class InstruccionFor extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
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
        generarCuarteto(Operador.ETIQ, new Expresion(redir.ini(), exp.getTipo(), this.getGenerador()), null, null);
        //agregando condicion for
        if (exp.getList()!=null) {
                for(Cuarteto c: exp.getList()){
                    this.getGenerador().addCuarteto(c);
                }
        } else {
            if (exp.getEtiq1()==null) {
                exp.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                
            } 
            if (exp.getLugarTemp().equals("1")) {
                generarCuarteto(Operador.IF_IGUAL, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), exp, new Expresion("1", exp.getTipo(), this.getGenerador()));
                generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
            } else if(exp.getLugarTemp().equals("0")){
                generarCuarteto(Operador.IF_IGUAL, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), exp, new Expresion("1", exp.getTipo(), this.getGenerador()));
                generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
            }
            
            
        }
        //redirigir a etiq
        generarCuarteto(Operador.ETIQ, new Expresion(redir.fin(), exp.getTipo(), this.getGenerador()), null, null);
        
        //agregando incremento
        if (in.getExp().getList()!=null) {
                for(Cuarteto c: in.getExp().getList()){
                    this.getGenerador().addCuarteto(c);
                }
            }
        //redirigir a goto etiq
        generarCuarteto(Operador.GOTO, new Expresion(redir.ini(), exp.getTipo(), this.getGenerador()), null, null);
        //redirigir a etiq
        generarCuarteto(Operador.ETIQ, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), null, null);
        
        //bloque de intrucciones
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }
        //reasignacion del incremento
        String temp = this.getGenerador().getLugarTemp();
        this.getGenerador().agregarTemporal(new Token(temp, 0, 0), asig.getExp().getTipo());
        if (in.getOperador()==Operador.MAS) {
            generarCuarteto(Operador.MAS, new Expresion(temp, asig.getExp().getTipo(), this.getGenerador()), new Expresion(asig.getLoc().getId().getLexeme(), asig.getExp().getTipo(), this.getGenerador()), in.getExp());
        } else {
            generarCuarteto(Operador.MENOS, new Expresion(temp, asig.getExp().getTipo(), this.getGenerador()), new Expresion(asig.getLoc().getId().getLexeme(), asig.getExp().getTipo(), this.getGenerador()), in.getExp());
        }
        
        generarCuarteto(Operador.ASIG, new Expresion(asig.getLoc().getId().getLexeme(), asig.getExp().getTipo(), this.getGenerador()), new Expresion(temp, in.getExp().getTipo(), this.getGenerador()), null);
        
        //redirigir a goto etiq
        generarCuarteto(Operador.GOTO, new Expresion(redir.fin(), exp.getTipo(), this.getGenerador()), null, null);
        //redirigir a etiq
        generarCuarteto(Operador.ETIQ, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
        
        
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarForGlobal(sym);
        } else {
            verificarForLocal(sym, sub);
        }
        
    }
    
    public void verificarForGlobal(TablaSimbolos sym){
        /*evaluar asignacion*/
        sym.verificarAsignacion(asig);
        /*evaluar expresion de condicion*/
        exp.evaluarExpresiones(sym, TipoVar.GLOBAL, null); //para local deberia ser evaluarExresiones2
        /*evaluar incremento*/
        in.getExp().evaluarExpresiones(sym, TipoVar.GLOBAL, null);
        /*evaluar cada instruccion*/
        sym.verificarTipoInstruc(list);
    
    }
    
    public void verificarForLocal(TablaSimbolos sym, InstruccionSub sub){
        /*evaluar asignacion*/
        sym.verificarAsignacionLocal(asig, sub);
        /*evaluar expresion de condicion*/
        exp.evaluarExpresiones(sym, TipoVar.LOCAL, sub); //para local deberia ser evaluarExresiones2
        /*evaluar incremento*/
        in.getExp().evaluarExpresiones(sym, TipoVar.LOCAL, sub);
        /*evaluar cada instruccion*/
        sym.verificarInstruccionLocal(list, sub);
        
    }
    
    
}
