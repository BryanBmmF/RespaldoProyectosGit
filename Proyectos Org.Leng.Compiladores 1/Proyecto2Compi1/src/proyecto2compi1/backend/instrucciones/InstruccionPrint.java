/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2compi1.backend.instrucciones;

import java.util.List;
import proyecto2compi1.frontend.JFramePrincipal;

/**
 *
 * @author bryan
 */
public class InstruccionPrint extends Instruccion{
    private List<String> listaTexto;
    private JFramePrincipal panel;
    private String codigoHtml;
    
    public InstruccionPrint(String token) {
        super(token);
    }

    public InstruccionPrint(List<String> listaTexto, JFramePrincipal panel, String token) {
        super(token);
        this.listaTexto = listaTexto;
        this.panel = panel;
        this.codigoHtml = "";
    }
    
    
    @Override
    public void ejecutar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("* EJECUTANDO PRINT *");
        this.codigoHtml= ""; //reiniciar en cada vuelta
        
        for(String texto: listaTexto){
                if (panel.verificarVariableInteger(texto)){
                        /* existe la variable a usar */
                        codigoHtml += String.valueOf(panel.retornarVariableInteger(texto));
//                        if (panel.retornarVariableInteger(texto)!=null){
//                                /* code */
//                                codigoHtml += String.valueOf(panel.retornarVariableInteger(texto));
//                        } else {
//                                codigoHtml += String.valueOf(0);
//                        }
					

                } else {
                        codigoHtml+=texto;
                }

        
        }
        
    }
    
    @Override
    public String recuperarTexto() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return codigoHtml+"\n";
    }
    
}
