/*
 * Implementacion de Comando Pwd
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.comandos.ComandoPwd;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoPwd;
import consolaLinux.backend.controladores.ControladorArbol;
import javax.swing.JTextArea;

/**
 *
 * @author bryan
 */
public class ImplementComandoPwd implements InterfaceComandoPwd{
        /**
         * Se evalua que el comando no sea nulo
         * Se obtiene se obtiene la Ubicacion Actual
         * Por ultimo se recarga el arbol
         **/
        @Override
        public void ejecutarComando(ComandoPwd comandoPwd, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
                if (comandoPwd != null) {
                        String ubicacionActual = controladorArbol.getUbicacionActual();
                        System.out.printf("ejecutando comando %s, Ubicacion Actual: %s\n", comandoPwd.getToken(), ubicacionActual );
                        consolaTextArea.append(ubicacionActual);

                        controladorArbol.recargarArbol();
                }
        }

    
}
