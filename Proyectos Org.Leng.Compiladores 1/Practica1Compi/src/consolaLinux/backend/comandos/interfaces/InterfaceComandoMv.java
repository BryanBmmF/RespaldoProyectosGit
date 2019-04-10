/*
 * Interface comando mv
 */
package consolaLinux.backend.comandos.interfaces;

import consolaLinux.backend.comandos.ComandoMv;
import consolaLinux.backend.controladores.ControladorArbol;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public interface InterfaceComandoMv extends Comando<ComandoMv>{
        void moverHaciaElPadre(ComandoMv comandoMv, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoMover);
        void moverHaciaOtraUbicacion(ComandoMv comandoMv, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoMover, 
                                     JTextArea consolaTextArea);
    
}
