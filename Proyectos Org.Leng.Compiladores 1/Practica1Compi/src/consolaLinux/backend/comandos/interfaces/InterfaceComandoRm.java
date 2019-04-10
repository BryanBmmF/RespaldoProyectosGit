/*
 * Interface comando rm
 */
package consolaLinux.backend.comandos.interfaces;

import consolaLinux.backend.comandos.ComandoRm;
import consolaLinux.backend.controladores.ControladorArbol;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public interface InterfaceComandoRm extends Comando<ComandoRm>{
        void eliminarArchivoNormal(DefaultMutableTreeNode nodoBasePath, String[] paths,
                        ControladorArbol controladorArbol, JTextArea consolaTextArea);
        void eliminarDirectorio(DefaultMutableTreeNode nodoBasePath, String[] paths,
                        ControladorArbol controladorArbol, JTextArea consolaTextArea);
    
}
