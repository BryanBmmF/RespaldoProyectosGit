/*
 * Aplicacion Juego de la fortuna: Acontinuacion se muestra el codigo fuente para este juego
 * con la descripcion de cada proceso a utilizar.
 */
package proyecto1;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
/**
 * title: proyecto1 junio 2018
 * @author bryan
 */
public class Proyecto1 {

    //Variables a utilizar
    static String nombreJ1,nombreJ2,nombreJ3,nombreJ4 ;
    static int avanceJ1=0,avanceJ2=0,avanceJ3=0,avanceJ4=0;
    static int punteoJ1=0,punteoJ2=0,punteoJ3=0,punteoJ4=0;
    static int contJ1=0,contJ2=0,contJ3=0,contJ4=0;
    static int opcionMenu,evaluo,numeroDado,puntuacionProyecto,puntuacionFracaso,
            puntuacionAvance,puntuacionGanador=0,casillaAnt=1,casillaAnt2=1,casillaAnt3=1,casillaAnt4=1;
    public static final int PRIMER_TURNO=1,SEGUNDO_TURNO=2,TERCER_TURNO=3,CUARTO_TURNO=4;
    public static final int PUNTEO_PROYECTO=30,PUNTEO_FRACASO=-40,PUNTEO_AVANCE=5,PUNTEO_GANADOR=100;
    static boolean gameOver=false,j3Habilitado=false,j4Habilitado=false;
    static boolean turnoPerdidoJ1=false,turnoPerdidoJ2=false,turnoPerdidoJ3=false,turnoPerdidoJ4=false;
    static List<String> lista= new ArrayList<>();
    //instanciando objeto Scanner y random para ingreso de datos y aleatoriedad de numeros
    static Scanner entrada = new Scanner(System.in);
    static Random dado= new Random();
    static MarcoDeJuego marco = new MarcoDeJuego();
    static PanelDeJuego nuevoTablero= new PanelDeJuego();
    //colores para texto
    static String black="\033[30m",red="\033[31m",green="\033[32m",yellow="\033[33m" ,blue="\033[34m" 
            ,purple="\033[35m",cyan="\033[36m" , white="\033[37m", reset="\u001B[0m";
    
