/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import CErrores.CErrores;
import Objetos.Cuarteto;
import Objetos.Expresion;
import Objetos.Logica;
import Objetos.Token;
import Tablas.TablaSimbolos.Simbolos;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import Valores.Etiquetas;
import Valores.Temporales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Call implements Instruction {

    private Logica logica = new Logica();
    private Token id;
    private List<Expresion> lista;
    private Integer ambito;
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private String valorFuncion = "";

    public Call(Token id, List<Expresion> lista, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        this.id = id;
        this.lista = lista;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
    }

    public Token getId() {
        return id;
    }

    public void setId(Token id) {
        this.id = id;
    }

    public List<Expresion> getLista() {
        return lista;
    }

    public void setLista(List<Expresion> lista) {
        this.lista = lista;
    }

    @Override
    public void setAmbit(int ambito) {
        this.ambito = ambito;
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).asignarAmbito(ambito);

        }
    }

    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).asignarValorFuncion(idFuncion);

        }
    }

    @Override
    public boolean validate() {
        String value = tablaSimbolos.getIdType(id.getLexeme(), ambito, "SUBPROGRAMA");
        if (value != null) {// validar nombre
            List<String> listaParametros = tablaSimbolos.parametrosFuncion(id.getLexeme());
            List<String> listaFuncion = new ArrayList<>();
            List<Expresion> expresiones = this.lista;
            logica.asignarAmbitoExpresionesFuncion(expresiones, this.ambito);
            if (listaParametros != null && expresiones != null && expresiones.size() == listaParametros.size()) {//validar numero parametros
                for (int i = 0; i < expresiones.size(); i++) {
                    String valor = expresiones.get(i).validarClases(tablaSimbolos, tablaTipos);
                    if (expresiones.get(i).validarParametroFuncion(id.getLexeme(), tablaSimbolos, tablaTipos)) {//validar que no exista recursion 
                        if (valor != null) {
                            listaFuncion.add(valor);
                        }
                    } else {
                        return false;
                    }
                }

                for (int i = 0; i < listaFuncion.size() && listaFuncion.size() == listaParametros.size(); i++) {
                    if (!logica.validarDosDatosParametros(listaParametros.get(i), listaFuncion.get(i), tablaTipos)) {
                        return false;
                    }
                }

                return true;
            } else {
                CErrores.agregarError("SEMANTICO", "NUMERO_PARAMETROS_FUNCION", null, ambito, "SUBPROGRAMA", id.getLine(), id.getColumn(), "LOS PARAMETROS DEL SUBPROGRAMA: " + id.getLexeme() + " NO SON LOS MISMOS");
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();

        List<Cuarteto> lista1;
        Simbolos subprograma = tablaSimbolos.getSimbolFuncion(id.getLexeme());

        subprograma.setEtSalida(Etiquetas.siguienteEtiqueta());

        List<String> temporalesParametros = new ArrayList<>();
        Cuarteto cuarteto;
        for (int i = 0; i < this.lista.size(); i++) {
            lista1 = this.lista.get(i).execute();
            temporalesParametros.add(logica.returnUltimoTemporalExpresionValorT(lista1));
            Cuarteto.unirCuartetos(lista, lista1);
        }

        for (int i = 0; i < temporalesParametros.size(); i++) {
            cuarteto = Cuarteto.MakeParam(temporalesParametros.get(i));
            lista.add(cuarteto);
        }

        cuarteto = Cuarteto.MakeCallVoid(id.getLexeme(), temporalesParametros.size() + "");
        lista.add(cuarteto);

        List<Instruction> listadoInstruccionesSubprograma = subprograma.getInstruccionesFuncion();

        for (int i = 0; i < listadoInstruccionesSubprograma.size(); i++) {
            listadoInstruccionesSubprograma.get(i).asignarValorFuncion(id.getLexeme());
        }

        List<String> temporalesp = subprograma.getTemporalesParametros();
        List<String> tiposParametros = subprograma.getListaParametros();
        for (int i = 0; i < temporalesp.size(); i++) {
            cuarteto = Cuarteto.MakeAsignacion(temporalesp.get(i), temporalesParametros.get(i), ambito + "", tiposParametros.get(i));
            cuarteto.setMostrar3D(false);
            lista.add(cuarteto);
        }

        lista1 = new ArrayList<>();
        for (int i = 0; i < listadoInstruccionesSubprograma.size(); i++) {
            lista1 = listadoInstruccionesSubprograma.get(i).execute();
            for (int j = 0; j < lista1.size(); j++) {
                lista1.get(j).setMostrar3D(false);
            }
            Cuarteto.unirCuartetos(lista, lista1);
        }
        cuarteto = Cuarteto.MakeEtiqueta(subprograma.getEtSalida());
        cuarteto.setMostrar3D(false);
        lista.add(cuarteto);

        return lista;
    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        return false;
    }

}
