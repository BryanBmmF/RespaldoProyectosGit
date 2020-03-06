/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import CErrores.CErrores;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Valores.Temporales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class ExpresionUnica implements Expresion {

    private Logica logica = new Logica();
    private Dato literalValue;
    private Integer ambito;
    private String tipoExpresion;
    private TablaSimbolos table;
    private TablaTipos tablaTipos;
    private boolean tieneString;
    private String tipoDato;
    private String valorFuncion = "";

    public ExpresionUnica(Dato literalValue) {
        logica = new Logica();
        this.literalValue = literalValue;
    }

    public Dato getLiteralValue() {
        return literalValue;
    }

    public void setLiteralValue(Dato literalValue) {
        this.literalValue = literalValue;
    }

    public String getTipoExpresion() {
        return tipoExpresion;
    }

    public void setTipoExpresion(String tipoExpresion) {
        this.tipoExpresion = tipoExpresion;
    }

    public TablaSimbolos getTable() {
        return table;
    }

    public void setTable(TablaSimbolos table) {
        this.table = table;
    }

    public TablaTipos getTablaTipos() {
        return tablaTipos;
    }

    public void setTablaTipos(TablaTipos tablaTipos) {
        this.tablaTipos = tablaTipos;
    }

    public boolean isTieneString() {
        return tieneString;
    }

    public void setTieneString(boolean tieneString) {
        this.tieneString = tieneString;
    }

    @Override
    public void asignarAmbito(int ambito) {
        this.ambito = ambito;
    }

    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
    }

    @Override
    public String validarClases(TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        this.table = tablaSimbolos;
        this.tablaTipos = tablaTipos;

        return getValue();
    }

    private String getValue() {
        if (literalValue != null) {
            if (literalValue.getTipo().equals("VARIABLE")) {
                String value = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "VARIABLE");
                if (value != null) {
                    return value;
                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "VARIABLE", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE LA VARIABLE: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION UNICA");

                    return null;
                }
            } else if (literalValue.getTipo().equals("ARREGLO")) {
                String value = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "ARREGLO");
                if (value != null) {
                    List<ExpresionAritmetica> lista = (List<ExpresionAritmetica>) literalValue.getLexema();
                    logica.asignarAmbitoExpresionesArreglo(lista, this.ambito);
                    for (int i = 0; i < lista.size(); i++) {
                        String tipo = lista.get(i).validarClases(table, tablaTipos);
                        if (tipo != null) {
                            if (!tipo.equals("Long") && !tipo.equals("Integer") && !tipo.equals("Byte")) {
                                CErrores.agregarError("SEMANTICO", "ERROR_DIMENSION_ARREGLO", null, null, "ARREGLO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "DIMENSION DEL ARREGLO: " + literalValue.getNombre().getLexeme() + " NO ES DE TIPO ENTERO, EN LA OPERACION UNICA");

                                return null; // mostrar que la expresion no es de tipo numerica entera
                            }
                        } else {
                            return null;
                        }

                    }
                    List<String> list = table.dimensionesArreglo(literalValue.getNombre().getLexeme(), ambito);
                    if (list != null) {
                        if (list.size() != lista.size()) {
                            CErrores.agregarError("SEMANTICO", "DIMENSION_ARREGLO", literalValue, ambito, "ARREGLO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "LAS DIMENSIONES DEL ARREGLO: " + literalValue.getNombre().getLexeme() + " NO SON LAS MISMAS. TAMANO DEL ARREGLO: " + list.size() + ", TAMANO EN LA OPERACION: " + lista.size() + ". ERROR EN LA OPERACION UNICA");

                            return null;// mostrar que el tamano del arreglo no es el mismo
                        }
                    } else {
                        return null;
                    }

                    return value;
                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "ARREGLO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE EL ARREGLO: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION UNICA");

                    return null;
                }
            } else if (literalValue.getTipo().equals("PARAMETRO")) {
                String value = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "PARAMETRO");
                if (value != null) {
                    return value;
                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "PARAMETRO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE EL PARAMETRO: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION UNICA");
                    return null;
                }

            } else if (literalValue.getTipo().equals("SUBPROGRAMA")) {
                String value = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "SUBPROGRAMA");
                if (value != null) {// validar nombre
                    List<String> listaParametros = table.parametrosFuncion(literalValue.getNombre().getLexeme());
                    List<String> listaFuncion = new ArrayList<>();
                    List<Expresion> expresiones = (List<Expresion>) literalValue.getLexema();
                    logica.asignarAmbitoExpresionesFuncion(expresiones, this.ambito);
                    if (listaParametros != null && expresiones != null && expresiones.size() == listaParametros.size()) {//validar numero parametros
                        for (int i = 0; i < expresiones.size(); i++) {
                            String valor = expresiones.get(i).validarClases(table, tablaTipos);
                            if (expresiones.get(i).validarParametroFuncion(literalValue.getNombre().getLexeme(), table, tablaTipos)) {//validar que no exista recursion 
                                if (valor != null) {
                                    listaFuncion.add(valor);
                                }
                            } else {
                                CErrores.agregarError("SEMANTICO", "RECURSION", literalValue, ambito, "SUBPROGRAMA",
                                        literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(),
                                        "EN EL SUBPROGRAMA:  " + literalValue.getNombre().getLexeme() + " EXISTE RECURSION, NO ES VALIDA");

                                return null;
                            }
                        }

                        for (int i = 0; i < listaFuncion.size() && listaFuncion.size() == listaParametros.size(); i++) {
                            if (!logica.validarDosDatosParametros(listaParametros.get(i), listaFuncion.get(i), tablaTipos)) {//validar que cada parametro sea concordante con el que pide la funcion
                                CErrores.agregarError("SEMANTICO", "COINCIDENCIA_PARAMETROS", literalValue, ambito, "SUBPROGRAMA",
                                        literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(),
                                        "EL PARAMETRO DEL SUBPROGRAMA: " + literalValue.getNombre().getLexeme() + " NO CONCUERDAN EN EL TIPO QUE ES. " + listaFuncion.get(i) + ", DEBERIA DE SER TIPO: " + listaParametros.get(i) + "  EN LA OPERACION UNICA");

                                return null;
                            }
                        }

                        return value;//manda valor
                    } else {
                        CErrores.agregarError("SEMANTICO", "NUMERO_PARAMETROS_FUNCION", literalValue, ambito, "SUBPROGRAMA", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "LOS PARAMETROS DEL SUBPROGRAMA: " + literalValue.getNombre().getLexeme() + " NO SON LOS MISMOS");
                        return null;
                    }

                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "SUBPROGRAMA", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE EL SUBPROGRAMA: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION UNICA");
                    return null;
                }

            } else {
                return literalValue.getTipo();
            }

        } else {
            return null;
        }

    }

    @Override
    public boolean validarParametroFuncion(String nombre, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        return !(literalValue.getTipo().equals("SUBPROGRAMA") && literalValue.getNombre().getLexeme().equals(nombre));
    }

    @Override
    public List<Cuarteto> execute() {
        String valor = validarClases(table, tablaTipos);
        asignarTipoDato(valor);
        return generar3D();
    }

    public List<Cuarteto> generar3D() {

        switch (literalValue.getTipo()) {
            case "VARIABLE":
                return generar3DVariable("VARIABLE");
            case "ARREGLO":
                return generar3DArreglo();
            case "SUBPROGRAMA":
                return generar3DSubprograma();
            case "PARAMETRO":
                return generar3DVariable("PARAMETRO");
            default:
                return generar3DNormal();
        }

    }

    public List<Cuarteto> generar3DNormal() {
        List<Cuarteto> lista = new ArrayList<>();
        Cuarteto cuarteto;
        cuarteto = Cuarteto.MakeOperacionIgualAsignacion(Temporales.siguienteTemporal(tipoDato), literalValue.getNombre().getLexeme(), ambito + "", tipoDato, literalValue.getTipo());
        lista.add(cuarteto);
        return lista;
    }

    public List<Cuarteto> generar3DVariable(String tipo) {
        List<Cuarteto> lista = new ArrayList<>();
        Cuarteto cuarteto;
        int value = table.getIdAmbit(literalValue.getNombre().getLexeme(), ambito, tipo);
        String tipoVar = table.getIdType(literalValue.getNombre().getLexeme(), ambito, tipo);
        String valorMandar = "";
        if (value == ambito) {
            valorMandar = valorFuncion;
        }
        cuarteto = Cuarteto.MakeOperacionIgualAsignacion(Temporales.siguienteTemporal(tipoDato), literalValue.getNombre().getLexeme() + valorMandar, value + "", tipoDato, tipoVar);
        lista.add(cuarteto);
        return lista;
    }

    public List<Cuarteto> generar3DArreglo() {
        List<Cuarteto> lista = new ArrayList<>();
        List<Cuarteto> lista1 = new ArrayList<>();
        List<Cuarteto> lista2;
        List<Expresion> expresiones = (List<Expresion>) literalValue.getLexema();// expresiones que vienen del arreglo

        List<String> tamanos = table.dimensionesArreglo(literalValue.getNombre().getLexeme(), ambito);//tamanos del arreglo
        List<String> arregloTam = new ArrayList<>();// expresiones convertidas a tamanos
        Cuarteto cuarteto;
        if (expresiones.size() > 1) {

            for (int i = 0; i < expresiones.size(); i++) {
                lista1 = expresiones.get(i).execute();
                arregloTam.add(logica.returnUltimoTemporalExpresionValorT(lista1));
                Cuarteto.unirCuartetos(lista, lista1);
            }

            String unaDimension = logica.operarDimensiones(tamanos, arregloTam, lista, tipoDato, "Long");
            int value = table.getIdAmbit(literalValue.getNombre().getLexeme(), ambito, "ARREGLO");
            String val = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "ARREGLO");
            String valorMandar = "";
            if (value == ambito) {
                valorMandar = valorFuncion;
            }
            cuarteto = Cuarteto.MakeOperacionIgualAsignacionArreglo(Temporales.siguienteTemporal(tipoDato), literalValue.getNombre().getLexeme() + valorMandar, Integer.toString(value), unaDimension, tipoDato, val);
            lista.add(cuarteto);
        } else {
            lista1 = expresiones.get(0).execute();
            String valor = logica.returnUltimoTemporalExpresionValorT(lista1);
            int value = table.getIdAmbit(literalValue.getNombre().getLexeme(), ambito, "ARREGLO");
            String val = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "ARREGLO");
            String valorMandar = "";
            if (value == ambito) {
                valorMandar = valorFuncion;
            }

            cuarteto = Cuarteto.MakeOperacionIgualAsignacionArreglo(Temporales.siguienteTemporal(tipoDato), literalValue.getNombre().getLexeme() + valorMandar, Integer.toString(value), valor, tipoDato, val);
            lista1.add(cuarteto);
            Cuarteto.unirCuartetos(lista, lista1);

        }

        return lista;
    }

    public List<Cuarteto> generar3DSubprograma() {
        List<Cuarteto> lista = new ArrayList<>();

        List<Cuarteto> lista1;
        List<Expresion> expresiones = (List<Expresion>) literalValue.getLexema();
        List<String> temporalesParametros = new ArrayList<>();
        Cuarteto cuarteto;
        for (int i = 0; i < expresiones.size(); i++) {
            lista1 = expresiones.get(i).execute();
            temporalesParametros.add(logica.returnUltimoTemporalExpresionValorT(lista1));
            Cuarteto.unirCuartetos(lista, lista1);
        }

        for (int i = 0; i < temporalesParametros.size(); i++) {
            cuarteto = Cuarteto.MakeParam(temporalesParametros.get(i));
            lista.add(cuarteto);
        }

        cuarteto = Cuarteto.MakeCall(literalValue.getNombre().getLexeme(), temporalesParametros.size() + "", Temporales.siguienteTemporal(tipoDato));
        lista.add(cuarteto);
        return lista;
    }

    public void asignarTipoDato(String tipo) {
        this.tipoDato = tipo;

    }

    public String getValorFuncion() {
        return valorFuncion;
    }

    public void setValorFuncion(String valorFuncion) {
        this.valorFuncion = valorFuncion;
    }

}
