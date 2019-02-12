
package alimentos;
import java.util.Scanner;
import pokemones.Pokemon;

/**
 *
 * @author bryan
 */
public class Alimento {
    
    static Scanner scanner =new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    
    final int beneficioFruta=10;
    final int beneficioVerdura=15;
    final int beneficioConcentrado=12;
    
    final int dañoChocolate=10;
    final int dañoComidaChatarra=15;
    final int dañoGolosina=12;
    
    //atributos
    String nombre;
    String tipo;
    public static int contadorDeAlimento=1;
    public static int contadorDeAlimento2=1;
    //constructor de alimento
    public Alimento(){}
    
    //menu
    
    //atributos
    public void alimentar(int dato){}
    public void almacenar(){}
    public void mostrarMenu(){
        int opcion;
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
        
        System.out.println("\n1.Alimentos saludabeles");
        System.out.println("2.Alimentos Daninos");
        
        System.out.println("\nIngrese numero de opcion: ");
        opcion=scanner.nextInt();
        
            if(opcion==1){
                Alimento nuevoAlimento= new Alimento();
                nuevoAlimento.mostrarSubMenu1();
            }
            else{
               Alimento nuevoAlimento = new Alimento();
               nuevoAlimento.mostrarSubMenu2();
            }
        
    }
    public void mostrarSubMenu1(){
        int opcion;
        
        System.out.println("\n1.Fruta");
        System.out.println("2.Verdura");
        System.out.println("3.Concentrado");
                
        System.out.println("\nIngrese numero de opcion: ");
        opcion=scanner.nextInt();
                
            switch(opcion){
                case 1:{
                    Saludable fruta=new Saludable("fruta","saludable");
                    fruta.alimentar(beneficioFruta);
                break;
                }
                case 2:{
                    Saludable verdura= new Saludable("verdura","saludable");
                    verdura.alimentar(beneficioVerdura);
                break;
                }
                default:{
                    Saludable concentrado= new Saludable("Concentrado","saludable");
                    concentrado.alimentar(beneficioConcentrado);
                break;
                }
            }
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
    }
    public void mostrarSubMenu2(){
        int opcion;
        
        System.out.println("\n1.Comida Chatarra");
        System.out.println("2.Chocolate");
        System.out.println("3.Golosinas");
                
        System.out.println("\nIngrese numero de opcion: ");
        opcion=scanner.nextInt();
                
            switch(opcion){
                case 1:{
                    Dañino comidaChatarra= new Dañino("Comida Chatarra","Dañino");
                    comidaChatarra.alimentar(dañoComidaChatarra);
                break;
                }
                case 2:{
                    Dañino chocolate = new Dañino("Chocolate","Dañino");
                    chocolate.alimentar(dañoChocolate);
                break;
                }
                default:{
                    Dañino golosinas= new Dañino("Golosinas","Dañino");
                    golosinas.alimentar(dañoGolosina);
                break;
                }
            }
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
    }
    
    
}
