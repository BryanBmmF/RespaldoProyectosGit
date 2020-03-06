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
import Objetos.ExpresionBooleana;
import Objetos.Logica;
import Objetos.Token;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Valores.Etiquetas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class For implements Instruction {

    private ExpresionAritmetica expresionInicio;
    private ExpresionAritmetica expresionAumento;
    private ExpresionBooleana condicion;
    private Dato dato;
    private boolean aumento;
    private List<Instruction> lista;
    private Logica logica = new Logica();
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private Integer ambito;
    private Token token;
    private String valorFuncion="";

    public For(ExpresionAritmetica expresionInicio, ExpresionAritmetica expresionAumento, ExpresionBooleana condicion, Dato dato, boolean aumento, List<Instruction> lista, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos, Token token) {
        this.expresionInicio = expresionInicio;
        this.expresionAumento = expresionAumento;
        this.condicion = condicion;
        this.dato = dato;
        this.aumento = aumento;
        this.lista = lista;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
        this.token = token;
    }

    @Override
    public void setAmbit(int ambito) {
        this.expresionInicio.asignarAmbito(ambito);
        this.expresionAumento.asignarAmbito(ambito);
        this.condicion.asignarAmbito(ambito);
        this.ambito = ambito;
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setAmbit(ambito);
        }

    }
    
     @Override
    public void asignarValorFuncion(String idFuncion) {
        this.expresionInicio.asignarValorFuncion(idFuncion);
        this.expresionAumento.asignarValorFuncion(idFuncion);
        this.condicion.asignarValorFuncion(idFuncion);
        this.valorFuncion = idFuncion;
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).asignarValorFuncion(idFuncion);
        }
    }


    @Override
    public boolean validate() {
        boolean bandera = true;
        boolean bandera2 = true;
        String tipo = tablaSimbolos.getIdType(dato.getNombre().getLexeme(), ambito, "VARIABLE");
        if (tipo == null) {
            bandera = false;
        } else {
            if (!tipo.equals("Byte") && !tipo.equals("Integer") && !tipo.equals("Long")) {
                CErrores.agregarError("SEMANTICO", "TIPO_NUMERICO", null, null, null,
                        token.getLine(), token.getColumn(),
                        "EL ID " + dato.getNombre().getLexeme() + " NO ES DE TIPO NUMERICO ENTERO, ES DE TIPO: " + tipo + ". EN EL CONTROL DE FLUJO FOR.");

            }
        }

        String valor = expresionInicio.validarClases(tablaSimbolos, tablaTipos);
        if (valor != null) {
            if (!valor.equals("Byte") && !valor.equals("Integer") && !valor.equals("Long")) {
                CErrores.agregarError("SEMANTICO", "TIPO_NUMERICO", null, null, null,
                        token.getLine(), token.getColumn(),
                        "LA EXPRESION DE ASIGNACION NO ES DE TIPO NUMERICA ENTERA, ES DE TIPO: " + valor + ". EN EL CONTROL DE FLUJO FOR.");

                bandera = false;
            }
        } else {
            bandera = false;
        }

        String bol = condicion.validarClases(tablaSimbolos, tablaTipos);
        if (bol == null) {
            bandera = false;
        }

        String valorAumento = expresionAumento.validarClases(tablaSimbolos, tablaTipos);
        if (valorAumento != null) {
            if (!valorAumento.equals("Byte") && !valorAumento.equals("Integer") && !valorAumento.equals("Long")) {
                CErrores.agregarError("SEMANTICO", "TIPO_NUMERICO", null, null, null,
                        token.getLine(), token.getColumn(),
                        "LA EXPRESION DE AUMENTO NO ES DE TIPO NUMERICA, ES DE TIPO: " + valorAumento + ". EN EL CONTROL DE FLUJO FOR.");

                bandera = false;
            }
        } else {
            bandera = false;
        }

        for (int i = 0; i < lista.size(); i++) {
            bandera2 = lista.get(i).validate();
            if (!bandera2) {
                bandera = false;
            }
        }

        if (!bandera) {
            CErrores.agregarError("SEMANTICO", "FOR", null, null, null,
                    token.getLine(), token.getColumn(),
                    "PROBLEMAS CON EL CONTROL DE FLUJO FOR");

        }

        return bandera;
    }

    @Override
    public List<Cuarteto> execute() {

        ExpresionAritmetica expr = new ExpresionAritmetica(dato);
        expr.asignarTablas(tablaTipos, tablaSimbolos);
        expr.asignarAmbito(ambito);
        expr.asignarValorFuncion(valorFuncion);
        String operador;
        if (aumento) {
            operador = "+";
        } else {
            operador = "-";
        }
        ExpresionAritmetica ultima = new ExpresionAritmetica(new Token(operador, 0, 0), expr, expresionAumento);
        ultima.asignarTablas(tablaTipos, tablaSimbolos);
        ultima.asignarAmbito(ambito);
        ultima.asignarValorFuncion(valorFuncion);
        Asignacion asignacionInicio = new Asignacion(dato, expresionInicio, tablaSimbolos, tablaTipos);
        asignacionInicio.setAmbit(ambito);
        asignacionInicio.asignarValorFuncion(valorFuncion);

        List<Cuarteto> lista = new ArrayList<>(), aux;
        Cuarteto cuartetoEtiqueta, cuartetoIf, cuartetoGoto;
        Cuarteto.unirCuartetos(lista, asignacionInicio.execute());

        Asignacion asignacion = new Asignacion(dato,ultima, tablaSimbolos, tablaTipos);
        asignacion.setAmbit(ambito);
        asignacion.asignarValorFuncion(valorFuncion);

        String etiquetaInicio = Etiquetas.siguienteEtiqueta();
        String etiquetaInstrucciones = Etiquetas.siguienteEtiqueta();
        String etiquetaSalida = Etiquetas.siguienteEtiqueta();
        aux = condicion.execute();
        String temporalCondicion = logica.returnUltimoTemporalCondicion(aux);

        cuartetoEtiqueta = new Cuarteto();
        cuartetoEtiqueta.setOperador("ET");
        cuartetoEtiqueta.setResultado(etiquetaInicio);
        lista.add(cuartetoEtiqueta);

        Cuarteto.unirCuartetos(lista, aux);

        cuartetoIf = new Cuarteto();
        cuartetoIf.setOperador("IF");
        cuartetoIf.setResultado(temporalCondicion);
        lista.add(cuartetoIf);

        cuartetoGoto = new Cuarteto();
        cuartetoGoto.setOperador("GOTO");
        cuartetoGoto.setResultado(etiquetaInstrucciones);
        lista.add(cuartetoGoto);

        cuartetoGoto = new Cuarteto();
        cuartetoGoto.setOperador("GOTO");
        cuartetoGoto.setResultado(etiquetaSalida);
        lista.add(cuartetoGoto);

        cuartetoEtiqueta = new Cuarteto();
        cuartetoEtiqueta.setOperador("ET");
        cuartetoEtiqueta.setResultado(etiquetaInstrucciones);
        lista.add(cuartetoEtiqueta);

        aux = new ArrayList<>();
        for (int i = 0; i < this.lista.size(); i++) {
            Cuarteto.unirCuartetos(aux, this.lista.get(i).execute());
        }
        Cuarteto.unirCuartetos(lista, aux);
        aux = asignacion.execute();
        Cuarteto.unirCuartetos(lista, aux);

        cuartetoGoto = new Cuarteto();
        cuartetoGoto.setOperador("GOTO");
        cuartetoGoto.setResultado(etiquetaInicio);
        lista.add(cuartetoGoto);

        cuartetoEtiqueta = new Cuarteto();
        cuartetoEtiqueta.setOperador("ET");
        cuartetoEtiqueta.setResultado(etiquetaSalida);
        lista.add(cuartetoEtiqueta);

        return lista;

    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        return logica.asignarReturn(this.lista, tipo,tSalida);
    }

   
}
