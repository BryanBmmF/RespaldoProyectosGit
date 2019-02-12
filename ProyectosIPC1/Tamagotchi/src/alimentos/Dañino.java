
package alimentos;

import static pokemones.Pokemon.pokemonElegido;
import static pokemones.Pokemon.puntosDeVidaPokemon;
import static pokemones.Pokemon.vidaPokemonEnJuego;
import static reportes.Alimento1.alimentosNegativos;

/**
 *
 * @author bryan
 */
public class Dañino extends Alimento {
    
    //constructor
    public Dañino(String nombre, String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }
    @Override
    public void alimentar(int daño){
        int proceso;
        int restar=daño;
        System.out.println("Alimentacion Completada");
        System.out.println("Alimento: "+nombre);
        System.out.println("Tipo: "+tipo);
        System.out.println("Daño a Salud: "+restar+" Pts.");
        
        proceso=vidaPokemonEnJuego-restar;
        vidaPokemonEnJuego=proceso;
        
        puntosDeVidaPokemon[pokemonElegido]=vidaPokemonEnJuego;
        alimentosNegativos[pokemonElegido]=contadorDeAlimento;
        contadorDeAlimento++;
        
    }
    @Override
    public void almacenar(){}
    
}
