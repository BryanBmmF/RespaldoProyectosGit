/*
 * Interface del comando Chmod
 */
package consolaLinux.backend.comandos.interfaces;

import consolaLinux.backend.comandos.ComandoChmod;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public interface InterfaceComandoChmod extends Comando<ComandoChmod> {
        static final String RECURSIVO = "-R";
        boolean esConOpcionRecursiva(ComandoChmod comandoChmod);
        void establecerPermisosOpcionRecursiva(DefaultMutableTreeNode nodo, ComandoChmod comandoChmod);
        
}
