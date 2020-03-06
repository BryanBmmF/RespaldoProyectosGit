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
public class DeclaracionArreglo implements Instruction {

    private Logica logica = new Logica();
    private String tipo;
    private List<Dato> id;
    private List<ExpresionAritmetica> expresiones;
    private Integer ambito;
    private TablaSimbolos simbolos;
    private TablaTipos tipos;
    private Token token;
    private String valorFuncion="";

    public DeclaracionArreglo(String tipo, List<Dato> id, List<ExpresionAritmetica> expresiones, TablaSimbolos simbolos, TablaTipos tipos, Token token) {
        this.tipo = tipo;
        this.id = id;
        this.expresiones = expresiones;
        this.simbolos = simbolos;
        this.tipos = tipos;
        this.token = token;
    }

    
    @Override
    public void setAmbit(int ambito) {
        this.ambito = ambito;
        for (int i = 0; i < expresiones.size(); i++) {
            expresiones.get(i).asignarAmbito(ambito);
        }
    }
    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.valorFuncion = idFuncion;
        for (int i = 0; i < expresiones.size(); i++) {
            expresiones.get(i).asignarValorFuncion(idFuncion);
        }
    }

    @Override
    public boolean validate() {
        boolean bandera = true;

        if (tipo.equals("void")) {
            CErrores.agregarError("SEMANTICO", "TIPO_VOID", null, ambito, "ARREGLO",
                    token.getLine(), token.getColumn(),
                    "A LOS ARREGLOS SE LE ESTA TRATANDO DE ASIGNAR UN TIPO void, ESE TIPO SOLO ES VALIDO PARA SUBPROGRAMAS.");

            bandera = false;
        }
        for (int i = 0; i < expresiones.size(); i++) {
            String valor = expresiones.get(i).validarClases(simbolos, tipos);
            if (valor != null) {
                if (!valor.equals("Byte") && !valor.equals("Integer") && !valor.equals("Long")) {
                    CErrores.agregarError("SEMANTICO", "ERROR_DIMENSION_ARREGLO", null, ambito, "ARREGLO",
                            token.getLine(), token.getColumn(),
                            "LA EXPRESION DE UNA DIMENSION DE LOS ARREGLOS NO ES DE TIPO NUMERICO ENTERO");
                    bandera = false;
                }
            }
        }
        for (int i = 0; i < id.size(); i++) {
            if (simbolos.existsInAmbit(id.get(i).getNombre().getLexeme(), ambito, "ARREGLO")) {

                CErrores.agregarError("SEMANTICO", "DECLARACION_ARREGLO", id.get(i), ambito, "ARREGLO",
                        id.get(i).getNombre().getLine(), id.get(i).getNombre().getColumn(),
                        "EL ARREGLO CON ID " + id.get(i).getNombre().getLexeme() + ", YA EXISTE EN LA TABLA DE SIMBOLOS");
                bandera = false;
            }

        }

        if (bandera) {
            List<String> listado = new ArrayList<>();
            for (int i = 0; i < expresiones.size(); i++) {
                listado.add("tt");

            }
            for (int i = 0; i < id.size(); i++) {
                Simbolos sim = new Simbolos(id.get(i).getNombre().getLexeme(), "ARREGLO", tipo, ambito, expresiones.size(), listado, expresiones);
                simbolos.addElementInAmbit(sim);
            }
        }

        return bandera;

    }

    @Override
    public List<Cuarteto> execute() {
        List<Cuarteto> lista = new ArrayList<>();
        List<Cuarteto> lista1 = new ArrayList<>();
        List<String> tamanos = new ArrayList<>();
        Cuarteto cuarteto;
        for (int i = 0; i < expresiones.size(); i++) {
            lista1 = expresiones.get(i).execute();
            String val = logica.returnUltimoTemporalExpresionValorT(lista1);
            tamanos.add(val);
            Cuarteto.unirCuartetos(lista, lista1);
        }
        
        List<String> temporales = logica.listadoTemporales(tamanos.size()-1);
        String tamanoDimension;
        
        if (tamanos.size() > 1) {
            for (int i = 1; i < tamanos.size(); i++) {
                if(i==1){
                    cuarteto = Cuarteto.MakeOperacion("Long", temporales.get(i-1), "*",tamanos.get(i-1), tamanos.get(i),"");
                }else{
                    cuarteto = Cuarteto.MakeOperacion("Long", temporales.get(i-1), "*",temporales.get(i-2), tamanos.get(i),"");
                }
                lista.add(cuarteto);
            }
            tamanoDimension = temporales.get(temporales.size()-1);
        }else{
            tamanoDimension = tamanos.get(0);
        }

        for (int i = 0; i < id.size(); i++) {
            List<String> listaTamanos = simbolos.dimensionesArreglo(id.get(i).getNombre().getLexeme(), ambito);
            for (int j = 0; j < listaTamanos.size(); j++) {
                listaTamanos.set(j, tamanos.get(j));                
            }
            simbolos.setDimensionGeneralArreglo(id.get(i).getNombre().getLexeme(), ambito,tamanoDimension);
        }
        
        for (int i = 0; i < id.size(); i++) {
            
            cuarteto = Cuarteto.MakeDeclaracionArreglo(tipo,tamanoDimension,id.get(i).getNombre().getLexeme(),ambito+"", tamanoDimension);
            lista.add(cuarteto);
        }
        
        
        return lista;

    }

    @Override
    public boolean asignarReturn(String tipo,String tSalida) {
        return false;
    }

    

}
