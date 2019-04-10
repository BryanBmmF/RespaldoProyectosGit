/*
 * Clase Controlador  del Arbol JTree
 */
package consolaLinux.backend.controladores;

import consolaLinux.backend.archivos.Archivo;
import static consolaLinux.backend.archivos.Archivo.ARCHIVO;
import static consolaLinux.backend.archivos.Archivo.DIRECTORIO;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author bryan
 */
public class ControladorArbol {
        //constantes necesarias
        public static final String SLASH = "/";
	public static final String ROOT = "/";
	public static final String PATH_PADRE = "..";
        public static final String PATH_ACTUAL = ".";
        
        //Miembros y modelos del Arbol
	private DefaultMutableTreeNode nodoRaiz;
	private DefaultTreeModel model;
	private String ubicacionActual;
	private JTree arbol;
        
        //**Constructores**// 
	public ControladorArbol(JTree arbol) {
		this.arbol = arbol;
		this.nodoRaiz = this.crearNodoCarpeta(ROOT);
		this.model = new DefaultTreeModel(nodoRaiz);
		this.arbol.setModel(this.model);
		this.arbol.setExpandsSelectedPaths(true);
		reestablecerPath();
	}
        
	public ControladorArbol(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}
        
        /**
         * Metodo que devuelve la ubicacion actual del arbol
         **/
	public String getUbicacionActual() {
		return ubicacionActual;
	}
        
        /**
         * Metodo para reestablecer el path de un nodo seleccionado
         **/
        public final void reestablecerPath() {
		this.seleccionarUnNodo(this.nodoRaiz, ROOT);
	}
        
        /**
         * Metodo para recargar el Arbol despues de cada ejecucion de Comandos
         **/
        public void recargarArbol(){
                DefaultMutableTreeNode seleccionado = this.obtenerNodoActualSeleccionado();
		this.model.reload();
		this.seleccionarNodoEnArbol(seleccionado);
		this.desplegarContenidoNodoEnArbol(seleccionado);
        }
        
        /**
         * Metodo para seleccionar un Nuevo Nodo y moverse hacia el (cambiar ubicacion actual)
         **/
        public void seleccionarUnNodo(DefaultMutableTreeNode nodo, String path) {
		this.seleccionarNodoEnArbol(nodo);
		this.cambiarUbicacionActual(path);
	}
        
        /**
         * Metodo para seleccionar un Nuevo Nodo y no cambiar ubicacion
         **/
        public void seleccionarUnNodoSinCambiarUbicacion(DefaultMutableTreeNode nodo) {
		this.seleccionarNodoEnArbol(nodo);
                
	}
        
        /**
         * Metodo para seleccionar un nodo en el arbol
         **/
        public void seleccionarNodoEnArbol(DefaultMutableTreeNode nodo) {
		this.arbol.getSelectionModel().setSelectionPath(new TreePath(nodo.getPath()));
	}
        
        /**
         * Metodo para expandir un nodo en el arbol
         **/
        public void desplegarContenidoNodoEnArbol(DefaultMutableTreeNode nodo) {
		this.arbol.expandPath(new TreePath(nodo.getPath()));
	}
        
        /**
         * Se compara si el path es Padre (..)
         * Se compara si es un path Absoluto
         * Se compara si es cualquier otra ruta con la raíz como ruta actual
         * O en caso es cualquier otra ruta sin raíz como ruta actual
         **/
        public void cambiarUbicacionActual(String path) {
		if (PATH_PADRE.equals(path)) {
			this.cambiarUbicacionActualDelPadre();
		} else if (path.startsWith(ROOT)) {
                                this.ubicacionActual = path;
                        } else if (ROOT.equals(this.ubicacionActual)) {
                                        this.ubicacionActual = this.ubicacionActual + path;
                                } else {
                                            this.ubicacionActual = this.ubicacionActual + SLASH + path;
                                    }
	}
        
        /**
         * Se separa la ubicacion actual en una lista de paths segun las diagonales que contengan
         * Si el arreglo consta de un solo elemento esto quiere decir que que la ubicacion actual es la raiz
         * Si la lista es de mas de un elemento , listaPaths se copia a listaPathsNuevos y se define
           la longitud de listaPathsNuevos.
         * Luego se define la nueva ubicacionActual creando un nuevo path con listaPathsNuevos
         **/
        public void cambiarUbicacionActualDelPadre() {
		String[] listaPaths1 = this.ubicacionActual.split(SLASH);
		if (listaPaths1.length == 1) {
			this.ubicacionActual = ROOT;
		} else if (listaPaths1.length > 1) {
			String[] listaPathsNuevos = Arrays.copyOf(listaPaths1, listaPaths1.length - 1);
			this.ubicacionActual = String.join(SLASH, listaPathsNuevos);
		}
	}
        
