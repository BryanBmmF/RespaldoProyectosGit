
package pokemones;

import imagenes.Imagen;
import static imagenes.Imagen.agua1;
import static imagenes.Imagen.agua2;
import static imagenes.Imagen.agua3;
import static imagenes.Imagen.fuego1;
import static imagenes.Imagen.fuego2;
import static imagenes.Imagen.fuego3;
import static imagenes.Imagen.otro1;
import static imagenes.Imagen.otro2;
import static imagenes.Imagen.otro3;
import static imagenes.Imagen.otro4;
import static imagenes.Imagen.planta1;
import static imagenes.Imagen.planta2;
import static imagenes.Imagen.planta3;
import static pokemones.Pokemon.contadorPokemon;

/**
 *
 * @author bryan
 */
public class Original extends Pokemon {
    
    @Override
    public void crear(){
    char opcionVolver='s';
    int  opcion;
    boolean encontrar=false;
    System.out.println("\n:::Pokemones disponibles:::");    
    while(contadorPokemon<5&&(opcionVolver=='s'||opcionVolver=='S'))
    {
    System.out.println("\nTipo de pOkemon");
    System.out.println("\n1.Agua");
    System.out.println("2.Fuego");
    System.out.println("3.Planta");
    System.out.println("4.Otros");
    System.out.println("\nIngrese numero de opcion: ");
    opcion=scanner.nextInt();
    
        switch(opcion){
            case 1:{
                    Imagen nuevaImagen=new Imagen();
                    nuevaImagen.pokemonAgua();
                    System.out.println("ingrese el numero del Pokemon a crear: ");
                    opcion=scanner.nextInt();
                        switch(opcion){
                            case 1:{
                                //buscando secuencial de pokemon agua 1
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Squirtle")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Agua nuevoPokemon =new Agua("Squirtle","Agua",agua1);
                                    nuevoPokemon.almacenar();
                                    
                                }
                            break;
                            }
                            case 2:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Blastoise")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                Agua nuevoPokemon =new Agua("Blastoise","Agua",agua2);
                                nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 3:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Wartortle")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                Agua nuevoPokemon =new Agua("Wartortle","Agua",agua3);
                                nuevoPokemon.almacenar();
                                }
                            break;
                            }
                        }
            break;
            }
            case 2:{
                    Imagen nuevaImagen=new Imagen();
                    nuevaImagen.pokemonFuego();
                    System.out.println("ingrese el numero del Pokemon a crear: ");
                    opcion=scanner.nextInt();
                        switch(opcion){
                            case 1:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Charmander")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Fuego nuevoPokemon =new Fuego("Charmander","Fuego",fuego1); 
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 2:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Charmeleon")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Fuego nuevoPokemon =new Fuego("Charmeleon","Fuego",fuego2);
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 3:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Charizard")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Fuego nuevoPokemon =new Fuego("Charizard","Fuego",fuego3);
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                        }
                    
            break;
            }
            case 3:{
                    Imagen nuevaImagen=new Imagen();
                    nuevaImagen.pokemonPlanta();
                    System.out.println("ingrese el numero del Pokemon a crear: ");
                    opcion=scanner.nextInt();
                        switch(opcion){
                            case 1:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Bulbasaur")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Planta nuevoPokemon =new Planta("Bulbasaur","Planta",planta1);  
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 2:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Venusaur")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Planta nuevoPokemon =new Planta("Venusaur","Planta",planta2);
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 3:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Ivysaur")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Planta nuevoPokemon =new Planta("Ivysaur","Planta",planta3);
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                        }
                    
            break;
            }
            default:{
                    Imagen nuevaImagen=new Imagen();
                    nuevaImagen.otros();
                    System.out.println("ingrese el numero del Pokemon a crear: ");
                    opcion=scanner.nextInt();
                        switch(opcion){
                            case 1:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("PIKACHU")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Otros nuevoPokemon =new Otros("PIKACHU","Electrico",otro1);  
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 2:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Golem")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Otros nuevoPokemon =new Otros("Golem","Tierra",otro2);
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 3:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Slowbro")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Otros nuevoPokemon =new Otros("Slowbro","Normal",otro3);
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            default:{
                                //buscando secuencial de pokemon agua 2
                                int i=0;
                                while(i<5 && encontrar==false){
                                    if(nombresPokemon[i].equals("Cataperie")){
                                        encontrar=true;
                                    }
                                    i++;
                                }
                                if(encontrar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Otros nuevoPokemon =new Otros("Cataperie","Insecto",otro4);
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                        }
            break;      
            }
        
        }
        contadorPokemon++;
    System.out.println("Desea crear algun otro pokemon?? [S]i, [N]o");
    opcionVolver=scanner2.next().charAt(0);
    }
    if(contadorPokemon==5){
    System.out.println("ya posees el MAXIMO de pokemones");
    }
}
    @Override
    public void alimentar(){

}
    @Override
    public void revivir(){}
    @Override
    public void eliminar(){}
    @Override
    public void desmayar(){}
    
    public void almacenar(){
     
    }
    
}
