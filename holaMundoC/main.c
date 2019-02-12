
/* 
 * File:   main.c
 * Author: bryan
 *
 * Created on 18 de julio de 2018, 11:55 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * Argumentos principales argc para el contador de parametros ingresados en la ejecucion
 *      argv para el puntero que hace referencia a los parametros ingresados
 */
int main(int argc, char** argv) {
    char nombre[50];
    char mensaje[50]="Bienvenido al programa: ";
    if(argc==1){
        printf("Que nombre de personaje desea tener? ");
        //se delimita la entrada nombre para no lanzar warnings en la compilacion
        fgets(nombre,40,stdin);
    }else{
        int contador=0;
        for(int i=1;i<argc;i++){// empieza el contador en 1 porque el primer parametro argv[0] es el nombre del ejecutable
            int longParam=strlen(argv[i]);  //longitud del parametro en turno
            char temporal[longParam];   //se crea un arreglo para almacenar el contenido del parametro en turno
            strcpy(temporal,argv[i]);   //traspaso de arreglos, parametro a temporal
            for(int j=0;j<longParam;j++){
                nombre[contador]=temporal[j];   //concatenando cadena nombre con cada parametro temporal
                contador++;
            }
            nombre[contador]=' ';   //almacenando espacio entre parametros
            contador++;
        }    
    }
    printf("%s %s",mensaje,nombre); //se imprimen los parametros
    printf("\n");
    
    char expresion='s';
    while (expresion=='r'||expresion=='R') {
        printf("Hola Mundo");
    }
    
    do{
        printf("Hola Mundo");
        expresion='s';
    
    }while(expresion=='r'||expresion=='R');
    
    switch(expresion){
        case 'r':{
            printf("Hola Mundo");
            break;
        }
        case 't':{
            printf("Hola Mundo");
            break;
        }
        case 's':{
            printf("Hola Mundo");
            break;
        }
        default :{
            printf("Hola Mundo");
            break;
        }
    }
    

    
    return (EXIT_SUCCESS);//fin de proceso
}

