
package pokemones;

import static reportes.Estado.estadosPokemon;


/**
 *
 * @author bryan
 */
public class Inventado extends Pokemon{
    
    @Override
    public void crear(){
    char opcionVolver='s';
    int renglones;
    String almacenar="\n";
    String almacenar2="";
    String totalAlmacenar="";
    while(contadorPokemon<LIMITE_POKEMON&&(opcionVolver=='s'||opcionVolver=='S')){
        
        System.out.println("\n\n::Ingrese los Siguientes Datos::");
        System.out.print("\nNombre: ");
        nombre=scanner3.nextLine();
        System.out.println("[Imagen por renglones] ");
        System.out.println("cuantos renglones posee su imagen: ");
        renglones=scanner.nextInt();
        int n=1;
        for (int i = 0; i < renglones; i++) {
            System.out.print("renglon "+n+":");
            imagen=scanner4.nextLine();
            n++;
            almacenar2=almacenar+imagen;
            totalAlmacenar=totalAlmacenar+almacenar2;
        }
            //comprobando que no se repita el nombre o imagen de algun pokemon
            int i=0;
            //busqueda secuencial
            while(i<5 && encontrar==false){
                if(nombresPokemon[i].equals(nombre)){
                    encontrar=true;
                }
                    else if(imagenesPokemon[i].equals(imagen)){
                        encontrar=true;
                    }
                i++;
            }
                    if(encontrar==true){
                        System.out.println("\nEl nombre y/o la imagen ya pertenecen a un pokemon ");
                        contadorPokemon --;
                        encontrar=false;
                    }
                    else{
                        //asignacion de nombre e imagen de pokemon
                        nombresPokemon[contadorPokemon]=nombre;
                        imagenesPokemon[contadorPokemon]=totalAlmacenar;
                        nivelesPokemon[contadorPokemon]=nivel;
                        puntosDeVidaPokemon[contadorPokemon]=puntosDeVida;
                        experienciaDePokemon[contadorPokemon]=experiencia;
                        estadosPokemon[contadorPokemon]=estadoV;
                    }
        almacenar2="";
        totalAlmacenar="";
        contadorPokemon++;
        System.out.println("\nDesea crear algun otro pokemon?? [S]i, [N]o");
        opcionVolver=scanner2.next().charAt(0);
    }
        //condicion si se llega al maximo de pokemons
        if(contadorPokemon==5){
            System.out.println("YA POSEES EL MAXIMO DE POKEMONS");
        }

}
    
}
