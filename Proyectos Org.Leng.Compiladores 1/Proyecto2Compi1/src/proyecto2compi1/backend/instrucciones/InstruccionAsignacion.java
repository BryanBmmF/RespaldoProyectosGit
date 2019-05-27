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
public class InstruccionAsignacion extends Instruccion{
    private String nombre;
    private Integer valorEntero;
    private Boolean valorBooleano;
    private String valorString;
    private String tipo;
    private JFramePrincipal panel;
    private int indexTab;
    public InstruccionAsignacion(String token) {
        super(token);
    }

    public InstruccionAsignacion(String nombre, Integer valor1, String tipo, JFramePrincipal panel, String token, int indexTab) {
        super(token);
        this.nombre = nombre;
        this.valorEntero = valor1;
        this.tipo = tipo;
        this.panel = panel;
        this.indexTab = indexTab;
    }

    public InstruccionAsignacion(String nombre, Boolean valor2, String tipo, JFramePrincipal panel, String token,int indexTab) {
        super(token);
        this.nombre = nombre;
        this.valorBooleano = valor2;
        this.tipo = tipo;
        this.panel = panel;
        this.indexTab = indexTab;
    }

    public InstruccionAsignacion(String nombre, String valor3, String tipo, JFramePrincipal panel, String token,int indexTab) {
        super(token);
        this.nombre = nombre;
        this.valorString = valor3;
        this.tipo = tipo;
        this.panel = panel;
        this.indexTab = indexTab;
    }

    
    
    @Override
    public void ejecutar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("* EJECUTANDO ASIGNACION *");
        asignarVariable();
        
    }
    public void asignarVariable(){
            switch (tipo) {
                    case "INTEGER":{
                            if (this.panel.verificarVariableInteger(nombre)){
					/* existe la variable a asignar el valor */
					this.panel.asignarVariableInteger(nombre, valorEntero);
                                        panel.cargarTablaSimbolos();
                                        System.out.println("asignando i: "+valorEntero);
				} else {
						//se crea y se asigna de una vez
						//this.panel.agregarVariableInstruc(nombre, valor1);
                                                System.out.println("Variable no definida");
                                                panel.agregarErrorSemantico(1, 1, "La variable: "+nombre+" no fue previamente Definida", indexTab);

				}
                    break;
                    }
                    case "BOOLEAN":{
                            if (this.panel.verificarVariableBoolean(nombre)){
					/* existe la variable a asignar el valor */
					this.panel.asignarVariableBoolean(nombre, valorBooleano);
                                        panel.cargarTablaSimbolos();
				} else {
						//se crea y se asigna de una vez
						//this.panel.agregarVariableInstruc(nombre, valor1);
                                                System.out.println("Variable no definida");
                                                panel.agregarErrorSemantico(1, 1, "La variable: "+nombre+" no fue previamente Definida", indexTab);
				}
                    break;
                    }
                    case "STRING":{
                            if (this.panel.verificarVariableString(nombre)){
					/* existe la variable a asignar el valor */
					this.panel.asignarVariableString(nombre, valorString);
                                        panel.cargarTablaSimbolos();
				} else {
						//se crea y se asigna de una vez
						//this.panel.agregarVariableInstruc(nombre, valor1);
                                                System.out.println("Variable no definida");
                                                panel.agregarErrorSemantico(1, 1, "La variable: "+nombre+" no fue previamente Definida", indexTab);
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

    public Integer getValorEntero() {
        return valorEntero;
    }

    public void setValorEntero(Integer valorEntero) {
        this.valorEntero = valorEntero;
        asignarVariable();//guardando nuevo valo en la tabla
    }
    
    
    
}
