/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import java.util.ArrayList;
import java.util.List;
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
public class InstruccionLlamarSub extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private Token idsub;
    private List<Expresion> lisParam;
    private List<Cuarteto> temporal;
    
    /*AGREGAR PARAMETRO NUMERO DE LLAMADA PARA GENERAR CODIGO FINAL CADA VEZ QUE SE LLAME EL SUB (Suma1, Suma2, Suma3...)*/

    public InstruccionLlamarSub(Token idsub, List<Expresion> lisParam, GeneradorCod generador) {
        super(generador);
        this.idsub = idsub;
        this.lisParam = lisParam;
        this.temporal = new ArrayList();
    }
    
    
    
    public InstruccionLlamarSub(GeneradorCod generador) {
        super(generador);
    }

    @Override
    public void evaluar() {
        //declarar los parametros se hace al momento de evaluar call
        //crar cuarteto call, numParam se have al momento de evaluar call
        
        /*guardar los cuartetos gemerados a la hora de evaluarcall*/
        if (this.temporal!=null) {
            for(Cuarteto c: this.temporal){
                this.getGenerador().addCuarteto(c);
            }
        }
        
        
    }

    public Token getIdsub() {
        return idsub;
    }

    public void setIdsub(Token idsub) {
        this.idsub = idsub;
    }

    public List<Expresion> getLisParam() {
        return lisParam;
    }

    public void setLisParam(List<Expresion> lisParam) {
        this.lisParam = lisParam;
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        //this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
        this.temporal.add(new Cuarteto(op, result, arg1, arg2));
        
    }

    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
         if (ambito==TipoVar.GLOBAL) {
            verificarCallGlobal(sym);
        } else {
            verificarCallLocal(sym, sub);
        }
    }
    
    public void verificarCallGlobal(TablaSimbolos sym){
        /*evaluar expresion de condicion*/
        if (this.lisParam!=null) {
            for(Expresion exp: this.lisParam){
                exp.evaluarExpresiones(sym, TipoVar.GLOBAL, null); //para local deberia ser evaluarExresiones2
            }
        }
        if (sym.consultarExistenciaSub(idsub, lisParam, sym.getListaConsultaSubs())) {
            String temp = this.getGenerador().getLugarTemp(); //guardando temporal
            this.getGenerador().agregarTemporal(new Token(temp, 0, 0), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()));
            if (lisParam!=null) {
                /*declarar parametros*/
                for(Expresion ex: lisParam){
                    generarCuarteto(this.getGenerador().getOp().PARAM, ex, null, null);
                }
                generarCuarteto(this.getGenerador().getOp().CALL, new Expresion(temp, sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()), new Expresion(idsub.getLexeme(), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()), new Expresion(""+lisParam.size(), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()));
            } else {
                generarCuarteto(this.getGenerador().getOp().CALL, new Expresion(temp, sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()), new Expresion(idsub.getLexeme(), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()),  new Expresion("0", sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()));
            }    
        }
        
    }
    
    public void verificarCallLocal(TablaSimbolos sym, InstruccionSub sub){
        /*evaluar expresion de condicion*/
        if (this.lisParam!=null) {
            for(Expresion exp: this.lisParam){
                exp.evaluarExpresiones(sym, TipoVar.LOCAL, sub); //para local deberia ser evaluarExresiones2
            }
        }
        if (sym.consultarExistenciaSub(idsub, lisParam, sym.getListaConsultaSubs())) {
            String temp = this.getGenerador().getLugarTemp(); //guardando temporal
            this.getGenerador().agregarTemporal(new Token(temp, 0, 0), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()));
            if (lisParam!=null) {
                /*declarar parametros*/
                for(Expresion ex: lisParam){
                    generarCuarteto(this.getGenerador().getOp().PARAM, ex, null, null);
                }
                
                generarCuarteto(this.getGenerador().getOp().CALL, new Expresion(temp, sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()), new Expresion(idsub.getLexeme(), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()), new Expresion(""+lisParam.size(), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()));
            } else {
                generarCuarteto(this.getGenerador().getOp().CALL, new Expresion(temp, sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()), new Expresion(idsub.getLexeme(), sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()),  new Expresion("0", sym.buscarSubprogramaNoDeclarado(idsub, sym.getListaConsultaSubs()), this.getGenerador()));
            }    
        }
        
    }
    
    
    
}
