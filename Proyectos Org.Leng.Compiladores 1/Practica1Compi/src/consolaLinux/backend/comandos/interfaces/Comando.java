/*
 * Interface general Comando con un unico metodo ejecutarComando
 */
package consolaLinux.backend.comandos.interfaces;
import consolaLinux.backend.controladores.ControladorArbol;
import javax.swing.JTextArea;

/**
 *
 * @author bryan
 */
public interface Comando <T>{
        //metodo de ejecucion de un comando T
        void ejecutarComando(T t,ControladorArbol controladorArbol, JTextArea consolaTextArea);
}
