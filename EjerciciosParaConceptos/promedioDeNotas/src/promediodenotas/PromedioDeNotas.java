
package promediodenotas;
import java.util.Scanner;

/**
 * Autor: Bryan Monzon
 * Fceha: 13/02/2018 
 * Titulo: Promedio de notas
 * Descripcon: este programa permite al usuario ingresar 4 notas
 * calcular el promedio, y la nota menor.
 */
public class PromedioDeNotas {
    
    //variable con ambito global
    static Scanner scanner=new Scanner(System.in);
    
    /**
	 * Este es el procedimiento principal
	 */

    public static void main(String[] args) {
        //Declaracion de variables locales
        
        float promedio;
        int menor;
        int[] notas = new int[4];//declaracion de un vector con 4 espacios
        
        //inicio del ciclo for
        for(int cont=0;cont<4;cont++){
            
            //Ingresando las notas
            System.out.printf("Ingrese la nota %d",cont+1);
            System.out.println(" ");
            notas[cont]=scanner.nextInt();
            
        }//fin del ciclo for
        
        //calculo del promedio de las notas ingresadas por el usuario
        promedio=(notas[0]+notas[1]+notas[2]+notas[3])/4f;
        
        //imprimiendo el resultado del promedio en pantalla
        System.out.println("El promedio es:"+promedio);
        
        //revisando si esta aprobado o reprobado
        if(promedio<61){
            System.out.println("\nREPROBADO");
        }
        else{
            System.out.println("\nAPROBADO");
        }
        
        //procedimiento para hallar la nota menor de las ingresadas
        menor= notas[0];
            for(int cont2=1;cont2<4;cont2++){
                if(menor>notas[cont2]){
                    menor=notas[cont2];
                }//fin sentencia si
                
                
            }//fin de ciclo for
            
            //imprimirndo la nota menor en pantalla
        System.out.println("\nla nota menor es:"+menor);
    }
    
}
