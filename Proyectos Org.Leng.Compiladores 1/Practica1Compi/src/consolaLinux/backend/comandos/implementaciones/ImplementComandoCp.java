/*
 * Implementacion comando cp
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.archivos.Archivo;
import consolaLinux.backend.comandos.ComandoCp;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoCp;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoCp implements InterfaceComandoCp{
    /**
     * Se comprueba que el comando no sea nulo
     * Se divide el path origen en una lista de ubicaciones por separado
     * Se obtiene el nodo Base de la ruta origen
     * Se obtiene el ultimo nodo padre de la ruta origen
     * Se busca el nodo a copiar en el arbol
     * Se verifica si el path destino es null, padre u otra ubicacion para realizar la copia
     * Por ultimo se recarga el arbol 
     **/
    @Override
    public void ejecutarComando(ComandoCp comandoCp, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
            if (comandoCp!=null) {
                    System.out.println("Ejecutando comando: "+comandoCp.getToken()+" desde path Actual: "+comandoCp.getPathActual()
                            +" hasta path Destino: "+comandoCp.getPathDestino());
                  
                    DefaultMutableTreeNode nodoBasePathOrigen = controladorArbol.obtenerNodoBaseDeRuta(comandoCp.getPathActual());
                    String[] pathsOrigen =comandoCp.getPathActual().split(SLASH);
                    try {
                            DefaultMutableTreeNode ultimoNodoPadre = controladorArbol.obtenerUltimoNodoPadre(nodoBasePathOrigen, pathsOrigen);
                            DefaultMutableTreeNode nodoCopiar= controladorArbol.buscarNodo(ultimoNodoPadre, pathsOrigen[pathsOrigen.length-1]);

                            if (comandoCp.getPathDestino() == null) {
                                    consolaTextArea.append("\n" +"Se debe especificar el path destino");
                            } else if (comandoCp.getPathDestino().equals("..")) {
                                            this.copiarHaciaElPadre(comandoCp, controladorArbol, nodoCopiar);
                                    } else {    
                                                this.copiarHaciaOtraUbicacion(comandoCp, controladorArbol, nodoCopiar, consolaTextArea);
                                        }

                    } catch (Exception ex) {
                            consolaTextArea.append("\n" + ex.getMessage());
                    }
                    
                    controladorArbol.recargarArbol();
                    
                    
            }
    }
    
    /**
     * En caso copiar hacia el padre
     * Se obtiene el nodo padre destino y se selecciona
     * Se verifica si el nodo es un directorio para hacer la copia de todo el directorio o solo un archivo
     **/
    @Override
    public void copiarHaciaElPadre(ComandoCp comandoCp, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoCopiar) {
            DefaultMutableTreeNode nodoPadreDestino = controladorArbol.obtenerNodoPadreSeleccionado();
            controladorArbol.seleccionarUnNodo(nodoPadreDestino, comandoCp.getPathDestino());

            Archivo archivo= (Archivo)nodoCopiar.getUserObject();
            if (archivo.esDirectorio()) {
                    DefaultMutableTreeNode nuevoNodoClonado = (DefaultMutableTreeNode)nodoCopiar;
                    nodoPadreDestino.add(nuevoNodoClonado);
            } else {
                        nodoPadreDestino.add(controladorArbol.crearNodoArchivo(archivo.getNombre()));                   
            }
    }
    
    /**
     * En caso copiar hacia una ubicacion nueva
     * Se obtiene el nodo padre destino y se selecciona
     * se divide el path destino en un arreglo
     * se navega al nodo padre de la nueva ubicacion y se selecciona
     * Se verifica si el nodo es un directorio para hacer la copia de todo el directorio o solo un archivo
     **/
    @Override
    public void copiarHaciaOtraUbicacion(ComandoCp comandoCp, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoCopiar, JTextArea consolaTextArea) {
            DefaultMutableTreeNode nodoPadreNuevaUbicacion = controladorArbol.obtenerNodoBaseDeRuta(comandoCp.getPathDestino());
            DefaultMutableTreeNode nodoSeleccionado;
            String[] pathsDestino =comandoCp.getPathDestino().split(SLASH);
            try {
                    nodoSeleccionado = controladorArbol.navegarHaciaUnNodoEspecifico(nodoPadreNuevaUbicacion, pathsDestino);
                    controladorArbol.seleccionarUnNodo(nodoSeleccionado, comandoCp.getPathDestino());
                    
                    Archivo archivo= (Archivo)nodoCopiar.getUserObject();
                    if (archivo.esDirectorio()) {
                            DefaultMutableTreeNode nuevoNodoClonado = (DefaultMutableTreeNode)nodoCopiar;
                            nodoSeleccionado.add(nuevoNodoClonado);
                    } else {
                                nodoSeleccionado.add(controladorArbol.crearNodoArchivo(archivo.getNombre()));                   
                    }
                    
            } catch (Exception ex) {
                    consolaTextArea.append("\n" + ex.getMessage());
            }
    }
    
}
