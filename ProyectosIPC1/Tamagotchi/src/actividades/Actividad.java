
package actividades;

import static actividades.Buena.scanner;
import java.util.Scanner;
import pokemones.Pokemon;

/**
 *
 * @author bryan
 */
public class Actividad {
    static Scanner scanner =new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    
    final int beneficioDucha=10;
    final int beneficioVacuna=15;
    final int beneficioEjercicio=12;
    
    final int dañoResfriado=10;
    final int dañoInfeccion=15;
    final int dañoGolpe=12;
    
    String tipo;
    String nombre;
    public static int contadorActividad1=1;
    public static int contadorActividad2=1;
    public void mostrarMenu(){
        int opcion;
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
        
        //menu Actividades disponibles
        System.out.println("\n1.Actividades para curar y mantener la salud");
        System.out.println("2.Actividades para enfermar y restar salud");
        
        System.out.println("\nIngrese numero de opcion: ");
        opcion=scanner.nextInt();
        
            if(opcion==1){
                Actividad nuevaActividad=new Actividad();
                nuevaActividad.mostrarSubMenu1();
            
            }
            else{
               Actividad nuevaActividad=new Actividad();
               nuevaActividad.mostrarSubMenu2();
               
            }
    }
    public void realizarActividad(int dato){
        System.out.println("Actividad realizada!!!");
       
    }    
    public void mostrarSubMenu1(){
        int opcion;
        
        System.out.println("\n1.Ejercicio");
        System.out.println("2.Ducha");
        System.out.println("3.Vacuna");
                
        System.out.println("\nIngrese numero de opcion: ");
        opcion=scanner.nextInt();
                
            switch(opcion){
                case 1:{
                    Buena ejercicio=new Buena("Ejercicio","Actividad Buena");
                    ejercicio.realizarActividad(beneficioEjercicio);
                break;
                }
                case 2:{
                    Buena ducha=new Buena("Ducha","Actividad buena");
                    ducha.realizarActividad(beneficioDucha);
                break;
                }
                default:{
                    Buena vacuna=new Buena("Vacuna","Actividad buena");
                    vacuna.realizarActividad(beneficioVacuna);
                break;
                }
            }
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
}
    public void mostrarSubMenu2(){
        int opcion;
        
        System.out.println("\n1.Resfriado");
        System.out.println("2.Infeccion");
        System.out.println("3.Golpe");
                
        System.out.println("\nIngrese numero de opcion: ");
        opcion=scanner.nextInt();
                
            switch(opcion){
                case 1:{
                    Mala resfriado=new Mala("Resfriado","Actividad mala");
                    resfriado.realizarActividad(dañoResfriado);
                break;
                }
                case 2:{
                    Mala infeccion=new Mala("Infeccion","Actividad Mala");
                    infeccion.realizarActividad(dañoInfeccion);
                break;
                }
                default:{
                    Mala golpe=new Mala("Golpe","actividad Mala");
                    golpe.realizarActividad(dañoGolpe);
                break;
                }
            }
            
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
    
}
    
}
