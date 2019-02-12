
package actividades;

import static pokemones.Pokemon.pokemonElegido;
import static pokemones.Pokemon.puntosDeVidaPokemon;
import static pokemones.Pokemon.vidaPokemonEnJuego;
import static reportes.Actividad.actividadesSaludables;

/**
 *
 * @author bryan
 */
public class Buena extends Actividad {
    
    public Buena(String nombre, String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }
    @Override
    public void realizarActividad(int beneficio){
        int sumar=beneficio;
        int proceso;
        System.out.println("\nActividad completada!!!!");
        System.out.println("Actividad: "+nombre);
        System.out.println("Tipo: "+tipo);
        System.out.println("Beneficio a Salud: "+sumar+" Pts.\n");
        
        proceso=vidaPokemonEnJuego+sumar;
        vidaPokemonEnJuego=proceso;
        
        puntosDeVidaPokemon[pokemonElegido]=vidaPokemonEnJuego;
        actividadesSaludables[pokemonElegido]=contadorActividad1;
        contadorActividad1++;
    }
    

}
