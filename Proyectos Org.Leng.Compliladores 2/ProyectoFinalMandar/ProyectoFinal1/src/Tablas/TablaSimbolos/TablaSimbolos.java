package Tablas.TablaSimbolos;

import Objetos.Token;
import Tablas.TablaTipos.TablaTipos;
import Tablas.TablaTipos.Tipos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Instructions.*;
import Valores.VariableT;

/**
 *
 * @author jpmazate
 */
public class TablaSimbolos {

    private List<Simbolos> tablaSimbolos;

    public TablaSimbolos() {
        this.tablaSimbolos = new ArrayList<>();
    }

    public boolean addElementInAmbit(Simbolos element) {
        if (!existsInAmbit(element.getNombre(), element.getAmbito(), element.getCategoria())) {
            tablaSimbolos.add(element);
            return true;
        }
        return false;
    }

    public boolean addElementInGeneral(Simbolos element) {
        if (!existsInGeneral(element.getNombre(), element.getCategoria())) {
            tablaSimbolos.add(element);
            return true;
        }
        return false;
    }

    public boolean existsInAmbit(String nombre, int ambito, String tipo) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(nombre) && ambito == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (tipo.equals(sim)) {
                    return true;
                } else if ((tipo.equals("ARREGLO") && sim.equals("VARIABLE")) || (tipo.equals("VARIABLE") && sim.equals("ARREGLO"))) {
                    return true;
                } else if ((tipo.equals("PARAMETRO") && sim.equals("VARIABLE")) || (tipo.equals("VARIABLE") && sim.equals("PARAMETRO"))) {
                    return true;
                } else if ((tipo.equals("PARAMETRO") && sim.equals("ARREGLO")) || (tipo.equals("ARREGLO") && sim.equals("PARAMETRO"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existsInGeneral(String nombre, String tipo) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(nombre) && 0 == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (tipo.equals(sim)) {
                    return true;
                } else if ((tipo.equals("ARREGLO") && sim.equals("VARIABLE")) || (tipo.equals("VARIABLE") && sim.equals("ARREGLO"))) {
                    return true;
                } else if ((tipo.equals("PARAMETRO") && sim.equals("VARIABLE")) || (tipo.equals("VARIABLE") && sim.equals("PARAMETRO"))) {
                    return true;
                } else if ((tipo.equals("PARAMETRO") && sim.equals("ARREGLO")) || (tipo.equals("ARREGLO") && sim.equals("PARAMETRO"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verDato(String nombre, int ambito, String tipo) {
        if (existsInAmbit(nombre, ambito, tipo)) {
            return true;
        } else if (existsInGeneral(nombre, tipo)) {
            return true;
        } else {
            return false;

        }
    }

    public String getIdType(String id, int ambito, String categoria) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && ambito == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (categoria.equals(sim)) {
                    return tablaSimbolos.get(i).getTipo();
                    // }else if ( ( categoria.equals("ARREGLO") && sim.equals("VARIABLE") ) || ( categoria.equals("VARIABLE") && sim.equals("ARREGLO") ) ){
                    //   return tablaSimbolos.get(i).getTipo();
                } else if ((categoria.equals("PARAMETRO") && sim.equals("VARIABLE")) || (categoria.equals("VARIABLE") && sim.equals("PARAMETRO"))) {
                    return tablaSimbolos.get(i).getTipo();
                    //}else if( ( categoria.equals("PARAMETRO") && sim.equals("ARREGLO") ) || ( categoria.equals("ARREGLO") && sim.equals("PARAMETRO") ) ){
                    //  return tablaSimbolos.get(i).getTipo();
                }
            }

            if (categoria.equals("SUBPROGRAMA") && tablaSimbolos.get(i).getNombre().equals(id)) {
                return tablaSimbolos.get(i).getTipo();
            }
        }
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && 0 == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (categoria.equals(sim)) {
                    return tablaSimbolos.get(i).getTipo();
                    // }else if ( ( categoria.equals("ARREGLO") && sim.equals("VARIABLE") ) || ( categoria.equals("VARIABLE") && sim.equals("ARREGLO") ) ){
                    //   return tablaSimbolos.get(i).getTipo();
                } else if ((categoria.equals("PARAMETRO") && sim.equals("VARIABLE")) || (categoria.equals("VARIABLE") && sim.equals("PARAMETRO"))) {
                    return tablaSimbolos.get(i).getTipo();
                    //}else if( ( categoria.equals("PARAMETRO") && sim.equals("ARREGLO") ) || ( categoria.equals("ARREGLO") && sim.equals("PARAMETRO") ) ){
                    //  return tablaSimbolos.get(i).getTipo();
                }
            }

            if (categoria.equals("SUBPROGRAMA") && tablaSimbolos.get(i).getNombre().equals(id)) {
                return tablaSimbolos.get(i).getTipo();
            }
        }
        return null;
    }

    public List<String> parametrosFuncion(String id) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && tablaSimbolos.get(i).getCategoria().equals("SUBPROGRAMA")) {
                return tablaSimbolos.get(i).getListaParametros();
            }
        }
        return null;
    }

    public List<Instruction> instruccionesFuncion(String id) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id)  && tablaSimbolos.get(i).getCategoria().equals("SUBPROGRAMA")) {
                return tablaSimbolos.get(i).getInstruccionesFuncion();
            }
        }
        return null;
    }

    public List<String> dimensionesArreglo(String id, int ambito) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && ambito == tablaSimbolos.get(i).getAmbito() && tablaSimbolos.get(i).getCategoria().equals("ARREGLO")) {
                return tablaSimbolos.get(i).getTamanoDimensiones();
            }
        }
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && 0 == tablaSimbolos.get(i).getAmbito() && tablaSimbolos.get(i).getCategoria().equals("ARREGLO")) {
                return tablaSimbolos.get(i).getTamanoDimensiones();
            }
        }
        return null;
    }

    public void setDimensionGeneralArreglo(String id, int ambito, String dimensionGeneral) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && ambito == tablaSimbolos.get(i).getAmbito() && tablaSimbolos.get(i).getCategoria().equals("ARREGLO")) {
                tablaSimbolos.get(i).setDimensionGeneral(dimensionGeneral);
            }
        }
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && 0 == tablaSimbolos.get(i).getAmbito() && tablaSimbolos.get(i).getCategoria().equals("ARREGLO")) {
                tablaSimbolos.get(i).setDimensionGeneral(dimensionGeneral);
            }
        }

    }
    
    

    public Integer getIdAmbit(String id, int ambito, String categoria) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && ambito == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (categoria.equals(sim)) {
                    return ambito;
                    // }else if ( ( categoria.equals("ARREGLO") && sim.equals("VARIABLE") ) || ( categoria.equals("VARIABLE") && sim.equals("ARREGLO") ) ){
                    //   return tablaSimbolos.get(i).getTipo();
                } else if ((categoria.equals("PARAMETRO") && sim.equals("VARIABLE")) || (categoria.equals("VARIABLE") && sim.equals("PARAMETRO"))) {
                    return ambito;
                    //}else if( ( categoria.equals("PARAMETRO") && sim.equals("ARREGLO") ) || ( categoria.equals("ARREGLO") && sim.equals("PARAMETRO") ) ){
                    //  return tablaSimbolos.get(i).getTipo();
                }
            }

            if (categoria.equals("SUBPROGRAMA") && tablaSimbolos.get(i).getNombre().equals(id)) {
                return ambito;
            }
        }
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && 0 == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (categoria.equals(sim)) {
                    return 0;
                    // }else if ( ( categoria.equals("ARREGLO") && sim.equals("VARIABLE") ) || ( categoria.equals("VARIABLE") && sim.equals("ARREGLO") ) ){
                    //   return tablaSimbolos.get(i).getTipo();
                } else if ((categoria.equals("PARAMETRO") && sim.equals("VARIABLE")) || (categoria.equals("VARIABLE") && sim.equals("PARAMETRO"))) {
                    return 0;
                    //}else if( ( categoria.equals("PARAMETRO") && sim.equals("ARREGLO") ) || ( categoria.equals("ARREGLO") && sim.equals("PARAMETRO") ) ){
                    //  return tablaSimbolos.get(i).getTipo();
                }
            }

            if (categoria.equals("SUBPROGRAMA") && tablaSimbolos.get(i).getNombre().equals(id)) {
                return 0;
            }
        }
        return null;
    }
    
    
    public Integer getArregloAmbit(String id, int ambito, String categoria) {
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && ambito == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (categoria.equals(sim)) {
                    return ambito;
                    // }else if ( ( categoria.equals("ARREGLO") && sim.equals("VARIABLE") ) || ( categoria.equals("VARIABLE") && sim.equals("ARREGLO") ) ){
                    //   return tablaSimbolos.get(i).getTipo();
                } 
            }

            
        }
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && 0 == tablaSimbolos.get(i).getAmbito()) {
                String sim = tablaSimbolos.get(i).getCategoria();
                if (categoria.equals(sim)) {
                    return 0;
                    // }else if ( ( categoria.equals("ARREGLO") && sim.equals("VARIABLE") ) || ( categoria.equals("VARIABLE") && sim.equals("ARREGLO") ) ){
                    //   return tablaSimbolos.get(i).getTipo();
                } 
            }

           
        }
        return null;
    }
    
    

    public String getTSalidaFuncion(String id) {

        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id)  && tablaSimbolos.get(i).getCategoria().equals("SUBPROGRAMA")) {
                return tablaSimbolos.get(i).gettSalida();
            }
        }
        return "";

    }
    
    public Simbolos getSimbolFuncion(String id) {

        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getNombre().equals(id) && tablaSimbolos.get(i).getCategoria().equals("SUBPROGRAMA")) {
                return tablaSimbolos.get(i);
            }
        }
        return null;

    }

    public List<Simbolos> getTable() {
        return this.tablaSimbolos;
    }

    public void cleanAll() {
        this.tablaSimbolos.clear();
    }

    public int size() {
        return this.tablaSimbolos.size();
    }
    
    public List<Simbolos> getVariables(String categoria,int ambito) {
        List<Simbolos> listado = new ArrayList<>();
        for (int i = 0; i < tablaSimbolos.size(); i++) {
            if (tablaSimbolos.get(i).getCategoria().equals(categoria) && ambito == tablaSimbolos.get(i).getAmbito() ) {
                listado.add(tablaSimbolos.get(i));
            }
        }
        return listado;

    }

}
