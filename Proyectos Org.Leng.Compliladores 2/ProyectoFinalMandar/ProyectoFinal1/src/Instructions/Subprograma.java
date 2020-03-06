/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import Objetos.Cuarteto;
import Objetos.Dato;
import Objetos.Parametros;
import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Subprograma implements Instruction {

    private String tipo;
    private Dato id;
    private List<Parametros> parametros;
    private List<Instruction> instrucciones;
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private Integer ambito;
    private String valorFuncion = "";

    public Subprograma(String tipo, Dato id, List<Parametros> parametros, List<Instruction> instrucciones, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos) {
        this.tipo = tipo;
        this.id = id;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
        this.ambito = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Dato getId() {
        return id;
    }

    public void setId(Dato id) {
        this.id = id;
    }

    public List<Parametros> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametros> parametros) {
        this.parametros = parametros;
    }

    public List<Instruction> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(List<Instruction> instrucciones) {
        this.instrucciones = instrucciones;

    }

    @Override
    public void setAmbit(int ambito) {
        this.ambito = ambito;
    }

    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        List<Cuarteto> list1;
        List<Cuarteto> list2;
        Cuarteto cuarteto;

        cuarteto = Cuarteto.MakeEtiquetaSubprograma("ET" + id.getNombre().getLexeme());
        lista.add(cuarteto);

        for (int i = 0; i < instrucciones.size(); i++) {
            if (instrucciones.get(i) instanceof Declaracion) {
                Declaracion dec = (Declaracion) instrucciones.get(i);
                dec.asignarValorFuncion(id.getNombre().getLexeme());
                list1 = dec.execute();

                list1.get(0).setMostrar3D(false);
                for (int j = 0; j < list1.size(); j++) {
                    list1.get(i).setMostrar3D(false);
                    list1.get(i).setMostrarC(true);
                }
                Cuarteto.unirCuartetos(lista, list1);
                instrucciones.remove(i);
                i--;
            } else if (instrucciones.get(i) instanceof DeclaracionArreglo) {
                DeclaracionArreglo dec = (DeclaracionArreglo) instrucciones.get(i);
                dec.asignarValorFuncion(id.getNombre().getLexeme());
                list1 = dec.execute();
                for (int j = 0; j < list1.size(); j++) {
                    list1.get(i).setMostrar3D(false);
                    list1.get(i).setMostrarC(true);
                }

                Cuarteto.unirCuartetos(lista, list1);
                instrucciones.remove(i);
                i--;
//            } else {
//                if (instrucciones.get(i) instanceof Return) {                    
//                    instrucciones.get(i).asignarValorFuncion(id.getNombre().getLexeme());
//                    list1 = instrucciones.get(i).execute();
//                    for (int j = 0; j < list1.size(); j++) {
//                        list1.get(j).setMostrarC(false);
//                    }
//                    Cuarteto.unirCuartetos(lista, list1);
//                }

            }
        }

        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).getOperador().equals("DECLARACION")) {
                lista.get(i).setMostrarC(false);
            }
        }

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getOperador().equals("DECLARACION_ARREGLO")) {
                lista.get(i).setMostrarC(true);
            }
        }

        return lista;

    }

    @Override
    public boolean asignarReturn(String tipo, String tSalida) {
        return false;
    }

}
