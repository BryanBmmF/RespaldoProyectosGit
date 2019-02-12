/*
 * Programa para entender flujos de Datos 
 */
package escrituradatos;
import java.io.*;

/**
 *
 * @author bryan
 */
public class EscrituraDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String dia ="1 de Septiembre de 2018";
        DataOutputStream data = null;
        
        try{
            data = new DataOutputStream(new FileOutputStream("registos.tmp"));
            data.writeUTF(dia);//escribe primer registro
            
            for(int hora=0; hora<24; hora++){
                
                double presion, temperatura;
                presion= presHora();
                temperatura= tempHora();
                
                //Escribe segun la estructura de cada registro
                
                data.writeInt(hora);
                data.writeDouble(presion);
                data.writeDouble(temperatura);
            
            }
        }
        catch(IOException e){
            
            System.out.println("Anomalia en el flujo de salida"+e.getMessage());
            
        }
        
        finally{
            try{
                data.close();//cerrando el flujo
            
            }
            catch(IOException er){
                er.printStackTrace();//desplegando errores
            }
        }
    }
    
    //creacion de metodos auxiliares
    
    static private Double tempHora(){
        final Double TEMINF= 5.0;
        final Double TEMSUP= 40.0;
        
        return(Math.random()*(TEMSUP-TEMINF)+TEMINF);
        //retornando temperatura aleatoria
    }
    static private Double presHora(){
        final Double PREINF= 680.0;
        final Double PRESUP= 790.0;
        
        return(Math.random()*(PRESUP-PREINF)+PREINF);
        
        //retornando PRESION aleatoria
    }
    
}


