/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CErrores;

import Objetos.Dato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class CErrores {
    
    private static List<CError> listaErrores = new ArrayList<CError>();
    
    public static void agregarError(String tipoError,String tipoErrorSemantico, Dato dato,Integer ambito , String tipo, Integer fila, Integer columna,String mensaje){
        CError err = new CError(tipoError,tipoErrorSemantico ,dato, ambito, tipo, fila, columna, mensaje);
        listaErrores.add(err);
    }
    
    public static List<CError> getListaErrores(){
        return listaErrores;
    }
    
    public static void reiniciar(){
        listaErrores.clear();
    }
    
}
