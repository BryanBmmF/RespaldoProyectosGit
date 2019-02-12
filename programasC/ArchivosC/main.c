/*
 * Archivos
 */

/* 
 * File:   main.c
 * Author: bryan
 *
 * Created on 31 de julio de 2018, 05:24 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
FILE *archivo;
// /home/bryan/NetBeansProjects/programasC/ArchivosC/
int main(int argc, char** argv) {
    int c;
    char direccion[]="archivo1.txt";
    archivo= fopen(direccion,"r");
    if(archivo==NULL){
        printf("\nEl archivo no existe, pero se creara");
        archivo= fopen(direccion,"w");
    }else{
         printf("\nSe encontro el archivo");
         char buffer[] = "Esto es un texto dentro del fichero.";
 	
 	archivo = fopen ( "archivo1.txt", "at" );
 	
 	fprintf(archivo,"%s.%i",buffer,5);
 	
        fprintf(archivo, "%s", "\n");
 	
 	fclose ( archivo );
    }

    return (EXIT_SUCCESS);
}

