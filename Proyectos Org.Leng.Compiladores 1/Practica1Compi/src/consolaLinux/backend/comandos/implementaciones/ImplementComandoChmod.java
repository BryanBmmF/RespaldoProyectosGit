/*
 * Implementacion Comando Chmod
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.archivos.Archivo;
import consolaLinux.backend.comandos.ComandoChmod;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoChmod;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import java.util.Enumeration;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoChmod implements InterfaceComandoChmod{
    
    /**
     * Se comprueba que el comando no sea nulo
     * Se divide el path en una lista de ubicaciones por separado
     * Se obtiene el nodo Padre de la ruta
     * Se verifica si el comando Chmod incluye la opcion Recursiva, para asi buscar el nodo y establecerle
       los permisos correspondientes, de lo contario solo se busca el archivo con nodo Padre y se
       le agregan los permisos correspondientes.
     * Por ultimo se recarga el arbol 
     **/
    @Override
    public void ejecutarComando(ComandoChmod comandoChmod, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
            if (comandoChmod != null) { //si el comando no es nulo
                    System.out.println("Ejecutando Comando: " + comandoChmod.getToken());
                    String[] paths = comandoChmod.getPath().split(SLASH);
                    try {
                            DefaultMutableTreeNode nodoPadre = controladorArbol.obtenerNodoBaseDeRuta(comandoChmod.getPath());
                            if (esConOpcionRecursiva(comandoChmod)) {
                                    DefaultMutableTreeNode nodo = controladorArbol.buscarUltimoNodo(nodoPadre, paths);
                                    establecerPermisosOpcionRecursiva(nodo, comandoChmod);
                            } else {
                                    Archivo archivo = controladorArbol.buscarUltimoArchivo(nodoPadre, paths);
                                    archivo.establecerPermisos(comandoChmod.getPermisos());
                            }
                    } catch(Exception ex) {
                            consolaTextArea.append("\n" + ex.getMessage());
                    }
                    
                    controladorArbol.recargarArbol();
            }
        
    }
    
    /**
     * Se verifica si la instruccion Chmod contiene permisos recursivos
     * Si los contiene se devuelve verdadero, de lo contrario falso
     **/
    @Override
    public boolean esConOpcionRecursiva(ComandoChmod comandoChmod) {
            if (comandoChmod.getOpcionRecursiva() != null && comandoChmod.getOpcionRecursiva().contains(RECURSIVO)) {
                    return true;
            }
            return false;
    }
    
    /**
     * Se castea el nodo recibido a un objeto Archivo para hacer uso de sus propiedades
     * Se establecen los permisos segun el comandoChmod
     * Si el archivo es un directorio se enumeran todos los archivos dentro de el (sus hijos)
       se castean a (Archivo) y a cada uno se le establecen los permisos respectivos
     **/
    @Override
    public void establecerPermisosOpcionRecursiva(DefaultMutableTreeNode nodo,ComandoChmod comandoChmod) {
            Archivo archivo = (Archivo) nodo.getUserObject();
            archivo.establecerPermisos(comandoChmod.getPermisos());
            if (archivo.esDirectorio()) {
                    Enumeration<DefaultMutableTreeNode> children = nodo.depthFirstEnumeration();
                    while (children.hasMoreElements()) {
                            DefaultMutableTreeNode child = children.nextElement();
                            Archivo archivoHijo = (Archivo) child.getUserObject();
                            archivoHijo.establecerPermisos(comandoChmod.getPermisos());
                    }
            }
    }

    
    
}
