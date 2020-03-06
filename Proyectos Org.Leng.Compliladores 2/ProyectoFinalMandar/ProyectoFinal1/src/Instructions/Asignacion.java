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
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Asignacion implements Instruction {

    private Dato id;
    private Integer ambito;
    private Expresion expresion;
    private Logica logica;
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private String valorFuncion = "";

    public Asignacion(Dato id, Expresion expresion, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        this.id = id;
        this.expresion = expresion;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
        logica = new Logica();
    }

    @Override
    public void setAmbit(int ambito) {
        this.ambito = ambito;
        this.expresion.asignarAmbito(ambito);
    }

    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
        this.expresion.asignarValorFuncion(idFuncion);
    }

    @Override
    public boolean validate() {
        boolean bandera = true;

        String tipo = tablaSimbolos.getIdType(id.getNombre().getLexeme(), ambito, "VARIABLE");
        if (tipo == null) {
            CErrores.agregarError("SEMANTICO", "BUSQUEDA", id, ambito, "VARIABLE",
                    id.getNombre().getLine(), id.getNombre().getColumn(),
                    "LA VARIABLE CON ID " + id.getNombre().getLexeme() + " ,NO EXISTE EN LA TABLA DE SIMBOLOS");

            bandera = false;
        } else {
            if (tipo.equals("void")) {
                CErrores.agregarError("SEMANTICO", "TIPO_VOID", id, ambito, "ARREGLO",
                        id.getNombre().getLine(), id.getNombre().getColumn(),
                        "EL ARREGLO CON ID " + id.getNombre().getLexeme() + " NO PUEDE TENER TIPO void, ES SOLO DE SUBPROGRAMAS");
                bandera = false;
            }
            String valor = expresion.validarClases(tablaSimbolos, tablaTipos);
            if (valor != null) {
                String resultado = logica.compararClases(tipo, valor, tablaTipos);
                if (resultado == null) {
                    CErrores.agregarError("SEMANTICO", "TIPO_ASIGNACION", id, ambito, "VARIABLE",
                            id.getNombre().getLine(), id.getNombre().getColumn(),
                            "LA VARIABLE CON ID " + id.getNombre().getLexeme() + " ES DE TIPO " + tipo + ", Y SE LE ESTA TRATANDO DE ASIGNAR UN VALOR TIPO " + valor);
                    bandera = false;
                    bandera = false;
                }
            } else {
                bandera = false;
            }

        }
        return bandera;
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        List<Cuarteto> aux;

        Cuarteto cuarteto;
        aux = expresion.execute();
        Cuarteto.unirCuartetos(lista, aux);
        String temporal = logica.returnUltimoTemporalExpresionValorT(aux);
        int value = tablaSimbolos.getIdAmbit(id.getNombre().getLexeme(), ambito, "VARIABLE");
        String tipo = tablaSimbolos.getIdType(id.getNombre().getLexeme(), ambito, "VARIABLE");
        
        cuarteto = Cuarteto.MakeAsignacion(id.getNombre().getLexeme(), temporal, value + "", tipo);

        lista.add(cuarteto);

        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo, String tSalida) {
        return false;
    }

}
