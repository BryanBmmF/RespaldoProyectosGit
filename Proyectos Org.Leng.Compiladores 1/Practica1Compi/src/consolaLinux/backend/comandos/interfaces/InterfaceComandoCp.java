/*
 * Interface Comando cp
 */
package consolaLinux.backend.comandos.interfaces;
import consolaLinux.backend.comandos.ComandoCp;
import consolaLinux.backend.controladores.ControladorArbol;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public interface InterfaceComandoCp extends Comando<ComandoCp>{
        void copiarHaciaElPadre(ComandoCp comandoCp, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoCopiar);
        void copiarHaciaOtraUbicacion(ComandoCp comandoCp, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoCopiar, JTextArea consolaTextArea);
}
