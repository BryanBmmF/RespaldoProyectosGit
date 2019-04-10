/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emulacionarbol;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author bryan
 */
public class ControladorArbol {
    
        public static final String SLASH = "/";
	public static final String ROOT = "/";
	public static final String PATH_PADRE = "..";
        public static final String PATH_ACTUAL = ".";

	DefaultMutableTreeNode nodoRaiz;
	DefaultTreeModel model;
	String ubicacionActual;
	JTree arbol;
        
        public ControladorArbol(JTree arbol) {
		this.arbol = arbol;
		this.nodoRaiz = this.crearNodoCarpeta(ROOT);
		this.model = new DefaultTreeModel(nodoRaiz);
		this.arbol.setModel(this.model);
		this.arbol.setExpandsSelectedPaths(true);
		reestablecerPath();
	}
        
        public final void reestablecerPath() {
		this.seleccionarUnNodo(this.nodoRaiz, ROOT);
	}
        public void seleccionarUnNodo(DefaultMutableTreeNode nodo, String path) {
		this.seleccionarNodoEnArbol(nodo);
		this.cambiarUbicacionActual(path);
	}
        public void cambiarUbicacionActual(String path) {
		if (PATH_PADRE.equals(path)) {//path ..
			this.cambiarUbicacionActualDelPadre();
		} else if (path.startsWith(ROOT)) {//absolute path
			this.ubicacionActual = path;
		} else if (ROOT.equals(this.ubicacionActual)) {
			//any other path with root as current path
			this.ubicacionActual = this.ubicacionActual + path;
		} else {
			//any other path with no root as current path
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
        public void seleccionarNodoEnArbol(DefaultMutableTreeNode node) {
		this.arbol.getSelectionModel().setSelectionPath(new TreePath(node.getPath()));
	}
	public ControladorArbol(String currentLocation) {
		this.ubicacionActual = currentLocation;
	}

	public String getUbicacionActual() {
		return ubicacionActual;
	}
        //CREACIONES DE NODOS CARPETAS Y NODOS ARCHIVOS
        public DefaultMutableTreeNode crearNodoCarpeta(String name) {
		return new DefaultMutableTreeNode(this.crearObjetoCarpeta(name));
	}
        public Archivo crearObjetoCarpeta(String name) {
		return new Archivo(name, 0, true);
	}
        public DefaultMutableTreeNode crearNodoArchivo(String name) {
		return new DefaultMutableTreeNode(this.crearObjetoArchivo(name));
	}
        public Archivo crearObjetoArchivo(String name) {
		int size = ThreadLocalRandom.current().nextInt(0, 1000);
		return new Archivo(name, size, false);
	}
    
}
