
package reportes;

import static pokemones.Pokemon.imagenesPokemon;
import static pokemones.Pokemon.nombresPokemon;

/**
 *
 * @author bryan
 */
public class Visual extends Reporte{
    
    @Override
    public void mostrarReporte(){
        
        System.out.println(":::Reporte Visual De Pokemones::: ");
        System.out.println("");
        int k=0;
        int cont=1;//contador
        for(String i:imagenesPokemon){//imprimiendo imagenes
            System.out.println("cont"+nombresPokemon[k]);
            System.out.println(i);
            k++;
        
        }
        
    
    }
}
