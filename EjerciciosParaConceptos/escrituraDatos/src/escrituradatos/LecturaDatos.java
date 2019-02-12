/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituradatos;
import java.io.*;
/**
 *
 * @author bryan
 */
public class LecturaDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dia;
        double mxt= -11.0; //valor minimo para encontrar maximo
        FileInputStream file;
        DataInputStream data= null;
        
        try{
            file = new FileInputStream("registos.tmp");
            data= new DataInputStream(file);
        }
        catch(IOException e){
            
            System.out.println("Anomalia al crear flujo de entrada, "+e.getMessage());
            return; //termina la ejecucion
        }
        //proceso del flujo
        try{
            int hora;
            boolean mas= true;
            double pres , temp;
            dia= data.readUTF();
            System.out.println(dia);
            
                while(mas){
                    hora= data.readInt();
                    pres= data.readDouble();
                    temp = data.readDouble();
                    
                    System.out.println("Hora: "+hora+"  Presion: "+pres+
                            "\tTemperatura: "+temp);
                    
                    mxt= Math.max(mxt, temp);//comparando temperatura maxima
                    
                }
        }
        catch(EOFException eof){
            System.out.println("Fin de lectura de archivo.\n");
        }
        catch(IOException io){
            System.out.println("Anomalia al leer flujo de entrada, "+io.getMessage());
            
            return; //termina la ejecucion
        }
        finally{
            try{
                data.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        
        }
        //termina el proceso, escribe la temperatura maxima
        
        System.out.println("\n La Temperatura Maxima: "+(float)mxt);
    }
    
}
