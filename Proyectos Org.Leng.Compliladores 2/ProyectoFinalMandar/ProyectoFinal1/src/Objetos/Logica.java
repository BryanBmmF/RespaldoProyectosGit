/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import java.util.List;
import Instructions.Instruction;
import Instructions.Return;
import Tablas.TablaTipos.Tipos;
import Tablas.TablaSimbolos.*;
import Valores.Temporales;
import Valores.VariableT;
import java.util.ArrayList;

/**
 *
 * @author jpmazate
 */
public class Logica {

    public void operar(List<Instruction> instructions, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {

        List<Cuarteto> cuartetos = new ArrayList<>(), aux;
        for (int i = 0; i < instructions.size(); i++) {
            aux = instructions.get(i).execute();
            Cuarteto.unirCuartetos(cuartetos, aux);
        }
        List<CErrores.CError> listado = CErrores.CErrores.getListaErrores();
        List<Cuarteto> c = new ArrayList<>();

        if (listado.isEmpty()) {
            List<VariableT> temporales = Temporales.getListado();
            List<Simbolos> variablesGlobales = tablaSimbolos.getVariables("VARIABLE", 0);
            for (int i = 0; i < temporales.size(); i++) {
                c.add(Cuarteto.makeDeclaracion(temporales.get(i).getTipo(), temporales.get(i).getValorT(), 0 + ""));

            }
            Cuarteto.unirCuartetos(c, cuartetos);

            for (int i = 0; i < c.size(); i++) {
                System.out.println(c.get(i).makeC() + "\n");
            }

        }

    }

    public String inicioCodigoC() {
        String encabezado;
        encabezado = "\n"
                + "#include <stdio.h>\n"
                + "#include <stdlib.h>\n"
                + "#include <string.h>\n"
                + "\n"
                + "\n"
                + " \n"
                + " \n"
                + "int main(int argc, char** argv) {";
        return encabezado;
    }

    public String finCodigoC() {
        String pie;
        pie = "\nreturn (EXIT_SUCCESS);\n"
                + "}";
        return pie;
    }

    public String compararClases(String operador1, String operador2, TablaTipos tablaTipos) {

        if (operador1 == null || operador2 == null) {
            return null;
        }
        Boolean valor = tablaTipos.pertenecenAlMismoDato(operador1, operador2);
        if (valor != null) {
            if (valor) {
                Tipos tipoUno = tablaTipos.returnTipo(operador1);
                Tipos tipoDos = tablaTipos.returnTipo(operador2);

                if (tipoUno != null && tipoDos != null) {
                    if (tipoUno.getNumeroElemento() >= tipoDos.getNumeroElemento()) {
                        return tipoUno.getNombre();
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } else {
            return null;
        }
    }

    public static TablaTipos crearTabla() {

        TablaTipos tipos = new TablaTipos();
        Tipos tvoid = new Tipos(0, "Void", 0, "Void", "Void", "Void");
        Tipos tstring = new Tipos(1, "String", 0, "String", "String", "String");
        Tipos tbyte = new Tipos(3, "Byte", 0, "Number", "Byte", "Number");
        Tipos tint = new Tipos(4, "Integer", 0, "Number", "Integer", "Number");
        Tipos tlong = new Tipos(5, "Long", 0, "Number", "Long", "Number");
        Tipos tfloat = new Tipos(6, "Float", 0, "Number", "Float", "Number");
        Tipos tdouble = new Tipos(7, "Double", 0, "Number", "Double", "Number");
        Tipos tboolean = new Tipos(8, "Boolean", 0, "Boolean", "Boolean", "Boolean");

        tipos.addElement(tvoid);
        tipos.addElement(tstring);
        tipos.addElement(tbyte);
        tipos.addElement(tint);
        tipos.addElement(tlong);
        tipos.addElement(tfloat);
        tipos.addElement(tdouble);
        tipos.addElement(tboolean);

        return tipos;
    }

    public void removerParametros(List<String> nombres, int ambito, TablaSimbolos table) {
        List<Simbolos> tabla = table.getTable();
        for (int i = 0; i < nombres.size(); i++) {
            for (int j = 0; j < tabla.size(); j++) {
                if (tabla.get(j).getNombre().equals(nombres.get(i)) && tabla.get(j).getAmbito() == ambito && tabla.get(j).getCategoria().equals("PARAMETRO")) {
                    tabla.remove(j);
                    break;
                }
            }
        }
    }

    public void removerFuncion(String nombre, TablaSimbolos table) {
        List<Simbolos> tabla = table.getTable();
        for (int i = 0; i < tabla.size(); i++) {
            if (tabla.get(i).getNombre().equals(nombre) && tabla.get(i).getCategoria().equals("SUBPROGRAMA")) {
                tabla.remove(i);
                break;
            }
        }
    }

    public boolean validarDosDatosParametros(String uno, String dos, TablaTipos tipos) {
        String valor = compararClases(uno, dos, tipos);
        if (valor != null) {
            return valor.equals(uno);
        }

        return false;
    }

    public void asignarAmbitoExpresionesFuncion(List<Expresion> expr, int ambito) {
        for (int i = 0; i < expr.size(); i++) {
            expr.get(i).asignarAmbito(ambito);

        }
    }

    public void asignarAmbitoExpresionesArreglo(List<ExpresionAritmetica> expr, int ambito) {
        for (int i = 0; i < expr.size(); i++) {
            expr.get(i).asignarAmbito(ambito);

        }
    }

    public String returnUltimoTemporalExpresionValorT(List<Cuarteto> lista1) {
        String valorT = lista1.get(lista1.size() - 1).getValorT();
        if (valorT == null) {
            valorT = lista1.get(lista1.size() - 3).getValorT();
            return valorT;
        } else {
            return valorT;
        }
    }

    public String returnUltimoTemporalExpresionResultado(List<Cuarteto> lista1) {
        return lista1.get(lista1.size() - 1).getResultado();
    }

    public String returnUltimoTemporalCondicion(List<Cuarteto> lista1) {
        try {
            String valor = lista1.get(lista1.size() - 3).getValorT();
            return valor;
        } catch (Exception e) {
            return lista1.get(lista1.size() - 1).getValorT();
        }

    }

    public List<String> listadoTemporales(int tamano) {
        List<String> valores = new ArrayList<>();
        for (int i = 0; i < tamano; i++) {
            valores.add(Temporales.siguienteTemporal("Long"));
        }
        return valores;
    }

    public String operarDimensiones(List<String> tamanos, List<String> valores, List<Cuarteto> lista, String tipoDato, String tipoOperacion) {
        String valor;
        String dimension;
        String temporal = "";
        String temporalSiguiente;
        List<String> temporalesSumar = new ArrayList<>();
        for (int i = 0; i < valores.size(); i++) {
            valor = valores.get(i);
            if (i + i < valores.size()) {
                boolean bandera = true;
                for (int k = i + 1; k < valores.size(); k++) {
                    dimension = tamanos.get(k);
                    if (bandera) {
                        temporal = Temporales.siguienteTemporal("Long");
                        multiplicarDimensiones(valor, dimension, temporal, lista, tipoDato, tipoOperacion);
                        bandera = false;
                    } else {
                        temporalSiguiente = Temporales.siguienteTemporal("Long");
                        multiplicarDimensiones(temporal, dimension, temporalSiguiente, lista, tipoDato, tipoOperacion);
                        temporal = temporalSiguiente;
                    }

                }
            } else {
                temporal = valor;
            }
            temporalesSumar.add(temporal);
        }
        boolean bandera = true;

        for (int i = 0; i < temporalesSumar.size(); i++) {
            if (i + 1 < temporalesSumar.size()) {
                if (bandera) {
                    temporal = Temporales.siguienteTemporal("Long");
                    sumarDimensiones(temporalesSumar.get(i), temporalesSumar.get(i + 1), temporal, lista, tipoDato, tipoOperacion);
                    bandera = false;
                } else {
                    temporalSiguiente = Temporales.siguienteTemporal("Long");
                    sumarDimensiones(temporal, temporalesSumar.get(i + 1), temporalSiguiente, lista, tipoDato, tipoOperacion);
                    temporal = temporalSiguiente;
                }
            }
        }
        return temporal;
    }

    public void multiplicarDimensiones(String valor, String dimension, String temporal, List<Cuarteto> lista, String tipoDato, String datoOperacion) {
        Cuarteto cuarteto = Cuarteto.MakeOperacion(tipoDato, temporal, "*", valor, dimension, datoOperacion);
        lista.add(cuarteto);
    }

    public void sumarDimensiones(String valor1, String valor2, String temporal, List<Cuarteto> lista, String tipoDato, String datoOperacion) {
        Cuarteto cuarteto = Cuarteto.MakeOperacion(tipoDato, temporal, "+", valor1, valor2, datoOperacion);
        lista.add(cuarteto);
    }

    public boolean asignarReturn(List<Instruction> lista, String tipo,String tSalida) {
        boolean bandera=false,bandera2;
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i) instanceof Return) {
                Return r =(Return) lista.get(i);
                r.setTipoReturn(tipo);
                r.settSalida(tSalida);
                bandera = true;
            } else {
                bandera2  = lista.get(i).asignarReturn(tipo,tSalida);
                if(!bandera && bandera2){
                    bandera = true;
                }
            }

        }
        return bandera;
    }

}
