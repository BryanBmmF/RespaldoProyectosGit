/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2compi1.backend.instrucciones;

import proyecto2compi1.frontend.JFramePrincipal;

/**
 *
 * @author bryan
 */
public class InstruccionDeclaracion extends Instruccion{
    private String nombre;
    private String tipo;
    private JFramePrincipal panel;
    private int indexTab;
    public InstruccionDeclaracion(String token) {
        super(token);
    }

    public InstruccionDeclaracion(String nombre, String tipo, JFramePrincipal panel, String token, int indexTab) {
        super(token);
        this.nombre = nombre;
        this.tipo = tipo;
        this.panel = panel;
        this.indexTab = indexTab;
    }
    
    
    @Override
    public void ejecutar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("* EJECUTANDO DECLARACION *");
        ingresarVariable();
        
        
    }
    
    public void ingresarVariable(){
            switch (tipo) {
                    case "INTEGER":{
                            if (panel.verificarVariableInteger(nombre)){
                                    /* existe la variable a ingresar */
                                    String error = "La variable : "+nombre+" ya esta declarada...";
                                    //listaErrores.add(error); REPORTAR DEUNAVEZ AL ARCHIVO XML
                                    //textArea.append("\nError Semantico:\n" + error);
                                    System.out.println(error);
                                    panel.agregarErrorSemantico(1, 1, error,indexTab);

                            } else {
                                    panel.agregarVariableInteger(nombre, 1);
                                    panel.agregarTablaSimbolos(nombre, tipo, "");

                            }
                    break;
                    }
                    case "BOOLEAN":{
                            if (panel.verificarVariableBoolean(nombre)){
                                    /* existe la variable a ingresar */
                                    String error = "La variable : "+nombre+" ya esta declarada...";
                                    //listaErrores.add(error); REPORTAR DEUNAVEZ AL ARCHIVO XML
                                    //textArea.append("\nError Semantico:\n" + error);
                                    System.out.println(error);
                                    panel.agregarErrorSemantico(1, 1, error,indexTab);
                            } else {
                                    panel.agregarVariableBoolean(nombre,null);
                                    panel.agregarTablaSimbolos(nombre, tipo, "");

                            }
                    break;
                    }
                    case "STRING":{
                            if (panel.verificarVariableString(nombre)){
                                    /* existe la variable a ingresar */
                                    String error = "La variable : "+nombre+" ya esta declarada...";
                                    //listaErrores.add(error); REPORTAR DEUNAVEZ AL ARCHIVO XML
                                    //textArea.append("\nError Semantico:\n" + error);
                                    System.out.println(error);
                                    panel.agregarErrorSemantico(1, 1, error,indexTab);
                            } else {
                                    panel.agregarVariableString(nombre, null);
                                    panel.agregarTablaSimbolos(nombre, tipo, "");
                            }
                    break;
                    }    
                    default:
                        throw new AssertionError();
            }
            
	}
    @Override
    public String recuperarTexto() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "";
    }
    
    
    
}
