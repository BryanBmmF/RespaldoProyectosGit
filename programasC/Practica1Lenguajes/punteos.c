/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
//puntero de archivo

//variables externas que hacen referencia a las globales en el main
extern char nombrePersonaje[50];
extern int puntosDeVida,puntosDeMana,puntosDeVidaEnemigo,enemigoVencido1,enemigoVencido2,enemigoVencido3
            ,oro,nivel,experiencia,articulo1,articulo2,articulo3,hpMaximo,mpMaximo;
void guardarPunteo(){
    
    FILE *archivo;
    int c;
    char direccion[]="punteos.txt";
    archivo= fopen(direccion,"r");
    if(archivo==NULL){
        printf("\nSe creo el archivo punteos.txt");
        archivo= fopen(direccion,"at");
        
        int totalVencidos= enemigoVencido1+enemigoVencido2+enemigoVencido3;
        fprintf(archivo,"%i %s",totalVencidos,nombrePersonaje);
        fclose(archivo);
        
    }else{
        printf("\nYa existe el archivo punteos.txt");
        archivo= fopen(direccion,"at");
        int totalVencidos= enemigoVencido1+enemigoVencido2+enemigoVencido3;
        fprintf(archivo,"%i %s",totalVencidos,nombrePersonaje);
        fclose(archivo);
    }
}
void mostrarPunteos(){
    //estructura para el puntaje de un Jugador
    struct datosJugador{
        char nombreJugador[50];
        char numeroEnemDerrotados[50];
    }datosJugadores[5];
    //estructura para cada cadena leida
    struct cadenaLeida{
        char cadena[50];
    }cadenas[5];
    FILE *archivo;
    char caracteres[50];
    int contSaltos=0,contNombres=0,contNumeros=0;
    //se abre para leer el archivo punteos
    archivo = fopen("punteos.txt","r");
    //se verifica si existe
    if (archivo == NULL){
        printf("\nNo Hay Registros. \n\n");
    }
    else{
        printf("\nNo.Enemigos Derrotados\t\tPersonaje");
        printf("\n");
        //leyendo linea a linea el archivo 
	while (feof(archivo)== 0){
            fgets(caracteres,50,archivo);
            strcpy(cadenas[contSaltos].cadena,caracteres);
            contSaltos++;
 	}
        //separando datos
        for(int i=0;i<contSaltos;i++){
            
            char * pch;
            int conTokens=1;
            pch = strtok (cadenas[i].cadena,",");   // Aqui deja solo la coma
            while (pch != NULL){
                if(conTokens%2==0){
                   // printf ("%s",pch);     // Aqui guarda los datos numeros
                    strcpy(datosJugadores[i].numeroEnemDerrotados,pch);
                    pch = strtok (NULL, ",");
                }else{
                  // printf ("%s",pch);     // Aqui guarda los datos cadenas
                   strcpy(datosJugadores[i].nombreJugador,pch);
                   pch = strtok (NULL, ","); 
                }
            conTokens++;  
            }
        }        
    }
    fclose(archivo);
        //se imprime la estructura leida
        for(int i=0;i<contSaltos;i++){
            printf("\n\t%s\t\t\t%s",datosJugadores[i].nombreJugador,datosJugadores[i].numeroEnemDerrotados);
        }
}
void separarDatos(){
    
}
    
