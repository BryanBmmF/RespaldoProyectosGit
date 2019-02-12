
package tamagotchi;

import actividades.Actividad;
import alimentos.Alimento;
import batallas.Batalla;
import static batallas.Batalla.turnoInicial;
import imagenes.Imagen;
import java.util.Scanner;
import pokemones.Pokemon;
import reportes.Reporte;

/**
 *
 * @author bryan
 */
public class Tamagotchi {
    
    static Scanner scanner =new Scanner(System.in);     //scanner para enteros
    static Scanner scanner2 = new Scanner(System.in);   //scanner para caracteres
    
    public static void main(String[] args) {
        
        int opcion;
        char opcionVolver;
        //menu
        do{
            Imagen principal =new Imagen();
            principal.portada();
            System.out.println("Menu de opciones");
            System.out.println("\n1.Crear Pokemons");
            System.out.println("2.Seleccionar Mi Pokemon");
            System.out.println("3.Iniciar Batalla");
            System.out.println("4.Actividades Pokemon");
            System.out.println("5.Alimentos Pokemon");
            System.out.println("6.Reportes");
            System.out.println("7.Salir");
            System.out.println("");
            Pokemon mostrarPokemon=new Pokemon();
            mostrarPokemon.mostrar();
        
            System.out.println("\nIngrese numero de opcion: ");
            opcion=scanner.nextInt();
            //iniciando comparacion de la opcion elegida
                switch(opcion){
                    case 1: { 
                            Pokemon crearPokemon=new Pokemon();//creacion de pokemon
                            crearPokemon.mostrarMenu();
                        break;
                    }
                    case 2:{
                        Pokemon seleccionarPokemon=new Pokemon();//seleccion de pokemon
                        seleccionarPokemon.seleccionar();
                        break;
                    }
                    case 3: {
                        do{
                            Batalla nuevaBatalla= new Batalla(); //insatanciando nueva batalla
                            nuevaBatalla.mostrarOpciones();
                            //validando la repeticion
                            System.out.println("\nDesea otra batalla? [S]i, [N]o");
                            opcionVolver= scanner2.next().charAt(0);
                            turnoInicial=1;//reiniciando turno
                        }
                            //condicion de bucle nuevaBatalla
                        while(opcionVolver=='s'||opcionVolver=='S');
                        
                        break;
                    }
                    case 4: {
                        do{
                            Actividad nuevaActividad= new Actividad();//instanciando objeto nueva actividad
                            nuevaActividad.mostrarMenu();
                            //validando la repeticion
                            System.out.println("\nDesea realizar otra Actividad? [S]i, [N]o");
                            opcionVolver= scanner2.next().charAt(0);
                            }
                            //condicion de bucle nuevaActividad
                        while(opcionVolver=='s'||opcionVolver=='S');
                        break;
                    }
                    case 5: {
                        do{
                            Alimento nuevoAlimento= new Alimento();//instanciando objeto nuevo alimento
                            nuevoAlimento.mostrarMenu();
                            //validando la repeticion
                            System.out.println("\nDesea consumir algo mas? [S]i, [N]o");
                            opcionVolver= scanner2.next().charAt(0);
                            }
                            //condicion de bucle nuevaAlimento
                        while(opcionVolver=='s'||opcionVolver=='S');
                        
                        break;
                    }
                    case 6: {
                        do{
                            Reporte nuevoReporte= new Reporte();//instanciando objeto nuevo reporte
                            nuevoReporte.opcionReporte();
                            //validando la repeticion
                            System.out.println("\nDesea obtener algun otro Reporte? [S]i, [N]o");
                            opcionVolver= scanner2.next().charAt(0);
                            }
                            //condicion de bucle nuevaAlimento
                        while(opcionVolver=='s'||opcionVolver=='S');
                            
                        break;
                    }
                    default: {
                            System.exit(0);//saliendo del juego
                        break;
                    }
            
                }
                
            System.out.println("\nVolver al menu: [S]i");
            opcionVolver= scanner2.next().charAt(0);
            
        }
        while(opcionVolver!='s'||opcionVolver!='S');
    }
    
    
}

