/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import static pokemones.Pokemon.imagenesPokemon;
import static pokemones.Pokemon.nombresPokemon;

/**
 *
 * @author bryan
 */
public class Estado extends Reporte{
    
    public static String[] estadosPokemon=new String[5];

    @Override
    public void mostrarReporte(){
        
        System.out.println(":::Reporte De estado de Pokemons::: ");
        System.out.println("");
        int k=0;
        int cont=1;//contador
        for(String i:imagenesPokemon){//imprimiendo imagenes
            System.out.println("cont"+nombresPokemon[k]+": "+estadosPokemon[k]);
            System.out.println(i);
            k++;
        
        }
    
}    
}

