package reportes;

import static pokemones.Pokemon.nombresPokemon;

/**
 *
 * @author bryan
 */
public class Alimento1 extends Reporte{
    
    //alimentos
    public static int [] alimentosPositivos=new int[4];
    public static int [] alimentosNegativos=new int[4];
    
    //constructor
    public Alimento1(){
        
        
      
    }
    //atributos heredados
    @Override
    public void mostrarReporte(){
        System.out.println(":::Reporte de alimentos ");
        System.out.println("");
        int k=0;
        int cont=1;//contador
        System.out.println("Saludables");
        for(int i:alimentosPositivos){//imprimiendo alimentos saludables
            System.out.println("cont"+nombresPokemon[k]+": "+i);
            System.out.println("");
            System.out.println(i);
            k++;
        
        }
        System.out.println("\nNo Saludables");
        for(int i:alimentosNegativos){//imprimiendo alimentos no saludables
            System.out.println("cont"+nombresPokemon[k]+": "+i);
            System.out.println("");
            System.out.println(i);
            k++;
        
        }
    }
    
}
