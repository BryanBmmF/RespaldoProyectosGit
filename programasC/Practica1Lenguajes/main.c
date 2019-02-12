/*
 * Practica 1 de lenguajes Formales y de Programacion.
 */

/* 
 * File:   main.c
 * Author: bryan
 *
 * Created on 24 de julio de 2018, 06:05 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "headersJuego.h"

/*
 * Variables globales a utilizar, y prototipos de funciones
 */
int puntosDeVida,puntosDeMana,puntosDeVidaEnemigo,enemigoVencido1,enemigoVencido2,enemigoVencido3
    ,oro,nivel,experiencia,articulo1,articulo2,articulo3,hpMaximo,mpMaximo;
char nombrePersonaje[50];

//firmas locales
void acreditacionInicial(); void opcionesMenuPrincipal(int opcion); char regresarMenu();

//procedimiento inicial main, con argumento argc(contador de parametros recibidos), argv(puntero de parametros)
int main(int argc, char** argv) {
    char mensaje[50]="Bienvenido al Juego: ";
    if(argc==1){
        printf("Que nombre de personaje desea tener? ");
        //se delimita la entrada nombre para no lanzar warnings en la compilacion
        fgets(nombrePersonaje,40,stdin);
    }else{
        int contador=0;
        for(int i=1;i<argc;i++){// empieza el contador en 1 porque el primer parametro argv[0] es el nombre del ejecutable
            int longParam=strlen(argv[i]);  //longitud del parametro en turno
            char temporal[longParam];   //se crea un arreglo para almacenar el contenido del parametro en turno
            strcpy(temporal,argv[i]);   //traspaso de arreglos, parametro a temporal
            for(int j=0;j<longParam;j++){
                nombrePersonaje[contador]=temporal[j];   //concatenando cadena nombre con cada parametro temporal
                contador++;
            }
            nombrePersonaje[contador]=' ';   //almacenando espacio entre parametros
            contador++;
        }    
    }
    printf("%s %s",mensaje,nombrePersonaje); //se imprime el mensaje principal y los parametros del personaje
    printf("\n");
    
    acreditacionInicial();  //acreditacion inicial de punteos
    
    //despliegue del menu Principal de opciones
    int numeroDeOpcion;
    do{
        printf("\n::MENU DE OPCIONES::");
        printf("\n1. A la Carga.");
        printf("\n2. Tienda.");
        printf("\n3. zzZzzZZ(Dormir).");
        printf("\n4. Status.");
        printf("\n5. Mejor Punteo.");
        //printf("\n6. Mas Poder!!!");
        printf("\n6. Salir.\n");
        printf("\nIngrese numero de opcion: ");
        scanf("%i",&numeroDeOpcion);
        
        //validacion de opcion ingresada
        while (numeroDeOpcion<1 || numeroDeOpcion>6) {
            printf("\nOpcion incorrecta, vuelva ingresar un numero de opcion: ");
            scanf("%i",&numeroDeOpcion);
        }
        opcionesMenuPrincipal(numeroDeOpcion); //operacion a realizar
        
    }while(numeroDeOpcion!=6);
  
    return (EXIT_SUCCESS);
}
void acreditacionInicial(void){
    enemigoVencido1=0;enemigoVencido2=0;enemigoVencido3=0;oro=0;nivel=0;
    experiencia=0;articulo1=0;articulo2=0;articulo3=0;puntosDeVidaEnemigo=0;
    hpMaximo=100*(nivel+1);mpMaximo=10*(nivel+1);
    puntosDeVida=hpMaximo; puntosDeMana=mpMaximo;
    
}
void opcionesMenuPrincipal(int opcion){
    char opcionVolver='n';
    switch(opcion){
        case 1:
            do{
                printf("\nBienvenido a la Batalla %s",nombrePersonaje);
                batallar(); //llamada de la funcion batallar de headersJuego
                opcionVolver= regresarMenu();
            }while((opcionVolver=='n')||(opcionVolver=='N'));
            break;
        
        case 2:
            do{
                printf("\nBienvenido a la Tienda");
                comprar(); //llamada de funcion comprar de headersJuego
                opcionVolver= regresarMenu();
            }while((opcionVolver=='n')||(opcionVolver=='N'));
            break;
        case 3:
            do{
                printf("\nBienvenido al Descanso");
                dormir();// llamada a funcion dormir de headersJuego
                opcionVolver= regresarMenu();
            }while((opcionVolver=='n')||(opcionVolver=='N'));
            break;
        
        case 4:
            do{
                printf("\nBienvenido al Status");
                status(); //llamada de funcion status de headersJuego
                opcionVolver= regresarMenu();
            }while((opcionVolver=='n')||(opcionVolver=='N'));
            break;
        
        case 5:
            do{
                printf("\nMejores Punteos de Juego");
                mostrarPunteos(); //llamada de funcion punteos
                 opcionVolver= regresarMenu();
            }while((opcionVolver=='n')||(opcionVolver=='N'));
            break;
        
        default:
            printf("\nGRACIAS POR JUGAR!!!");
            break;
        
    } 
}
char regresarMenu(){
    char opcionRetornar='n';
    printf("\n\n(En caso de no volver al menu, se repetira esta opcion)");
    printf("\n\tVolver al Menu principal [s]i, [n]o ? ");
    scanf(" %c", &opcionRetornar);
    return opcionRetornar;
}

