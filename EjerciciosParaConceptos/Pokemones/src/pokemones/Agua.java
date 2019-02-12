/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemones;

/**
 *
 * @author bryan
 */
public class Agua extends Pokemon{
    
    public Agua(String nombre,String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    
    }
    
    @Override
    public void almacenar(){      
        nombresPokemon[contadorPokemon]=nombre;
        System.out.println("el pokemon "+nombre+" se almaceno en la pos. "+contadorPokemon+"del arreglo");
    }
    

    
}
