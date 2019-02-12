
package pokemones;

/**
 *
 * @author bryan
 */
public class Otros extends Original{
    
    public Otros(String nombre,String tipo,String imagen){
        this.nombre=nombre;
        this.tipo=tipo;
        this.imagen=imagen;
    }
    @Override
    public void almacenar(){      
        //asignacion de caracteristicas de pokemon
        nombresPokemon[contadorPokemon]=nombre;
        imagenesPokemon[contadorPokemon]=imagen;
        nivelesPokemon[contadorPokemon]=nivel;
        puntosDeVidaPokemon[contadorPokemon]=puntosDeVida;
        experienciaDePokemon[contadorPokemon]=experiencia;
    }
    
}
