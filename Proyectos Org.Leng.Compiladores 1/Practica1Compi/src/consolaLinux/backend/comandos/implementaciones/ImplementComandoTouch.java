/*
 * Implementacion comando Touch
 */
package consolaLinux.backend.comandos.implementaciones;
import static consolaLinux.backend.archivos.Archivo.ARCHIVO;
import consolaLinux.backend.comandos.ComandoTouch;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoTouch;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoTouch implements InterfaceComandoTouch{
        /**
         * Se evalua que el comando no sea nulo
         * Se obtiene el nodo base de la ruta especificada
         * Se crea el nuevo Archivo en el nodo base del Arbol
         * Por ultimo se recarga el arbol
         **/
        @Override
        public void ejecutarComando(ComandoTouch touch, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
                if (touch != null) {
                        System.out.printf("Ejecutando Comando: %s, En el path: %s\n", touch.getToken(), touch.getPath());
                        DefaultMutableTreeNode nodoBase = controladorArbol.obtenerNodoBaseDeRuta(touch.getPath());
                        try {
                                String[] paths =touch.getPath().split(SLASH);
                                controladorArbol.crearNuevoNodoTipo(ARCHIVO,nodoBase, paths,consolaTextArea);
                        } catch (Exception ex) {
                                consolaTextArea.append("\n" + ex.getMessage());
                        }
                        
                        controladorArbol.recargarArbol();
                }
        }
    
}
