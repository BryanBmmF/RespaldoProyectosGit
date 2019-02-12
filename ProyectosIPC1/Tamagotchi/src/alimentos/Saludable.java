
package alimentos;

import static pokemones.Pokemon.pokemonElegido;
import static pokemones.Pokemon.puntosDeVidaPokemon;
import static pokemones.Pokemon.vidaPokemonEnJuego;
import static reportes.Alimento1.alimentosPositivos;

/**
 *
 * @author bryan
 */
public class Saludable extends Alimento {
    
    //constructor
    public Saludable(String nombre, String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }
    
    //atributos heredados
    @Override
    public void alimentar(int beneficio){
        int sumar=beneficio;
        int proceso;
        System.out.println("Alimentacion completada!!!!");
        System.out.println("Alimento: "+nombre);
        System.out.println("Tipo: "+tipo);
        System.out.println("Beneficio a Salud: "+sumar+" Pts.");
        
        proceso=vidaPokemonEnJuego+sumar;
        vidaPokemonEnJuego=proceso;
        
        puntosDeVidaPokemon[pokemonElegido]=vidaPokemonEnJuego;
        alimentosPositivos[pokemonElegido]=contadorDeAlimento2;
        contadorDeAlimento2++;
    }
    @Override
    public void almacenar(){}
    
}
