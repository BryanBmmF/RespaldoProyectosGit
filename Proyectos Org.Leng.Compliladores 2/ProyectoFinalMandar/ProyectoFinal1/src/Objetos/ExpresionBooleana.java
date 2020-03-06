/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import CErrores.CErrores;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Tablas.TablaTipos.Tipos;
import Valores.Etiquetas;
import Valores.Temporales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class ExpresionBooleana implements Expresion {

    private Logica logica = new Logica();
    private Token operator;
    private ExpresionBooleana left;
    private ExpresionBooleana right;
    private Dato literalValue;
    private Condicion valorCondicion;
    private TablaSimbolos table;
    private TablaTipos tablaTipos;
    private Integer ambito;
    private String tipoDato;
    private String valorFuncion = "";

    public ExpresionBooleana(Token operator, ExpresionBooleana left, ExpresionBooleana right) {
        this.logica = new Logica();
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public ExpresionBooleana(Token operator, ExpresionBooleana right) {
        this.logica = new Logica();
        this.operator = operator;
        this.right = right;
    }

    public ExpresionBooleana(Dato literalValue) {
        this.logica = new Logica();
        this.literalValue = literalValue;
    }

    public ExpresionBooleana(Condicion condicion) {
        this.logica = new Logica();

        this.valorCondicion = condicion;
    }

    public Token getOperator() {
        return operator;
    }

    public ExpresionBooleana getLeft() {
        return left;
    }

    public ExpresionBooleana getRight() {
        return right;
    }

    public Dato getLiteralValue() {
        return literalValue;
    }

    public void setLiteralValue(Dato literalValue) {
        this.literalValue = literalValue;
    }

    public Condicion getValorCondicion() {
        return valorCondicion;
    }

    public void setValorCondicion(Condicion valorCondicion) {
        this.valorCondicion = valorCondicion;
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

    @Override
    public void asignarAmbito(int ambito) {
        this.ambito = ambito;
        if (valorCondicion != null) {
            valorCondicion.asignarAmbito(ambito);
        }
        if (left != null) {
            left.asignarAmbito(ambito);
        }
        if (right != null) {
            right.asignarAmbito(ambito);
        }

    }

    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;

        if (valorCondicion != null) {
            valorCondicion.asignarValorFuncion(idFuncion);
        }
        if (left != null) {
            left.asignarValorFuncion(idFuncion);
        }
        if (right != null) {
            right.asignarValorFuncion(idFuncion);
        }
    }

    @Override
    public String validarClases(TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        asignarTablas(tablaTipos, tablaSimbolos);
        return operarClases();
    }

    public void asignarTablas(TablaTipos tipos, TablaSimbolos simbolos) {
        this.tablaTipos = tipos;
        this.table = simbolos;
        if (left != null) {
            left.asignarTablas(tipos, simbolos);
        }
        if (right != null) {
            right.asignarTablas(tipos, simbolos);
        }

    }

    public String operarClases() {
        if (operator != null && operator.getLexeme().equals("AND")) {

            String izquierda = left.operarClases();
            String derecha = right.operarClases();

            if (izquierda == null || derecha == null) {
                return null;
            }
            if ((izquierda.equals("Boolean") || izquierda.equals("Boolean")) && (derecha.equals("Boolean") || derecha.equals("Boolean"))) {
                return "Boolean";
            } else {
                return null;
            }

        } else if (operator != null && operator.getLexeme().equals("OR")) {

            String izquierda = left.operarClases();
            String derecha = right.operarClases();

            if (izquierda == null || derecha == null) {
                return null;
            }
            if (izquierda.equals("Boolean") && derecha.equals("Boolean")) {
                return "Boolean";
            } else if (izquierda.equals("Boolean") || derecha.equals("Boolean")) {
                return "Boolean";
            } else {
                return null;
            }

        } else if (operator != null && operator.getLexeme().equals("NOT")) {
            String derecha = right.operarClases();

            if (derecha == null) {
                return null;
            }
            if (derecha.equals("Boolean")) {
                return "Boolean";
            } else if (derecha.equals("Boolean")) {
                return "Boolean";
            } else {
                return null;
            }

        } else {

            return getValue();
        }

    }

    private String getValue() {
        if (literalValue != null) {
            if (literalValue.getTipo().equals("VARIABLE")) {
                String value = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "VARIABLE");
                if (value != null) {
                    if (value.equals("Boolean")) {
                        return "Boolean";
                    } else {
                        CErrores.agregarError("SEMANTICO", "TIPO_DATO", literalValue, ambito, "VARIABLE", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "LA VARIABLE: " + literalValue.getNombre().getLexeme() + " NO ES DE TIPO BOOLEAN ,EN LA OPERACION BOOLEANA");
                        return null;
                    }

                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "VARIABLE", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE LA VARIABLE: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION BOOLEANA");
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
                                CErrores.agregarError("SEMANTICO", "ERROR_DIMENSION_ARREGLO", null, null, "ARREGLO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "DIMENSION DEL ARREGLO: " + literalValue.getNombre().getLexeme() + " NO ES DE TIPO ENTERO, EN LA OPERACION BOOLEANA");
                                return null; // mostrar que la expresion no es de tipo numerica entera
                            }

                        } else {
                            return null;
                        }

                    }
                    List<String> list = table.dimensionesArreglo(literalValue.getNombre().getLexeme(), ambito);
                    if (list != null) {
                        if (list.size() != lista.size()) {
                            CErrores.agregarError("SEMANTICO", "DIMENSION_ARREGLO", literalValue, ambito, "ARREGLO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "LAS DIMENSIONES DEL ARREGLO: " + literalValue.getNombre().getLexeme() + " NO SON LAS MISMAS. TAMANO DEL ARREGLO: " + list.size() + ", TAMANO EN LA OPERACION: " + lista.size() + ". ERROR EN LA OPERACION BOOLEANA");
                            return null;// mostrar que el tamano del arreglo no es el mismo
                        }
                    } else {
                        return null;
                    }
                    if (value.equals("Boolean")) {
                        return "Boolean";
                    } else {
                        CErrores.agregarError("SEMANTICO", "TIPO_DATO", literalValue, ambito, "ARREGLO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "EL ARREGLO: " + literalValue.getNombre().getLexeme() + " NO ES DE TIPO BOOLEAN ,EN LA OPERACION BOOLEANA");

                        return null;
                    }

                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "ARREGLO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE EL ARREGLO: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION ARITMETICA");
                    return null;
                }
            } else if (literalValue.getTipo().equals("PARAMETRO")) {
                String value = table.getIdType(literalValue.getNombre().getLexeme(), ambito, "PARAMETRO");
                if (value != null) {
                    if (value.equals("Boolean")) {
                        return "Boolean";
                    } else {
                        CErrores.agregarError("SEMANTICO", "TIPO_DATO", literalValue, ambito, "PARAMETRO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "EL PARAMETRO: " + literalValue.getNombre().getLexeme() + " NO ES DE TIPO BOOLEAN ,EN LA OPERACION BOOLEANA");
                        return null;
                    }

                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "PARAMETRO", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE EL PARAMETRO: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION BOOLEANA");
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
                                        "EL PARAMETRO DEL SUBPROGRAMA: " + literalValue.getNombre().getLexeme() + " NO CONCUERDAN EN EL TIPO QUE ES. " + listaFuncion.get(i) + ", DEBERIA DE SER TIPO: " + listaParametros.get(i) + "  EN LA OPERACION BOOLEANA");

                                return null;
                            }
                        }
                        if (value.equals("Boolean")) {
                            return "Boolean";
                        } else {
                            CErrores.agregarError("SEMANTICO", "TIPO_DATO", literalValue, ambito, "SUBPROGRAMA", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "EL SUBPROGRAMA: " + literalValue.getNombre().getLexeme() + " NO ES DE TIPO BOOLEAN ,EN LA OPERACION BOOLEANA");

                            return null;
                        }
                    } else {
                        CErrores.agregarError("SEMANTICO", "NUMERO_PARAMETROS_FUNCION", literalValue, ambito, "SUBPROGRAMA", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "LOS PARAMETROS DEL SUBPROGRAMA: " + literalValue.getNombre().getLexeme() + " NO SON LOS MISMOS");
                        return null;
                    }

                } else {
                    CErrores.agregarError("SEMANTICO", "BUSQUEDA", literalValue, ambito, "SUBPROGRAMA", literalValue.getNombre().getLine(), literalValue.getNombre().getColumn(), "NO EXISTE EL SUBPROGRAMA: " + literalValue.getNombre().getLexeme() + " EN LA OPERACION ARITMETICA");

                    return null;
                }

            } else {
                return literalValue.getTipo();
            }

        } else if (valorCondicion != null) {
            return valorCondicion.validarClases(table, tablaTipos);

        } else {
            return null;
        }
    }

    @Override
    public boolean validarParametroFuncion(String nombre, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        if (operator != null) {
            if (!operator.getLexeme().equals("NOT")) {
                return left.validarParametroFuncion(nombre, tablaSimbolos, tablaTipos) && right.validarParametroFuncion(nombre, tablaSimbolos, tablaTipos);
            } else {
                return right.validarParametroFuncion(nombre, tablaSimbolos, tablaTipos);
            }
        }
        if (literalValue != null) {
            return !(literalValue.getTipo().equals("SUBPROGRAMA") && literalValue.getNombre().getLexeme().equals(nombre));
        } else if (valorCondicion != null) {
            return valorCondicion.validarParametroFuncion(nombre, tablaSimbolos, tablaTipos);
        }
        return false;
    }

    @Override
    public List<Cuarteto> execute() {
        String valor = validarClases(table, tablaTipos);
        asignarTipoDato(valor);
        return generar3D();
    }

    public List<Cuarteto> generar3D() {
        List<Cuarteto> lista, lista1, lista2;
        Cuarteto cuarteto, cuartetoIf1, cuartetoIf2, cuartetoGoto, cuartetoEtiqueta;
        String resultado1, resultado2;

        if (operator != null && operator.getLexeme().equals("AND")) {
            String etiquetaTrue = Etiquetas.siguienteEtiqueta();
            String etiquetaFalse = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();
            String etiqueta1 = Etiquetas.siguienteEtiqueta();
            String etiqueta2 = Etiquetas.siguienteEtiqueta();

            lista = new ArrayList<>();
            lista1 = left.generar3D();
            lista2 = right.generar3D();

            String valorFinal = Temporales.siguienteTemporal("Integer");
            if (lista1.get(lista1.size() - 1).getOperador() != null && lista1.get(lista1.size() - 1).getOperador().startsWith("ET")) {
                resultado1 = lista1.get(lista1.size() - 3).getValorT();
            } else {
                resultado1 = lista1.get(lista1.size() - 1).getValorT();
            }
            cuartetoIf1 = new Cuarteto();
            cuartetoIf1.setOperador("IF");
            cuartetoIf1.setResultado(resultado1);

            lista1.add(cuartetoIf1);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiqueta1);
            lista1.add(cuartetoGoto);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaFalse);
            lista1.add(cuartetoGoto);
            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiqueta1);
            lista1.add(cuartetoEtiqueta);

            Cuarteto.unirCuartetos(lista1, lista2);

            if (lista1.get(lista1.size() - 1).getOperador() != null && lista1.get(lista1.size() - 1).getOperador().startsWith("ET")) {
                resultado1 = lista1.get(lista1.size() - 3).getValorT();
            } else {
                resultado1 = lista1.get(lista1.size() - 1).getValorT();
            }
            cuartetoIf1 = new Cuarteto();
            cuartetoIf1.setOperador("IF");
            cuartetoIf1.setResultado(resultado1);
            lista1.add(cuartetoIf1);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaTrue);
            lista1.add(cuartetoGoto);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaFalse);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaTrue);
            lista1.add(cuartetoEtiqueta);

            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "1", ambito + "", tipoDato, "Boolean");
            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaFalse);
            lista1.add(cuartetoEtiqueta);

            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "0", ambito + "", tipoDato, "Boolean");
            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista1.add(cuartetoEtiqueta);

            return lista1;

        } else if (operator != null && operator.getLexeme().equals("OR")) {
            String etiquetaTrue = Etiquetas.siguienteEtiqueta();
            String etiquetaFalse = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();
            String etiqueta1 = Etiquetas.siguienteEtiqueta();
            String etiqueta2 = Etiquetas.siguienteEtiqueta();

            lista = new ArrayList<>();
            lista1 = left.generar3D();
            lista2 = right.generar3D();
            String valorFinal = Temporales.siguienteTemporal("Integer");
            if (lista1.get(lista1.size() - 1).getOperador() != null && lista1.get(lista1.size() - 1).getOperador().startsWith("ET")) {
                resultado1 = lista1.get(lista1.size() - 3).getValorT();
            } else {
                resultado1 = lista1.get(lista1.size() - 1).getValorT();
            }
            cuartetoIf1 = new Cuarteto();
            cuartetoIf1.setOperador("IF");
            cuartetoIf1.setResultado(resultado1);

            lista1.add(cuartetoIf1);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaTrue);
            lista1.add(cuartetoGoto);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiqueta1);
            lista1.add(cuartetoGoto);
            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiqueta1);
            lista1.add(cuartetoEtiqueta);

            Cuarteto.unirCuartetos(lista1, lista2);

            if (lista1.get(lista1.size() - 1).getOperador() != null && lista1.get(lista1.size() - 1).getOperador().startsWith("ET")) {
                resultado1 = lista1.get(lista1.size() - 3).getValorT();
            } else {
                resultado1 = lista1.get(lista1.size() - 1).getValorT();
            }
            cuartetoIf1 = new Cuarteto();
            cuartetoIf1.setOperador("IF");
            cuartetoIf1.setResultado(resultado1);
            lista1.add(cuartetoIf1);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaTrue);
            lista1.add(cuartetoGoto);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaFalse);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaTrue);
            lista1.add(cuartetoEtiqueta);
            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "1", ambito + "", tipoDato, "Boolean");

            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaFalse);
            lista1.add(cuartetoEtiqueta);

            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "0", ambito + "", tipoDato, "Boolean");
            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista1.add(cuartetoEtiqueta);

            return lista1;

        } else if (operator != null && operator.getLexeme().equals("NOT")) {
            String etiquetaTrue = Etiquetas.siguienteEtiqueta();
            String etiquetaFalse = Etiquetas.siguienteEtiqueta();
            String etiquetaSalida = Etiquetas.siguienteEtiqueta();

            lista = new ArrayList<>();
            lista1 = right.generar3D();
            String valorFinal = Temporales.siguienteTemporal("Integer");

            if (lista1.get(lista1.size() - 1).getOperador() != null && lista1.get(lista1.size() - 1).getOperador().startsWith("ET")) {
                resultado1 = lista1.get(lista1.size() - 3).getValorT();
            } else {
                resultado1 = lista1.get(lista1.size() - 1).getValorT();
            }
            cuartetoIf1 = new Cuarteto();
            cuartetoIf1.setOperador("IF");
            cuartetoIf1.setResultado(resultado1);

            lista1.add(cuartetoIf1);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaFalse);
            lista1.add(cuartetoGoto);
            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaTrue);
            lista1.add(cuartetoGoto);
            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaTrue);
            lista1.add(cuartetoEtiqueta);

            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "1", ambito + "", tipoDato, "Boolean");
            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaFalse);
            lista1.add(cuartetoEtiqueta);

            cuarteto = Cuarteto.MakeOperacionIgualAsignacion(valorFinal, "0", ambito + "", tipoDato, "Boolean");
            lista1.add(cuarteto);

            cuartetoGoto = new Cuarteto();
            cuartetoGoto.setOperador("GOTO");
            cuartetoGoto.setResultado(etiquetaSalida);
            lista1.add(cuartetoGoto);

            cuartetoEtiqueta = new Cuarteto();
            cuartetoEtiqueta.setOperador("ET");
            cuartetoEtiqueta.setResultado(etiquetaSalida);
            lista1.add(cuartetoEtiqueta);

            return lista1;
        } else {
            if (literalValue != null) {

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
            } else {
                return valorCondicion.execute();
            }
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
        String val = table.getIdType(literalValue.getNombre().getLexeme(), ambito, tipo);
        String valorMandar = "";
        if (value == ambito) {
            valorMandar = valorFuncion;
        }
        cuarteto = Cuarteto.MakeOperacionIgualAsignacion(Temporales.siguienteTemporal(tipoDato), literalValue.getNombre().getLexeme() + valorMandar, value + "", tipoDato, val);
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
            cuarteto = Cuarteto.MakeOperacionIgualAsignacionArreglo(Temporales.siguienteTemporal(tipoDato), literalValue.getNombre().getLexeme()+valorMandar, Integer.toString(value), valor, tipoDato, val);
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

        if (left != null) {
            left.asignarTipoDato(tipo);
        }
        if (right != null) {
            right.asignarTipoDato(tipo);
        }
    }

}
