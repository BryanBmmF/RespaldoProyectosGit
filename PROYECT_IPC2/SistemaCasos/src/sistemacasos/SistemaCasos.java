/*
 * Clase principal de ejecicion del sistema
 */
package sistemacasos;
import sistemacasos.ui.LoginUsuario;

/**
 *
 * @author bryan
 */
public class SistemaCasos {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                // TODO code application logic here

                LoginUsuario login= new LoginUsuario();
                login.setVisible(true); 
        }
    
}
