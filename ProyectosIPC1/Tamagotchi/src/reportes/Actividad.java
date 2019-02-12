
package reportes;

import static pokemones.Pokemon.nombresPokemon;

/**
 *
 * @author bryan
 */
public class Actividad extends Reporte{
    //actividades
    public static int[] actividadesRealizadas= new int[5];
    public static int[] actividadesSaludables=new int[5];
    public static int[] actividadesNoSaludables=new int[5];
    
    //constructor
    public Actividad(){
        
        
        
    }
    @Override
    public void mostrarReporte(){
        System.out.println(":::Reporte de Actividades ");
        System.out.println("");
        int k=0;
        int cont=1;//contador
        System.out.println("Saludables");
        for(int i:actividadesSaludables){//imprimiendo alimentos saludables
            System.out.println("cont"+nombresPokemon[k]+": "+i);
            System.out.println("");
            System.out.println(i);
            k++;
        
        }
        System.out.println("\nNo Saludables");
        for(int i:actividadesNoSaludables){//imprimiendo alimentos no saludables
            System.out.println("cont"+nombresPokemon[k]+": "+i);
            System.out.println("");
            System.out.println(i);
            k++;
        
        }
    }
    
    
    
}
