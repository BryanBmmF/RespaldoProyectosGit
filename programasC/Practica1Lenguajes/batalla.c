/*
 * codigo de batalla
 */
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include"headersJuego.h"
//prototipos internos
int numeroAleatorio(int inferior,int superior);
void seleccionarEnemigo(); void turnoEnemigo();
void turnoJugador(); void ataquePersonaje(); void curarPersonaje(); void usarItems(); void huirPorMiedo();
void acreditacionFinalpersonaje(); void acreditacionInicial(); void aumentarNivelJuego();
//declaracion de variables globales en esta fuente a utilizar
int turno,experienciaGanada,oroGanado,oroPerdido,opcionMiedo=0,numeroEnemigoSelc,facAtackEnemSeleccionado;
char enemigoSeleccionado[20];
//constantes a utlilizar
const int ENEMIGO_DARK=1,ENEMIGO_DRAGON=2,ENEMIGO_GOLEM=3,HP_ENEM_DARK=105,HP_ENEM_DRAGON=110,HP_ENEM_GOLEM=115,
          FACTOR_ATACK_DARK=5,FACTOR_ATACK_DRAGON=10,FACTOR_ATACK_GOLEM=15,TOTAL_ENEMIGOS=3,
          SIN_MIEDO=0,CON_MIEDO=1,MAXIMA_EXPERIENCIA=100,BENEFICIO_POTION=25,BENEFICIO_HI_POTION=75,BENEFICIO_M_POTION=10;
          
const char NOM_ENEMIGO_DARK[]="Dark_Wolf",NOM_ENEMIGO_DRAGON[]="Dragon",NOM_ENEMIGO_GOLEM[]="Migthy_Golem";
//variables externas que hacen referencia a las globales en el main
extern char nombrePersonaje[50];
extern int puntosDeVida,puntosDeMana,puntosDeVidaEnemigo,enemigoVencido1,enemigoVencido2,enemigoVencido3
            ,oro,nivel,experiencia,articulo1,articulo2,articulo3,hpMaximo,mpMaximo;
//funcion principal de esta fuente 
void batallar(void){
    int turno;
    printf("\nAcreditacion Inicial de Batalla: ");
    printf("\n\tHP de Vida Personaje: %i",puntosDeVida);
    printf("\n\tMP de Mana Personaje: %i",puntosDeMana);
    printf("\n\tNivel de  Personaje: %i",nivel);
    printf("\n\tExperiencia de Personaje: %i",experiencia);
    printf("\n\tOro de Personaje: %i",oro);
    //seleccion de enemigo oponente en la batalla
    seleccionarEnemigo();
    printf("\n\tENEMIGO OPONENTE: %s",enemigoSeleccionado);
    printf("\n\tHP de Enemigo : %i",puntosDeVidaEnemigo);
    printf("\n\nEl Primer Turno es Aleatorio...........");
    
    //primer turno si es 1 inicia Enemigo, si es 2 inicia jugador
    turno= numeroAleatorio(1,2);
    do{
        if(turno%2 ==0){
            turnoJugador();// llamado a la funcion turnoJugador
            //limpia pantalla
        }else{
            turnoEnemigo();
            //limpia pantalla
        }
        turno++;//aumentando contador de turnos
    //se realiza lo anterior almenos una vez y luego se valida el seguimiento
    }while((puntosDeVida>0)&&(puntosDeVidaEnemigo>0)&& !(opcionMiedo==CON_MIEDO));
    //en caso de haber terminado la batalla
    if(!(opcionMiedo==CON_MIEDO)){ //si no es por huida del jugador
        if(puntosDeVida>puntosDeVidaEnemigo){// si gana el personaje venciendo al enemigo
            //limpia pantalla
            printf("\n\n=>FELICIDADES %s GANASTE LA BATALLA..",nombrePersonaje);
            acreditacionFinalpersonaje();
            puntosDeVidaEnemigo=0;// reiniciando solo la vida del enemigo despues de ganar el jugador
        }else{//si no el enemigo es el ganador
            printf("\n=<PERDISTE LA BATALLA EL GANADOR ES: %s ",enemigoSeleccionado);
            //se guarda el punteo final
            guardarPunteo();
            acreditacionInicial();
        }   
    }else{ //huida del jugador por miedo
        printf("\nFinal de la Batalla!!!");
        puntosDeVidaEnemigo=0;// reiniciando solo la vida del enemigo despues de la huida del jugador
        opcionMiedo=SIN_MIEDO;// vuelve a no tener miedo
    }
}
/*
 * Funcion que selecciona un enemigo aleatorio dentro del total de existentes
 *  -Acredita el nombre del enemigo y su numero
 *  -Acredita Puntos de vida del enemigo, y el factor de ataque
 */
