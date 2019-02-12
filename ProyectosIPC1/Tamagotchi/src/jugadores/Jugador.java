
package jugadores;

import java.util.Random;
import java.util.Scanner;
import static pokemones.Pokemon.nivelPokemonEnJuego;
import static pokemones.Pokemon.nombrePokemonEnJuego;

/**
 *
 * @author bryan
 */
public class Jugador {
    static Scanner scanner2 = new Scanner(System.in);   //scaner para caracteres
    //atributos
    String nombre;
    int numeroDepokemons;
    int numeroAleatorio;
    int numeroAleatorio2;
    public static boolean huir=false;
    public static int atacar;
    Random aleatorio = new Random();//declarando variables tipo random para aleatoriedad
 
    //constructor de jugador
    public Jugador(){}
    
    //metodos
    public void obtenerTurno(){
        int turno;          //declaracion atributos
        Random aleatorio = new Random();//declarando variables tipo random para aleatoriedad
        
        //eligiendo aleatoriamente el primer turno
        turno = (aleatorio.nextInt(2)+1);
            //si turno =1 inicia el adversario de lo contrario el retador
            if(turno==2){
                System.out.println("Turno de Retador: ");
                Retador inicia =new Retador();
                inicia.generarCodigoInicial();
            }
            else{
                System.out.println("Turno de Adversario");
                Adversario espera=new Adversario();//en espera de batalla
                espera.esperarBatalla();
                
            }
    }
    public void iniciarBatalla(){}
    public void generarCodigoInicial(){}
    public void esperarBatalla(){}
    public void remplazarPokemon(){}
    public void atacar(){
         int aleatorio;        //variables para aleatorio
         Random numeroAleatorio = new Random(); //declarando variables tipo random para aleatoriedad
         int ataqueJugador;
        //acciones de la funcion atacar sobre vida del Adversario
        aleatorio = (numeroAleatorio.nextInt(20-10+1)+10);
        ataqueJugador= ((nivelPokemonEnJuego+1)*10)+aleatorio;
        System.out.println("\nEnviar Codigo: ");
        System.out.println("mi"+nombrePokemonEnJuego+"|"+ataqueJugador);
    }
    public void huir(){
        huir=true;//huyendo de la batalla
    }
    public void elegirOpcion(){
        int opcion;
        System.out.println("\nOpciones de Batalla: ");
        System.out.println("\n1.Atacar");
        System.out.println("2.Huir");
        System.out.print("\nIngrese numero de Opcion: ");
        opcion=scanner2.nextInt();
        
            if(opcion==1){
                Jugador nuevoAtaque =new Jugador();
                nuevoAtaque.atacar();
            }
            else{
                System.out.println("huir de la batalla");
                Jugador nuevaHuida =new Jugador();
                nuevaHuida.huir();
            }
    }
    
}