        /**
         * Se obtiene el nodo Hijo seleccionado
         * Se obtiene el nodo Padre del nodo Hijo Seleccionado
         * Si el nodo Padre no existe se retorna el mismo nodo Hijo
         * Si el nodo Padre si existe se retorna este mismo
         **/
        public DefaultMutableTreeNode obtenerNodoPadreSeleccionado() {
		DefaultMutableTreeNode nodoHijo = obtenerNodoActualSeleccionado();
		DefaultMutableTreeNode nodoPadre = (DefaultMutableTreeNode) nodoHijo.getParent();
		if (nodoPadre == null) {
			return nodoHijo;
		}
		return nodoPadre;
	}
        
        /**
         * Se obtiene el nombre del nuevo nodo en la ultima parte de la lista Paths
         * Se crea un nuevo nodo 
         * Se obtiene el ultimo nodo padre (Directorio) en donde se creara el nuevo Nodo
         * Se compara si el nuevo nodo sera Archivo o Directorio
         * Se agrega el nodo al ultimo nodo padre (Directorio)
         * Por ultimo se envia
         **/
        public DefaultMutableTreeNode crearNuevoNodoTipo(String tipo, DefaultMutableTreeNode nodoBase,
		String[] paths, JTextArea consolaTextArea) throws Exception {
                String nombreNodo = paths[paths.length - 1];
                DefaultMutableTreeNode nuevoNodo = null;
                DefaultMutableTreeNode ultimoNodoPadre = this.obtenerUltimoNodoPadre(nodoBase, paths);
                //compara si es directorio o archivo
                switch (tipo) {
                        case DIRECTORIO:{
                                if (!buscarNodoEnDirectorioPadre(ultimoNodoPadre, nombreNodo)) {
                                        nuevoNodo = this.crearNodoCarpeta(nombreNodo);
                                        ultimoNodoPadre.add(nuevoNodo);   
                                } else {
                                        consolaTextArea.append("\n" + "El directorio ya existe..");
                                }
                                break;
                        }
                        case ARCHIVO:{
                                if (!buscarNodoEnDirectorioPadre(ultimoNodoPadre, nombreNodo)) {
                                        nuevoNodo = this.crearNodoArchivo(nombreNodo);
                                        ultimoNodoPadre.add(nuevoNodo);   
                                } else {
                                        consolaTextArea.append("\n" + "El archivo ya existe..");
                                }
                                
                                break;
                        }
                        default:
                                throw new AssertionError();
                }
		              
                return nuevoNodo;	
		
	}
        
        /**
         * Metodo para crear un nodo carpeta
         **/
        public DefaultMutableTreeNode crearNodoCarpeta(String nombre) {
		return new DefaultMutableTreeNode(this.crearArchivoDirectorio(nombre));
	}
        
         /**
         * Metodo para crear un nodo Archivo 
         **/
        public DefaultMutableTreeNode crearNodoArchivo(String nombre) {
		return new DefaultMutableTreeNode(this.crearSoloArchivo(nombre));
	}
        /**
         * Metodo para crear un Archivo tipo directorio
         **/
        public Archivo crearArchivoDirectorio(String name) {
		return new Archivo(name, 0, true);
	}
        
        /**
         * Metodo para crear solo Archivo
         **/
        public Archivo crearSoloArchivo(String name) {
		int size = ThreadLocalRandom.current().nextInt(0, 2000);
		return new Archivo(name, size, false);
	}
        
        /**
         * Se copia de listaPaths a nuevaListaBasePaths hasta antes del ultimo 
           ya que ese ultimo es el Nuevo directorio(ultimo Nodo Padre).
         * Luego se retorna al Padre del nuevo Nodo que resulta de navegar hasta el nodo base
         **/
        public DefaultMutableTreeNode obtenerUltimoNodoPadre(DefaultMutableTreeNode nodoBase,
		String[] listaPaths) throws Exception {
		String[] nuevaListaBasePaths = Arrays.copyOf(listaPaths, listaPaths.length - 1);
		//navegar al Padre del nuevo Nodo
		return this.navegarHaciaUnNodoEspecifico(nodoBase, nuevaListaBasePaths);
	}
        
        /**
         * Se crea un SiguienteNodoBase
         * Para cada path, se busca en la ubicacion actual el nodoBaseSiguiente
         * Se ignora la ruta vacía cuando es una ruta absoluta
         * Se crea un Nuevo Archivo para albergar el siguienteNodoBase usando casteo
         * Se verifica si es un directorio
         **/
        public DefaultMutableTreeNode navegarHaciaUnNodoEspecifico(DefaultMutableTreeNode nodoBase,
		String[] paths) throws Exception {
		DefaultMutableTreeNode siguienteNodoBase = nodoBase;
		for (String path : paths) {
			if (path.length() > 0) {
				siguienteNodoBase = this.buscarNodo(siguienteNodoBase, path);
			}
		}
		Archivo nuevoDirectorioBase = (Archivo) siguienteNodoBase.getUserObject();
		if (!nuevoDirectorioBase.esDirectorio()) {
                    //en caso de no ser un directorio
			throw new Exception("El path: " + String.join(SLASH, paths)
				   + " no es un directorio.");
		}
		return siguienteNodoBase;
	}
        