void seleccionarEnemigo(){
    int numeroEnemigo=numeroAleatorio(1,TOTAL_ENEMIGOS);
    switch(numeroEnemigo){
        case 1: strcpy(enemigoSeleccionado,NOM_ENEMIGO_DARK);numeroEnemigoSelc=ENEMIGO_DARK;
            puntosDeVidaEnemigo=HP_ENEM_DARK,facAtackEnemSeleccionado=FACTOR_ATACK_DARK; 
        break;
        case 2: strcpy(enemigoSeleccionado,NOM_ENEMIGO_DRAGON); numeroEnemigoSelc=ENEMIGO_DRAGON;
            puntosDeVidaEnemigo=HP_ENEM_DRAGON,facAtackEnemSeleccionado=FACTOR_ATACK_DRAGON;
        break;
        case 3: strcpy(enemigoSeleccionado,NOM_ENEMIGO_GOLEM); numeroEnemigoSelc=ENEMIGO_GOLEM;
            puntosDeVidaEnemigo=HP_ENEM_GOLEM,facAtackEnemSeleccionado=FACTOR_ATACK_GOLEM;
        break;
        default:printf("\nNo esta registrado este enemigo");
        break;
    }  
}
/*
 * Funcion que maneja el turno de cada enemigo
 *  -Resta Vida al personaje de acuerdo al ataque generado por el enemigo
 *   segun su factor de ataque, y el nivel de juego
 */
void turnoEnemigo(){
    printf("\n\nTurno de Enemigo: %s",enemigoSeleccionado);
    //variables para los rangos superior e inferior del enemigo, y el ataque correspondiente
    int rangoInf,rangoSup,ataqueEnemigo;
    //se calculan los rangos del ataque del enemigo, se calcula el ataque y resta vida al personaje
    rangoInf=facAtackEnemSeleccionado+nivel; rangoSup=facAtackEnemSeleccionado+nivel+10;
    ataqueEnemigo=numeroAleatorio(rangoInf,rangoSup); 
    puntosDeVida= puntosDeVida-ataqueEnemigo;
    printf("\nDetalles de Turno Enemigo %s:",enemigoSeleccionado);
    printf("\n\tAtaque Enemigo: %i",ataqueEnemigo);
    printf("\n\tHP de Vida Personaje Perdidos: -%i",ataqueEnemigo); 
}
/*
 * Funcion que maneja el turno de cada personaje
 *  -Despliega opciones del personaje durante la batalla y la llamada a cada funcion
 */
