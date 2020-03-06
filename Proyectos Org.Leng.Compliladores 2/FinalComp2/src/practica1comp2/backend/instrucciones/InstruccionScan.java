/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.Tipo;
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
public class InstruccionScan extends  Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private Token idGuardar;
    private Operador scan;
    private TablaSimbolos sym;
    private Tipo tipo;

    public InstruccionScan(Token idGuardar, Operador scan, TablaSimbolos sym, GeneradorCod generador) {
        super(generador);
        this.idGuardar = idGuardar;
        this.scan = scan;
        this.sym = sym;
        this.tipo = null;
    }

    @Override
    public void evaluar() {
        if (scan==Operador.SCANN) {
            generarCuarteto(Operador.SCANN, new Expresion(idGuardar.getLexeme(), this.tipo, this.getGenerador()), null, null);
        } else {
            generarCuarteto(Operador.SCANS, new Expresion(idGuardar.getLexeme(), this.tipo, this.getGenerador()), null, null);
        }
        
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
        
    }

    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarScanGlobal(sym);
        } else {
            verificarScanLocal(sym, sub);
        }
        
    }
    
    public void verificarScanGlobal(TablaSimbolos sym){
        /*evaluar expresion de condicion*/
        if (sym.consultarVar(idGuardar,null)) {
                 tipo = sym.getTipo(idGuardar);
                if (scan==Operador.SCANN) {
                    if (!(tipo.getJerarqui()>=2 && tipo.getJerarqui()<=6)) {
                        sym.getErrorsList().add(String.format("La Variable '%s' "
                                + " , linea %d columna %d  no admite valores numericos (int, long, float, etc ).",
                                idGuardar.getLexeme(), idGuardar.getLine(), idGuardar.getColumn()));
                    }
                } else {
                    if ((tipo.getJerarqui()!=7)) {
                        sym.getErrorsList().add(String.format("La Variable '%s' "
                                + " , linea %d columna %d  no admite valores tipo String.",
                                idGuardar.getLexeme(), idGuardar.getLine(), idGuardar.getColumn()));
                    }
                }
 
        }
    
    }
    
    public void verificarScanLocal(TablaSimbolos sym, InstruccionSub sub){
        /*evaluar expresion de condicion*/
        if (sym.consultarVarLocal(idGuardar, sub.getProcessName().getLexeme())) {
                tipo = sym.getTipoLocal(idGuardar, sub.getProcessName().getLexeme());
                if (scan==Operador.SCANN) {
                    if (!(tipo.getJerarqui()>=2 && tipo.getJerarqui()<=6)) {
                        sym.getErrorsList().add(String.format("La Variable '%s' "
                                + " , linea %d columna %d  no admite valores numericos (int, long, float, etc ).",
                                idGuardar.getLexeme(), idGuardar.getLine(), idGuardar.getColumn()));
                    }
                } else {
                    if ((tipo.getJerarqui()!=7)) {
                        sym.getErrorsList().add(String.format("La Variable '%s' "
                                + " , linea %d columna %d  no admite valores tipo String.",
                                idGuardar.getLexeme(), idGuardar.getLine(), idGuardar.getColumn()));
                    }
                }
 
        }
        
        //seteaar el nombre del id
        setIdGuardar(new Token(idGuardar.getLexeme()+sub.getProcessName().getLexeme(), idGuardar.getLine(), idGuardar.getColumn()));
        
        
    }

    public Token getIdGuardar() {
        return idGuardar;
    }

    public void setIdGuardar(Token idGuardar) {
        this.idGuardar = idGuardar;
    }

    public Operador getScan() {
        return scan;
    }

    public void setScan(Operador scan) {
        this.scan = scan;
    }

    public TablaSimbolos getSym() {
        return sym;
    }

    public void setSym(TablaSimbolos sym) {
        this.sym = sym;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
