/*
 * Clase Controlador para usuarios del sistema
 */
package sistemacasos.backend.user;
import sistemacasos.database.OperadorEsquema;

/**
 *
 * @author bryan
 */
public class ControladorUsuarios {    
        public ControladorUsuarios(){
        
        }
        //metodo para validacion de ingreso de usuarios
        public String ValidarIngreso(String user,String pass){
                OperadorEsquema operador= new OperadorEsquema();
                return operador.ValidarUsuario(user, pass); //retorna el tipo de usuario para darle acceso al sistema
                
        }
        //metodo para registrar usurios nuevos del sistema
        public void registrarUsuario(Usuario user){
                //se envia a la bd
                OperadorEsquema operador= new OperadorEsquema();
                operador.insertarUsuario(user);
        }
        //metodo para consultar un usuario
        public String consultarUsuario(String cui){
                OperadorEsquema operador= new OperadorEsquema();
                return operador.recuperarUsuario(cui);// retorna el usuario correspondiente al cui
        }
        
}