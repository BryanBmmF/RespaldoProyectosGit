/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import CErrores.CErrores;
import Objetos.Cuarteto;
import Objetos.Dato;
import Objetos.ExpresionUnica;
import Objetos.Token;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Scann implements Instruction {

    ExpresionUnica id;
    TablaSimbolos tablaSimbolos;
    TablaTipos tablaTipos;
    private Token token;
    int ambito;
    String valorFuncion = "";

    public Scann(ExpresionUnica id, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos, Token token) {
        this.id = id;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
        this.token = token;
    }

    public ExpresionUnica getId() {
        return id;
    }

    public void setId(ExpresionUnica id) {
        this.id = id;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    public TablaTipos getTablaTipos() {
        return tablaTipos;
    }

    public void setTablaTipos(TablaTipos tablaTipos) {
        this.tablaTipos = tablaTipos;
    }

    @Override
    public void setAmbit(int ambito) {
        this.id.asignarAmbito(ambito);
        
    }
    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
    }


    @Override
    public boolean validate() {
        String valor = id.validarClases(tablaSimbolos, tablaTipos);
        if (valor != null && (valor.equals("Long") || valor.equals("Integer") || valor.equals("Byte") || valor.equals("Float") || valor.equals("Double"))) {
            return true;
        }
        CErrores.agregarError("SEMANTICO", "SCANN", null, null, null,
                token.getLine(), token.getColumn(),
                "PROBLEMAS CON LA SENTENCIA SCANN, NO ES DE TIPO NUMERICO");

        return false;
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        String val = id.getLiteralValue().getNombre().getLexeme();
        lista.add(Cuarteto.MakeScann(val));
        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        return false;
    }

    
}
