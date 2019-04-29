/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2compi1.backend.instrucciones;

import java.util.List;
import practica2compi1.frontend.PanelGrafico;

/**
 *
 * @author bryan
 */
public class InstruccionRepeat extends Instruccion{
    private Integer n;
    private List<Instruccion> listaInstrucciones;

    public InstruccionRepeat(Integer n, String token) {
        super(token);
        this.n = n;
    }

    public InstruccionRepeat(Integer n, List<Instruccion> listaInstrucciones, String token) {
        super(token);
        this.n = n;
        this.listaInstrucciones = listaInstrucciones;
    }
    

    @Override
    public void ejecutar(PanelGrafico panel) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 1; i < n; i++) {//por alguna razon hace siempre una instruccion mas por eso empezamos el ciclo en 1
                for(Instruccion in: listaInstrucciones){
                        in.ejecutar(panel);
                }
        }
    }
    
}
