/*
 *Practica de archivos
 */
package practicalab1;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 *
 * @author bryan
 */
public class PracticaLab1 {
    static Scanner scanner=new Scanner(System.in);
    static Scanner scanner2=new Scanner(System.in);
    static int opcionMenu;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     do{
         opcionMenu=menu();
        switch(opcionMenu){
            case 1:{
                do{
                    escritura();
                }while(retornarMenu()==false);
                 break;
            }
            case 2:{
                do{
                    lectura();
                }while(retornarMenu()==false);
                 break;
            }
        }
     
     }while(opcionMenu!=0);
        
    }
    public static int menu(){
        int opcion;
        System.out.println("1.Escribir Algo");
        System.out.println("2.Mostrar Todo");
        System.out.println("0.Salir");
        System.out.println("Ingrese numero de opcion:");
        opcion = scanner.nextInt();
        while(opcion<0 || opcion>2){
            System.out.println("Opcion Invalida, intente Otra vez:");
            opcion= scanner.nextInt();
        }
        
        return opcion;
    }
    public static void escritura(){
    String texto;
    System.out.println("Escriba algo:");
    texto= scanner2.nextLine();
    //éste método permite escribir si no existe y actualizar (agregar) si existe
    //  se crea pw como un nuevo escritor, que utiliza una bufferización del archivo, el "true" activa la edición y se coloca al final  
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("archivo.txt", true)))) {
            pw.println(texto);
        }catch (IOException e) {
            System.err.println(e);
        }		
    }
    public static void lectura(){
        try{
            File archivo = new File("archivo.txt");
            Scanner lectura = new Scanner(archivo);
            List<String> textos = new ArrayList<>();
            while (lectura.hasNext()) {
		textos.add(lectura.nextLine());
            }
            for(String i: textos){
                System.out.println(i);
            }
        }catch(FileNotFoundException ex){
		System.out.println("No se encontró el archivo");
	}
        
    }
    //metodo para retornar al menu Principal
    public static boolean retornarMenu(){
        boolean retorno=false;
        char opcionVolver;
        System.out.println("Volver al menu [s]i, [n]o");
        opcionVolver= scanner.next().charAt(0);
        
        if (opcionVolver=='s' || opcionVolver=='S')retorno=true;
        return retorno;
    }
    
}
