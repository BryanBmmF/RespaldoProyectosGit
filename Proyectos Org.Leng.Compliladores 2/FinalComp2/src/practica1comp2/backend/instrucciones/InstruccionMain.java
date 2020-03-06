/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import java.math.BigInteger;
import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Categoria;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionMain extends Instruccion implements GenerarCuarteto{
    private List<Instruccion> instrucciones;

    public InstruccionMain(List<Instruccion> instrucciones, GeneradorCod generador) {
        super(generador);
        this.instrucciones = instrucciones;
    }

    @Override
    public void evaluar() {
        generarCuarteto(Operador.ETIQ, new Expresion("main", new Tipo(TipoVar.INT, null, BigInteger.ONE, BigInteger.ONE, Categoria.VAR, 0, null, 0, 0, null, null), this.getGenerador()), null, null);
        //evaluar las instrucciones del main
        if (!instrucciones.isEmpty()) {
            for(Instruccion instruc : instrucciones){
                   if (instruc!=null) {
                       System.out.println(">>NUEVA INSTRUCCION MAIN");
                       instruc.evaluar();
                }
            }
        }
        
        /*fin de main*/
        generarCuarteto(Operador.FIN_MAIN, null, null, null);
        
    }
    
    public void agregarFinMain(){
        
    
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(List<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
    
    
}
