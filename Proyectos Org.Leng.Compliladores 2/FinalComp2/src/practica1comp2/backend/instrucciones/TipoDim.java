/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.expresiones.Expresion;

/**
 *
 * @author bryan
 */
public class TipoDim {
    private Tipo tipo;
    private Expresion ex;
    private List<Expresion> dims;
    //private int x= 9;
    //private int[] a = new int[x];

//    public TipoDim(Tipo tipo, Expresion ex) {
//        this.tipo = tipo;
//        this.ex = ex;
//    }

    public TipoDim(Tipo tipo, List<Expresion> dims) {
        this.tipo = tipo;
        this.dims = dims;
    }
    
    

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

//    public Expresion getEx() {
//        return ex;
//    }
//
//    public void setEx(Expresion ex) {
//        this.ex = ex;
//    }

    public List<Expresion> getDims() {
        return dims;
    }

    public void setDims(List<Expresion> dims) {
        this.dims = dims;
    }
    
    
    
    
}
