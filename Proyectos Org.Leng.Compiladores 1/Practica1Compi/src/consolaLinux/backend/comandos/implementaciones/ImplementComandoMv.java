/*
 * Implementacion comando mv
 */
package consolaLinux.backend.comandos.implementaciones;

import consolaLinux.backend.comandos.ComandoMv;
import consolaLinux.backend.comandos.interfaces.InterfaceComandoMv;
import consolaLinux.backend.controladores.ControladorArbol;
import static consolaLinux.backend.controladores.ControladorArbol.SLASH;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public class ImplementComandoMv implements InterfaceComandoMv{
    
    /**
     * Se comprueba que el comando no sea nulo
     * Se divide el path origen en una lista de ubicaciones por separado
     * Se obtiene el nodo Padre de la ruta origen
     * Se obtiene el ultimo nodo Base de la ruta origen
     * Se busca el nodo a copiar en el arbol
     * Se verifica si el path destino es null, padre u otra ubicacion para realizar la copia
     * Por ultimo se recarga el arbol 
     **/
    @Override
    public void ejecutarComando(ComandoMv comandoMv, ControladorArbol controladorArbol, JTextArea consolaTextArea) {
            if (comandoMv!=null) {
                    System.out.println("Ejecutando comando: "+comandoMv.getToken()+" desde path Actual: "+comandoMv.getPathActual()
                            +" hasta path Destino: "+comandoMv.getPathDestino());
                    
                    DefaultMutableTreeNode nodoBasePathOrigen = controladorArbol.obtenerNodoBaseDeRuta(comandoMv.getPathActual());
                    String[] pathsOrigen =comandoMv.getPathActual().split(SLASH);
                    try {
                            DefaultMutableTreeNode ultimoNodoPadre = controladorArbol.obtenerUltimoNodoPadre(nodoBasePathOrigen, pathsOrigen);
                            DefaultMutableTreeNode nodoMover= controladorArbol.buscarNodo(ultimoNodoPadre, pathsOrigen[pathsOrigen.length-1]);

                            if (comandoMv.getPathDestino() == null) {
                                    consolaTextArea.append("\n" +"Se debe especificar el path destino");
                                    //o cambiar nombre del archivo
                            } else if (comandoMv.getPathDestino().equals("..")) {
                                            this.moverHaciaElPadre(comandoMv, controladorArbol, nodoMover);
                                    } else {    
                                                this.moverHaciaOtraUbicacion(comandoMv, controladorArbol, nodoMover, consolaTextArea);
                                        }

                    } catch (Exception ex) {
                            consolaTextArea.append("\n" + ex.getMessage());
                    }
                    
                    controladorArbol.recargarArbol();

            }
    }
    
    /**
     * En caso de mover hacia el padre
     * Se obtiene el nodo padre destino y se selecciona
     * Se mueve el nodo hacia el padre destino
     **/
    @Override
    public void moverHaciaElPadre(ComandoMv comandoMv, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoMover) {
            DefaultMutableTreeNode nodoPadreDestino = controladorArbol.obtenerNodoPadreSeleccionado();
            controladorArbol.seleccionarUnNodo(nodoPadreDestino, comandoMv.getPathDestino());
            nodoPadreDestino.add(nodoMover);
    }
    
    /**
     * En caso de mover hacia una ubicacion nueva
     * Se obtiene el nodo padre destino
     * se divide el path destino en un arreglo
     * se navega al nodo padre de la nueva ubicacion y se selecciona
     * Se mueve el nodo hacia el padre destino
     **/
    @Override
    public void moverHaciaOtraUbicacion(ComandoMv comandoMv, ControladorArbol controladorArbol, DefaultMutableTreeNode nodoMover, JTextArea consolaTextArea) {
            DefaultMutableTreeNode nodoPadreNuevaUbicacion = controladorArbol.obtenerNodoBaseDeRuta(comandoMv.getPathDestino());
            DefaultMutableTreeNode nodoSeleccionado;
            String[] pathsDestino =comandoMv.getPathDestino().split(SLASH);
            try {
                    nodoSeleccionado = controladorArbol.navegarHaciaUnNodoEspecifico(nodoPadreNuevaUbicacion, pathsDestino);
                    controladorArbol.seleccionarUnNodo(nodoSeleccionado, comandoMv.getPathDestino());

                    nodoSeleccionado.add(nodoMover);
            } catch (Exception ex) {
                    consolaTextArea.append("\n" + ex.getMessage());
            }
    }
    
}
