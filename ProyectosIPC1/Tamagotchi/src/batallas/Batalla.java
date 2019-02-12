
package batallas;

import java.util.Scanner;
import jugadores.Adversario;
import jugadores.Jugador;
import static jugadores.Jugador.huir;
import jugadores.Retador;
import static pokemones.Pokemon.experienciaDePokemon;
import static pokemones.Pokemon.experienciaPokemonEnJuego;
import static pokemones.Pokemon.pokemonElegido;
import static pokemones.Pokemon.puntosDeVidaPokemon;
import static pokemones.Pokemon.vidaPokemonEnJuego;

/**
 *
 * @author bryan
 */
public class Batalla {
    static Scanner scanner =new Scanner(System.in);     //scanner para enteros
    static Scanner scanner4 = new Scanner(System.in);   //scaner para caracteres
    static int contadorBatalla=0;
    
    public static int turnoInicial=1;
    public static String codigoRecibido;
    //metodos
    
    public void mostrarOpciones(){
        String nombreJugador;
        int opcion;
               
        System.out.println("\n::Bienvenido a la Batalla::");
        //ingresando nombre del jugador
        System.out.println("\nIngrese su nombre: ");
        nombreJugador=scanner4.nextLine();
        //menu de opcion para el jugador
        System.out.println("\nQue opcion deseas:");
        System.out.println("\n1.Retador");
        System.out.println("2.Adversario");
        opcion=scanner.nextInt();
            if(opcion==2){
                //creando objeto nuevo adversario
                System.out.println("\nEn espera de codigo: ");
                System.out.println("ingresar: ");
                codigoRecibido=scanner4.nextLine();
                turnoInicial++;
                Batalla seguirCombate=new Batalla();
                seguirCombate.combate(codigoRecibido);
                
            }
            else{
                //creando objeto nuevo retador
                Retador nuevoRetador= new Retador();
                nuevoRetador.iniciarBatalla();//iniciando batalla
            }
    }
    public void combate(String codigo){
        
        do{
            if(turnoInicial%2==0){        
                System.out.println("");
                Jugador nuevaOpcion = new Jugador();
                nuevaOpcion.elegirOpcion();//eligiendo opcion en el menu de batalla
                turnoInicial++;                 
            }
            else {
                System.out.println("\nRecibir codigo");  
                System.out.print("ingresar: ");
                codigoRecibido=scanner4.nextLine();
                turnoInicial++;
            }
        
          
        }
            while(huir==false&&vidaPokemonEnJuego!=0);
        
        if(vidaPokemonEnJuego>0){
            System.out.println("\nGANASTE LA BATALLA");
            int vidaPokemonElegido;
            puntosDeVidaPokemon[pokemonElegido]=vidaPokemonEnJuego+50;
            experienciaDePokemon[pokemonElegido]=experienciaPokemonEnJuego+60;
        
        }
    }
}
