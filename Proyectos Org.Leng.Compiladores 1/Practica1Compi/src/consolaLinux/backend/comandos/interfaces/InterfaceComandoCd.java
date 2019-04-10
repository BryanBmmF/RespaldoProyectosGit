/*
 * Interface comando Cd
 */
package consolaLinux.backend.comandos.interfaces;
import consolaLinux.backend.comandos.ComandoCd;
import consolaLinux.backend.controladores.ControladorArbol;
import javax.swing.JTextArea;

/**
 *
 * @author bryan
 */
public interface InterfaceComandoCd extends Comando<ComandoCd>{
        static final String DIRECTORIO_ROOT="/";
        static final String DIRECTORIO_PADRE="..";
        static final String PADRE="Padre";
        void verificarUbicacionDondeTrasladarse(String path, ControladorArbol controladorArbol, JTextArea consolaTextArea);
    
}
