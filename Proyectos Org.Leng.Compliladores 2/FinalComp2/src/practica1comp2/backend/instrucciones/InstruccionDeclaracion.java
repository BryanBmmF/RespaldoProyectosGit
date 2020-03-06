/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionDeclaracion extends Instruccion { //implemetar mejor generar cuarteto ya que no sirve para todas 
    private Tipo tipo;
    private List<Id> listVar;

    public InstruccionDeclaracion(Tipo tipo, List<Id> listVar, GeneradorCod generador) {
        super(generador);
        this.tipo = tipo;
        this.listVar = listVar;
    }
    
    @Override
    public void evaluar() {
        for(Id id: listVar){
            if (id.isIsAsig()) {
                //es una asignacion generar codigo3d y c
                id.getAsig().evaluar();
            } else {
                 //generar solo codigo c
            }
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Id> getListVar() {
        return listVar;
    }

    public void setListVar(List<Id> listVar) {
        this.listVar = listVar;
    }
    
    
    
}
