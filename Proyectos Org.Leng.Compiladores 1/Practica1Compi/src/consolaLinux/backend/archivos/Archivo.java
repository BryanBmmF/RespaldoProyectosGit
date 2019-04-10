/*
 * Clase Archivo
 */
package consolaLinux.backend.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Archivo {
        //Propiedades de los Archivos
        public static final String ARCHIVO = "ARCHIVO";
	public static final String DIRECTORIO = "DIRECTORIO";
        private static final String ESCRITURA = "w";
	private static final String LECTURA = "r";
	private static final String EJECUCION = "x";
	private static final String ES_DIRECTORIO = "d";
	private static final String PERMISO_DESACTIVADO = "-";
	private static final char AGREGAR_PERMISOS = '+';
	private static final char REMOVER_PERMISOS = '-';
	
        //Atributos y Acciones de un archivo
	private String nombre;
	private int pesoKB;
	private boolean directorio;
	private boolean escribir;
	private boolean leer;
	private boolean ejecutar;
	private LocalDate colocarFecha;

	public Archivo(String nombre, int pesoKb, boolean directorio) {
		this.nombre = nombre;
		this.pesoKB = pesoKb;
		this.directorio = directorio;
		colocarFecha = LocalDate.now(); //la fecha actual
	}

        public Archivo() {//solo para leer y escribir archivos de texto
        }
        
        //obtener modelo lista para ls -l
	public String obtenerModeloLista() {
                String modeloLista= "";
                modeloLista +=getDirectorio()+getEscribir()+getLeer()+getEjecutar()+"\t";
                modeloLista +=this.pesoKB+" Kb\t";
                modeloLista +=colocarFecha.getDayOfMonth()+"\t";
                modeloLista +=colocarFecha.getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault())+"\t";
                modeloLista +=colocarFecha.getYear()+"\t";
                modeloLista += this.nombre;
                
                return modeloLista;
	}
	
	public String obtenerInfoNormal() {
		return this.nombre + "\t"; //nombre mas tab
	}
	
	private String getEscribir() {
		return obtenerPermisosDeTexto(escribir, ESCRITURA);
	}
	
	private String getLeer() {
		return obtenerPermisosDeTexto(leer, LECTURA);
	}
	
	private String getEjecutar() {
		return obtenerPermisosDeTexto(ejecutar, EJECUCION);
	}
	
	private String getDirectorio() {
		return obtenerPermisosDeTexto(esDirectorio(), ES_DIRECTORIO);
	}
	
        //se obtiene cada permiso activo si lo tiene, en caso contrario se devuelve permisos desactivado
	private String obtenerPermisosDeTexto(boolean permisoActivo, String permiso) {
                if (permisoActivo) {
                        return permiso;
                } else {
                        return PERMISO_DESACTIVADO;
                }
	}
	
        //se evalua si se agregan o quitan los permisos
	public void establecerPermisos(String opcionesDePermisos) {
		char modificar = opcionesDePermisos.charAt(0);
		switch (modificar) {
			case AGREGAR_PERMISOS:
				this.agregarPermisos(opcionesDePermisos);
				break;
			case REMOVER_PERMISOS:
				this.eliminarPermisos(opcionesDePermisos);
				break;
			default:
				throw new AssertionError();
		}
	}
	
        //se establecen permisos
	private void agregarPermisos(String opcionesDepermisos) {
		setEscribir(opcionesDepermisos.contains(ESCRITURA));
		setLeer(opcionesDepermisos.contains(LECTURA));
		setEjecutar(opcionesDepermisos.contains(EJECUCION));
	}
	
        //se establece lo negado si los tiene
	private void eliminarPermisos(String opcionesDepermisos) {
		setEscribir(!opcionesDepermisos.contains(ESCRITURA));
		setLeer(!opcionesDepermisos.contains(LECTURA));
		setEjecutar(!opcionesDepermisos.contains(EJECUCION));
	}
        
        public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPesoKB() {
		return pesoKB;
	}

	public boolean esDirectorio() {
		return directorio;
	}

	public boolean permitirEscribir() {
		return escribir;
	}

	public void setEscribir(boolean escribir) {
		this.escribir = escribir;
	}

	public boolean permitirLeer() {
		return leer;
	}

	public void setLeer(boolean leer) {
		this.leer = leer;
	}

	public boolean permitirEjecutar() {
		return ejecutar;
	}

	public void setEjecutar(boolean ejecutar) {
		this.ejecutar = ejecutar;
	}
	
	public boolean estaOculto() {
		return this.nombre.startsWith(".");
	}
        
        //sobrecarga de toString para establecer parametro inicial del nombre para saber si es directorio o no
	@Override
	public String toString() {
		String parametroInicial;
		if (esDirectorio()) {
			parametroInicial = "D- ";
		} else {
			parametroInicial = "";
		}
		return parametroInicial + this.nombre;
	}
        
        //metodo para leer archivos , devuelve listado con cada linea del archivo
        public static List<String> leerArchivo(String path){
                List<String> textos = new ArrayList<>();
                try{
                        File archivo = new File(path);
                        Scanner lectura = new Scanner(archivo);
                        while (lectura.hasNext()) {
                                textos.add(lectura.nextLine());
                        }
                }catch(FileNotFoundException ex){
                        System.out.println("No se encontró el archivo");
                }
                return textos;
        }
        //metodo para escribir en un archivo
        public void escrituraBasica(String path,String parametro) {
                FileWriter escritor = null;
                try {
                        //para escribir texto se usa un objeto especial que envia los caracteres al flujo
                        escritor = new FileWriter(new File(path));
                        escritor.append(parametro);
                }catch (IOException e) {
                        System.out.println("============== error escribiendo en archivo");
                }finally {
                        try {
                                escritor.close();
                        }catch (IOException ex) {
                                System.out.println("========no se pudo cerrar archivo");
                        }
                }
        }
    
}