void turnoJugador(){
    int opcionBatalla;
    //menu de opciones para el turno del jugador
    printf("\n");
    printf("\nTurno de %s",nombrePersonaje);
    printf("\n1.Atacar\t\t\t\t\tNombre:\t\t\t%s",nombrePersonaje);
    printf("2.Curar\t\t\t\t\t\tPuntos De Vida (HP):\t%i",puntosDeVida);
    printf("\n3.Item\t\t\t\t\t\tPuntos De mana (MP):\t%i",puntosDeMana);
    printf("\n4.Tengo Miedo\t\t\t\t\tOro:    \t\t%i",oro);
    printf("\n\t\t\t\t\t\tVida del enemigo:\t%i",puntosDeVidaEnemigo);
    do{//validando la opcion seleccionada
        printf("\nIngrese numero de opcion: ");
        scanf("%i",&opcionBatalla);
                
    }while((opcionBatalla<1)||(opcionBatalla>4));
    //comparacion de la opcion seleccionada y llamada a la funcion respectiva
    switch(opcionBatalla){
        case 1: ataquePersonaje(); break; 
        case 2: curarPersonaje(); break;
        case 3: usarItems(); break;
        case 4: huirPorMiedo(); break;
    }
}
//Funcion especial para calcular un numero aleatorio dentro de un rango especificado
int numeroAleatorio(int inferior, int superior){
    int numero;
    srand(time(NULL));
    numero=inferior+rand() % ((superior+1)-inferior);
    return numero;
}
//funciones especiales para opciones durante la batalla
//funcion ataque de personaje para calcula ataque a ejercer sobre el enemigo
void ataquePersonaje(){
    int ataqueJugador;
    //calculando ataque total del personaje
    ataqueJugador=((nivel+1)*10)+numeroAleatorio(10,20);
    //ejerciendo ataque sobre el enemigo
    puntosDeVidaEnemigo=puntosDeVidaEnemigo-ataqueJugador;
    printf("\nDetalles de Turno Personaje %s",nombrePersonaje);
    printf("\tAtaque de Personaje: %i",ataqueJugador);
    printf("\n\tHP de Enemigo perdidos: -%i",ataqueJugador);
}
//funcion curarPersonaje para recuperar vida del personaje 
void curarPersonaje(){
    int curaEjercida;
    //condicion de puntos de mana para ejecutar la curacion del jugador
        if(puntosDeMana>=1){
            //acciones de la funcion curar en el jugador
            curaEjercida= ((nivel+1)*5)+numeroAleatorio(15,25);;
            puntosDeVida= puntosDeVida+curaEjercida;
            if(puntosDeVida<=hpMaximo){//si no eccede el hp maximo se cura normalmente y se resta el mp
                puntosDeMana=puntosDeMana-1;
                printf("\nDetalles de Cura en el Turno de %s ",nombrePersonaje);
                printf("\n\tHP Recuperados: %i",curaEjercida);
                printf("\n\tHP de Vida Total: %i",puntosDeVida);
                printf("\n\tMP de mana Perdidos: %i",1);
            }else{//sino es porque eccedio el hp maximo y se mantendra en el maximo
                printf("\nDetalles de Cura en el Turno de %s ",nombrePersonaje);
                printf("\n\tHP Recuperados: %i",curaEjercida);
                printf("\n\tLlegaste al maximo de HP en este Nivel");
                puntosDeMana=puntosDeMana-1;
                puntosDeVida=hpMaximo;
            }
            
        }
        else{//imprimiendo el mensaje de curacion fallada
            printf("\nNo cuentas con Puntos De mana (MP) para curarte");
        } 
}
//funcion Item para mostrar las diferentes posiones disponibles, y usarlas segun el caso
void usarItems(){
   int opcionItem;
   //imprimiendo posibles Items y su cantidad
    printf("\nArticulos Disponibles:");
    printf("\n1.Potion, Cura 25HP:\t%i",articulo1);
    printf("\n2.Hi-Potion,Cura 75HP:\t%i",articulo2);
    printf("\n3.M-Potion, Recu 10MP:\t%i",articulo3);
    do{//validacion de la opcion
        printf("\n\nNumero de opcion: ");
        scanf("%i",&opcionItem);            
    }while(opcionItem<1||opcionItem>3);
    printf("\nDetalles del Item Utilizado:");
    //comparador de opciones de Items posibles a utilizar
    switch(opcionItem){
        case 1: 
            if(articulo1>0){//si hay existencias del articulo1
                puntosDeVida=puntosDeVida+BENEFICIO_POTION;
                if(puntosDeVida<=hpMaximo){//si no eccede el xpMaximo, se utiliza el item normalmente
                    articulo1=articulo1-1;
                    printf("\n\tHP Recuperados por el Articulo1  %i:",BENEFICIO_POTION);
                }else{//llego al hpMaximo utilizacndo este Item
                    puntosDeVida=hpMaximo; articulo1=articulo1-1;
                    printf("\n\tLlego al HP Maximo con este Item");
                }
            }else{
                printf("\n No hay mas Potion Disponible");
            }
        break;
        case 2: 
            if(articulo2>0){//si hay existencias del articulo2
                puntosDeVida=puntosDeVida+BENEFICIO_HI_POTION;
                if(puntosDeVida<=hpMaximo){//si no eccede el hpMaximo, se utiliza el item normalmente
                    articulo2=articulo2-1;
                    printf("\n\tHP Recuperados por el Articulo2  %i:",BENEFICIO_HI_POTION);
                }else{//llego al hpMaximo utilizando este Item
                    puntosDeVida=hpMaximo; articulo2=articulo2-1;
                    printf("\n\tLlego al HP Maximo con este Item");
                }
            }else{
                printf("\n No hay mas Hi-Potion Disponible");
            }
        break;
        case 3: 
            if(articulo3>0){//si hay existencias del articulo3
                puntosDeMana=puntosDeMana+BENEFICIO_M_POTION;
                if(puntosDeMana<=mpMaximo){//si no eccede el mpMaximo, se utiliza el item normalmente
                    articulo3=articulo3-1;
                    printf("\n\tMP Recuperados por el Articulo3  %i:",BENEFICIO_M_POTION);
                }else{//llego al mpMaximo utilizando este Item
                    puntosDeMana=mpMaximo; articulo3=articulo3-1;
                    printf("\n\tLlego al MP Maximo con este Item");
                }
            }else{
                printf("\n No hay mas M-Potion Disponible");
            }
        break;
        default: printf("\n No existe el articulo"); break;
    }
}
void huirPorMiedo(){
    oroPerdido= (nivel*2)+numeroAleatorio(5,10);
    if(oro>oroPerdido){//si tiene suficiente oro puede huir
        oro= oro-oroPerdido;
        printf("\n\nHuiste de la batalla!!!");
	printf("\n\tCantidad de Oro Perdido: %i piezas",oroPerdido);
        opcionMiedo=CON_MIEDO; //finalizando batalla por huida del jugador, se activa el opcionMiedo    
    }
    else{//sino no puede huir de la batalla
        printf("\nALERTA!! No pudes huir de la batalla por falta de Oro!!!, perdiste este Turno");
    }    
}
//funcion de acreditacion final para un personaje ganador
void acreditacionFinalpersonaje(){
    printf("\n\nResumen del Juego: ");
    //Evaluacion del Aumento de nivel y calculo de oro ganado
    aumentarNivelJuego();
    oroGanado=numeroAleatorio(5,15)*facAtackEnemSeleccionado;
    oro= oro+oroGanado;
    //imprimiendo acreditacion
    printf("\n\t Ganador: %s",nombrePersonaje);
    printf("\t Oro Ganado: %i piezas",oroGanado);
    printf("\n\t Experiencia Ganada: %i puntos",experienciaGanada);
    printf("\n\t Enemigo derrotado: %s",enemigoSeleccionado);
    //Acreditacion de conteo de derrotas para cada enemigo
    switch(numeroEnemigoSelc){
        case 1: enemigoVencido1++; break;
        case 2: enemigoVencido2++; break;
        case 3: enemigoVencido3++; break;
        default: printf("\n sin enemigo"); break;
    }
}
//funcion para Aumentar de nivel automaticamente despues de la Batalla
void aumentarNivelJuego(){
    //acreditacion de experiencia
    experienciaGanada=numeroAleatorio(2,5)*facAtackEnemSeleccionado;
    experiencia=experiencia+experienciaGanada;
    if(experiencia>=MAXIMA_EXPERIENCIA){
        //se aumenta el nivel junto con el valor de hpMaximo,mpMaximo, y se reinicia la variable experiencia
        nivel= nivel+1; experiencia=0;
        hpMaximo=100*(nivel+1);mpMaximo=10*(nivel+1);
        printf("\n\t => FELICIDADES LLEGASTE AL NIVEL  %i",nivel);
    }
    
}