        /**
         * Se crea un nuevo Archivo Base casteando el Nodo Base
         * Se Realiza una enumeracion de los hijos con todos los nodos del Nodo Base
         * Se compara el nombre de cada hijo encontrado con el nombre del nodo a buscar
           y se devuelve.
         * Si el nombre no Concuerda con ninguno de los hijos se lanza un error
         **/
        public DefaultMutableTreeNode buscarNodo(DefaultMutableTreeNode nodoBase, String nombre)
		throws Exception {
		Archivo archivoBase = (Archivo) nodoBase.getUserObject();
		Enumeration<DefaultMutableTreeNode> listaHijosNodoBase = nodoBase.children();
		//Recorrido de los hijos de nodoBase
		while (listaHijosNodoBase.hasMoreElements()) {
			DefaultMutableTreeNode hijo = listaHijosNodoBase.nextElement();
			Archivo nodo = (Archivo) hijo.getUserObject();
			if (nodo.getNombre().equals(nombre)) {
				return hijo;
			}
		}
		//en caso de no encontrar el nodo
		throw new Exception("No se encuentra el archivo o directorio: " + nombre + " en "
			   + archivoBase.getNombre());
	}
        
        /**
         * Se crea un nuevo Archivo Base casteando el Nodo Base
         * Se Realiza una enumeracion de los hijos con todos los nodos del Nodo Base
         * Se compara el nombre de cada hijo encontrado con el nombre del nodo a buscar
           y se devuelve verdadero si se encuentra, en caso contario falso.
         **/
        public boolean buscarNodoEnDirectorioPadre(DefaultMutableTreeNode nodoBase, String nombre){
		Archivo archivoBase = (Archivo) nodoBase.getUserObject();
		Enumeration<DefaultMutableTreeNode> listaHijosNodoBase = nodoBase.children();
		//Recorrido de los hijos de nodoBase
		while (listaHijosNodoBase.hasMoreElements()) {
			DefaultMutableTreeNode hijo = listaHijosNodoBase.nextElement();
			Archivo nodo = (Archivo) hijo.getUserObject();
			if (nodo.getNombre().equals(nombre)) {
				return true;
			}
		}
		//en caso de no encontrar el nodo
		return false;
	}
        
        /**
         * Se busca el ultimo nodo Correspondiente al nodoBase 
           y se devuelve en forma de un objeto Archivo
         **/
        public Archivo buscarUltimoArchivo(DefaultMutableTreeNode nodoBase, String[] paths) throws Exception {
		DefaultMutableTreeNode ultimoNodo = buscarUltimoNodo(nodoBase, paths);
		return (Archivo) ultimoNodo.getUserObject();
	}
        
        /**
         * Se busca el ultimo nodo Padre correspondiente al nodo Base en la ubicacion que indican los paths 
           y se devuelve el nodo
         **/
	public DefaultMutableTreeNode buscarUltimoNodo(DefaultMutableTreeNode nodoBase, String[] paths) throws Exception {
		DefaultMutableTreeNode ultimoNodoPadre = this.obtenerUltimoNodoPadre(nodoBase, paths);
		return this.buscarNodo(ultimoNodoPadre, paths[paths.length - 1]);
	}
        
        
        /**
         * Se verifica que el path recibido sea ABSOLUTO comparando que al inicio contenga una diagonal
           esto quiere decir que el nodo raiz es el padre.
         * De lo contrario el path recibido es RELATIVO y se coloca al nodo seleccionado como padre
         
         **/
        public DefaultMutableTreeNode obtenerNodoBaseDeRuta(String path) {
		DefaultMutableTreeNode nodoBase;
		if (path.startsWith(SLASH)) {
			nodoBase = this.getNodoRaiz();
		} else {
			nodoBase = this.obtenerNodoActualSeleccionado();
		}
		return nodoBase;
	}
        
        /**
         * Se devuelve el nodo seleccionado del arbol
         **/
        public DefaultMutableTreeNode obtenerNodoActualSeleccionado() {
		return (DefaultMutableTreeNode) this.arbol.getLastSelectedPathComponent();
	}
        
        /**
         * Metodos Getter y Setter de:
         - Nodo raiz
         - Modelo
         - Arbol
         **/
        public DefaultMutableTreeNode getNodoRaiz() {
            return nodoRaiz;
        }

        public void setNodoRaiz(DefaultMutableTreeNode nodoRaiz) {
            this.nodoRaiz = nodoRaiz;
        }

        public DefaultTreeModel getModel() {
            return model;
        }

        public void setModel(DefaultTreeModel model) {
            this.model = model;
        }

        public JTree getArbol() {
            return arbol;
        }

        public void setArbol(JTree arbol) {
            this.arbol = arbol;
        }
        
    
}
