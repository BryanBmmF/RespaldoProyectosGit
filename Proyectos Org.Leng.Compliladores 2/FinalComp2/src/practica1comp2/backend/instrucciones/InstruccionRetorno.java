/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.analizadores.simbolos.Token;
import practica1comp2.backend.expresiones.EvaluarExpresion;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionRetorno extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private Token retorno;
    private Expresion exp;
    private Expresion subPadre;

    public InstruccionRetorno(Token retorno, Expresion exp, GeneradorCod generador) {
        super(generador);
        this.retorno = retorno;
        this.exp = exp;
        this.subPadre = null;
    }

    @Override
    public void evaluar() {
        //sub Padre es el que lleva el nombre de la funcion que esta llamando
        generarCuarteto(Operador.RETURN, exp, subPadre, null);
        
    }
    
    public Token getRetorno() {
        return retorno;
    }

    public void setRetorno(Token retorno) {
        this.retorno = retorno;
    }
    
    

    public Expresion getExp() {
        return exp;
    }

    public void setExp(Expresion exp) {
        this.exp = exp;
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }

    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarReturnGlobal(sym);
        } else {
            verificarReturnLocal(sym, sub);
        }
        
    }
    
    public void verificarReturnGlobal(TablaSimbolos sym){
        /*evaluar expresion de condicion*/
        exp.evaluarExpresiones(sym, TipoVar.GLOBAL, null); //para local deberia ser evaluarExresiones2
    
    }
    
    public void verificarReturnLocal(TablaSimbolos sym, InstruccionSub sub){
        /*evaluar expresion de condicion*/
        if (!(exp.isIsIdent() || exp.isIsPosArray())) {
            exp.evaluarExpresiones(sym, TipoVar.LOCAL, sub); //para local deberia ser evaluarExresiones2
            
        }
        this.subPadre = new Expresion(sub.getProcessName().getLexeme(), sub.getTipo(), this.getGenerador());
        
    }
    
    
}
