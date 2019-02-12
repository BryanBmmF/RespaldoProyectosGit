/*
 * Clase principal main con acceso mediante login
 */
package proyectofinal.run;
import proyectofinal.interfaz.LoginUsuario;

/**
 *
 * @author bryan
 */
public class RunMuebleria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //acceso al programa mediante login
        LoginUsuario login= new LoginUsuario();
        login.setVisible(true);        
        
        
    }
    
}
