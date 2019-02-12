
package clases1;
import java.util.Scanner;
/**
 *
 * @author bryan
 */
public class Clases1 {
    
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int opcion;
        char regresarMenu;
        do{
            System.out.println("Menu de opciones");
            System.out.println("1.Crear Estudiante");
            System.out.println("2.Ver estudiantes");
            System.out.println("0.Salir");
            
            System.out.println("Ingrese numero de opcion: ");
            opcion=scanner.nextInt();
            
            switch(opcion){
                case 1:{
                    do{
                        Estudiante estudiante= new Estudiante();
                        estudiante.crearEstudiante();
                        System.out.println("Regresar a Menu [s]i, [n]o ");
                        regresarMenu= scanner.next().charAt(0);
                    }while(regresarMenu!='s');
                    break;
                }
                case 2:{
                    do{
                        Estudiante estudiante= new Estudiante();
                        estudiante.verEstiantes();
                        System.out.println("Regresar a Menu [s]i, [n]o ");
                        regresarMenu= scanner.next().charAt(0);
                    }while(regresarMenu!='s');
                    break;
                }
                
                case 0: System.exit(0); break;
            }
        }while(opcion!=0);
    }
    public static  void crearEstudiante(){
        Long carne;
        int regAc;
        String nombre,carrera;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2= new Scanner(System.in);
        System.out.println("Ingrese No.Carne: ");
        carne= scanner.nextLong();
        System.out.println("Ingrese No.Registro Academico: ");
        regAc= scanner.nextInt();
        System.out.println("Ingrese Nombre: ");
        nombre=scanner2.nextLine();
        System.out.println("Ingrese Carreara: ");
        carrera= scanner2.nextLine();
      
    }
    
}
