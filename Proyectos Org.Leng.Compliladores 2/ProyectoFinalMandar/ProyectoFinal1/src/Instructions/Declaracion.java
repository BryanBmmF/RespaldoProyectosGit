/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import CErrores.CErrores;
import Objetos.Cuarteto;
import Objetos.Dato;
import Objetos.Expresion;
import Objetos.Token;
import Tablas.TablaSimbolos.Simbolos;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Tablas.TablaTipos.Tipos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Declaracion implements Instruction {

    private String tipo;
    private Dato id;
    private TablaSimbolos simbolos;
    private TablaTipos tipos;
    private Integer ambito;
    private String valorFuncion = "";

    public Declaracion(String tipo, Dato id, TablaSimbolos simbolos, TablaTipos tipos) {
        this.tipo = tipo;
        this.id = id;
        this.simbolos = simbolos;
        this.tipos = tipos;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Dato getId() {
        return id;
    }

    public void setId(Dato id) {
        this.id = id;
    }

    public TablaSimbolos getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(TablaSimbolos simbolos) {
        this.simbolos = simbolos;
    }

    public TablaTipos getTipos() {
        return tipos;
    }

    public void setTipos(TablaTipos tipos) {
        this.tipos = tipos;
    }

    

    @Override
    public void setAmbit(int ambito) {
        this.ambito = ambito;
    }
    
    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
    }

    @Override
    public boolean validate() {
        boolean bandera = true;

        if (tipo.equals("void")) {
            CErrores.agregarError("SEMANTICO", "TIPO_VOID",id ,ambito,"VARIABLE",
                            id.getNombre().getLine(), id.getNombre().getColumn(),
                            "LA VARIABLE CON ID "+id.getNombre().getLexeme()+", SE LE ESTA TRATANDO DE ASIGNAR UN TIPO void, ESE TIPO SOLO ES VALIDO PARA SUBPROGRAMAS.");
            bandera = false;
        }

        if (simbolos.existsInAmbit(id.getNombre().getLexeme(), ambito, "VARIABLE")) {
             CErrores.agregarError("SEMANTICO", "DECLARACION", id, ambito, "VARIABLE",
                        id.getNombre().getLine(), id.getNombre().getColumn(),
                        "LA VARIABLE CON ID " + id.getNombre().getLexeme() + ", YA EXISTE EN LA TABLA DE SIMBOLOS");

            bandera = false;
        } 
        
        if(bandera){
            Simbolos sim = new Simbolos(id.getNombre().getLexeme(),"VARIABLE", tipo, ambito);
            simbolos.addElementInAmbit(sim);
        }

        return bandera;

    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        
        lista.add(Cuarteto.makeDeclaracion(tipo,id.getNombre().getLexeme()+valorFuncion, Integer.toString(ambito)));
        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        return false;
    }

    

}