    //procedimiento principal main
    public static void main(String[] args) { 
        //ACREDITACION INICIAL DE PUNTEOS
        acreditarConfig("src/archivos/configuraciones.txt");
        do{
            opcionMenu= menuPrincipal();//acceso al menu principal
            //inicio de comparador y llamada del metodo respectivo
            switch(opcionMenu){
                case 1:{
                    do{ iniciarJuego();} while(retornarMenu()==false);
                break;
                }
                case 2:{
                    do{ mostrarGanadores();} while(retornarMenu()==false);
                break;    
                }
                case 3:{
                    do{ config();} while(retornarMenu()==false);
                break;    
                }
                case 4:{
                    do{ indicaciones();} while(retornarMenu()==false);
                break;    
                }
                case 5:{
                    do{System.out.println(blue+"===========================================================");
                    System.out.println(yellow+"\tVersion del Juego: 1.0");
                    System.out.println(yellow+"\tDesarrollador: Bryan Monzon");
                    System.out.println(yellow+"\tUSAC-CUNOC 2018");
                }while(retornarMenu()==false);
                break;    
                }
                case 0:{
                    System.exit(0);
                break;    
                }
            }           
        }while(opcionMenu!=0);
    }
    //metodo que despliega el menu principal y devuelve el No.Opcion elegido
    public static int menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("");
        System.out.println(green+"* * * * * * * * * * * * * * * * * * * * *");
        System.out.println(green+ "* Bienvenido al Juego de la Fortuna     *");
        System.out.println(green+ "* * * * * * * * * * * * * * * * * * * * *");
        System.out.println(yellow+"* * * * * * * * * * * * * * * * * * * * *");
        System.out.println(yellow+"* Menu de Opciones                      *");
        System.out.println(yellow+"*   1.Iniciar Juego                     *");
        System.out.println(yellow+"*   2.Punteos                           *");
        System.out.println(yellow+"*   3.Configuraciones                   *");
        System.out.println(yellow+"*   4.Como Jugar??                      *");
        System.out.println(yellow+"*   5.Acerca de                         *");
        System.out.println(yellow+"*   0.Salir                             *");
        System.out.println(yellow+"* * * * * * * * * * * * * * * * * * * * *");
        System.out.println(green+ "Ingrese numero de Opcion a realizar:");        
        String opcionTem = scanner.nextLine(); //convirtiendo a valor entero
        opcion = Integer.valueOf(opcionTem);
        //opcion= scanner.nextInt();
        //validacion de opcion ingresada
        while(opcion<0 || opcion>5){
            System.out.println(green+"Esta opcion no se encuentra en el menu, intente otra vez:");
            String temp2= scanner.nextLine();
            opcion=Integer.valueOf(temp2);
            //opcion= scanner.nextInt();
        }
        return opcion;  
    }
    //metodo que inicia un nuevo juego
    public static void iniciarJuego(){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int opcion;
        //menu de inicio de una nueva partida
        System.out.println("");
        System.out.println(green  +"* * * * * * * * * * * * * * * * * *");
        System.out.println(green  +"* Opciones de Multijugador        *");
        System.out.println(green  +"* * * * * * * * * * * * * * * * * *");
        System.out.println(yellow +"* * * * * * * * * * * * * * * * * *");
        System.out.println(yellow+ "*    1. 2 Jugadores               *");
        System.out.println(yellow+ "*    2. 3 Jugadores               *");
        System.out.println(yellow+ "*    3. 4 Jugadores               *");
        System.out.println(yellow+ "* * * * * * * * * * * * * * * * * *");
        System.out.println(green+"Ingrese numero de Opcion a realizar:");
        String opcionTem = scanner1.nextLine(); //convirtiendo a valor entero
        opcion = Integer.valueOf(opcionTem);
        //opcion= scanner1.nextInt();
        //validacion de opcion ingresada
        while(opcion<0 || opcion>3){
            System.out.println(green+"Esta opcion no se encuentra en el menu, intente otra vez:");
            String temp2= scanner1.nextLine();
            opcion=Integer.parseInt(temp2);
            //opcion= scanner1.nextInt();
        }
        /**
         * Comparador del menu de opciones multijugador
         * Asignacion de nombres para jugadores
         * Habilitacion de jugadores
         * despliegue en pantalla de los turnos correspondientes
         **/
        switch(opcion){
            case 1:{ asignarPrimeros2J(); 
                System.out.println("\n"+green+"Los turnos correspondientes son:");
                System.out.println(yellow+"\tPrimer Turno (TJ1) para: "+nombreJr(PRIMER_TURNO));
                System.out.println(yellow+"\tSegundo Turno (TJ2) para: "+nombreJr(SEGUNDO_TURNO));
                break;
            }
            case 2:{ asignarPrimeros2J();
                System.out.println(green+"Ingrese Nombre de tercer Jugador:");
                nombreJ3= scanner2.nextLine();
                j3Habilitado=true;
                System.out.println("\n"+green+"Los turnos correspondientes son: ");
                System.out.println(yellow+"\tPrimer Turno (TJ1) para: "+nombreJr(PRIMER_TURNO));
                System.out.println(yellow+"\tSegundo Turno (TJ2) para: "+nombreJr(SEGUNDO_TURNO));
                System.out.println(yellow+"\tTercer Turno (TJ3) para: "+nombreJr(TERCER_TURNO));
                break;
            }
            case 3:{ asignarPrimeros2J();
                System.out.println(green+"Ingrese Nombre de tercer Jugador:");
                nombreJ3= scanner2.nextLine();
                System.out.println(green+"Ingrese Nombre de cuarto Jugador:");
                nombreJ4= scanner2.nextLine();
                j3Habilitado=true;
                j4Habilitado=true;
                System.out.println("\n"+green+"Los turnos correspondientes son: ");
                System.out.println(yellow+"\tPrimer Turno  (TJ1) para: "+nombreJr(PRIMER_TURNO));
                System.out.println(yellow+"\tSegundo Turno (TJ2) para: "+nombreJr(SEGUNDO_TURNO));
                System.out.println(yellow+"\tTercer Turno  (TJ3) para: "+nombreJr(TERCER_TURNO));
                System.out.println(yellow+"\tCuarto Turno  (TJ4) para: "+nombreJr(CUARTO_TURNO));
                break;
            }     
        }
        /**
         * Se visualiza la ventana en pantalla con el tablero
         * Se procede a jugar
         **/
        visualizarTablero(); jugar();
    }
    public static void jugar(){
        do{
            //avance de posicion de Jugador, verifica si tiene un turno perdido y si ya lo solvento para proceder  
            //primer turno
            if(turnoPerdidoJ1==true) contJ1++;
            if(contJ1==2){turnoPerdidoJ1=false; contJ1=0;}
            if(turnoPerdidoJ1==false)controladorDeTurnos("(TurnoJ1) "+nombreJr(PRIMER_TURNO),PRIMER_TURNO,avanceJ1,punteoJ1,casillaAnt);
            if(avanceJ1<100){ 
                //segundo turno
                if(turnoPerdidoJ2==true) contJ2++;
                if(contJ2==2){turnoPerdidoJ2=false; contJ2=0;}
                if(turnoPerdidoJ2==false)controladorDeTurnos("(TurnoJ2) "+nombreJr(SEGUNDO_TURNO),SEGUNDO_TURNO,avanceJ2,punteoJ2,casillaAnt2);
                if(avanceJ2<100){
                    //tercer turno
                    if(j3Habilitado){ 
                        if(turnoPerdidoJ3==true) contJ3++;
                        if(contJ3==2){turnoPerdidoJ3=false; contJ3=0;}
                        if(turnoPerdidoJ3==false)controladorDeTurnos("(TurnoJ3) "+nombreJr(TERCER_TURNO),TERCER_TURNO,avanceJ3,punteoJ3,casillaAnt3);
                        if(avanceJ3<100){
                            //cuarto turno
                            if(j4Habilitado){
                                if(turnoPerdidoJ4==true) contJ4++;
                                if(contJ4==2){turnoPerdidoJ4=false; contJ4=0;}
                                if(turnoPerdidoJ4==false)controladorDeTurnos("(TurnoJ4) "+nombreJr(CUARTO_TURNO),CUARTO_TURNO,avanceJ4,punteoJ4,casillaAnt4);
                                if (avanceJ4>=100){
                                    //Ha ganado Jugador4
                                    gameOver=true; punteoJ4=punteoJ4+puntuacionGanador;
                                    acreditacionFinal(nombreJr(CUARTO_TURNO),punteoJ4); 
                                }
                            }
                        }
                        else{//Ha ganado Jugador3
                            gameOver=true; punteoJ3=punteoJ3+puntuacionGanador; acreditacionFinal(nombreJr(TERCER_TURNO),punteoJ3);
                        }
                    }     
                }
                else{//Ha ganado Jugador2
                    gameOver=true; punteoJ2=punteoJ2+puntuacionGanador; acreditacionFinal(nombreJr(SEGUNDO_TURNO),punteoJ2);    
                }  
            }
            else{//Ha ganado Jugador1
                gameOver=true; punteoJ1=punteoJ1+puntuacionGanador;acreditacionFinal(nombreJr(PRIMER_TURNO),punteoJ1);  
            }   
        }while(gameOver==false);
    }
    //metodo final para acreditacion de ganador
    public static void acreditacionFinal(String ganador,int punteo){
        System.out.println("!!!! HAY UN NUENO GANADOR DE LA FORTUNA");
        System.out.println("Felicidades: "+ganador);
        System.out.println("Estado Monetario Final: "+punteo);
        marco.dispose();//cerrando ventana de tablero
        
        //se guardan los datos del ganador en un archivo
        escribirArchivo("src/archivos/ganadoresDeJuego.txt", ganador+"."+String.valueOf(punteo));
        
        //reset de avances y punteos
        avanceJ1=0; avanceJ2=0; avanceJ3=0; avanceJ4=0;
        punteoJ1=0; punteoJ2=0; punteoJ3=0; punteoJ4=0;
    }
    //metodo para lanzar dado de juego
    public static void lanzarDado(int posicion){
        int opcion;
        System.out.println("Para Lanzar dado presiona [1]:");
        //String opcionTem = entrada.nextLine(); //convirtiendo a valor entero
        //opcion = Integer.valueOf(opcionTem);
        opcion= entrada.nextInt();
        //validacion de opcion ingresada
            while(opcion!=1){
                System.out.println(green+"No Lanzaste el dado, intente otra vez:");
                //String opcionTem2 = entrada.nextLine(); //convirtiendo a valor entero
                //opcion = Integer.valueOf(opcionTem2);
                opcion= entrada.nextInt();
            }
            //ejecucion del lanzamiento de  dado
            numeroDado= dado.nextInt(6)+1;
            System.out.println("");
            if((numeroDado+posicion)<=100){
                System.out.println("Obtuviste un "+numeroDado+" y avanzaste hasta la casilla "+(numeroDado+posicion));
                System.out.println(green+desplegarDado(numeroDado));
            }
            else{ System.out.println(yellow+"Obtuviste un "+numeroDado+" y llegaste al final!!!");
                System.out.println(green+desplegarDado(numeroDado));
            }
            
    }
    /**
     * Metodo para acreditar avances al Jugador
  Se acredita el avance y se establece su posicion en tablero
  Se evalua el tipo de casilla donde se encuentra
  Se establece la posicion final, y se ubica en el tablero
  Se acredita el mostrarGanadores o No.de monedas, se actualiza la casilla anterior
     **/
    public static void avanzar(int numeroAvance,int numeroJugador){
        int posicionFinal,tipoCasilla,posicionEnTablero,punteoAcreditado;
        switch(numeroJugador){
            case PRIMER_TURNO: {avanceJ1=avanceJ1+numeroAvance;
                posicionEnTablero=avanceJ1; tipoCasilla=evaluarCasilla(posicionEnTablero);
                posicionFinal=avanceJ1+evaluo; avanceJ1=posicionFinal; ubicarEnTablero(posicionFinal, PRIMER_TURNO);
                punteoAcreditado=establecerPosicion(posicionFinal,tipoCasilla,PRIMER_TURNO); punteoJ1=punteoJ1+punteoAcreditado;
                casillaAnt=posicionFinal;//para ser normalizada antes que inicie el proximo turno
            break;
            }
            case SEGUNDO_TURNO:{avanceJ2=avanceJ2+numeroAvance;
                posicionEnTablero=avanceJ2; tipoCasilla=evaluarCasilla(posicionEnTablero);
                posicionFinal=avanceJ2+evaluo; avanceJ2=posicionFinal; ubicarEnTablero(posicionFinal, SEGUNDO_TURNO);
                punteoAcreditado=establecerPosicion(posicionFinal,tipoCasilla,SEGUNDO_TURNO); punteoJ2=punteoJ2+punteoAcreditado;
                casillaAnt2=posicionFinal;//para ser normalizada antes que inicie el proximo turno
            break;
            }
            case TERCER_TURNO:{avanceJ3=avanceJ3+numeroAvance;
                posicionEnTablero=avanceJ3; tipoCasilla=evaluarCasilla(posicionEnTablero);
                posicionFinal=avanceJ3+evaluo; avanceJ3=posicionFinal; ubicarEnTablero(posicionFinal, TERCER_TURNO);
                punteoAcreditado=establecerPosicion(posicionFinal,tipoCasilla,TERCER_TURNO); punteoJ3=punteoJ3+punteoAcreditado;
                casillaAnt3=posicionFinal;//para ser normalizada antes que inicie el proximo turno
            break;
            }
            case CUARTO_TURNO:{avanceJ4= avanceJ4+numeroAvance;
                posicionEnTablero=avanceJ4; tipoCasilla=evaluarCasilla(posicionEnTablero);
                posicionFinal=avanceJ4+evaluo; avanceJ4=posicionFinal; ubicarEnTablero(posicionFinal, CUARTO_TURNO);
                punteoAcreditado=establecerPosicion(posicionFinal,tipoCasilla,CUARTO_TURNO); punteoJ4=punteoJ4+punteoAcreditado;
                casillaAnt4=posicionFinal;//para ser normalizada antes que inicie el proximo turno
            break;
            }
        }        
    }
    //metodo para comparar retornar si es avance simple un proyecto o un fracaso
    public static int evaluarCasilla(int posicion){
        int retorno;
        switch(posicion){ // Tipo de retorno: 1: proyecto  2: fracaso  3:avance normal
            case 1:{ evaluo=37; retorno=1;  break;} case 4: { evaluo=10; retorno=1; break;}
            case 9:{ evaluo=22; retorno=1;  break;} case 17:{ evaluo=-10; retorno=2;break;}
            case 21:{ evaluo=21; retorno=1; break;} case 28:{ evaluo=56; retorno=1; break;}
            case 51:{ evaluo=16; retorno=1; break;} case 54:{ evaluo=-20; retorno=2;break;}
            case 62:{ evaluo=-43; retorno=2;break;} case 64:{ evaluo=-4; retorno=2; break;}
            case 72:{ evaluo=19; retorno=1; break;} case 80:{ evaluo=19; retorno=1; break;}
            case 87:{ evaluo=-51; retorno=2;break;} case 93:{ evaluo=-20; retorno=2;break;}
            case 95:{ evaluo=-20; retorno=2;break;} case 98:{ evaluo=-19; retorno=2;break;}
            default:{ evaluo=0; retorno=3;  break;}
        }  
      return retorno;
    }//metodo para ubicar al jugador en la casilla correspondiente
    public static void ubicarEnTablero(int posicion,int turno){
        if (posicion<=100) {
            nuevoTablero.actualizarCasilla(posicion, turno);
        }
        
    }//metodo que actualiza la casilla donde a pasado un jugador previamente
    public static void normalizarCasilla(int posicion,int turno){
        if (posicion<=100) {
             nuevoTablero.normalCasilla(posicion, turno);
        }
       
    }
    //metodo para evaluar posibilidades en la casillla y retornar mostrarGanadores respectivo
    public static int establecerPosicion(int posicionFinal,int tipoCasilla,int turnoJugador){
        int punteoRetorno=0;
        if (posicionFinal<=100) {
            switch(tipoCasilla){
                case 1:{ System.out.println("");
                    System.out.println("Felicidades Caiste en un Proyecto Avansaste hasta la Casilla "+posicionFinal);
                    punteoRetorno=puntuacionProyecto; restarTurno(turnoJugador,1);
                break;
                }
                case 2:{ System.out.println("");
                    System.out.println("Mala Suerte Caiste en un Fracaso Descendiste hasta la Casilla "+posicionFinal);
                    punteoRetorno=puntuacionFracaso; restarTurno(turnoJugador,2);
                    System.out.println(nombreJr(turnoJugador)+" PERDERAS TU TURNO EN LA PROXIMA VUELTA");
                    
                break;
                }
                case 3:{ System.out.println("");
                    System.out.println("Avance Normal, ahora estas en Casilla "+posicionFinal);
                    punteoRetorno=puntuacionAvance; restarTurno(turnoJugador,3);
                break;
                }
            }    
        } 
       return punteoRetorno; 
    }
    //metodo para controlar avance de jugadores mediante los turnos
    public static void controladorDeTurnos(String JugadorDeTurno,int turno,int posicionActual,int monedas,int casAnt){
        System.out.println(green+"===========================================================");
        System.out.println("\t\t\t\tPosicion Actual: Casilla("+posicionActual+")");
        System.out.println(JugadorDeTurno+"\t\t\tEstado Monetario: "+monedas+" Monedas");
        ubicarEnTablero(casAnt, turno);//ubicando antes del lanzamiento de dado
        //se lanza el dado, se normaliza la casilla, se actualizan los identificadores, y se avanza en el tablero
        lanzarDado(posicionActual); normalizarCasilla(casAnt,turno); nuevoTablero.colocarIdentificadores(); avanzar(numeroDado,turno); 
         System.out.println(green+"===========================================================");
    }
    //metodo para habilitar turnos perdidos o normalizarlos
    public static void restarTurno(int jugadorEnTurno,int tipoAvance){
        if (tipoAvance==2) {
            switch(jugadorEnTurno){
                case PRIMER_TURNO: turnoPerdidoJ1=true; break; case SEGUNDO_TURNO: turnoPerdidoJ2=true; break;
                case TERCER_TURNO: turnoPerdidoJ3=true; break; case  CUARTO_TURNO: turnoPerdidoJ4=true; break;
            }  
        }
        else{
            switch(jugadorEnTurno){
                case PRIMER_TURNO: turnoPerdidoJ1=false; break; case SEGUNDO_TURNO: turnoPerdidoJ2=false; break;
                case TERCER_TURNO: turnoPerdidoJ3=false; break; case  CUARTO_TURNO: turnoPerdidoJ4=false; break;
            }  
        }
    }
    //metodo para editar configuraciones del juego
    public static void config(){
        Scanner cambiar= new Scanner(System.in);
        Scanner cambiar2= new Scanner(System.in);
        char opcionVolver;
        lista=leerArchivo("src/archivos/configuraciones.txt");
        System.out.println(blue+"===========================================================");
        System.out.println(green+"Configuraciones del Juego");
        System.out.println("");
        System.out.println(yellow+"Configuracion Actual:");
        System.out.println(yellow+"\tAcreditacion por Proyecto: "+lista.get(0)+" Monedas");
        System.out.println(yellow+"\tAcreditacion por Fracaso: "+lista.get(1)+" Monedas");
        System.out.println(yellow+"\tAcreditacion por Avance: "+lista.get(2)+" Monedas");
        System.out.println(yellow+"\tAcreditacion de Ganador: "+lista.get(3)+" Monedas");
        System.out.println("");
        System.out.println(green+"Desea Cambiar La Configuracion: [s]i, [n]o");
        String opcionTemp = cambiar.nextLine();
        opcionVolver = opcionTemp.charAt(0);
        //si opcion es si se solicita el ingreso de nuevos valores y se actualizan en la lista
        if (opcionVolver=='s' || opcionVolver=='S'){
            System.out.println(yellow+"Nueva Acreditacion por Proyecto: ");
            puntuacionProyecto= cambiar2.nextInt(); lista.set(0, String.valueOf(puntuacionProyecto));
            System.out.println(yellow+"Nueva Acreditacion por Fracaso: ");
            puntuacionFracaso= cambiar2.nextInt(); lista.set(1, String.valueOf(puntuacionFracaso));
            System.out.println(yellow+"Nueva Acreaditacion por Avance: ");
            puntuacionAvance= cambiar2.nextInt(); lista.set(2, String.valueOf(puntuacionAvance));
            System.out.println(yellow+"Nueva Acreditacion de Ganador: ");
            puntuacionGanador= cambiar2.nextInt(); lista.set(3, String.valueOf(puntuacionGanador));
            //se actualiza el archivo configuraciones
            escribirArchivo2("src/archivos/configuraciones.txt", lista);
        }
        
    }
    //metodo para acreditar configuraciones del juego
    public static void acreditarConfig(String path){
        if (buscarArchivoExistente(path)) {//si existe el Archivo
            //se lee y se acreditan las configuraciones
            lista=leerArchivo(path);
            puntuacionProyecto=Integer.valueOf(lista.get(0));puntuacionFracaso=Integer.valueOf(lista.get(1));
            puntuacionAvance=Integer.valueOf(lista.get(2));  puntuacionGanador=Integer.valueOf(lista.get(3));
        }
        else{
            //se crea y se escriben las configuraciones por defecto
            escribirArchivo(path, String.valueOf(PUNTEO_PROYECTO));escribirArchivo(path, String.valueOf(PUNTEO_FRACASO));
            escribirArchivo(path, String.valueOf(PUNTEO_AVANCE));  escribirArchivo(path, String.valueOf(PUNTEO_GANADOR));
            //se leen las mismas configuraciones con recursividad
            acreditarConfig(path);
        }
    }
    //metodo buscador de un archivo existente
    public static boolean buscarArchivoExistente(String path){
        //se procede a verificar si existe dentro de los archivos     
        boolean encontrada= false;
        File file = new File(path);
            //verifica si existe el archivo
            if(file.exists()){
                encontrada= true;
            }
            return encontrada;       
    }
    //metodo para leer archivos del juego, devuelve listado con cada linea del archivo
    public static List<String> leerArchivo(String path){
        List<String> textos = new ArrayList<>();
        try{
            File archivo = new File(path);
            Scanner lectura = new Scanner(archivo);
            while (lectura.hasNext()) {
		textos.add(lectura.nextLine());
            }
        }catch(FileNotFoundException ex){
		System.out.println("No se encontró el archivo");
	}
        return textos;
    }
    //metodo para abrir un archivo pdf
    public static void abrirArchivo(String path){
        try {
            File objetoFile= new File(path);
            Desktop.getDesktop().open(objetoFile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    //metodo para escribir archivos del juego
    public static void escribirArchivo(String path,String texto){
        //éste método permite escribir si no existe, y actualizar (agregar) si existe
        //se crea pw como un nuevo escritor, que utiliza una bufferización del archivo,
        //el "true" activa la edición y se coloca al final  
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
            pw.println(texto);
        }catch (IOException e) {
            System.err.println(e);
        }  
    }
    //metodo para escribir archivos del juego2
    public static void escribirArchivo2(String path,List<String> listaNueva){
        try{
            // usando printWriter se crea el nuevo archivo
            PrintWriter escribir = new PrintWriter(path);
            // se envía directamente la información lineal
            for(String i: listaNueva){
                escribir.println(i);
            }
            //se cierra el archivo
            escribir.close();
	}catch(IOException ex){
            //Salvo que haya un error en la lectura del archivo muesta el sig. mensaje
            System.out.println("No se encontró el archivo");
	}			
    }
    //metodo para mostrar el historial de ganadores del juego
    public static void mostrarGanadores(){
        System.out.println(blue+"===========================================================");
        System.out.println(green+"Historial de Ganadores del Juego");
        //se verifica si existe el archivo
        if(buscarArchivoExistente("src/archivos/ganadoresDeJuego.txt")){
            lista=leerArchivo("src/archivos/ganadoresDeJuego.txt");
            //se inicializan dos arreglos para almacenar el contenido de la lista
            String[] nombres= new String[lista.size()];
            int[] punteos= new int[lista.size()];
            //se recorre la lista
            int contador=0;
            for(String ganador: lista){
                int separador= ganador.indexOf(".");
                nombres[contador]= ganador.substring(0, separador);
                punteos[contador]= Integer.valueOf(ganador.substring(separador+1));
                contador++;
            }
            //se procede a ordenar los punteos
            ordenador(punteos, nombres);
            System.out.println("");
            System.out.println(green+"Nombre\t\t\tMonedas Ganadas");
            //se visualizan en pantalla
            int indice=0;
            for(String i:lista){
                System.out.println(yellow+(indice+1)+"."+nombres[indice]+"\t\t\t"+punteos[indice]+" Monedas");
                indice++;
            }
        }
        else{
            System.out.println(yellow+"\tNo Existe ningun registro.");
        }
        
    }
    //metodo ordenador tipo insercion
    public static void ordenador(int[] punteos, String[] nombres){
        int auxPunteo,cont1,cont2;
        String auxNombre;
        for (cont1=1;cont1<punteos.length;cont1++) {
            auxPunteo=punteos[cont1];
            auxNombre=nombres[cont1];
            for(cont2=cont1-1; cont2>=0 && punteos[cont2]<auxPunteo;cont2--){
                punteos[cont2+1]=punteos[cont2];
                nombres[cont2+1]=nombres[cont2];
                punteos[cont2]=(int)auxPunteo;
                nombres[cont2]=auxNombre;
            }
        }  
    }
    //metodo para imprimir indicaciones del juego
    public static void indicaciones(){
        Scanner scanner= new Scanner(System.in);
        int opcion;
        System.out.println(blue+"===========================================================");
        System.out.println(green+"Indicaciones del juego");
        System.out.println(yellow+"\t1.Desplegar Breve Guia de");
        System.out.println(yellow+"\t2.Abrir Manual de Usuario");
        System.out.println(green+"Ingrese numero de opcion:");
        opcion= scanner.nextInt();
        while(opcion<1 || opcion>2){
            System.out.println(green+"Opcion Invalida, Intente otra vez: ");
            opcion= scanner.nextInt();
        }
        if (opcion==2) {
            abrirArchivo("src/archivos/manualDeUsuario.pdf");
        }
        else{
            System.out.println(green+"Indicaciones de Como Jugar");
            lista= leerArchivo("src/archivos/guia.txt");
            for(String linea: lista){
                System.out.println(yellow+linea);
            }
        }
        
    }
    //metodo que solicita el ingreso de los dos primeros Jugadores
    public static void asignarPrimeros2J(){
        Scanner entradaNombre = new Scanner(System.in);
        System.out.println("");
        System.out.println(green+"Ingrese Nombre de Primer Jugador:");
        nombreJ1= entradaNombre.nextLine();
        System.out.println(green+"Ingrese Nombre de Segundo Jugador:");
        nombreJ2= entradaNombre.nextLine();
    } 
    //metodo que devuelve el nombre del jugador de acuerdo al turno
    public static String nombreJr(int numTurno){
        String retorno="";
        switch(numTurno){
            case PRIMER_TURNO: retorno=nombreJ1; break; case SEGUNDO_TURNO: retorno= nombreJ2; break;
            case TERCER_TURNO: retorno= nombreJ3; break;case CUARTO_TURNO: retorno= nombreJ4; break;
        }
        return retorno;
    }
    //metodo para retornar al menu Principal
    public static boolean retornarMenu(){
        Scanner volver= new Scanner(System.in);
        boolean retorno=false;
        char opcionVolver;
        System.out.println("");
        System.out.println(green+"Volver al menu [s]i, [n]o");
        String opcionTemp = volver.nextLine();
        opcionVolver = opcionTemp.charAt(0);
        //opcionVolver= volver.next().charAt(0);
        
        if (opcionVolver=='s' || opcionVolver=='S')retorno=true;
        return retorno;
    }
    //metodo que permite visualizar el tablero de juego
    public static void visualizarTablero(){
        marco.setVisible(true);            
    }
    //desplegar dado
    public static String  desplegarDado(int valor){
        String cara="";
        switch (valor) {
            case 1:
                cara=" ______"
                 +"\n|      |"
                 +"\n|  *   |"
                 +"\n|______|";
                break;
            case 2:
                cara=" ______"
                 +"\n|      |"
                 +"\n| *  * |"
                 +"\n|______|";
                break;
            case 3:
                cara=" ______"
                 +"\n|      |"
                 +"\n| * * *|"
                 +"\n|______|";
                break;
            case 4:
                cara=" ______"
                 +"\n| *  * |"
                 +"\n|      |"
                 +"\n|_*__*_|";
                break;
            case 5:
                cara=" ______"
                 +"\n| *  * |"
                 +"\n|   *  |"
                 +"\n|_*__*_|";
                break;
            case 6:
                cara=" ______"
                 +"\n| *  * |"
                 +"\n| *  * |"
                 +"\n|_*__*_|";
                break;
        }
        return cara;
    }

}

