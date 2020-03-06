/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Temporales {
    
     private static String temporal = "t";
    private static int contador = 0;
    
    private static ArrayList<VariableT> listado = new ArrayList<>();

    public static String siguienteTemporal(String tipo){
        temporal = "t" + contador;
        contador++;
        agregarT(temporal, tipo);
        if(tipo==null){
            System.out.println("error");
        }
        return temporal;
    }
    
    
    public static String actualTemporal(String tipo) {
        contador--;
        temporal = "t" + contador;
        contador++;
        return temporal;
    }
    
    public static void agregarT(String t, String tipo){
       listado.add(new VariableT(tipo, t));
       
    }
    
    public static List<VariableT> getListado(){
        return listado;
    }
    
    
    

    public static String ultimoTemporal() {
        return temporal;
    }

    public static void reiniciar() {
        contador = 0;
    }

    

}
