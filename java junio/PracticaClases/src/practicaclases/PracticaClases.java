/*
 * Ejercicios de clases 1
 */
package practicaclases;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;
/**
 *
 * @author bryan
 */
public class PracticaClases {
    /**
     * @param args the command line arguments
     */
    private static List<Partido> partidos= new ArrayList<>();
    static Scanner entrada= new Scanner(System.in);
    static Scanner cadenas= new Scanner(System.in);
    static Scanner numeros= new Scanner(System.in);
    //colores para texto
    static String green="\033[32m",yellow="\033[33m" ,blue="\033[34m";
    public static void main(String[] args) {
        int opcion;
        char opcionRegresar;
        do{ //menu de opciones principales
            System.out.println(green+"|MENU DE OPCIONES|");
            System.out.println(yellow+"\t1.Agregar Partidos");
            System.out.println(yellow+"\t2.Visualizar Partidos");
            System.out.println(yellow+"\t0.Salir");

            System.out.println("\nIngrese numero de opcion: ");
            opcion = entrada.nextInt();
            //comparador de opcion ingresada
            switch(opcion){
                case 1:{
                    do{ crearPartido();
                        System.out.println("\nRegresar al menu [s]i, [n]o ");
                        opcionRegresar= entrada.next().charAt(0);
                    }while(opcionRegresar=='n');
            
                break;
                }
                case 2:{
                    do{ visualizarPartidos();
                        System.out.println("\nRegresar al menu [s]i, [n]o ");
                        opcionRegresar= entrada.next().charAt(0);
                    }while(opcionRegresar=='n');
                break;
                }
                case 0:{
                  System.exit(0);
                break;
                }
            }
        }while(opcion!=0);
        
    }
    //metodo para crear un nuevo partido
    public static void crearPartido(){
        Campo campoJuego= new Campo();
        List<Arbitro> arbitros= new ArrayList<>();
        List<Jugador> jugadoresEquipo1= new ArrayList<>();
        List<Jugador> jugadoresEquipo2= new ArrayList<>();
        List<Tecnico> tecnicos= new ArrayList<>();
        int numeroEntrada;
        // se ingresan los datos para un nuevo partido
        System.out.println("");
        System.out.println(green+"|Nuevo Partido|");
        System.out.println("Ingrese los siguientes datos: ");
        System.out.print(yellow+"\tNumero de Jugadores para Primer Equipo: ");
        numeroEntrada=entrada.nextInt();
        jugadoresEquipo1=ingrsarJugadores(numeroEntrada);
        System.out.println("");
        System.out.print(yellow+"Numero de Jugadores para Segundo Equipo: ");
        numeroEntrada=entrada.nextInt();
        jugadoresEquipo2=ingrsarJugadores(numeroEntrada);
        System.out.println("");
        System.out.print(yellow+"Numero de Tecnicos: ");
        numeroEntrada= entrada.nextInt();
        tecnicos=ingresarTecnicos(numeroEntrada);
        System.out.print(yellow+"Numero de Arbitros: ");
        numeroEntrada=entrada.nextInt();
        arbitros=ingrsarArbitros(numeroEntrada);
        System.out.println(yellow+"Tipo de Campo");
        campoJuego=ingresarCampo();
        
        //crear partido y agregarlo a la lista
        partidos.add(new Partido(campoJuego, arbitros, jugadoresEquipo1, jugadoresEquipo2, tecnicos));
                
    }
    //metodo para visualizar los partidos creados
    public static void visualizarPartidos(){
        System.out.println("");
        System.out.println(green+"|Partidos creados|");
        int cont=1;
        for(Partido partido: partidos){
            System.out.println(green+"<<PARTIDO "+cont+">>");
            //Campo
            String cadena= partido.getCampo().getNombre().substring(0, 3);
            if (cadena.equals("Est")) {//Si es un Estadio
                System.out.println(yellow+"\t"+partido.getCampo().getNombre());
                System.out.println(yellow+"\tUbicacion: "+partido.getCampo().getUbicacion());
                System.out.println(yellow+"\tCapacidad: "+partido.getCampo().getCapacidad()+" Espectadores");
                System.out.println(yellow+"\tDimensiones (mt): "+partido.getCampo().getDimensiones());
                System.out.println(yellow+"\tTipo de Gramilla: "+partido.getCampo().getTipoGramilla());
                System.out.println(yellow+"\tTipo de Asientos: "+partido.getCampo().getTipoDeAsientos());   
            }else{//si es un campo simple
                 System.out.println(yellow+"\t"+partido.getCampo().getNombre());
                System.out.println(yellow+"\tUbicacion: "+partido.getCampo().getUbicacion());
                System.out.println(yellow+"\tDimensiones (mt): "+partido.getCampo().getDimensiones());
                System.out.println(yellow+"\tTipo de Gramilla: "+partido.getCampo().getTipoGramilla());
            }
            
            //jugadores de primer equipo
            int contJ1=1;
            System.out.println("");
            System.out.println(yellow+"Jugadores de Primer Equipo");
            System.out.println(green+"\tNo.\tNombre\t\tEdad\tNo.Camisola\tPosicion");
            for(Jugador jugador: partido.getJugadoresEquipo1()){
                System.out.println(yellow+"\t"+contJ1+"\t"+jugador.getNombre()+"\t\t"+jugador.getEdad()+"\t\t"+jugador.getNumero()+"\t"+jugador.getPosicion());
                contJ1++;
            }
            //jugadores de segundo equipo
            int contJ2=1;
            System.out.println("");
            System.out.println(yellow+"Jugadores de Segundo Equipo");
            System.out.println(green+"\tNo.\tNombre\t\tEdad\tNo.Camisola\tPosicion");
            for(Jugador jugador: partido.getJugadoresEquipo2()){
                System.out.println(yellow+"\t"+contJ2+"\t"+jugador.getNombre()+"\t\t"+jugador.getEdad()+"\t\t"+jugador.getNumero()+"\t"+jugador.getPosicion());
                contJ2++;
            }
            // Tecnicos
            int contT=1;
            System.out.println("");
            System.out.println(yellow+"Tecnicos del Partidos");
            System.out.println(green+"\tNo.\tNombre\t\tEdad\tNacionalidad\texperiencia");
            for(Tecnico tecnico: partido.getTecnicos()){
                System.out.println(yellow+"\t"+contT+"\t"+tecnico.getNombre()+"\t\t"+tecnico.getEdad()+"  \t"+tecnico.getPais()+"\t"+tecnico.getExperiencia()+" años");
                contT++;
            }
            //Arbitros
            int contA=1;
            System.out.println("");
            System.out.println(yellow+"Arbitros del Partido");
            System.out.println(green+"\tNo.\tNombre\t\tEdad\tNacionalidad\tPosicion");
            for(Arbitro arbitro: partido.getArbitros()){
                System.out.println(yellow+"\t"+contA+"\t"+arbitro.getNombre()+"\t\t"+arbitro.getEdad()+"  \t"+arbitro.getNacionalidad()+"\t"+arbitro.getPosicion());
                contA++;
            }
            cont++;
        }
        
    }
    //metodo para ingresar jugadores
    public static List<Jugador> ingrsarJugadores(int numeroJugadores){
        List<Jugador> jugadores= new ArrayList<>();
        //caracteristicas de jugador
        String nombre,posicion;
        int edad,numero;
            for (int i = 0; i < numeroJugadores; i++) {
                System.out.println("\nJugador "+(i+1)+":");
                System.out.print("\tNombre: ");
                nombre=cadenas.nextLine();
                System.out.print("\tEdad: ");
                edad=numeros.nextInt();
                System.out.print("\tNumero de Camisola: ");
                numero= numeros.nextInt();
                System.out.print("\tPosicion (delantero, etc): ");
                posicion=cadenas.nextLine();
                jugadores.add(new Jugador(posicion, numero, nombre, edad));
            }
        return jugadores;
    }
    //metodo para ingresar Arbitros del juego
    public static List<Arbitro> ingrsarArbitros(int numeroArb){
        List<Arbitro> arbitros= new ArrayList<>();
        //caracteristicas de los arbitros
        String nombre,posicion,nacionalidad;
        int edad;
            for (int i = 0; i < numeroArb; i++) {
                System.out.println("\nArbitro "+(i+1)+":");
                System.out.print("\tNombre: ");
                nombre=cadenas.nextLine();
                System.out.print("\tEdad: ");
                edad=numeros.nextInt();
                System.out.print("\tPosicion (central, etc): ");
                posicion=cadenas.nextLine();
                System.out.print("\tNacionalidad(guatemalteco, etc): ");
                nacionalidad=cadenas.nextLine();
                arbitros.add(new Arbitro(posicion, nacionalidad, nombre, edad));
                
            }
        return arbitros;
    }
    //metodo para ingresar Tecnicos del partido
    public static List<Tecnico> ingresarTecnicos(int numeroTecnicos){
        List<Tecnico> tecnicos= new ArrayList<>();
        //caracteristicas de los tecnicos
        String nombre,nacionalidad;
        int edad,experiencia;
            for (int i = 0; i < numeroTecnicos; i++) {
                System.out.println("\nTecnico "+(i+1)+":");
                System.out.print("\tNombre: ");
                nombre=cadenas.nextLine();
                System.out.print("\tEdad: ");
                edad=numeros.nextInt();
                System.out.print("\tAños de experinecia: ");
                experiencia=numeros.nextInt();
                System.out.print("\tNacionalidad(guatemalteco, etc): ");
                nacionalidad=cadenas.nextLine();
                tecnicos.add(new Tecnico(nacionalidad, experiencia, nombre, edad));
            }
        return tecnicos;
    }
    //metodo para ingresar las caracteristicas del campo
    public static Campo ingresarCampo(){
        Campo campo= new Campo();
        String nombre,dimensiones,ubicacion,tipoGramilla,tipoAsientos;
        int opcion,capacidad;
        System.out.println(green+"\t1.Simple");
        System.out.println(green+"\t2.Estadio");
        System.out.println("\nIngrese numero de opcion: ");
        opcion = entrada.nextInt();
        if (opcion==1) { //caracteristicas de campo simple
            System.out.println(yellow+"Campo Simple");
            System.out.print("\tNombre: ");
            nombre=cadenas.nextLine();
            System.out.print("\tDimensiones(120x90, etc): ");
            dimensiones=cadenas.nextLine();
            System.out.print("\tUbicacion(Xela, etc): ");
            ubicacion= cadenas.nextLine();
            System.out.print("\tTipo de gramilla(sintetica, etc): ");
            tipoGramilla=cadenas.nextLine();
            campo= new Campo("Campo "+nombre, dimensiones, ubicacion, tipoGramilla);
        }
        else{//caracteristicas de estadio
            System.out.println(yellow+"Estadio");
            System.out.print("\tNombre: ");
            nombre=cadenas.nextLine();
            System.out.print("\tDimensiones(120x90, etc): ");
            dimensiones=cadenas.nextLine();
            System.out.print("\tUbicacion(Xela, etc): ");
            ubicacion= cadenas.nextLine();
            System.out.print("\tTipo de gramilla(sintetica, etc): ");
            tipoGramilla=cadenas.nextLine();
            System.out.print("\tCapacidad(3000, etc): ");
            capacidad=numeros.nextInt();
            System.out.print("\tTipo de Asientos(gradas, etc): ");
            tipoAsientos=cadenas.nextLine();
            campo= new Campo("Estadio "+nombre, dimensiones, ubicacion, tipoGramilla,capacidad, tipoAsientos);
        }
        return campo;
    }  
}
