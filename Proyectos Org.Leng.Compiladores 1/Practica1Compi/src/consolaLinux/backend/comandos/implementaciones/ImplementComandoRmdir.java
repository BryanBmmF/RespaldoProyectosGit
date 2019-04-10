/*
 * Implementacion Comando rmdir
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.archivos.Archivo;
import consolaLinux.backend.comandos.ComandoRmdir;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoRmdir;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import java.util.Enumeration;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoRmdir implements InterfaceComandoRmdir{
    
    /**
     * Se comprueba que el comando no sea nulo
     * Se divide el path en una lista de ubicaciones por separado
     * Se obtiene el nodo Base de la ruta
     * Se obtiene el ultimo nodo padre de la ruta
     * Se busca el nodo a eliminar
     * Se verifica que sea exclusivamente un directorio y que este no tenga hijos(vacio), para eliminarlo del ultimo nodo padre
     * Por ultimo se recarga el arbol 
     **/
    @Override
    public void ejecutarComando(ComandoRmdir comandoRmdir, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
            if (comandoRmdir!=null) {
                    System.out.println("ejecutando el comando: "+comandoRmdir.getToken());
                    DefaultMutableTreeNode nodoBasePath = controladorArbol.obtenerNodoBaseDeRuta(comandoRmdir.getPath());
                    String[] paths =comandoRmdir.getPath().split(SLASH);
                    
                    try {
                            DefaultMutableTreeNode ultimoNodoPadre;
                            ultimoNodoPadre = controladorArbol.obtenerUltimoNodoPadre(nodoBasePath, paths);
                            DefaultMutableTreeNode nodoElimiar= controladorArbol.buscarNodo(ultimoNodoPadre, paths[paths.length-1]);

                            Archivo archivo= (Archivo)nodoElimiar.getUserObject();
                            if (archivo.esDirectorio()) {
                                    Enumeration<DefaultMutableTreeNode> listaHijosNodoEliminar = nodoElimiar.children();
                                    int cont=0;
                                    while (listaHijosNodoEliminar.hasMoreElements()) {
                                            DefaultMutableTreeNode hijo = listaHijosNodoEliminar.nextElement();
                                            cont++;
                                    }
                                    if (cont==0) {
                                            ultimoNodoPadre.remove(nodoElimiar);
                                    } else {
                                            consolaTextArea.append("\n" + "Para eliminar directorios no vacios utilice rm -r"); 
                                    }
                            } else {
                                     consolaTextArea.append("\n" + "Para eliminar archivos utilice rm o rm -r"); 
                            }

                    } catch (Exception ex) {
                                consolaTextArea.append("\n" + ex.getMessage());
                    }
                   
                    controladorArbol.recargarArbol();
            }
    }
    
}
