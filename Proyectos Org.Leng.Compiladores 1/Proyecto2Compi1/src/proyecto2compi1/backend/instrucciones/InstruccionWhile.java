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
public class InstruccionWhile extends Instruccion{
    private Boolean condicion;
    private List<Instruccion> instruccionesBloque;
    
    private String codigoHtml;
    
    public InstruccionWhile(String token) {
        super(token);
    }

    public InstruccionWhile(Boolean condicion, List<Instruccion> instruccionesBloque, String token) {
        super(token);
        this.condicion = condicion;
        this.instruccionesBloque = instruccionesBloque;
        this.codigoHtml = "";
    }
    
    
    
    @Override
    public void ejecutar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("* EJECUTANDO WHILE *");
        while (condicion) {
            
        }
    }
    
    @Override
    public String recuperarTexto() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return codigoHtml;
    }
    
}
