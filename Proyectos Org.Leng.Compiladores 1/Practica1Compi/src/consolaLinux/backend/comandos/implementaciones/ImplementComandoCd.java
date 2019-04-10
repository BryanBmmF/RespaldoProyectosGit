/*
 * Implementacion de comando CD
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.comandos.ComandoCd;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoCd;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoCd implements InterfaceComandoCd{
        //nueva ubicacion
        private String nuevaUbicacion=DIRECTORIO_ROOT;
        
        /**
         * Se evalua que el comando no sea nulo
         * Se verifica la ubicacion hacia donde trasladarse 
         * Por ultimo se recarga el arbol
        **/
        @Override
        public void ejecutarComando(ComandoCd comandoCD, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
                if (comandoCD != null) { 
                        verificarUbicacionDondeTrasladarse(comandoCD.getPath(),controladorArbol,consolaTextArea); 
                        System.out.printf("ejecutando comando %s, y trasladando a ubicacion: %s\n", comandoCD.getToken(), nuevaUbicacion);
                }
                //actualizacion del arbol
                controladorArbol.recargarArbol();

        }
        
        /**
         * Se evalua si el path es nulo entonces se reestablece la ubicacion del arbol
         * En dado caso el path sea igual al directorio padre(..), se establece la nueva ubicacion como el nodo Padre 
           acontinuacion se obtiene el nodo Padre y se selecciona.
         * Si el path no pertenece al Directorio Padre, entonces se establce la nueva ubicacion con el path recibido,
           se obtiene el nodoBase de la ruta(path) se navega hacia el y por ultimo se selecciona
        **/
        @Override
        public void verificarUbicacionDondeTrasladarse(String path, ControladorArbol controladorArbol,JTextArea consolaTextArea) {
                if (path == null) {
                        controladorArbol.reestablecerPath();
                } else if (path.equals(DIRECTORIO_PADRE)) {
                                nuevaUbicacion = PADRE;
                                DefaultMutableTreeNode nodoPadre = controladorArbol.obtenerNodoPadreSeleccionado();
                                controladorArbol.seleccionarUnNodo(nodoPadre, path);
                        } else {    
                                    nuevaUbicacion = path;
                                    DefaultMutableTreeNode nodoBase = controladorArbol.obtenerNodoBaseDeRuta(path);
                                    DefaultMutableTreeNode nodoSeleccionado;
                                    try {
                                            nodoSeleccionado = controladorArbol.navegarHaciaUnNodoEspecifico(nodoBase, path.split(SLASH));
                                            controladorArbol.seleccionarUnNodo(nodoSeleccionado, path);
                                    } catch (Exception ex) {
                                            consolaTextArea.append("\n" + ex.getMessage());
                                    }
                            }
 
                
        }
 
   
}
