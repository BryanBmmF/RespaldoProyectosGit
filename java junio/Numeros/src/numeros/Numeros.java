/*
 * Aplicacion que convierte numeros de entero a letras y a romanos
 */
package numeros;
import java.util.Scanner;
/**
 *
 * @author bryan
 */
public class Numeros {
    static Scanner entrada= new Scanner(System.in);
    static int numero,convertidoEntero,convertidoEntero2,convertidoEntero3,convertidoEntero4;
    static String convertidoCadena;
    static String uniRomanos, decenRomanos, centRomanos, millarRomanos,
                  unidadNumerosR = "", decenaNumerosR = "", centenasNumerosR = "",
                  milNumerosR = "";
    public static void main(String[] args) {
        System.out.println("Conversor de numeros");
        System.out.print("Ingrese un numero de 1 a 4999: ");
        numero= entrada.nextInt();
        convertirLetras(numero);
        convertirRomanos();
        
    }
    
    public static void convertirLetras(int numero){
        convertidoCadena= String.valueOf(numero);
        switch(convertidoCadena.length()){
            case 1:System.out.println("\nEn Letras es: "+conversorBasico(numero));break;
            case 2:System.out.println("\nEn letras es: "+conversorBasico2(numero,0,1,2)); break;
            case 3:System.out.println("\nEn letras es: "+centenas(numero,0,1,2,3)); break;
            case 4:System.out.println("\nEn letras es: "+millares(numero)); break;
        }
        
    }
    public static String conversorBasico(int numero){//convierte numeros del 1 al 9
        String retorno="";
        switch(numero){
            case 0: retorno="Cero"; break; case 1: retorno="Uno"; break; case 2: retorno="Dos"; break; case 3: retorno="Tres"; break;
            case 4: retorno="Cuatro"; break; case 5: retorno="Cinco"; break; case 6: retorno="Seis"; break; case 7: retorno="Siete"; break;
            case 8: retorno="Ocho"; break; case 9: retorno="Nueve"; break;
        }
        return retorno;
    }
    public static String conversorBasico2(int numero,int in1, int in2, int in3){//convierte numeros entre 10 y 99
        String retorno="";
        if (numero<=15) {
            switch(numero){
                case 10: retorno="Diez"; break; case 11: retorno="Once"; break; case 12: retorno="Doce"; break;
                case 13: retorno="Trece"; break; case 14: retorno="Catorce"; break; case 15: retorno="Quince"; break;
            }    
        }else{
            convertidoEntero= Integer.parseInt(convertidoCadena.substring(in1, in2));
            convertidoEntero2= Integer.parseInt(convertidoCadena.substring(in2, in3));
            
            switch(convertidoEntero){
                case 1: retorno="Dieci"+conversorBasico(convertidoEntero2); break;
                case 2:{
                    if(convertidoEntero2!=0) retorno="Veinti"+conversorBasico(convertidoEntero2);
                    if(convertidoEntero2==0) retorno="Veinte"; break;
                } 
                case 3:retorno=repiteDecenas("Treinta", "Treinta y ", convertidoEntero2); break;
                case 4:retorno=repiteDecenas("Cuarenta", "Cuarenta y ", convertidoEntero2);break;
                case 5:retorno=repiteDecenas("Cincuenta", "Cincuenta y ", convertidoEntero2);break;
                case 6:retorno=repiteDecenas("Sesenta", "Sesenta y ", convertidoEntero2);break;
                case 7:retorno=repiteDecenas("Setenta", "Setenta y ", convertidoEntero2);break;
                case 8:retorno=repiteDecenas("Ochenta", "Ochenta y ", convertidoEntero2);break;
                case 9:retorno=repiteDecenas("Noventa", "Noventa y ", convertidoEntero2);break;
            }    
        }
        
        return retorno;
    }
    public static String repiteDecenas(String decena,String decenaUnidad,int valor){
        String retorno="";
        if(convertidoEntero2!=0) retorno=decenaUnidad+conversorBasico(valor);
        if(convertidoEntero2==0) retorno=decena;
        return retorno;
    }
    public static String centenas(int numero,int in1, int in2, int in3, int in4){
        String retorno="",enlace;
        convertidoEntero= Integer.parseInt(convertidoCadena.substring(in1, in2));
        convertidoEntero2= Integer.parseInt(convertidoCadena.substring(in2,in3));
        convertidoEntero3= Integer.parseInt(convertidoCadena.substring(in3, in4));
        enlace=convertidoCadena.substring(in2, in3)+convertidoCadena.substring(in3, in4);
        switch(convertidoEntero){
                case 1:{
                    if(convertidoEntero2==0 && convertidoEntero3==0) retorno="Cien"; 
                    if(convertidoEntero2==0 && convertidoEntero3!=0) retorno="Ciento "+conversorBasico(convertidoEntero3);
                    if(convertidoEntero2!=0) retorno="Ciento "+conversorBasico2(Integer.parseInt(enlace),1,2,3);              
                    break;
                } 
                case 2:retorno=repiteCentenas("Doscientos ", enlace); break;
                case 3:retorno=repiteCentenas("Trescientos ", enlace); break;
                case 4:retorno=repiteCentenas("Cuatrocientos ", enlace); break;
                case 5:retorno=repiteCentenas("Quinientos ", enlace); break;
                case 6:retorno=repiteCentenas("Seiscientos ", enlace); break;
                case 7:retorno=repiteCentenas("Setecientos ", enlace); break;
                case 8:retorno=repiteCentenas("Ochocientos ", enlace); break;
                case 9:retorno=repiteCentenas("Novecientos ", enlace); break;
            }    
        return  retorno;
    }
    public static String repiteCentenas(String centena,String enlace){
        String retorno="";
            if(convertidoEntero2==0 && convertidoEntero3==0) retorno=centena; 
            if(convertidoEntero2==0 && convertidoEntero3!=0) retorno=centena+conversorBasico(convertidoEntero3);
            if(convertidoEntero2!=0) retorno=centena+conversorBasico2(Integer.parseInt(enlace),1,2,3);
        return  retorno;    
    }
    public static String millares(int numero){
        String retorno="",enlace;
        convertidoEntero= Integer.parseInt(convertidoCadena.substring(0, 1));
        convertidoEntero2= Integer.parseInt(convertidoCadena.substring(1, 2));
        convertidoEntero3= Integer.parseInt(convertidoCadena.substring(2, 3));
        convertidoEntero4= Integer.parseInt(convertidoCadena.substring(3, 4));
        
        enlace=convertidoCadena.substring(1, 2)+convertidoCadena.substring(2, 3)+convertidoCadena.substring(3, 4);
        switch(convertidoEntero){
                case 1:retorno=repiteCentenas("Mil ", enlace); break;
                case 2:retorno=repiteCentenas("Dos Mil ", enlace); break;
                case 3:retorno=repiteCentenas("Tres Mil ", enlace); break;
                case 4:retorno=repiteCentenas("Cuatro Mil ", enlace); break;
                case 5:retorno=repiteCentenas("Cinco Mil ", enlace); break;
                case 6:retorno=repiteCentenas("Seis Mil ", enlace); break;
                case 7:retorno=repiteCentenas("Siete Mil ", enlace); break;
                case 8:retorno=repiteCentenas("Ocho Mil ", enlace); break;
                case 9:retorno=repiteCentenas("Nueve Mil ", enlace); break;
            }    
        return  retorno;
    }
    public static String repiteMillares(String millar,String enlace){
        String retorno="";
            if(convertidoEntero2==0 && convertidoEntero3==0 && convertidoEntero4==0) retorno=millar; 
            if(convertidoEntero2==0 && convertidoEntero3==0 && convertidoEntero4!=0) retorno=millar+conversorBasico(convertidoEntero4);
            if(convertidoEntero2!=0) retorno=millar+centenas(Integer.parseInt(enlace),1,2,3,4);
        return  retorno;    
    }
    //*************************************
    public static void convertirRomanos(){
        if(convertidoCadena.length() == 1){
            uniRomanos = convertidoCadena.substring(0, 1);
            unidadesRomanos();
        }
        if(convertidoCadena.length() == 2){
            uniRomanos  = convertidoCadena.substring(1, 2);
            unidadesRomanos();
            decenRomanos = convertidoCadena.substring(0, 1);
            decenasRomanos();
        }
        if(convertidoCadena.length() == 3){
            uniRomanos  = convertidoCadena.substring(2, 3);
            unidadesRomanos();
            decenRomanos = convertidoCadena.substring(1, 2);
            decenasRomanos();
            centRomanos = convertidoCadena.substring(0, 1);
            centenasRomanos();
        }
        if(convertidoCadena.length() == 4){
            uniRomanos  = convertidoCadena.substring(3, 4);
            unidadesRomanos();
            decenRomanos = convertidoCadena.substring(2, 3);
            decenasRomanos();
            centRomanos = convertidoCadena.substring(1, 2);
            centenasRomanos();
            millarRomanos = convertidoCadena.substring(0, 1);
            millaresRomanos();
        }
        System.out.println("\nEn Romanos: " + milNumerosR + centenasNumerosR + decenaNumerosR + unidadNumerosR);
        milNumerosR = ""; centenasNumerosR = ""; decenaNumerosR = ""; unidadNumerosR = "";
    }
    
