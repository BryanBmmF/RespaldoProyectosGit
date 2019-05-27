/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2compi1.backend.instrucciones;

import java.util.List;

/**
 *
 * @author bryan
 */
public class InstruccionIF extends Instruccion{
    private Boolean condicion;
    private List<Instruccion> instruccionesBloque1;
    private List<Instruccion> instruccionesBloque2;
    
    private String codigoHtml;
    
    public InstruccionIF(String token) {
        super(token);
    }

    public InstruccionIF(Boolean condicion, List<Instruccion> instruccionesBloque1, List<Instruccion> instruccionesBloque2, String token) {
        super(token);
        this.condicion = condicion;
        this.instruccionesBloque1 = instruccionesBloque1;
        this.instruccionesBloque2 = instruccionesBloque2;
        this.codigoHtml = "";
    }

    @Override
    public void ejecutar() {
            //concatenar con texto para devolver 
            System.out.println("* EJECUTANDO IF *");
            if (condicion.booleanValue()) {
                    System.out.println("----condicion verdadera");
                    for(Instruccion in: instruccionesBloque1){
                                in.ejecutar();
                                codigoHtml += in.recuperarTexto();
                        }
            } else {
                    System.out.println("----condicion falsa");
                    for(Instruccion in: instruccionesBloque2){
                                in.ejecutar();
                                codigoHtml += in.recuperarTexto();
                        }
            }
            
            
            
    }

    @Override
    public String recuperarTexto() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return codigoHtml;
    }
    
}
