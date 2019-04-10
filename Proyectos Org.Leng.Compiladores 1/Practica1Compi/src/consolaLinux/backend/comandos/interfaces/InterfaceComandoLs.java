/*
 * Interface comando ls
 */
package consolaLinux.backend.comandos.interfaces;

import consolaLinux.backend.archivos.Archivo;
import consolaLinux.backend.comandos.ComandoLs;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bryan
 */
public interface InterfaceComandoLs extends Comando<ComandoLs>{
        //constantes
        static final String OPCION_LISTA_Y_OCULTOS = "a";
        static final String OPCION_LISTA_DETALLADA = "l";
        
        //metodos
        boolean mostrarListaDeArchivos(ComandoLs comandols);
        boolean mostrarListaDetalladaDeArchivos(ComandoLs comandols);
        void desplegarArchivos(ComandoLs comandols, List<Archivo> listaArchivos, JTextArea consolaTextArea);
        void desplegarArchivosEnLista(List<Archivo> listaArchivos, JTextArea consolaTextArea);
        void desplegarArchivosFormaHabitual(List<Archivo> listaArchivos, JTextArea consolaTextArea);
        List<Archivo> obtenerArchivos(ComandoLs comandols,DefaultMutableTreeNode nodoBase);
        void listarArchivos(ComandoLs comandols, DefaultMutableTreeNode nodoBase, JTextArea consolaTextArea);
        
}
