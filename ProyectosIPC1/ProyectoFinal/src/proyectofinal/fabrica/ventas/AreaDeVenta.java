/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.fabrica.ventas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.archivo.Escritor;
import proyectofinal.fabrica.archivo.Lector;
import proyectofinal.fabrica.produccion.Mueble;

/**
 *
 * @author bryan
 */
public class AreaDeVenta implements Serializable {
    
    private Mueble muebleEnVenta;
    private double precio;
    private String identificador;
    private double costoFabricacion;
    private Escritor escritor;
    private Lector lector;
    private Archivo archivoPieza;
    
    public static final String RUTA_MUEBLESVENTA= "src/mueblesEnVenta/";
    public static final String EXT_MUEBLESVENTA= ".VEN";
    

    public AreaDeVenta(Mueble muebleEnVenta, double precio,double costoFabricacion, String identificador) {
        this.muebleEnVenta = muebleEnVenta;
        this.precio = precio;
        this.costoFabricacion=costoFabricacion;
        this.identificador = identificador;
        
        this.escritor=new Escritor();
        this.lector=new Lector();
        this.archivoPieza= new Archivo();
    }
    
    public void registrarMuebles(){
        
        generarMuebleEnVenta(RUTA_MUEBLESVENTA, identificador, EXT_MUEBLESVENTA);
        
    
    }
    //metodo generador de archivos de Materia prima 
    public void generarMuebleEnVenta(String ruta,String nombre,String exten){
        //metodo para generar Piezas
        File file = new File(ruta+nombre+exten);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		}
            
    }
    
}
