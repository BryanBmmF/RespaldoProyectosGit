
package pokemones;

import imagenes.Imagen;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Pokemon {
    
    static Scanner scanner =new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in);
    //Atributos de pokemon
    
    //reportes
    int [] conticantesDesmayados=new int[4];
    int[] huidasRealizadas=new int[4];
    int[] desmayadas=new int[4];
    int[] batallasGanadas=new int[4];
    int[] batallasPerdidas=new int[4];
    
    //general
    static String nombresPokemon[]={"es","es","es","es","es"};
    String[] tiposPokemon=new String[4];
    int[] nivelesPokemon=new int[4];
    int[] puntosDeVidapokemon=new int[4];
    String[] imegenesPokemon= new String[4];
    
    //actividades
    int[] actividadesRealizadas= new int[5];
    int[] nombreActividades=new int[5];
    
    //alimentos
    int [] alimentosPositivos=new int[4];
    int [] alimentosNegagtivos=new int[4];
    
    String[] estadosPokemon=new String[1];
    
    
    String nombre;
    String tipo;
    int nivel;
    int puntosDeVida;
    String imagen;
    int opcion;
    static int contadorPokemon=0;
    char opcionVolver='s';
    static boolean encontar= false;
    //metodo constructor de pokemon
    public Pokemon(){}
//metodos de pokemon
public void crear(){
    System.out.println(":::Pokemones disponibles:::");
    System.out.println("Tienes opcion de crear 5 pokemon MAXIMO");
    
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
                                while(i<5 && encontar==false){
                                    if(nombresPokemon[i].equals("Squirtle")){
                                        encontar=true;
                                    }
                                    i++;
                                }
                                if(encontar==true){
                                    System.out.println("Ya tienes este pokemon");
                                    contadorPokemon --;
                                }
                                else{
                                    Agua nuevoPokemon =new Agua("Squirtle","Agua");
                                    nuevoPokemon.almacenar();
                                }
                            break;
                            }
                            case 2:{
                                Agua nuevoPokemon =new Agua("Blastoise","Agua");
                                nuevoPokemon.almacenar();
                            break;
                            }
                            case 3:{
                                Agua nuevoPokemon =new Agua("Wartortle","Agua");
                                nuevoPokemon.almacenar();
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
                                Fuego nuevoPokemon =new Fuego("Charmander","Fuego"); 
                                nuevoPokemon.almacenar();
                            break;
                            }
                            case 2:{
                                Fuego nuevoPokemon =new Fuego("Charmeleon","Fuego");
                                nuevoPokemon.almacenar();
                            break;
                            }
                            case 3:{
                                Fuego nuevoPokemon =new Fuego("Charizard","Fuego");
                                nuevoPokemon.almacenar();
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
                                Planta nuevoPokemon =new Planta("Bulbasaur","Planta");  
                                nuevoPokemon.almacenar();
                            break;
                            }
                            case 2:{
                                Planta nuevoPokemon =new Planta("Venusaur","Planta");
                                nuevoPokemon.almacenar();
                            break;
                            }
                            case 3:{
                                Planta nuevoPokemon =new Planta("Ivysaur","Planta");
                                nuevoPokemon.almacenar();
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
                                Otros nuevoPokemon =new Otros("PIKACHU","Electrico");  
                                nuevoPokemon.almacenar();
                            break;
                            }
                            case 2:{
                                Otros nuevoPokemon =new Otros("Golem","Tierra");
                                nuevoPokemon.almacenar();
                            break;
                            }
                            case 3:{
                                Otros nuevoPokemon =new Otros("Slowbro","Normal");
                                nuevoPokemon.almacenar();
                            break;
                            }
                            default:{
                                Otros nuevoPokemon =new Otros("Cataperie","Insecto");
                                nuevoPokemon.almacenar();
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
public void almacenar(){
    System.out.println("se a almacenado correctamente");
}
public void alimentar(){}
public void revivir(){}
public void eliminar(){}
public void desmayar(){}

}

