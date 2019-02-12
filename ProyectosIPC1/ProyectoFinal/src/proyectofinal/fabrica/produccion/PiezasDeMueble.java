/*
 * Clase que controla el tipo y numero de piezas que necesita un determinado mueble
 */
package proyectofinal.fabrica.produccion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.archivo.Escritor;

/**
 *
 * @author bryan
 */
public class PiezasDeMueble implements Serializable{
    
    //Miembros privados
    private Mueble tipoMueble;
    private MateriaPrima pieza;
    private int numeroDePiezas;
    private ArrayList<String> revision;
    private static final String rm="src/muebles/";   //ruta de muebles
    private static final String rp="src/materiaPrima/cont";  //ruta de materiaPrima
    private Escritor escritor;
    
    //constructor de Piezas Muebles recibe parametros tipo Mueble MatPrima y nPiezas
    public PiezasDeMueble(Mueble tipoMueble,MateriaPrima pieza, int numeroDePiezas){
        this.tipoMueble=tipoMueble;
        this.pieza=pieza;
        this.numeroDePiezas=numeroDePiezas;  
        
        this.escritor = new Escritor();
        this.revision= new ArrayList<String>();
    }
    //constructor simple
    public PiezasDeMueble(){
        
    }
    public void mostrarDatos(){
    
        System.out.println("\n"+tipoMueble.getNombreNuevoMueble()+"\n"+pieza.getTipo()+"\n"+numeroDePiezas);
    }
    public void revisarPiezasDeMueble(){
        //se verifica si existe el mueble y las piezas
        //se crea la instancia de archivo Mueble, Pieza y se busca
        Archivo archivoMP= new Archivo();
            
            if (archivoMP.buscarExistente(rm+tipoMueble.getNombreNuevoMueble()+".mbl")&&archivoMP.buscarExistente(rp+pieza.getTipo()+".cont")) {
                //se genera el archivo mueblePieza
                generarMueblePiezas("src/piezasMuebles/","piezas","."+pieza.getTipo()+tipoMueble.getNombreNuevoMueble()+"PM");
                System.out.println("se procesara las piezas para "+tipoMueble.getNombreNuevoMueble());
            } 
            else{
                System.out.println("Piezas de mueble no procesadas porque");
            }
            if(archivoMP.buscarExistente(rm+tipoMueble.getNombreNuevoMueble()+".mbl")==false){
                System.out.println("El mueble "+tipoMueble.getNombreNuevoMueble()+" NO EXISTE");
                
                //se guarda la instruccion
                escritor.escrituraLinea("Piezas de mueble no procesadas porque "+"El mueble "+tipoMueble.getNombreNuevoMueble()+" NO EXISTE");
            }
            else if(archivoMP.buscarExistente(rp+pieza.getTipo()+".cont")==false){
                System.out.println("la pieza "+pieza.getTipo()+" NO EXISTE");
                
                //se guarda la instruccion
                escritor.escrituraLinea("Piezas de mueble no procesadas porque "+"la pieza "+pieza.getTipo()+" NO EXISTE");
            }
    
    }
    //metodo generador de archivo de mueble nuevo
    public void generarMueblePiezas(String ruta,String nombre,String exten){
        //metodo para generar Usuarios
        File file = new File(ruta+nombre+exten);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		}
            //se guarda la instruccion
            escritor.escrituraLinea("se procesara las piezas para "+tipoMueble.getNombreNuevoMueble());
            
        
    }
    
    //metodos accesores

    public Mueble getTipoMueble() {
        return tipoMueble;
    }

    public void setTipoMueble(Mueble tipoMueble) {
        this.tipoMueble = tipoMueble;
    }

    public MateriaPrima getPieza() {
        return pieza;
    }

    public void setPieza(MateriaPrima pieza) {
        this.pieza = pieza;
    }

    public int getNumeroDePiezas() {
        return numeroDePiezas;
    }

    public void setNumeroDePiezas(int numeroDePiezas) {
        this.numeroDePiezas = numeroDePiezas;
    }
    
}
