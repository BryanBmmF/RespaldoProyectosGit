/*
 * Clase que permite realizar movimientos con la Tarjeta de Credito
 */
package practicaformal2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static practicaformal2.Interfaz.AreaTexto;

/**
 *
 * @author bryan
 */
public class Movimiento implements Serializable {
    
    private String tipoDeMovimiento,descripcion,establecimiento,fechaMov;
    private String tarjetaEnUso;
    private double monto;
    private static int contadorMov=1;
    private static int contadorMovR=1;
    private static int contadorMovI=1;
    
    private static List<TarjetaDeCredito>lista;
    
    public Movimiento(String tarjetaEnUso, String fechaMov,String tipoDeMovimiento
        , String descripcion, String establecimiento, double monto){
        
        this.tarjetaEnUso= tarjetaEnUso;
        this.fechaMov= fechaMov;
        this.tipoDeMovimiento=tipoDeMovimiento;
        this.descripcion=descripcion;
        this.establecimiento= establecimiento;
        this.monto=monto;
        
         lista = new ArrayList<TarjetaDeCredito>();
        
    }
    public void mostrarPar(){
        System.out.println("\nTarjeta: "+tarjetaEnUso);
        System.out.println("fecha: "+fechaMov);
        System.out.println("Tipo: "+tipoDeMovimiento);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Establecimiento: "+establecimiento);
        System.out.println("Monto: "+monto);
    }
    public void generarMovimiento(String contador){
        //metodo para generar Nueva Tarjeta sin error alguno
        File file = new File("movimiento"+contador+".bin");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			//e.printStackTrace();
		}
    }
    public static List<TarjetaDeCredito> cargarTarjetas(){
        // verifica el sitio de carga y almacena todos los objetos movimientos pedidos en ararayList
        File folder = new File(".");
		List<TarjetaDeCredito> listaDeTarjetas = new ArrayList<>();
		if (folder.isDirectory()) {
			String[] archivos = folder.list();// hace una lista de todos los archivos
			for (String nombreArch : archivos) {
				if (nombreArch.endsWith(".card")) {
					File archivoLeer = new File(nombreArch);
					try (FileInputStream fileInputStream = new FileInputStream(archivoLeer);
						   ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
						listaDeTarjetas.add((TarjetaDeCredito) inputStream.readObject());
					} catch (IOException e) {
						System.out.println("error de conexion con el archivo");
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						System.out.println("El objeto no tiene la forma");
						e.printStackTrace();
					}
				}
			}
		}
        return listaDeTarjetas;
    }
    public boolean buscarNumeroDeTarjeta(){
        lista= cargarTarjetas();
        boolean encontrada= false;
        int i=0;
        
        while(encontrada==false && i<lista.size()){
            //en caso de encontrar la tarjeta
            if(lista.get(i).getNumeroDeTarjeta().equals(tarjetaEnUso)){
                encontrada= true;
            
            }else{ i++;}               
        }      
        return encontrada;// retorna el valor true o false
    
    }
    public void operarMovimiento(){
       // busca la tarjeta para hacer el movimiento
        if(buscarNumeroDeTarjeta()){
            System.out.println("\n Se podra realizar el mov poruqe la tarjeta existe");
            mostrarPar();
            //verificando si existe el archivo contador
            String contadorEnviar;
            Lector lector= new Lector();
            if(lector.buscarArchivo2("contadorMov.bin")){
                contadorEnviar=lector.lecturaBasicaDeArchivo("contadorMov.bin");
                
            }
            else{
                lector.escrituraBasica("contadorMov.bin", String.valueOf(contadorMov));
                contadorEnviar=lector.lecturaBasicaDeArchivo("contadorMov.bin");
                
            }
            //generar movimiento y almacenamiento
            generarMovimiento(contadorEnviar);

             lector.escrituraLinea("Se Realizo Movimiento tipo "+tipoDeMovimiento+" en Tarjeta: "+tarjetaEnUso);
            
            int contadorMovi= Integer.parseInt(contadorEnviar);
            contadorMovi++;
            //se guarda contador
            Lector guarda= new Lector();
            guarda.escrituraBasica("contadorMov.bin", String.valueOf(contadorMovi));
                        
        }
        else{
        System.out.println("no se podra hacer el movi porque la tarjeta no existe!!!!");
                       
        }
        
        
            
    }
}
