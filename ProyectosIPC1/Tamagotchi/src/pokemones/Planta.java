package pokemones;

/**
 *
 * @author bryan
 */
public class Planta extends Original{
    
    public Planta(String nombre,String tipo,String imagen){
        this.nombre=nombre;
        this.tipo=tipo;
        this.imagen=imagen;
    }
    @Override
    public void almacenar(){  
        String image= imagen;
        //asignacion de caracteristicas de pokemon
        nombresPokemon[contadorPokemon]=nombre;                
        nivelesPokemon[contadorPokemon]=nivel;
        imagenesPokemon[contadorPokemon]=imagen;
        puntosDeVidaPokemon[contadorPokemon]=puntosDeVida;
        experienciaDePokemon[contadorPokemon]=experiencia;
    }
    
}
