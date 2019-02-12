/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversoraux;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class ConversorAux {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        String date="23/01/2018";
        String dia=date.substring(0, 2);
        String mes=date.substring(3, 5);
        String an= date.substring(6,10);
        String dpi="1700913680101";
        String part1=dpi.substring(0,4);
        String part2=dpi.substring(4,9);
        String part3=dpi.substring(9, 13);
        System.out.println(part1);
        System.out.println(part2);
        System.out.println(part3);
        
        Scanner scanner= new Scanner(System.in);
        int numero;
        System.out.println("Ingrese un numero para convertir: ");
        numero= scanner.nextInt();
        System.out.println("Hexadecimal: "+conversionHexadecimal(numero));
    }
    public static String conversionBinaria(int numero){
        int numeroEvaluo= numero;
        String binario="";
        System.out.println("Conversion Binaria");
        if (numeroEvaluo==0) {
            return "0";
        }else{
            while(numeroEvaluo!=1){
            if (numeroEvaluo%2==0) {
                numeroEvaluo= numeroEvaluo/2;
                binario="0"+binario;
            }else{
                numeroEvaluo= numeroEvaluo/2;
                binario="1"+binario;
                }
            }   
            return "1"+binario;  
        }   
    }
    public static String conversionOctal(int numero){
      int numeroEvaluo=numero,cociente=numero,residuo=0;
      String octal="";
        System.out.println("Conversion Octal");
        do{
           cociente=numeroEvaluo/8;
           residuo=numeroEvaluo-(8*cociente);
           numeroEvaluo=cociente;
           octal=residuo+octal; 
        }while(cociente!=0);
        return octal;  
    }
    public static String conversionHexadecimal(int numero){
      int numeroEvaluo=numero,cociente=numero,residuo=0;
      String hexadecimal="";
        System.out.println("Conversion Hexadecimal");
        do{
           cociente=numeroEvaluo/16;
           residuo=numeroEvaluo-(16*cociente);
           numeroEvaluo=cociente;
            if (residuo<10) {
               hexadecimal=residuo+hexadecimal; 
            }else{
               hexadecimal=letraHexadecimal(residuo)+hexadecimal;
            }
        }while(cociente!=0);
        return hexadecimal;  
    }
    public static String letraHexadecimal(int numero){
        String equivalente="";
        switch(numero){
            case 10: equivalente="A";break; case 11: equivalente="B";break;
            case 12: equivalente="C";break; case 13: equivalente="D";break; 
            case 14: equivalente="E";break; case 15: equivalente="F";break;
            case 16: equivalente="G";break;
        }
        return equivalente;
    }
    
}
