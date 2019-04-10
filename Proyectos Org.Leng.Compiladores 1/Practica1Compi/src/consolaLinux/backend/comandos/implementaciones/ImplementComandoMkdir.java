/*
 * Implementacion del Comando mkdir para crear directorios
 */
package consolaLinux.backend.comandos.implementaciones;

import static consolaLinux.backend.archivos.Archivo.DIRECTORIO;
import consolaLinux.backend.comandos.ComandoMkdir;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoMkdir;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoMkdir implements InterfaceComandoMkdir{
        /**
         * Se evalua que el comando no sea nulo
         * Se obtiene el nodo base de la ruta especificada
         * Se crea el nuevo directorio en el nodo base del Arbol
         * Por ultimo se recarga el arbol
         **/
        @Override
        public void ejecutarComando(ComandoMkdir mkdir, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
                if (mkdir != null) { 
                        System.out.printf("Ejecutando Comando: %s, En el path: %s\n", mkdir.getToken(), mkdir.getPath());
                        DefaultMutableTreeNode nodoBase = controladorArbol.obtenerNodoBaseDeRuta(mkdir.getPath());
                        try {
                                String[] paths =mkdir.getPath().split(SLASH);
                                controladorArbol.crearNuevoNodoTipo(DIRECTORIO,nodoBase, paths,consolaTextArea);
                        } catch (Exception ex) {
                                consolaTextArea.append("\n" + ex.getMessage());
                        }

                        controladorArbol.recargarArbol();
                }
        }

    
}
