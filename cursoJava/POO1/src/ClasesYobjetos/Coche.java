
package ClasesYobjetos;

/**
 *
 * @author bryan
 */
public class Coche {
    
    //atributos
    String color;
    String marca;
    int km;
    
    //metodo
    public static void main(String[]args){
        
        //creacion de objetos o instanciacion de un objeto
        Coche coche1 = new Coche();
        
        //heredando los atributos de la clase padre Coche al hijo coche 1
        coche1.color="blanco";
        coche1.marca="Audi";
        coche1.km =0;
        
        //imprimiendo atributos
        System.out.println("El color del coche1 es: "+coche1.color);
        System.out.println("la marca del coche1 es"+coche1.marca);
        System.out.println("El kilometraje sel coche1 es:"+coche1.km);
        
        //instamciacion del Coche2
        
        Coche coche2 = new Coche();
        
        //heredando
        coche2.color="rojo";
        coche2.marca="Ferrari";
        coche2.km=100;
        
        //imprimiendo atributos
        System.out.println("\nEl color del coche2 es: "+coche2.color);
        System.out.println("la marca del coche2 es"+coche2.marca);
        System.out.println("El kilometraje sel coche2 es:"+coche2.km);
        
        
       
        
    }
    
    
    
    
}
