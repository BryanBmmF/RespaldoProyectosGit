/*
 * Reporte de solicitudes hechas
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
public class ListadoSolicitud implements Serializable{
    
    private static List<Solicitud>lista;
    
public ListadoSolicitud(){
    lista = new ArrayList<Solicitud>();
}
//metodo generador
public void generar(){
    
    Lector lector= new Lector();
    //encabezado de tabla
    String encabezado="\n"
            + "<html>\n"
            + "<h1>LISTADO DE SOLICITUDES</h1>\n" +
"	<table style=\"border-collapse: collapse;\">\n" +
"	  <tr>\n" +
"	    <th style=\"border: 1px solid #000000;\">NUMERO SOLICITUD</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">TIPO</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n" +
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
    lector.escrituraBasica("listadoSolicitudes.html",encabezado+cargar()+cola);
    lector.escrituraLinea("Se Genero un listado de Solicitudes");
            
} 
//cargando datos
public String cargar(){
    lista= cargarSolicitudes();// creando lista
    String datos="";
    int k=0;
    int f=1;
    //ciclo recorredor de la lista
    for(Solicitud i:lista){
         String tipo= validaTipo(lista.get(k).getTipo());
         String fechaAut=lista.get(k).getFecha();
         String fec= fechaAut.substring(0, 2);
         
         int integ= Integer.parseInt(fec);
         int integ2= integ+10;
         fec=fechaAut.substring(2, 10);
         fechaAut=String.valueOf(integ2)+fec;
        // Carga de cada renglon en la tabla
        datos=datos+"\n"
         +"<tr>\n" 
         + "<td style=\"border: 1px solid #000000;\">"+lista.get(k).getNumeroDeSolicitud()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista.get(k).getFecha()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+tipo+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista.get(k).getNombreSolicitante()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista.get(k).getSalarioSolicitante()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+lista.get(k).getDireccionSolicitante()+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+fechaAut+"</td>\n"
         + "<td style=\"border: 1px solid #000000;\">"+"Activa"+"</td>\n"
         + "</tr>\n";
        
        k++;
    }
    return datos;// retorno de datos
}
//metodo de carga de archivos para Solicitudes 
public static List<Solicitud> cargarSolicitudes(){
        // verifica el sitio de carga y almacena todos los objetos movimientos pedidos en ararayList
        File folder = new File(".");
		List<Solicitud> listaDeSolicitud = new ArrayList<>();
		if (folder.isDirectory()) {
			String[] archivos = folder.list();// hace una lista de todos los archivos
			for (String nombreArch : archivos) {
				if (nombreArch.endsWith(".sol")) {
					File archivoLeer = new File(nombreArch);
					try (FileInputStream fileInputStream = new FileInputStream(archivoLeer);
						   ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
						listaDeSolicitud.add((Solicitud) inputStream.readObject());
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
        return listaDeSolicitud; // retorno de lista con solicitudes
    }
//validacion de tipo de solicitud
public String validaTipo(int num){
        String regresa="";
            switch(num){
                case 1:{
                    regresa= "NACIONAL";
                    break;
                }
                case 2:{
                    regresa="REGIONAL";
                    break;
                }
                default:{
                    regresa="INTERNACIONAL";
                    break;
                }
            }
        return regresa;
    }
}

