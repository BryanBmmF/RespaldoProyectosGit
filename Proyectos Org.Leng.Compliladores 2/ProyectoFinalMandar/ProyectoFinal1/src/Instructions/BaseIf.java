/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import CErrores.CErrores;
import Objetos.Cuarteto;
import Objetos.ExpresionBooleana;
import Objetos.Logica;
import Objetos.Token;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class BaseIf implements Instruction{
    
    private ExpresionBooleana condicion;
    private List<Instruction> instructions;
    private Token token;
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private Logica logica = new Logica();

    public BaseIf(ExpresionBooleana condicion, List<Instruction> instructions,Token token, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        this.condicion = condicion;
        this.instructions = instructions;
        this.token = token;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
    }

    public ExpresionBooleana getCondicion() {
        return condicion;
    }

    public void setCondicion(ExpresionBooleana condicion) {
        this.condicion = condicion;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public void setAmbit(int ambito) {
        this.condicion.asignarAmbito(ambito);
        for (int i = 0; i < this.instructions.size(); i++) {
            this.instructions.get(i).setAmbit(ambito);
        }
    }
     @Override
    public void asignarValorFuncion(String idFuncion) {
        this.condicion.asignarValorFuncion(idFuncion);
        for (int i = 0; i < this.instructions.size(); i++) {
            this.instructions.get(i).asignarValorFuncion(idFuncion);
        }
    }
    
    
    

    @Override
    public boolean validate() {
        
        boolean bandera, bandera2 = true;

        String valor = condicion.validarClases(tablaSimbolos, tablaTipos);

        if (valor == null) {
            bandera2 = false;
        }
        for (int i = 0; i < instructions.size(); i++) {
            bandera = instructions.get(i).validate();
            if (!bandera) {
                bandera2 = false;
            }
        }
        if(!bandera2){
             CErrores.agregarError("SEMANTICO", "IF", null, null, null,
                            token.getLine(), token.getColumn(),
                            "PROBLEMAS CON EL CONTROL DE FLUJO IF");
                    
        }
        
        return bandera2;
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        
        
        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        
        return logica.asignarReturn(this.instructions, tipo,tSalida);
    }

   
}
