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
import Objetos.ExpresionAritmetica;
import Objetos.Logica;
import Objetos.Token;
import Tablas.TablaSimbolos.Simbolos;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Valores.Temporales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class AsignacionArreglo implements Instruction {

    private Dato id;
    private List<ExpresionAritmetica> expresiones;
    private Expresion expresionAsignacion;
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private Integer ambito;
    private Logica logica;
    private String valorFuncion = "";

    public AsignacionArreglo(Dato id, List<ExpresionAritmetica> expresiones, Expresion expresionAsignacion, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        this.id = id;
        this.expresiones = expresiones;
        this.expresionAsignacion = expresionAsignacion;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
        this.logica = new Logica();
    }

    @Override
    public void setAmbit(int ambito) {
        this.ambito = ambito;
        this.expresionAsignacion.asignarAmbito(ambito);
        for (int i = 0; i < expresiones.size(); i++) {
            expresiones.get(i).asignarAmbito(ambito);
        }

    }

    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
        this.expresionAsignacion.asignarValorFuncion(idFuncion);
        for (int i = 0; i < expresiones.size(); i++) {
            expresiones.get(i).asignarValorFuncion(idFuncion);
        }

    }

    @Override
    public boolean validate() {
        boolean bandera = true;
        String tipo = tablaSimbolos.getIdType(id.getNombre().getLexeme(), ambito, "ARREGLO");
        if (tipo == null) {
            CErrores.agregarError("SEMANTICO", "BUSQUEDA", id, ambito, "ARREGLO",
                    id.getNombre().getLine(), id.getNombre().getColumn(),
                    "EL ARREGLO CON ID " + id.getNombre().getLexeme() + " ,NO EXISTE EN LA TABLA DE SIMBOLOS");

            bandera = false;
        }
        for (int i = 0; i < expresiones.size(); i++) {
            String valor = expresiones.get(i).validarClases(tablaSimbolos, tablaTipos);
            if (valor != null) {
                if (!valor.equals("Byte") && !valor.equals("Integer") && !valor.equals("Long")) {
                    CErrores.agregarError("SEMANTICO", "ERROR_DIMENSION_ARREGLO", id, ambito, "ARREGLO",
                            id.getNombre().getLine(), id.getNombre().getColumn(),
                            "LA EXPRESION DE UNA DIMENSION DEL ARREGLO CON ID " + id.getNombre().getLexeme() + ", NO ES DE TIPO NUMERICO ENTERO");
                    bandera = false;
                }
            }
        }
        String valor = expresionAsignacion.validarClases(tablaSimbolos, tablaTipos);
        if (valor != null) {
            if (tipo != null) {
                String resultado = logica.compararClases(tipo, valor, tablaTipos);
                if (resultado == null) {
                    CErrores.agregarError("SEMANTICO", "TIPO_ASIGNACION", id, ambito, "ARREGLO",
                            id.getNombre().getLine(), id.getNombre().getColumn(),
                            "EL ARREGLO CON ID " + id.getNombre().getLexeme() + " ES DE TIPO " + tipo + ", Y SE LE ESTA TRATANDO DE ASIGNAR UN VALOR TIPO " + valor);
                    bandera = false;
                }
            }
        } else {
            bandera = false;
        }

        List<String> list = tablaSimbolos.dimensionesArreglo(id.getNombre().getLexeme(), ambito);
        if (list.size() != expresiones.size()) {
            CErrores.agregarError("SEMANTICO", "DIMENSION_ARREGLO", null, ambito, "ARREGLO", id.getNombre().getLine(), id.getNombre().getColumn(), "LAS DIMENSIONES DEL ARREGLO: " + id.getNombre().getLexeme() + " NO SON LAS MISMAS. TAMANO DEL ARREGLO: " + list.size() + ", TAMANO EN LA OPERACION: " + expresiones.size() + ". ERROR EN LA ASIGNACION");
        }

        return bandera;
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        List<Cuarteto> lista1 = new ArrayList<>();
        List<Cuarteto> lista2;

        String tipoDato = tablaSimbolos.getIdType(id.getNombre().getLexeme(), ambito, "ARREGLO");
        String unaDimension;

        List<String> tamanos = tablaSimbolos.dimensionesArreglo(id.getNombre().getLexeme(), ambito);//tamanos del arreglo
        List<String> arregloTam = new ArrayList<>();// expresiones convertidas a tamanos
        Cuarteto cuarteto;
        if (expresiones.size() > 1) {
            for (int i = 0; i < expresiones.size(); i++) {
                lista1 = expresiones.get(i).execute();
                arregloTam.add(logica.returnUltimoTemporalExpresionValorT(lista1));
                Cuarteto.unirCuartetos(lista, lista1);
            }
            unaDimension = logica.operarDimensiones(tamanos, arregloTam, lista, tipoDato, "Long");
        } else {
            lista1 = expresiones.get(0).execute();
            String valor = logica.returnUltimoTemporalExpresionValorT(lista1);
            unaDimension = valor;

        }

        List<Cuarteto> resultado = expresionAsignacion.execute();
        String t = logica.returnUltimoTemporalExpresionValorT(resultado);
        Cuarteto.unirCuartetos(lista, resultado);
        int value = tablaSimbolos.getIdAmbit(id.getNombre().getLexeme(), ambito, "ARREGLO");
        String valorMandar = "";
        if (value == ambito) {
            valorMandar = valorFuncion;
        }

        lista.add(Cuarteto.MakeAsignacionArreglo(id.getNombre().getLexeme() + valorMandar, t, value + "", unaDimension, tipoDato));

        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo, String tSalida) {
        return false;
    }

}
