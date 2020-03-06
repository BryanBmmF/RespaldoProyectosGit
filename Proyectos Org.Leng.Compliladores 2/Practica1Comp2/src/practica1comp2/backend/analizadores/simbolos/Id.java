/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.analizadores.simbolos;

import java.util.List;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.instrucciones.InstruccionArray;
import practica1comp2.backend.instrucciones.InstruccionAsig;

/**
 *
 * @author bryan
 */
public class Id {
    private Token id;
    //private List<Expresion> list;
    private boolean isAsig;
    private InstruccionAsig asig;
    private InstruccionArray asigAr;
    private Expresion ex;

//    public Id(boolean isAsig, InstruccionAsig asig) {
//        this.isAsig = isAsig;
//        this.asig = asig;
//    }

//    public Id(Token id, boolean isAsig, InstruccionAsig asig) {
//        this.id = id;
//        this.isAsig = isAsig;
//        this.asig = asig;
//    }

    public Id(Token id, boolean isAsig, InstruccionAsig asig, Expresion ex) {
        this.id = id;
        this.isAsig = isAsig;
        this.asig = asig;
        this.ex = ex;
    }
    
    
    
    

    public Id(Token id, boolean isAsig) {
        this.id = id;
        this.isAsig = isAsig;
    }

    public Id(Token id, boolean isAsig, Expresion ex) {
        this.id = id;
        this.isAsig = isAsig;
        this.ex = ex;
    }

    
//    public Id(String id, List<Expresion> list) {
//        this.id = id;
//        this.list = list;
//    }

//    public Id(Token id) {
//        this.id = id;
//    }
    
//    public void addDims(Expresion e){
//        list.add(e);
//    }

    public Token getId() {
        return id;
    }

    public void setId(Token id) {
        this.id = id;
    }

//    public List<Expresion> getList() {
//        return list;
//    }
//
//    public void setList(List<Expresion> list) {
//        this.list = list;
//    }

    public boolean isIsAsig() {
        return isAsig;
    }

    public void setIsAsig(boolean isAsig) {
        this.isAsig = isAsig;
    }

    public InstruccionAsig getAsig() {
        return asig;
    }

    public void setAsig(InstruccionAsig asig) {
        this.asig = asig;
    }

    public InstruccionArray getAsigAr() {
        return asigAr;
    }

    public void setAsigAr(InstruccionArray asigAr) {
        this.asigAr = asigAr;
    }

    public Expresion getEx() {
        return ex;
    }

    public void setEx(Expresion ex) {
        this.ex = ex;
    }
    
    
    
}
