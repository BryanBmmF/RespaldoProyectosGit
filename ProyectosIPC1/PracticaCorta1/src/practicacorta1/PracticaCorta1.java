package practicacorta1;
//importacion de librerias para el programa juego
import java.util.Scanner;
import java.util.Random; 
/**
 *title: Juego RPG (role playing game)
 *Description: Un RPG es un juego que permite la creación de un personaje, pelear contra enemigos, ganar puntos de experiencia y
               oro al vencer en las batalla, usar los puntos de experiencia para subir de nivel al personaje y comprar
               elementos que sirven al personaje durante las batallas.
 * @author Bryan Misael Monzon Fuentes    Febrero de 2018.
 */
public class PracticaCorta1 {
    //variables de tipo global
    static Scanner scanner = new Scanner(System.in);
    static int puntosDeVida;
    static int puntosDeMana;
    static int puntosDeVidaEnemigo;
    static int enemigoVencido1=0;
    static int enemigoVencido2=0;
    static int enemigoVencido3=0;
    static int oro=0;
    static int oroPerdido=0;
    static int nivel=0;
    static int experiencia=0;
    static int articulo1=0;
    static int articulo2=0;
    static int articulo3=0;
    static int opcionMiedo;
    static String nombrePersonaje;
    static char opcionSalir;
    static char opcion;
    static char repetirOpcion;
    static char repetirOpcion2;
    static char repetirOpcion3;
    static char repetirOpcion4;
    static char repetirOpcion5;
     /*
     * Este es el procedimiento principal
     */
    public static void main(String[] args) {
        //variable tipo local que recibe la opcion de nombre para el jugador
        int numeroDeOpcion;
             //acreditacion de los puntos iniciales
             puntosDeVida= 150*(nivel+1);
             puntosDeMana= 10*(nivel+1);
             //inicializacion del juego y preguntando si desea un nombre para el personaje
            	System.out.println("    ---->BIENVENIDO AL JUEGO<----");
            	System.out.println("\nDesea ingresar un nombre a su personaje [S]si, [N]no");
            	Scanner caracterNombre=new Scanner(System.in);
            	String opcionTemp = caracterNombre.nextLine();
            	opcion = opcionTemp.charAt(0);  //leyendo opcion
                	//Ingresando un nombre por el jugador
                	if(opcion=='s'||opcion=='S'){
                    		System.out.println("Ingrese el nombre:");
                    		Scanner cadenaNombre=new Scanner(System.in);
                    		nombrePersonaje=cadenaNombre.nextLine();
                    	}
                        //Estableciendo nombre predeterminado por el juego
                        else{
                            	nombrePersonaje="Jugador1";
                            	System.out.printf("\nSe le a asignado el personaje:\t"+nombrePersonaje);     
                        	}
                do{
                    System.out.print("\033[H\033[2J");//limpia pantalla
                    System.out.flush();
                    //Menu de opciones principales para el jugador
                    System.out.println("\n..MENU DE OPCIONES..");
                    System.out.println("1. A la carga.");  //Inicia la battalla
                    System.out.println("2.Tienda.");       //Permite comprar articulos para la batalla
                    System.out.println("3.zzZzzZzzZ(Dormir).");//Permite recuperar al jugador a su estado inicial 
                    System.out.println("4.Status.");       //Muestra las estadisticas del juego
                    System.out.println("5.Mas Poder!!!."); //Para aumento de nivel del juego 
                    System.out.println("6.Salir.");       //finaliza las acciones y sale del juego
                        do{//validando el numero de opcion
                            System.out.println("Ingrese el numero de opcion:");
                            numeroDeOpcion= scanner.nextInt();
                          }
                        while(numeroDeOpcion<1 || numeroDeOpcion>6);
                        //comparando la opcion ingresada
                        switch(numeroDeOpcion){
                            //mostrando los casos existentes por comparar
                            case 1:{
                                do{
                                    batalla();//llamando a la funcion batalla
                                        //Validando la repeticion de la fuencion o su finalizacion
                                        System.out.println("\nDesea otra Batalla? [S]i, [N]o");
                                        Scanner caracterBatalla=new Scanner(System.in);
                                        String opcionTemp1 = caracterBatalla.nextLine();
                                        repetirOpcion = opcionTemp1.charAt(0);
                                        opcionMiedo=0; //reiniciando la opcion miedo
                                    }                               
                                //condicion del bucle para la funcion batalla   
                                while(repetirOpcion=='s'||repetirOpcion=='S');
                            break;
                            }
                            case 2:{
                                do{
                                    tienda();//llamando a la funcion tienda
                                        //validando la repeticion de la funcion
                                        System.out.println("\nDesea realizar otra compra? [S]i, [N]o");
                                        Scanner caracterTienda=new Scanner(System.in);
                                        String opcionTemp2 = caracterTienda.nextLine();
                                        repetirOpcion2 = opcionTemp2.charAt(0);
                                    }
                                //condicion de bucle para la funcion tienda
                                while(repetirOpcion2=='s'||repetirOpcion2=='S');
                            break;
                            }
                            case 3:{
                                do{
                                    dormir();//llamando a la funcion dormir
                                        //validando la repeticion de la funcion
                                        System.out.println("\nDesea volver a dormir? [S]i, [N]o");
                                        Scanner caracterDormir=new Scanner(System.in);
                                        String opcionTemp3 = caracterDormir.nextLine();
                                        repetirOpcion3 = opcionTemp3.charAt(0);
                                    }
                                //condicion de bucle para la funcion dormir    
                                while(repetirOpcion3=='s'||repetirOpcion3=='S');
                            break;
                            }
                            case 4:{
                                do{
                                    status();//llamando a la funcion status
                                        //validando su repeticion
                                        System.out.println("\nMostrar nuevamente? [S]i, [N]o");
                                        Scanner caracterStatus=new Scanner(System.in);
                                        String opcionTemp4 = caracterStatus.nextLine();
                                        repetirOpcion4 = opcionTemp4.charAt(0);
                                    }
                                //condicion de bucle para la funcion status   
                                while(repetirOpcion4=='s'||repetirOpcion4=='S');
                            break;
                            }
                            case 5:{
                                do{
                                    poder();//llamando a la funcion poder
                                        //validando la repeticion de la funcion
                                        System.out.println("\nDesea mas poder? [S]i, [N]o");
                                        Scanner caracterPoder=new Scanner(System.in);
                                        String opcionTemp5 = caracterPoder.nextLine();
                                        repetirOpcion5 = opcionTemp5.charAt(0);
                                    }
                                //condion de bucle para la funcion poder    
                                while(repetirOpcion5=='s'||repetirOpcion5=='S');
                            break;
                            }
                       	default:{
                               System.exit(0);//saliendo del juego
                            break;
                            }
                        }
                    //validacion del retorno al menu principal
                    System.out.println("volver al menu [S]si, [N]no?");
                    Scanner caracterVolver=new Scanner(System.in);
                    String opcionTemp6 = caracterVolver.nextLine();
                    opcionSalir=opcionTemp6.charAt(0);
                }
                //condicion del bucle para menu principal
                while(opcionSalir=='S'||opcionSalir=='s');   
    }
    //creacion de la funcion batalla
    public static void batalla(){
	System.out.print("\033[H\033[2J");//limpia pantalla
        System.out.flush();
        int turno;          //declaracion de variables locales a utilizar
        int numeroAleatorio;
        int numeroAleatorio2;
        int ataqueEnemigo;
        int experienciaGanada;
        int oroGanado;
        String enemigo;
        Random aleatorio = new Random();//declarando variables tipo random para aleatoriedad
        Random aleatorio2 = new Random();
        Random aleatorio3 = new Random();
            //Inicializando la batalla
            System.out.println("...Bienvenido a la batalla...");
            System.out.println("El turno de atacar es aleatorio.");
            //eligiendo al oponente en battalla mediante el llamado de la funcion enemigos
            enemigo = enemigos();
            System.out.printf("\nTu oponente es: "+enemigo);
            //eligiendo turno aleatorio si es 1 inicia enemigo, si es 2 inicia jugador
            turno = (aleatorio.nextInt(2)+1);
                do{//condicion si primer turno es del jugador
                        if(turno%2==0){
                                turnoJugador();//llamando a funcion turnoJugador 
				System.out.print("\033[H\033[2J");//limpia pantalla
                    		System.out.flush();      
                        }
                        else{
                                System.out.println("\nturno de:"+enemigo);
                                ataqueEnemigo= turnoEnemigo(enemigo);//enviando parametro enemigo
                                puntosDeVida= puntosDeVida-ataqueEnemigo;//descontando vida a jugador                               
                        }        
                    turno=turno+1;//contador para los turnos correspondientes
                    //validando la continuidad del juego mediante los puntos de vida.
                }while(puntosDeVida>0 && puntosDeVidaEnemigo>0&&opcionMiedo!=1);

                if(opcionMiedo!=1){//condicion de huida del jugador 
                	//condicion si el ganador de la battala es el Jugador
                	if(puntosDeVida>puntosDeVidaEnemigo){
                    		System.out.print("\033[H\033[2J");//limpia pantalla
                    		System.out.flush();
                    		System.out.println("Ganador de la batalla: "+nombrePersonaje);
                    	//sumando los atributos ganados en battala
                    		numeroAleatorio = (aleatorio2.nextInt(30-20+1)+20);
                    		experienciaGanada= ((nivel+1)*10)+numeroAleatorio;
                    		experiencia=experiencia+experienciaGanada;
                    
                    		numeroAleatorio2 = (aleatorio3.nextInt(45-15+1)+15);
                    		oroGanado= ((nivel+1)*10)+numeroAleatorio2;
                    		oro=oro+oroGanado;
                    	//imprimiendo los atributos ganados en batalla
                    		System.out.println("Oro Ganado: "+oroGanado);
                    		System.out.println("experiencia Ganada: "+experienciaGanada);
                    	//reiniciando la vida a los enemigos
                    		puntosDeVidaEnemigo=0;
                    	//contador de derrotas para los enemigos disponibles
			switch(enemigo){
				case "Dark_Wolf":{
                            		enemigoVencido1=enemigoVencido1+1;
                        	break;
                        		}
                        	case "Dragon":{
                            		enemigoVencido2=enemigoVencido2+1;
                        	break;
                        		}
                    	default:{
                            enemigoVencido3=enemigoVencido3+1;
                        break;
                        }
                    }
                }
                	else{//mostrando al enemigo ganador en pantalla
                    		System.out.print("\033[H\033[2J");//limpia pantalla
                    		System.out.flush();
                    		System.out.println("Ganador de la batalla: "+enemigo);
                    		//reiniciando las caracteristicas  principales al jugador
                    		puntosDeVida=150;
                    		puntosDeMana=10;
                    		nivel=0;
                    		experiencia=0;
                    		oro=0;
                    		articulo1=0;
                    		articulo2=0;
                    		articulo3=0;
                    		enemigoVencido1=0;
                    		enemigoVencido2=0;
                    		enemigoVencido3=0;
                }
                }else{
			System.out.println("Huiste de la batalla!!!");
			System.out.println("oro perdido:"+oroPerdido);
			puntosDeVidaEnemigo=0;}//reiniciando solo la vida del enemigo despues de la huida del jugador
    }//creacion de la funcion turnoJugador
    public static void turnoJugador(){
        //variables locales
        int opcionBatalla;
        Scanner scannerDos=new Scanner(System.in);//nuevo scanner vara no recargar al anterior
        //menu de opciones para el turno del jugador
        System.out.println("\nturno de:"+nombrePersonaje);
	System.out.println("\n1.Atacar\t\t\t\t\tnombre:\t\t\t"+nombrePersonaje);
	System.out.println("2.Curar\t\t\t\t\t\tPuntos De Vida (HP):\t"+puntosDeVida);
	System.out.println("3.Item\t\t\t\t\t\tPuntos De mana (MP):\t"+puntosDeMana);
	System.out.println("4.Tengo Miedo\t\t\t\t\tOro:    \t\t"+oro);
        System.out.println("\t\t\t\t\t\tVida del enemigo:\t"+puntosDeVidaEnemigo);

            do{//validando la opcion seleccionada
                System.out.println("Numero de opcion:");
                opcionBatalla= scannerDos.nextInt();
                
            }while(opcionBatalla<1||opcionBatalla>4);
                //comparacion de la opcion seleccionada
                switch(opcionBatalla){
                    case 1:{
                        atacar();//llamando funcion atacar
                        break;
                    }
                    case 2:{
                        curar();//llamando funcion curar
                        break;
                    }
                    case 3:{
                        item();//llamando funcion item
                        break;
                    }
               	default:{
                        miedo();//llamando funcion miedo
                        break;
                    } 
                }
    }//creacion de la funcion atacar
    public static void atacar(){
        int aleatorio;        //variables locales a utilizar
        Random numeroAleatorio = new Random(); //declarando variables tipo random para aleatoriedad
        int ataqueJugador;
        //acciones de la funcion atacar sobre vida del enemigo
        aleatorio = (numeroAleatorio.nextInt(20-10+1)+10);
        ataqueJugador= ((nivel+1)*10)+aleatorio;
        puntosDeVidaEnemigo= puntosDeVidaEnemigo-ataqueJugador;
       
    }//creacion de la funcion curar
    public static void curar(){
        int aleatorio;      //variables locales a utilizar
        Random numeroAleatorio = new Random(); //declarando variables tipo random para aleatoriedad
        int curador;
        //condicion de puntos de mana para ejecutar la curacion del jugador
        if(puntosDeMana>=1){
            //acciones de la funcion curar en el jugador
            aleatorio = (numeroAleatorio.nextInt(25-15+1)+15);
            curador= ((nivel+1)*5)+aleatorio;
            puntosDeVida= puntosDeVida+curador;
            puntosDeMana=puntosDeMana-1;
        }
        else{//imprimiendo el mensaje de curacion fallada
            System.out.println("no cuentas con Puntos De mana (MP) para curarte");
        }
    }//creacion de la funcion enemigos que devuelve al enemigo seleccionado al azar
    public static String enemigos(){
        int numeroEnemigo;   //variables locales a utilizar
        String enemigoSeleccionado;
        Random numeroAleatorio = new Random();  //declarando variables tipo random para aleatoriedad
        
        numeroEnemigo= (numeroAleatorio.nextInt(3)+1);
            //comparando los enemigos disponibles
            switch(numeroEnemigo){
                case 1:{
                    enemigoSeleccionado= "Dark_Wolf";
		    puntosDeVidaEnemigo=150;
                    return enemigoSeleccionado;//retornando a enemigo Dark
                }
                case 2:{
                    enemigoSeleccionado= "Dragon";
		    puntosDeVidaEnemigo=155;
                    return enemigoSeleccionado;//retornando a enemigo Dragon
                }
                default:{
                    enemigoSeleccionado= "Migthy_Golem";
		    puntosDeVidaEnemigo=160;
                    return enemigoSeleccionado;//retornando a enemigo Golem                    
                }
            }   
    }//creacion de la funcion turno de enemigo que devuelve el ataque generado segun el poder del enemigo
    public static int turnoEnemigo(String enemigoRecibido){
        String enemigo;    //variables locales a utilizar
        int ataqueEnemigo;
        Random aleatorio = new Random();  //declarando variables tipo random para aleatoriedad
        int inferior;
        int superior;
        
        enemigo=enemigoRecibido;//recibiendo al enemigo elegido por la funcion enemigos
            //comparando con los enemigos disponibles
            switch(enemigo){
                case "Dark_Wolf":{
                    //ejecutando acciones del enemigo Dark
                    inferior=10+nivel;
                    superior=10+nivel+10;
                    ataqueEnemigo=(aleatorio.nextInt(superior-inferior+1)+inferior);
                    return ataqueEnemigo;//retornando el ataque de Dark
                }
                case "Dragon":{
                    inferior=15+nivel;   //ejecutando acciones del enemigo Dragon
                    superior=15+nivel+10;
                    ataqueEnemigo=(aleatorio.nextInt(superior-inferior+1)+inferior);
                    return ataqueEnemigo; //retornando ataque del enemigo Dragon
                }
                default:{
                    inferior=25+nivel;  //ejecutando acciones del enemigo Golem
                    superior=25+nivel+10;
                    ataqueEnemigo=(aleatorio.nextInt(superior-inferior+1)+inferior);
                    return ataqueEnemigo;  //retornando ataque del enemigo Golem
                }
            }
     }//creacion de la funcion tienda
    public static void tienda(){
        System.out.print("\033[H\033[2J");//limpia pantalla
        System.out.flush();
        int opcionCompra;      //variables locales a utilizar
        Scanner scannerDos=new Scanner(System.in);
        //mostrando en pantalla las opciones de la tienda
        System.out.println("Bienvenido a la tienda, que deceas adquirir:\n");
	System.out.println("PRODUCTO   \tPRECIO   \tBENEFICIO");
	System.out.println("1.Potion   \t50 oro   \tcura 25 HP");
	System.out.println("2.Hi-Potion\t100 oro  \tcura 75 HP");
	System.out.println("3.M-Potion \t75 oro   \trecupera 10 MP");
        //ingresando numero de opcion
        System.out.println("\n\nIngrese numero de opcion:");
        opcionCompra=scannerDos.nextInt();
            //comparando la opcion de compra
            switch(opcionCompra){
                case 1:{//condicion de oro necesario para el articulo1    
			if(oro>=50){
                            articulo1=articulo1+1;
                            System.out.println("compra exitosa");
                        }else {
                            System.out.println("oro insuficiente!!!");
                              }
                break;
                        }
		case 2:{//condicion de oro necesario para el articulo2
                        if(oro>=100){
                            articulo2=articulo2+1;
                         }else{ 
                            System.out.println("oro insuficiente!!!");
                              }
                break;
                        }
	     default:{//condicion de oro necesario para el articulo3
                     if(oro>=75){
                           articulo3=articulo3+1;
                     }else{ 
                          System.out.println("oro insuficiente!!!");  //poner while para ,ejora
                      		}
             break;
                     }
            }
    }//creacion de la funcion dormir permite al jugador recuperar HP y MP en su totalidad
    public static void dormir(){
        System.out.print("\033[H\033[2J");//limpia pantalla
        System.out.flush();
        int restoDeMana;   //variables locales a utilizar
        int restoDeVida;
        if(oro>=30){  //condicion de oro para recuperar vida y mana
            restoDeMana=10-puntosDeMana;
            puntosDeMana=puntosDeMana+restoDeMana;
            restoDeVida=150-puntosDeVida;
            puntosDeVida=puntosDeVida+restoDeVida;
            //descotando oro al jugador
            oro=oro-30;
            System.out.println("\nrecuperacion satisfactoria");
        }
        else{
            System.out.println("no cuentas con 'Oro' para recuperarte");
        }
    }//creacion de la funcion status para mostrar las estadisticas del juego actual
    public static void status(){
        System.out.print("\033[H\033[2J");//limpia pantalla
        System.out.flush();
        System.out.printf("\nNOMBRE:\t\t\t"+nombrePersonaje);
	System.out.printf("\nPuntos De Vida (HP):\t"+puntosDeVida);
	System.out.printf("\nPuntos De mana (MP):\t"+puntosDeMana);
        System.out.printf("\nNivel: \t\t\t"+nivel);
	System.out.printf("\nExperiencia:\t\t"+experiencia);
	System.out.printf("\nOro:    \t\t"+oro);
        System.out.printf("\nPotion:\t\t\t"+articulo1);
        System.out.printf("\nHi-Potion:\t\t"+articulo2);
        System.out.printf("\nM-Potion:\t\t"+articulo3);
        System.out.printf("\n\tEnemigos Vencidos:\t");
	System.out.printf("\nNombre:\t\t\tNo.Derrotas");
        System.out.printf("\nDark Wolf:\t\t"+enemigoVencido1);
	System.out.printf("\nDragon:\t\t\t"+enemigoVencido2);
        System.out.printf("\nMighty Golem:\t\t"+enemigoVencido3);	
    }//creacion de la funcion poder para aumentar de nivel al juego
    public static void poder(){
        System.out.print("\033[H\033[2J");//limpia pantalla
        System.out.flush();
        if(experiencia>=100){  //condicion de aumento de nivel
            nivel=nivel+1;
            System.out.println("Aumento de nivel exitoso");
        }
        else{
            System.out.println("carece de experiencia para subir su nivel");
        }
    }//creacion de la funcion Item para mostrar las diferentes posiones disponibles
     public static void item(){
        int opcionItem;    //variables locales a utilizar
        Scanner scannerDos=new Scanner(System.in);
        //imprimiendo posibles Items y su cantidad
        System.out.println("\nArticulos Disponibles:");
	System.out.println("\n1.Potion, Cura 25HP:\t"+articulo1);
	System.out.println("2.Hi-Potion,Cura 75HP:\t"+articulo2);
	System.out.println("3.M-Potion, Recupera 10MP:\t"+articulo3);
	
            do{//validacion de la opcion
                System.out.println("\nNumero de opcion:");
                opcionItem= scannerDos.nextInt();
                
            }while(opcionItem<1||opcionItem>4);
                //comparador para ver si es posibles utilizar un Item
                switch(opcionItem){
                    case 1:{
                        if(articulo1>0){//condicion de Item 1 y sus acciones
                            puntosDeVida=puntosDeVida+25;
                            articulo1=articulo1-1;
                        }
                        else{
                            System.out.println("no hay Disponible");
                            }
                    break;
                    }
                    case 2:{
                        if(articulo2>0){//condicion de Item 2 y sus acciones
                            puntosDeVida=puntosDeVida+75;
                            articulo2=articulo2-1;
                        }
                        else{
                            System.out.println("no hay Disponible");
                            }
                    break;
                    }
                    default:{
                        if(articulo3>0){ //condicion de Item 3 y sus acciones
                            puntosDeVida=puntosDeVida+75;
                            articulo3=articulo3-1;
                        }
                        else{
                            System.out.println("no hay Disponible");
                            }
                        break;
                    }                  
                }     
    }//creacion de la funcion miedo 
     public static void miedo(){
        int aleatorio;      //variables locales a utilizar
        Random numeroAleatorio = new Random(); //declarando variables tipo random para aleatoriedad
            aleatorio = (numeroAleatorio.nextInt(10-5+1)+5);
        
                if(oro>aleatorio){//condicion de finalizar battalla y sus acciones
                    oroPerdido= (nivel*2)+aleatorio;
                    oro= oro-oroPerdido;
                    System.out.println("Huiste de la batalla!!!");
		    System.out.println("oro perdido:"+oroPerdido);
                    opcionMiedo=1; //finalizando battalla por huida del jugador    
                }
                else{
                    System.out.println("No pudes huir de la batalla");
        }    
    }
}//Fin del programa 
