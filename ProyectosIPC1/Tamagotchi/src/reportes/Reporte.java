
package reportes;

import java.util.Scanner;
import pokemones.Pokemon;

/**
 *
 * @author bryan
 */
public class Reporte {
    static Scanner scanner =new Scanner(System.in);     //scanner para enteros
    static Scanner scanner2 = new Scanner(System.in);   //scanner para caracteres
    
    public int[] nivelesPokemon=new int[5];
    public int[] puntosDeVidaPokemon=new int[5];
    
    String nombre;
    String tipo;
    
    //constructor reporte
    public Reporte(){}
    
    //metodos
    public void mostrarReporte(){}
    public void guardarreporte(){}
    public void opcionReporte(){
        int opcion;
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
        
        System.out.println("\nReportes Disponibles ");
        System.out.println("\n1.Actividades Pokemon");
        System.out.println("2.Batallas");
        System.out.println("3.Estado de Pokemons");
        System.out.println("4.Rankin de Pokemons");
        System.out.println("5.Alimentacion Pokemons");
        System.out.println("6.Caracterisiticas de cada Pokemon");
        System.out.println("7.Alimentacion Pokemon1");
        System.out.println("8.Alimentacion Pokemon2");
        opcion=scanner.nextInt();
        
        switch(opcion){
            case 1 :{
                Actividad nuevoReporteActividad=new Actividad();
                nuevoReporteActividad.mostrarReporte();
            break;
            }
            case 2 :{
                Batalla nuevoReporteBatalla=new Batalla();
                nuevoReporteBatalla.mostrarReporte();
            break;
            }
            case 3 :{
                Estado nuevoReporteEstado=new Estado();
                nuevoReporteEstado.mostrarReporte();
            break;
            }
            case 4 :{
                MejorPokemon nuevoReportePokemon=new MejorPokemon();
                nuevoReportePokemon.mostrarReporte();
            break;
            }
            case 5 :{
                MejorAlimentado nuevoReporteAlimento=new MejorAlimentado();
                nuevoReporteAlimento.mostrarReporte();
            break;
            }
            case 6 :{
                Visual nuevoReporteVisual=new Visual();
                nuevoReporteVisual.mostrarReporte();
            break;
            }
            case 7 :{
                Alimento1 nuevoReporteAlimento1=new Alimento1();
                nuevoReporteAlimento1.mostrarReporte();
            break;
            }
            case 8 :{
                Alimento2 nuevoReporteAlimento2=new Alimento2();
                nuevoReporteAlimento2.mostrarReporte();
            break;
            }
        }
    }
}
