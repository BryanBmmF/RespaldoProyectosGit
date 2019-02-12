
package pokemones;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Pokemon {
    static Scanner scanner =new Scanner(System.in);     //scanner para enteros
    static Scanner scanner2 = new Scanner(System.in);   //scaner para caracteres
    static Scanner scanner3 = new Scanner(System.in);   //scanner para cadenas
    static Scanner scanner4 = new Scanner(System.in);   //scaner para imagenes asci
    
    //Atributos de pokemon
 
    //general
    public static String nombresPokemon[]={"","","","",""};//priv las 2 siguientes
    public static String imagenesPokemon[]={"Sin Crear","Sin Crear","Sin Crear","Sin Crear","Sin Crear"};
    public static int[] nivelesPokemon=new int[5];
    public static int[] puntosDeVidaPokemon=new int[5];
    public static int[] experienciaDePokemon= new int[5];
    
    //atributos temporales
    public static String nombrePokemonEnJuego="";
    public static int vidaPokemonEnJuego;
    public static String imagenPokemonEnJuego="";
    public static int nivelPokemonEnJuego;
    public static int experienciaPokemonEnJuego;
    public static int pokemonElegido;
    
    //caracteristicas de pokemon
    String estadoM="muerto";
    String estadoV="vivo";
    String nombre;
    String tipo;
    int nivel=0;
    int experiencia=0;
    int puntosDeVida=100;
    String imagen;
    static int contadorPokemon=0;
    static final int LIMITE_POKEMON=5;
    static boolean encontrar= false;
    static boolean seleccion=false;
    //metodo constructor de pokemon
    public Pokemon(){}
//metodos de pokemon
    public void crear(){
    
}
public void seleccionar(){//seleccion de pokemon
    char cambiar;
    int opcion;
    if(seleccion==false){
    System.out.println("\n\nLista de Pokemones creados disponibles");
        int j=1; //iteradores
        int l=0;
        for(String i:nombresPokemon){  //desplegando el arreglo nombresPokemon
            System.out.println(j+"."+i);
            System.out.println(imagenesPokemon[l]); //desplegando el arreglo imagenesPokemon
                j++;
                l++;
            System.out.println("");
        }
        System.out.println("Ingrese el numero del pokemon que desee seleccionar: ");
        opcion=scanner.nextInt();
        System.out.println("\nse ha seleccionado como mascota el pokemon: "+nombresPokemon[opcion-1]+
                "\n"+imagenesPokemon[opcion-1]);
        
        seleccion=true;
        //acreditacion del pokemon en juego
        nombrePokemonEnJuego=nombresPokemon[opcion-1];
        imagenPokemonEnJuego=imagenesPokemon[opcion-1];
        vidaPokemonEnJuego=puntosDeVidaPokemon[opcion-1];
        nivelPokemonEnJuego=nivelesPokemon[opcion-1];
        experienciaPokemonEnJuego=experienciaDePokemon[opcion-1];
        
        pokemonElegido=opcion-1;
    }
    else{
        System.out.println("\nYa tiene seleccionado un Pokemon.");
        System.out.println("Desea Cambiarlo S[i], N[o]");
        cambiar=scanner2.next().charAt(0);
        if(cambiar=='s'||cambiar=='S'){
            
            seleccion=false;
            seleccionar();
        }
        
        
    }
    
        
}
public void alimentar(){//alimentacion de pokemon

}
public void mostrarMenu(){
    
    int opcion;
        //imprimieno pokemon y caracteristicas en pantalla
        Pokemon mostrarPokemon =new Pokemon();
        mostrarPokemon.mostrar();
        System.out.println("\nTienes opcion de crear 5 pokemon MAXIMO");
        System.out.println("\n1.Crear Pokemon Manualmente");
        System.out.println("2.Elegir Pokemons Disponibles");
        
        System.out.println("\nIngrese numero de opcion: ");
        opcion=scanner.nextInt();
        
            if(opcion==1){
                Inventado nuevoInventado= new Inventado();
                nuevoInventado.crear();
            }
            else{
               Original nuevoOriginal = new Original();
               nuevoOriginal.crear();
            }
        

}
public void revivir(){}//pendientes
public void eliminar(){}
public void desmayar(){}
public void mostrar(){//caracteristicas de pokemon a mostrar
    if(seleccion==true){
        System.out.println("Pokemon: "+nombrePokemonEnJuego);
        System.out.println(imagenPokemonEnJuego);
        System.out.println("\nVida HP:\t"+vidaPokemonEnJuego);
        System.out.println("Experiencia:\t"+experienciaPokemonEnJuego);
        System.out.println("Nivel:\t\t"+nivelPokemonEnJuego);
        
    }
    
}
}

