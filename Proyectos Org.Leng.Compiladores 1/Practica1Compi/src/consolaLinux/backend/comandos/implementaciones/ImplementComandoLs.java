/*
 * Implementacion de comando ls
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.archivos.Archivo;
import consolaLinux.backend.comandos.ComandoLs;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoLs;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoLs implements InterfaceComandoLs{
        
        /**
         * Se crea un nuevo Nodo Base.
         * Se compara si el path donde se aplicara el comando ls es el actual para asi obtener unicamente el 
           nodo actual seleccionado, y listar su contenido.
         * De lo contrario se obtiene el nodo base del path y se navega hacia el nodoBase  para listar
           su contenido
         * Por ultimo se listan los Archivos del nodoBase seleccionado en la consola y se recarga el arbol
         **/
        @Override
        public void ejecutarComando(ComandoLs comandoLs, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
                if (comandoLs != null) { 
                        System.out.printf("ejecutando comando: %s, con opcion: %s, en la ubicacion de: %s\n", 
                                comandoLs.getToken(), comandoLs.getOpciones(), comandoLs.getPath());
                try {
                        DefaultMutableTreeNode nodoBase;
                        if (comandoLs.getPath() == null || comandoLs.getPath().length() == 0) {
                                nodoBase = controladorArbol.obtenerNodoActualSeleccionado();
                        } else {
                                DefaultMutableTreeNode nodoBaseDeRuta = controladorArbol.obtenerNodoBaseDeRuta(comandoLs.getPath());
                                nodoBase = controladorArbol.navegarHaciaUnNodoEspecifico(nodoBaseDeRuta, comandoLs.getPath().split(SLASH));
                        }
                        this.listarArchivos(comandoLs, nodoBase, consolaTextArea);
                        controladorArbol.desplegarContenidoNodoEnArbol(nodoBase);
                } catch(Exception ex) {
                            consolaTextArea.append("\n" + ex.getMessage());
		}
                
                controladorArbol.recargarArbol();
                }
                
        }
        
        /**
         * Devuelve verdadero si las opciones de comandoLs no es nulo y contiene la letra de OPCION_LISTA_DETALLADA (l)
           en caso contario devuelve falso
         **/
        @Override
        public boolean mostrarListaDeArchivos(ComandoLs comandols) {
                if (comandols.getOpciones()!=null && comandols.getOpciones().contains(OPCION_LISTA_DETALLADA)) {
                        return true;
                }
                return false;
        }
        
        /**
         * Devuelve verdadero si las opciones de comandoLs no es nulo y contiene la letra de OPCION_LISTA_Y_OCULTOS (a)
           en caso contario devuelve falso
         **/
        @Override
        public boolean mostrarListaDetalladaDeArchivos(ComandoLs comandols) {
                if (comandols.getOpciones()!=null && comandols.getOpciones().contains(OPCION_LISTA_Y_OCULTOS)) {
                        return true;
                }
                return false;
        }
        
         /**
         * Si el metodo mostrarListaArchivos devuelve verdadero se despliegan
           los archivos en lista, esto segun lo demande las opciones del comando ls
         * De ser lo contario se despliegan los archivos en formato habitual
         **/
        @Override
        public void desplegarArchivos(ComandoLs comandols, List<Archivo> listaArchivos, JTextArea consolaTextArea) {
                if (mostrarListaDeArchivos(comandols)) {
			desplegarArchivosEnLista(listaArchivos, consolaTextArea);
		} else {
			desplegarArchivosFormaHabitual(listaArchivos, consolaTextArea);
		}
        }
        
        /**
         * Este metodo despliega en el area de texto de la consola los archivos
           que le mandan en forma de lista.
         **/
        @Override
        public void desplegarArchivosEnLista(List<Archivo> listaArchivos, JTextArea consolaTextArea) {
                for (Archivo archivo : listaArchivos) {
			consolaTextArea.append("\n" + archivo.obtenerModeloLista());
		}
        }
        
        /**
         * Este metodo despliega en el area de texto de la consola los archivos
           que le mandan en formato habitual.
         **/
        @Override
        public void desplegarArchivosFormaHabitual(List<Archivo> listaArchivos, JTextArea consolaTextArea) {
                consolaTextArea.append("\n");
		for (Archivo archivo : listaArchivos) {
			consolaTextArea.append(archivo.obtenerInfoNormal());
		}
        }
        
        /**
         * Se Realiza una enumeracion de los hijos del nodo Padre y se guarda en listaHijos
         * Se declara tambien una lista de Archivos
         * Se recorre la lista de Hijos y cada uno de estos se vuelve un Archivo (Casteo).
         * Por ultimo se verifica si esta activa la opcion lista detallada (a) en las opciones
           del comando ls y se comprueba si el archivo es o no un archivo oculto, para agregarlo
           a la lista y luego retornarla.
         **/
        @Override
        public List<Archivo> obtenerArchivos(ComandoLs comandols, DefaultMutableTreeNode nodoPadre) {
                Enumeration<DefaultMutableTreeNode> listaHijos = nodoPadre.children();
		List<Archivo> listaArchivos = new ArrayList<>();
		while (listaHijos.hasMoreElements()) {
			DefaultMutableTreeNode child = listaHijos.nextElement();
			Archivo archivo = (Archivo) child.getUserObject();
			if (mostrarListaDetalladaDeArchivos(comandols) && archivo.estaOculto() || !archivo.estaOculto()) {
				listaArchivos.add(archivo);
			}
		}
		return listaArchivos;
        }
        
        /**
         * Se genera una lista de Archivos que resulta de llamar al metodo obtenerArchivos()
         * Se despliegan los archivos segun las opciones del comando ls en el metodo desplegarArchivos()
         **/
        @Override
        public void listarArchivos(ComandoLs comandols, DefaultMutableTreeNode nodoBase, JTextArea consolaTextArea) {
                List<Archivo> listaArchivos = obtenerArchivos(comandols, nodoBase);
		desplegarArchivos(comandols, listaArchivos, consolaTextArea);
        }



}
