/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Cuarteto {

    private String valorT;
    private String operador;
    private String izquierda;
    private String derecha;
    private String resultado;

    private String tipoT;
    private String nombreT;
    private String vezUsada;
    private String ambito;
    private boolean mostrarC = true;
    private boolean mostrar3D = true;

    public static Cuarteto makeDeclaracion(String tipo, String id, String ambito) {
        Cuarteto cuar = new Cuarteto();
        String value = convertType(tipo);
        if (value.equals("char") && tipo.equals("String")) {
            tipo = value;
            cuar.setDerecha("[250]");
        } else {
            tipo = value;
            cuar.setDerecha("");
        }
        cuar.setValorT(tipo);
        cuar.setResultado(id);
        cuar.setOperador("DECLARACION");
        cuar.setAmbito(ambito);
        return cuar;
    }

    public static Cuarteto MakeDeclaracionArreglo(String tipo, String tamano, String id, String ambito, String dimension) {
        Cuarteto cuar = new Cuarteto();
        String value = convertType(tipo);
        if (value.equals("char") && tipo.equals("String")) {
            tipo = value;
            cuar.setDerecha("[250]");
        } else {
            tipo = value;
            cuar.setDerecha("");
        }
        cuar.setValorT(tipo);
        cuar.setResultado(id);
        cuar.setOperador("DECLARACION_ARREGLO");
        cuar.setAmbito(ambito);
        cuar.setIzquierda(dimension);

        return cuar;
    }

    public static Cuarteto MakeAsignacion(String id, String resultado, String ambito, String tipo) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("ASIGNACION");
        cuar.setResultado(resultado);
        cuar.setAmbito(ambito);
        cuar.setValorT(id);
        cuar.setTipoT(tipo);
        return cuar;

    }

    public static Cuarteto MakeAsignacionArreglo(String id, String resultado, String ambito, String dimension, String tipo) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("ASIGNACION_ARREGLO");
        cuar.setResultado(resultado);
        cuar.setAmbito(ambito);
        cuar.setValorT(id);
        cuar.setIzquierda(dimension);
        cuar.setTipoT(tipo);
        return cuar;

    }

    public static Cuarteto MakePrint(String resultado, String tipo) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("PRINT");
        cuar.setResultado(resultado);
        cuar.setTipoT(tipo);
        return cuar;
    }

    public static Cuarteto MakePrintLn(String resultado, String tipo) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("PRINTLN");
        cuar.setResultado(resultado);
        cuar.setTipoT(tipo);
        return cuar;
    }

    public static Cuarteto MakeScann(String id) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("SCANN");
        cuar.setResultado(id);

        cuar.setValorT("i");
        return cuar;
    }

    public static Cuarteto MakeScans(String id) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("SCANS");
        cuar.setResultado(id);

        cuar.setValorT("s");
        return cuar;
    }

    public static Cuarteto MakeIf(String id) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("IF");
        cuar.setResultado(id);

        return cuar;
    }

    public static Cuarteto MakeGoto(String id) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("GOTO");
        cuar.setResultado(id);

        return cuar;
    }

    public static Cuarteto MakeEtiqueta(String id) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("ET");
        cuar.setResultado(id);

        return cuar;
    }

    public static Cuarteto MakeEtiquetaSubprograma(String id) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("ETT");
        cuar.setResultado(id);

        return cuar;
    }

    public static Cuarteto MakeOperacion(String tipoDato, String resultado, String operador, String izquierda, String derecha, String datoPeracion) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador(operador);
        cuar.setIzquierda(izquierda);
        cuar.setDerecha(derecha);
        cuar.setValorT(resultado);
        cuar.setTipoT(tipoDato);
        cuar.setResultado(datoPeracion);

        return cuar;
    }

    public static Cuarteto MakeOperacionMenosMenos(String tipoDato, String resultado, String operador, String derecha) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador(operador);
        cuar.setResultado(derecha);
        cuar.setValorT(resultado);
        cuar.setTipoT(tipoDato);

        return cuar;
    }

    public static Cuarteto MakeOperacionIgualAsignacion(String valorT, String resultado, String ambito, String tipo, String valorTipo) {
        if (resultado.equals("TRUE")) {
            resultado = "1";
        }
        if (resultado.equals("FALSE")) {
            resultado = "0";
        }

        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("=");
        cuar.setResultado(resultado);
        cuar.setValorT(valorT);
        cuar.setAmbito(ambito);
        cuar.setDerecha(tipo);
        cuar.setTipoT(valorTipo);

        return cuar;
    }

    public static Cuarteto MakeOperacionIgualAsignacionArreglo(String resultado, String id, String ambito, String tamano, String tipo, String valorTipo) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("=ARREGLO");
        cuar.setValorT(resultado);
        cuar.setIzquierda(id);
        cuar.setDerecha(tamano);
        cuar.setAmbito(ambito);
        cuar.setTipoT(tipo);
        cuar.setResultado(valorTipo);

        return cuar;
    }

    public static Cuarteto MakeReturn(String resultado, String valor, String got) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("RETURN");
        cuar.setValorT(resultado);
        cuar.setResultado(valor);
        cuar.setIzquierda(got);
        return cuar;
    }

    public static Cuarteto MakeParam(String resultado) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("PARAM");
        cuar.setValorT(resultado);
        return cuar;
    }

    public static Cuarteto MakeCall(String id, String numero, String temporal) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("CALL");
        cuar.setValorT(temporal);
        cuar.setDerecha(numero);
        cuar.setResultado(id);
        return cuar;
    }

    public static Cuarteto MakeCallVoid(String id, String numero) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("CALLVOID");
        cuar.setDerecha(numero);
        cuar.setResultado(id);
        return cuar;
    }

    public static Cuarteto MakeReturnCodigoC(String tSalida, String tresultado) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("RETURNC");
        cuar.setResultado(tresultado);
        cuar.setValorT(tSalida);
        return cuar;
    }

    public static Cuarteto MakeGotoSalidaC(String id) {
        Cuarteto cuar = new Cuarteto();
        cuar.setOperador("GOTOC");
        cuar.setResultado(id);

        return cuar;
    }

    public String make3D() {
        String mandar = "";
        if (mostrar3D) {
            if (operador == null) {
                mandar = valorT + " = " + resultado;
            } else {
                switch (operador) {
                    case "DECLARACION":

                        break;
                    case "DECLARACION_ARREGLO":

                        break;
                    case "ASIGNACION":
                        mandar = valorT + " = " + resultado;
                        break;
                    case "ASIGNACION_ARREGLO":
                        mandar = valorT + " [" + izquierda + "]" + " = " + resultado;
                        break;
                    case "PRINT":
                        mandar = "print " + resultado;
                        break;
                    case "PRINTLN":
                        mandar = "print " + resultado;
                        break;
                    case "SCANN":
                        mandar = "scan" + resultado;
                        break;
                    case "SCANS":
                        mandar = "scan" + resultado;
                        break;

                    case "IF":
                        mandar = "IF(" + resultado + "==1) ";
                        break;
                    case "IFF":
                        mandar = "if(" + resultado + " ) ";
                        break;
                    case "GOTO":
                        mandar = "GOTO " + resultado;
                        break;
                    case "ET":
                        mandar = resultado + ": ";
                        break;
                    case "ETT":
                        mandar = resultado + ": ";
                        break;
                    case "=":
                        mandar = valorT + " = " + resultado;
                        break;
                    case "=ARREGLO":
                        mandar = valorT + " = " + izquierda + "[" + derecha + "]";
                        break;
                    case "RETURN":
                        mandar = "return " + valorT;
                        break;
                    case "PARAM":
                        mandar = "PARAM " + valorT;
                        break;
                    case "CALL":
                        mandar = valorT + " = CALL " + resultado + " | " + derecha;
                        break;

                    case "+":
                        mandar = valorT + "=" + izquierda + " + " + derecha;
                        break;
                    case "-":
                        mandar = valorT + "=" + izquierda + " - " + derecha;
                        break;
                    case "*":
                        mandar = valorT + "=" + izquierda + " * " + derecha;
                        break;
                    case "/":
                        mandar = valorT + "=" + izquierda + " / " + derecha;
                        break;
                    case "%":
                        mandar = valorT + "=" + izquierda + " % " + derecha;
                        break;
                    case "--":
                        mandar = valorT + "=" + " - " + resultado;
                        break;
                    case "CALLVOID":
                        mandar = "CALL " + resultado + " | " + derecha;
                        break;

                    default:
                        break;
                }

            }
        }
        return mandar;
    }

    public String makeC() {
        String mandar = "";
        if (mostrarC) {
            if (operador == null) {
                mandar = valorT + " = " + resultado;
            } else {
                switch (operador) {
                    case "DECLARACION":
                        mandar = valorT + " " + resultado + ";";
                        break;
                    case "DECLARACION_ARREGLO":
                        mandar = valorT + " " + resultado + "[" + izquierda + "]" + ";";
                        break;
                    case "ASIGNACION":
                        if (tipoT.equals("String")) {
                            mandar = "strcat(" + valorT + "," + resultado + ");";
                        } else {
                            mandar = valorT + " = " + resultado + ";";
                        }

                        break;
                    case "ASIGNACION_ARREGLO":
                        if (tipoT.equals("String")) {
                            mandar = "strcat(" + valorT + "[" + izquierda + "]" + "," + resultado + ");";
                        } else {
                            mandar = valorT + " [" + izquierda + "]" + " = " + resultado + ";";
                        }

                        break;
                    case "PRINT":
                        String val = getTipoComodin(tipoT);
                        mandar = "printf(\"%" + val + "\"," + resultado + ");";
                        break;
                    case "PRINTLN":
                        String value = getTipoComodin(tipoT);
                        mandar = "printf(\"%" + value + "\\n \"," + resultado + ");";
                        break;
                    case "SCANN":
                        mandar = "scanf(\"%" + valorT + "\",&" + resultado + ");";
                        break;
                    case "SCANS":
                        mandar = "scanf(\"%" + valorT + "\",&" + resultado + ");";
                        break;

                    case "IF":
                        mandar = "if(" + resultado + " ==1) ";
                        break;
                    case "IFF":
                        mandar = "if(" + resultado + " ) ";
                        break;
                    case "GOTO":
                        mandar = "goto " + resultado + ";";
                        break;
                    case "GOTOC":
                        mandar = "goto " + resultado + ";";
                        break;
                    case "ET":
                        mandar = resultado + ": ";
                        break;
                    case "=":
                        if (derecha.equals("String") && tipoT.equals("String")) {

                            mandar = "strcat(" + valorT + "," + resultado + ");";
                        } else if (derecha.equals("String") && !tipoT.equals("String")) {
                            String comodin = getTipoComodin(tipoT);
                            mandar = "sprintf(" + valorT + ",\"%" + comodin + "\"," + resultado + ");";
                        } else {
                            mandar = valorT + " = " + resultado + ";";
                        }
                        break;
                    case "=ARREGLO":
                        if (tipoT.equals("String") && resultado.equals("String")) {
                            mandar = "strcat(" + valorT + "," + izquierda + "[" + derecha + "]);";
                        } else if (tipoT.equals("String") && !resultado.equals("String")) {
                            String comodin = getTipoComodin(resultado);
                            mandar = "sprintf(" + valorT + ",\"%" + comodin + "\"," + izquierda + "[" + derecha + "]" + ");";
                        } else {
                            mandar = valorT + " = " + izquierda + "[" + derecha + "];";
                        }

                        break;
                    case "RETURNC":
                        mandar = valorT + "=" + resultado + ";";
                        break;

                    case "+":
                        if (tipoT.equals("String") && resultado.equals("String")) {
                            mandar = "strcat(" + izquierda + "," + derecha + ");"
                                    + "\nstrcat(" + valorT + "," + izquierda + ");";
                        } else {
                            mandar = valorT + "=" + izquierda + " + " + derecha + ";";
                        }

                        break;
                    case "-":
                        mandar = valorT + "=" + izquierda + " - " + derecha + ";";
                        break;
                    case "*":
                        mandar = valorT + "=" + izquierda + " * " + derecha + ";";
                        break;
                    case "/":
                        mandar = valorT + "=" + izquierda + " / " + derecha + ";";
                        break;
                    case "%":
                        mandar = valorT + "=" + izquierda + " % " + derecha + ";";
                        break;
                    case "--":
                        mandar = valorT + "=" + " - " + resultado + ";";
                        break;

                    default:
                        break;
                }

            }
        }
        return mandar;
    }

    public String getTipoComodin(String value) {
        String val = "";
        switch (value) {
            case "Integer":
                val = "i";
                break;
            case "Float":
                val = "f";
                break;
            case "Double":
                val = "lf";
                break;
            case "String":
                val = "s";
                break;
            case "Byte":
                val = "i";
                break;
            case "Long":
                val = "d";
                break;
            case "Boolean":
                val = "d";
                break;
            default:
                break;
        }
        return val;
    }

    public static String convertType(String value) {
        switch (value) {
            case "Byte":
                return "int";
            case "Integer":
                return "int";
            case "Long":
                return "long";
            case "Boolean":
                return "int";
            case "Double":
                return "double";
            case "Float":
                return "float";
            case "Char":
                return "int";
            case "String":
                return "string";
            default:
                return "";
        }

    }

    public static String setChar() {
        return "[250]";
    }

    public static void unirCuartetos(List<Cuarteto> uno, List<Cuarteto> dos, Cuarteto cuarteto) {
        for (int i = 0; i < dos.size(); i++) {
            uno.add(dos.get(i));
        }
        uno.add(cuarteto);
    }

    public static void unirCuartetos(List<Cuarteto> uno, List<Cuarteto> dos) {
        for (int i = 0; i < dos.size(); i++) {
            uno.add(dos.get(i));
        }

    }

    public String getValorT() {
        return valorT;
    }

    public void setValorT(String valorT) {
        this.valorT = valorT;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(String izquierda) {
        this.izquierda = izquierda;
    }

    public String getDerecha() {
        return derecha;
    }

    public void setDerecha(String derecha) {
        this.derecha = derecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getTipoT() {
        return tipoT;
    }

    public void setTipoT(String tipoT) {
        this.tipoT = tipoT;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public String getVezUsada() {
        return vezUsada;
    }

    public boolean isMostrar3D() {
        return mostrar3D;
    }

    public void setMostrar3D(boolean mostrar3D) {
        this.mostrar3D = mostrar3D;
    }

    public void setVezUsada(String vezUsada) {
        this.vezUsada = vezUsada;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public boolean isMostrarC() {
        return mostrarC;
    }

    public void setMostrarC(boolean mostrarC) {
        this.mostrarC = mostrarC;
    }

}
