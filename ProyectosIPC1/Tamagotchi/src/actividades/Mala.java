
package actividades;
import static pokemones.Pokemon.pokemonElegido;
import static pokemones.Pokemon.puntosDeVidaPokemon;
import static pokemones.Pokemon.vidaPokemonEnJuego;
import static reportes.Actividad.actividadesNoSaludables;

/**
 *
 * @author bryan
 */
public class Mala extends Actividad{

    public Mala(String nombre,String tipo){
        
        this.nombre=nombre;
        this.tipo=tipo;
    }
    @Override
    public void realizarActividad(int daño){
        int proceso;
        int restar=daño;
        System.out.println("\nActividad Completada");
        System.out.println("Actividad: "+nombre);
        System.out.println("Tipo: "+tipo);
        System.out.println("Daño a Salud: "+restar+" Pts.\n");
        
        proceso=vidaPokemonEnJuego-restar;
        vidaPokemonEnJuego=proceso;
        
        puntosDeVidaPokemon[pokemonElegido]=vidaPokemonEnJuego;
        actividadesNoSaludables[pokemonElegido]=contadorActividad1;
        contadorActividad1++;
    }
}
