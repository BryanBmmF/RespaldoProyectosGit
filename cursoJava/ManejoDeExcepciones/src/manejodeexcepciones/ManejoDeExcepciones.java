/*
 Manejo de excepciones 
 
 */
package manejodeexcepciones;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Title: Excepciones 
 * @author bryan
 * Description: Description
 */
public class ManejoDeExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Scanner scanner= new Scanner(System.in);
        int opcion=0;
        boolean bandera=true;
        
        System.out.println("Bienvenido que desea hacer:");  //mostrando el menu de opciones
        System.out.println("1.Introducir Datos: \n2.Salir\n");
        
        int j=0;//inicializando iterador
            while(bandera==true){
                try{ //intentando librar error
                    System.out.print("Ingrese numero de opcion: ");
                    opcion=Integer.parseInt(scanner.nextLine());
        
                    int i=0; //iterador
                        while(opcion<1||opcion>2){
                            JOptionPane.showMessageDialog(null,"El numero de opcion No se encuentra en el menu\n Intente nuevamente");
                            System.out.print("Ingrese numero de opcion: ");
                            opcion=Integer.parseInt(scanner.nextLine());
                            i++;
            
                        }
                    bandera=false;    
                }
                //capturando excepcion de menu
                catch(java.lang.NumberFormatException excepcion1){
                    JOptionPane.showMessageDialog(null, "Ha introducido algo no solicitado\nIntente nuevamente");
            
                }
                j++;
            
            }
            if(opcion==1){ //condicion para la opcion numero 1 del menu
                int k=0;//iterador
                while(bandera==false){    
                    try{ //intentando ejecutar el metodo pedir datos
                        pedirDatos();
                        bandera=true;
                    }
                    //capturando excepcion 
                    catch(java.lang.NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Su edad debe ser ingresada en numeros \nIntente nuevamente");
                    }
                    k++;
                }
        
            }
        
            else{
                System.exit(0); //saliendo del programa
            }
               
        System.out.println("programa terminado correctamente sin errores");
        
    }
    //metodo pedir datos
    public static void pedirDatos() throws java.lang.NumberFormatException{
        String nombre;
        int edad; 
        
            //pidiendo en pantalla los datos
            nombre= JOptionPane.showInputDialog("Introduzca su nombre");
           
            edad= Integer.parseInt(JOptionPane.showInputDialog("Introduzca su edad"));
            
            //imprimiendo datos
            System.out.println("su nombre es: "+nombre);
            System.out.println("Dentro de 12 meses tendra: "+(edad+1));
    
    }
    
}
