/*
 * Clase Controlador para usuarios del sistema
 */
package proyecto2ipc2.backend.User;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.UsuarioDAOImp;
import proyecto2ipc2.backend.DAO.Interfaces.UsuarioDAO;
import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Restaurante.Restaurante;
import static proyecto2ipc2.database.OperadorEsquema.ELIMINACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_ACTUALIZACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_CREACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_ELIMINACION;
import static proyecto2ipc2.database.OperadorEsquema.ERROR_RECUP;
import static proyecto2ipc2.database.OperadorEsquema.ERR_INSERCION;
import static proyecto2ipc2.database.OperadorEsquema.MODIFICACION;
import static proyecto2ipc2.database.OperadorEsquema.RECUPERACION;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_ELIMINADO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_GUARDADO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_MODIFICADO;
import static proyecto2ipc2.database.OperadorEsquema.REGISTRO_RECUPERADO;
import proyecto2ipc2.frontend.Forms.FormCRUDUser;

/**
 *
 * @author bryan
 */
public class ControladorUsuarios {  
        public static final String USUARIO_NO_EXISTENETE="Este Usuario no existe";
        private Usuario user;
        private UsuarioDAO userDao;
        private FormCRUDUser formUser;

        public ControladorUsuarios(Usuario user, FormCRUDUser formUser) {
                this.user = user;
                this.formUser = formUser;
                this.userDao= new UsuarioDAOImp();
        }
        
        public ControladorUsuarios(){
               this.userDao= new UsuarioDAOImp(); 
        }
        //metodo para validacion de ingreso de usuarios
        public String ValidarIngreso(String user,String pass){
                return userDao.validarUsuario(user, pass); //retorna el tipo de usuario para darle acceso al sistema              
        }
        public Hotel consultarHotelAsignado(String user){
                return userDao.recuperarHotel(user); //retorna el tipo de usuario para darle acceso al sistema                
        }
        public Restaurante consultarRestAsignado(String user){
                return userDao.recuperarUsuarioRestaurante(user); //retorna el tipo de usuario para darle acceso al sistema              
        }
        
        //metodo para registrar usuarios nuevos del sistema
        public void registrarUsuario(){
                //se envia a la bd
                if (userDao.registrar(user)) {
                        JOptionPane.showMessageDialog(formUser,REGISTRO_GUARDADO, REGISTRO, 1);
                        formUser.agregarUsuarioEnTabla(user);
                        formUser.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formUser, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        //metodo para registrar usuarios nuevos del sistema
        public void actualizarUsuario(){
                //se envia a la bd
                if (userDao.actualizar(user,formUser.retornarUserTemporal())) {
                        JOptionPane.showMessageDialog(formUser, REGISTRO_MODIFICADO,MODIFICACION, 1);
                        formUser.actualizarUsuarioEnTabla();
                        formUser.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formUser, ERR_INSERCION, ERROR_ACTUALIZACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        //metodo para registrar usuarios nuevos del sistema
        public void eliminarUsuario(){
                //se envia a la bd
                if (userDao.eliminar(user)) {
                        JOptionPane.showMessageDialog(formUser, REGISTRO_ELIMINADO, ELIMINACION, 1);
                        formUser.eliminarUsuarioEnTabla();
                        formUser.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formUser, USUARIO_NO_EXISTENETE,ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        //metodo para consultar un usuario
        public void consultarUsuario(){
                Usuario usuario=userDao.recuperarUsuario(user.getUser());
                if (usuario!=null) {
                        JOptionPane.showMessageDialog(formUser, REGISTRO_RECUPERADO, RECUPERACION, 1);
                        formUser.rellenarCampos(usuario);
                } else{
                        JOptionPane.showMessageDialog(formUser, USUARIO_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }   
        }
        //metodo para consultar lista de usuarios
        public List<Usuario> recuperarUsuarios(){
                return userDao.recuperarLista();
        }
        public void asignarHotel(String user,int idHotel){
                //se envia a la bd
                if (userDao.asignarHotel(user,idHotel)) {
                        JOptionPane.showMessageDialog(formUser,REGISTRO_GUARDADO, REGISTRO, 1);
                        
                } else{
                        JOptionPane.showMessageDialog(formUser, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        public void asignarRestaurante(String user,int idRestaurante){
                //se envia a la bd
                if (userDao.asignarHotel(user,idRestaurante)) {
                        JOptionPane.showMessageDialog(formUser,REGISTRO_GUARDADO,REGISTRO, 1);
                        
                } else{
                        JOptionPane.showMessageDialog(formUser, ERR_INSERCION,ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        public void desasignarHotel(String user){
                //se envia a la bd
                if (userDao.desasignarHotel(user)) {
                        JOptionPane.showMessageDialog(formUser,REGISTRO_ELIMINADO, ELIMINACION, 1);
                        
                } else{
                        JOptionPane.showMessageDialog(formUser, ERROR_ELIMINACION, ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        public void desasignarRestaurante(String user){
                //se envia a la bd
                if (userDao.desasignarRestaurante(user)) {
                        JOptionPane.showMessageDialog(formUser,REGISTRO_ELIMINADO,ELIMINACION, 1);
                        
                } else{
                        JOptionPane.showMessageDialog(formUser, ERROR_ELIMINACION,ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        
        
}