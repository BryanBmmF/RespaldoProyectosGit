/*
 * Reporte de tarjetas creadas
 */
package practicaformal2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class ListadoTarjeta implements Serializable{
    
    private static List <TarjetaDeCredito> lista2;
    
    public ListadoTarjeta(){
        lista2= new ArrayList<TarjetaDeCredito>();
    }
    
    //metodo generador
public void generar(){
    
    Lector lector= new Lector();
    //encabezado de tabla
    String encabezado="\n"
            + "<html>\n"
            + "<h1>LISTADO DE TARJETAS</h1>\n" +
"	<table style=\"border-collapse: collapse;\">\n" +
"	  <tr>\n" +
"	    <th style=\"border: 1px solid #000000;\">NUMERO TARJETA</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">TIPO</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">ESTADO</th>\n" 
        +"</tr>\n" 
            ;
    //pie de tabla
    String cola="\n"
        +
"	</table>\n"
            + "</html>";
    //escribiendo archivo
    lector.escrituraBasica("listadoTarjetas.html",encabezado+cargar()+cola);
    lector.escrituraLinea("Se Genero un listado de tarjetas");
            
} 
//cargando datos
public String cargar(){
    lista2= cargarTarjetas();// creando lista
    String datos="";
    int k=0;
    int f=1;
    //ciclo recorredor de la lista 
    for(TarjetaDeCredito i:lista2){
         
         String fechaAut=lista2.get(k).getFechaSolicitud();
         String fec= fechaAut.substring(0, 2);
         
         int integ= Integer.parseInt(fec);
         int integ2= integ+10;
         fec=fechaAut.substring(2, 10);
         fechaAut=String.valueOf(integ2)+fec;
        // Carga de cada renglon en la tabla
        datos=datos+"\n"
         +"<tr>\n" 
         + "<td style=\"border: 1px solid #000000;\">"+lista2.get(k).getNumeroDeTarjeta()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista2.get(k).getTipo()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista2.get(k).getLimiteDeCredito()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista2.get(k).getPropietario()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista2.get(k).getDireccionPropietario()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+fechaAut+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista2.get(k).getEstado()+"</td>\n"
         + "</tr>\n";
        
        k++;
    }
    return datos;// retorno de datos
}
//metodo de carga de archivos para Solicitudes 
public static List<TarjetaDeCredito> cargarTarjetas(){
        // verifica el sitio de carga y almacena todos los objetos movimientos pedidos en ararayList
        File folder = new File(".");
		List<TarjetaDeCredito> listaTarjeta = new ArrayList<>();
		if (folder.isDirectory()) {
			String[] archivos = folder.list();// hace una lista de todos los archivos
			for (String nombreArch : archivos) {
				if (nombreArch.endsWith(".card")) {
					File archivoLeer = new File(nombreArch);
					try (FileInputStream fileInputStream = new FileInputStream(archivoLeer);
						   ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
						listaTarjeta.add((TarjetaDeCredito) inputStream.readObject());
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
        return listaTarjeta; // retorno de lista con solicitudes
    }
}
