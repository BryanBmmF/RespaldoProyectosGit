
package jugadores;

import batallas.Batalla;
import static batallas.Batalla.turnoInicial;
import java.util.Random;
import java.util.Scanner;
import static pokemones.Pokemon.nivelPokemonEnJuego;
import static pokemones.Pokemon.nombrePokemonEnJuego;

/**
 *
 * @author bryan
 */
public class Retador extends Jugador {
    static Scanner scanner4 = new Scanner(System.in);   //scaner para cadenas
    
    @Override
    public void iniciarBatalla(){
        //inicio de la battalla por el ratador
        
        Jugador nuevoJugador=new Jugador();
        nuevoJugador.obtenerTurno();  //obteniendo turno 
        
    }
    @Override
    public void generarCodigoInicial(){
        String codigoParaEnviar;
        String nombrePokemon;
        String parte1="mi";
        char pas ='|';
        int parte2;
        int aleatorio;        //variables para aleatorio
         Random numeroAleatorio = new Random(); //declarando variables tipo random para aleatoriedad
         int ataqueJugador;
        //acciones de la funcion atacar sobre vida del Adversario
        aleatorio = (numeroAleatorio.nextInt(20-10+1)+10);
        ataqueJugador= ((nivelPokemonEnJuego+1)*10)+aleatorio;
        
        System.out.println("\ncodigo para enviar:");
        System.out.println("mi"+nombrePokemonEnJuego+"|"+ataqueJugador);
        
        nombrePokemon=nombrePokemonEnJuego;
        parte2=ataqueJugador;
        codigoParaEnviar=parte1+nombrePokemon+pas+parte2;
        
        Batalla seguirCombate= new Batalla();
        seguirCombate.combate(codigoParaEnviar);
        
    }
    
}
