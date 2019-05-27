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
public class InstruccionFor extends Instruccion{
    private InstruccionAsignacion asignacion;
    private Integer ordinal2;
    private List<Instruccion> instruccionesBloque;
    
    private String codigoHtml;
    
    public InstruccionFor(String token) {
        super(token);
    }

    public InstruccionFor(InstruccionAsignacion asignacion, Integer ordinal2, List<Instruccion> instruccionesBloque, String token) {
        super(token);
        this.asignacion = asignacion;
        this.ordinal2 = ordinal2;
        this.instruccionesBloque = instruccionesBloque;
        this.codigoHtml = "";
    }
    
    @Override
    public void ejecutar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("* EJECUTANDO FOR *");
        
        //ejecutar la asignacion
        asignacion.ejecutar();
        
        for (int i = asignacion.getValorEntero(); i <= ordinal2.intValue(); i++) {
                System.out.println(""+asignacion.getValorEntero());
                
                for(Instruccion in: instruccionesBloque){
                        in.ejecutar(); //ejecutando cada instruccion que viene en el bloque
                        codigoHtml += in.recuperarTexto();
                }
                //actualizar la tabla en los metodos set del valor entero que representa al ordinal1 en el For
                asignacion.setValorEntero(asignacion.getValorEntero()+1);
        }
    }
    
    @Override
    public String recuperarTexto() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return codigoHtml;
    }
    
}
