
package jugadores;

import batallas.Batalla;
import static batallas.Batalla.turnoInicial;
import java.util.Scanner;
import static pokemones.Pokemon.nombrePokemonEnJuego;


/**
 *
 * @author bryan
 */

//herencia de adversario
public class Adversario extends Jugador {
    static Scanner scanner4 = new Scanner(System.in);   //scaner para cadenas
    
    //constructor de adversario
    
    @Override
    public void esperarBatalla(){
        String codigoParaEnviar;
        String nombrePokemon;
        String parte1="mi";
        String parte2="|0";
        //Adversario en espera de batalla
        System.out.println("\nCodigo a enviar: ");
        System.out.println("mi"+nombrePokemonEnJuego+"|0");
        
        nombrePokemon=nombrePokemonEnJuego;
        codigoParaEnviar=parte1+nombrePokemon+parte2;
        //enviar el parametro
        
        Batalla seguirCombate= new Batalla();
        seguirCombate.combate(codigoParaEnviar);
    }
}
