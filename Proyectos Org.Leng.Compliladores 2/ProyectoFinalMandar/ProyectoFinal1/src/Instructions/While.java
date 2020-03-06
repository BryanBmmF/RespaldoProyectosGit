/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instructions;

import CErrores.CErrores;
import Objetos.Cuarteto;
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
public class While implements Instruction {

    private Logica logica = new Logica();
    private ExpresionBooleana condicion;
    private List<Instruction> lista;
    private TablaSimbolos tablaSimbolos;
    private TablaTipos tablaTipos;
    private Token token;

    public While(ExpresionBooleana condicion, List<Instruction> lista, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos, Token token) {
        this.condicion = condicion;
        this.lista = lista;
        this.tablaSimbolos = tablaSimbolos;
        this.tablaTipos = tablaTipos;
        this.token = token;
    }

    @Override
    public void setAmbit(int ambito) {
        this.condicion.asignarAmbito(ambito);
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setAmbit(ambito);
        }
    }
    @Override
    public void asignarValorFuncion(String idFuncion) {
        this.condicion.asignarValorFuncion(idFuncion);
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).asignarValorFuncion(idFuncion);
        }
    }

    @Override
    public boolean validate() {
        boolean bandera, bandera2 = true;
        String valor = condicion.validarClases(tablaSimbolos, tablaTipos);

        if (valor == null) {
            bandera2 = false;
        }
        for (int i = 0; i < lista.size(); i++) {
            bandera = lista.get(i).validate();
            if (!bandera) {
                bandera2 = false;
            }
        } 
        
        if(!bandera2){
             CErrores.agregarError("SEMANTICO", "WHILE", null, null, null,
                            token.getLine(), token.getColumn(),
                            "PROBLEMAS EN EL CONTROL DE FLUJO WHILE");
                    
        }
        
        return bandera2;
    }

    @Override
    public List<Cuarteto> execute() {
        
        List<Cuarteto> lista = new ArrayList<>(), listaCondicion = new ArrayList<>(), aux = new ArrayList<>();
        listaCondicion = condicion.execute();
        String etiquetaInicio = Etiquetas.siguienteEtiqueta();
        String etiquetaInstrucciones = Etiquetas.siguienteEtiqueta();
        String etiquetaSalida = Etiquetas.siguienteEtiqueta();
        String temporalCondicion = logica.returnUltimoTemporalCondicion(listaCondicion);
        Cuarteto cuartetoEtiqueta, cuartetoIf, cuartetoGoto;
        
        cuartetoEtiqueta = new Cuarteto();
        cuartetoEtiqueta.setOperador("ET");
        cuartetoEtiqueta.setResultado(etiquetaInicio);
        lista.add(cuartetoEtiqueta);
        
        Cuarteto.unirCuartetos(lista, listaCondicion);
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

        
        for (int i = 0; i < this.lista.size(); i++) {
            Cuarteto.unirCuartetos(aux, this.lista.get(i).execute());
        }
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
            boolean bandera = logica.asignarReturn(this.lista,tipo,tSalida);
            return bandera;
        
    }

    
}
