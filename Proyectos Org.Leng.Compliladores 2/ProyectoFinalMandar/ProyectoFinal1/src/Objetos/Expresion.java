/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Tablas.TablaSimbolos.TablaSimbolos;
import Tablas.TablaTipos.TablaTipos;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public interface Expresion {

    public void asignarAmbito(int ambito);

    public String validarClases(TablaSimbolos tablaSimbolos, TablaTipos tablaTipos);

    public boolean validarParametroFuncion(String nombre, TablaSimbolos tablaSimbolos, TablaTipos tablaTipos);

    public abstract List<Cuarteto> execute();

    public void asignarValorFuncion(String idFuncion);

}
