/*
 * Implementacion comando rm
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.archivos.Archivo;
import consolaLinux.backend.comandos.ComandoRm;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoRm;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoRm implements InterfaceComandoRm{
    /**
     * Se comprueba que el comando no sea nulo
     * Se divide el path en una lista de ubicaciones por separado
     * Se obtiene el nodo Base de la ruta
     * Se verifica si el comando rm tiene la opcion -r para borrar un solo archivo o todo el directorio
     * Por ultimo se recarga el arbol 
     **/
    @Override
    public void ejecutarComando(ComandoRm comandoRm, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
            if (comandoRm!=null) {
                    System.out.println("ejecutando el comando: "+comandoRm.getToken());
                    
                    DefaultMutableTreeNode nodoBasePath = controladorArbol.obtenerNodoBaseDeRuta(comandoRm.getPath());
                    String[] paths =comandoRm.getPath().split(SLASH);
                    if (comandoRm.getOpciones()==null || comandoRm.getOpciones().length()==0) { 
                            this.eliminarArchivoNormal(nodoBasePath, paths, controladorArbol, consolaTextArea);
                    } else if (comandoRm.getOpciones().contains("-r")){
                                    this.eliminarDirectorio(nodoBasePath, paths, controladorArbol, consolaTextArea);
                            }
                    
                    controladorArbol.recargarArbol();
                    
            }
    }
    
    /**
     * En caso de eliminar un solo archivo
     * Se obtiene el nodo Padre de la ruta
     * se busca el nodo a eliminar
     * Se verifica que no sea un directorio para eliminar el nodo del ultimo nodo padre
     **/
    @Override
    public void eliminarArchivoNormal(DefaultMutableTreeNode nodoBasePath, String[] paths, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
            try {
                    DefaultMutableTreeNode ultimoNodoPadre;
                    ultimoNodoPadre = controladorArbol.obtenerUltimoNodoPadre(nodoBasePath, paths);
                    DefaultMutableTreeNode nodoElimiar= controladorArbol.buscarNodo(ultimoNodoPadre, paths[paths.length-1]);

                    Archivo archivo= (Archivo)nodoElimiar.getUserObject();
                    if (archivo.esDirectorio()) {
                           consolaTextArea.append("\n" + "Para eliminar directorios utilice rm -r"); 
                    } else {
                            ultimoNodoPadre.remove(nodoElimiar); 
                    }

            } catch (Exception ex) {
                        consolaTextArea.append("\n" + ex.getMessage());
            }
    }
    
    /**
     * En caso de eliminar todo un directorio
     * Se obtiene el nodo Padre de la ruta
     * se busca el nodo a eliminar
     * Se eliminar el nodo del ultimo nodo padre
     **/
    @Override
    public void eliminarDirectorio(DefaultMutableTreeNode nodoBasePath, String[] paths, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
            try {
                    DefaultMutableTreeNode ultimoNodoPadre;
                    ultimoNodoPadre = controladorArbol.obtenerUltimoNodoPadre(nodoBasePath, paths);
                    DefaultMutableTreeNode nodoElimiar= controladorArbol.buscarNodo(ultimoNodoPadre, paths[paths.length-1]);

                    ultimoNodoPadre.remove(nodoElimiar); 
            } catch (Exception ex) {
                        consolaTextArea.append("\n" + ex.getMessage());
            }
    }
    
}
