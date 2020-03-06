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
public class Println implements Instruction {

    protected List<Expresion> lista;
    protected TablaSimbolos tablaSimbolo;
    protected TablaTipos tablaTipos;
    protected Token token;
    protected Logica logica = new Logica();

    public Println(List<Expresion> lista, TablaSimbolos tablaSimbolo, TablaTipos tablaTipos, Token token) {
        this.lista = lista;
        this.tablaSimbolo = tablaSimbolo;
        this.tablaTipos = tablaTipos;
        this.token = token;
        logica = new Logica();
    }

    @Override
    public void setAmbit(int ambito) {
        for (int i = 0; i < this.lista.size(); i++) {
            lista.get(i).asignarAmbito(ambito);
        }
    }

    @Override
    public void asignarValorFuncion(String idFuncion) {
        for (int i = 0; i < this.lista.size(); i++) {
            lista.get(i).asignarValorFuncion(idFuncion);
        }
    }

    @Override
    public boolean validate() {
        boolean bandera = true;
        for (int i = 0; i < lista.size(); i++) {
            String valor = lista.get(i).validarClases(tablaSimbolo, tablaTipos);
            if (valor == null) {
                bandera = false;
            }
        }
        if (!bandera) {
            CErrores.agregarError("SEMANTICO", "PRINTLN", null, null, null,
                    token.getLine(), token.getColumn(),
                    "PROBLEMAS CON LA SENTENCIA PRINTLN");

        }
        return bandera;
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        List<Cuarteto> lista1;
        for (int i = 0; i < this.lista.size(); i++) {
            lista1 = this.lista.get(i).execute();
            String tipo = this.lista.get(i).validarClases(tablaSimbolo, tablaTipos);
            String valor = logica.returnUltimoTemporalExpresionValorT(lista1);
            Cuarteto.unirCuartetos(lista, lista1);
            lista.add(Cuarteto.MakePrintLn(valor, tipo));
        }

        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        return false;
    }

}