    public static void unidadesRomanos(){
        switch(uniRomanos){
            case "1": unidadNumerosR = "I"; break;
            case "2": unidadNumerosR = "II"; break;
            case "3": unidadNumerosR = "III"; break;
            case "4": unidadNumerosR = "IV"; break;
            case "5": unidadNumerosR = "V"; break;
            case "6": unidadNumerosR = "VI"; break;
            case "7": unidadNumerosR = "VII"; break;
            case "8": unidadNumerosR = "VIII"; break;
            case "9": unidadNumerosR = "IX"; break;
            case "0": unidadNumerosR = ""; break;
        }
    }
    
    public static void decenasRomanos(){
        switch(decenRomanos){
            case "1": decenaNumerosR = "X"; break;
            case "2": decenaNumerosR = "XX"; break;
            case "3": decenaNumerosR = "XXX"; break;
            case "4": decenaNumerosR = "XL"; break;
            case "5": decenaNumerosR = "L"; break;
            case "6": decenaNumerosR = "LX"; break;
            case "7": decenaNumerosR = "LXX"; break;
            case "8": decenaNumerosR = "LXXX"; break;
            case "9": decenaNumerosR = "XC"; break;
            case "0": decenaNumerosR = ""; break;
        }
    }
    
    public static void centenasRomanos(){
        switch(centRomanos){
            case "1": centenasNumerosR = "C"; break;
            case "2": centenasNumerosR = "CC"; break;
            case "3": centenasNumerosR = "CCC"; break;
            case "4": centenasNumerosR = "CD"; break;
            case "5": centenasNumerosR = "D"; break;
            case "6": centenasNumerosR = "DC"; break;
            case "7": centenasNumerosR = "DCC"; break;
            case "8": centenasNumerosR = "DCCC"; break;
            case "9": centenasNumerosR = "CM"; break;
            case "0": centenasNumerosR = ""; break;
        }
    }
    
    public static void millaresRomanos(){
        switch(millarRomanos){
            case "1": milNumerosR = "M"; break;
            case "2": milNumerosR = "MM"; break;
            case "3": milNumerosR = "MMM"; break;
            case "4": milNumerosR = "MMMM"; break;
            case "0": milNumerosR = ""; break;
        }
    }
    
}
