/*
 * 
 */
package proyecto2ipc2.backend.Restaurante;

import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.MenuDAOImp;
import proyecto2ipc2.backend.DAO.Implementaciones.RestauranteDAOImp;
import proyecto2ipc2.backend.DAO.Interfaces.MenuDAO;
import proyecto2ipc2.backend.DAO.Interfaces.RestauranteDAO;
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
import proyecto2ipc2.frontend.Forms.FormCRUDUMenu;

/**
 *
 * @author bryan
 */

public class ControladorMenus {
        private Menu menu;
        private FormCRUDUMenu formMenu;
        private MenuDAO menuDao;
        private RestauranteDAO restauranteDao;
        public static final String MENU_NO_EXISTENETE="Este Menu no existe";
        
        public ControladorMenus(Menu menu, FormCRUDUMenu formMenu) {
                this.menu = menu;
                this.formMenu = formMenu;
                this.menuDao=new MenuDAOImp();
                this.restauranteDao= new RestauranteDAOImp();
        }

        public ControladorMenus() {
                this.menuDao=new MenuDAOImp();
                this.restauranteDao= new RestauranteDAOImp();
            
        }
        
         //metodo para registrar usuarios nuevos del sistema
        public void registrarMenu(){
                //se envia a la bd
                if (menuDao.registrar(menu)) {
                        JOptionPane.showMessageDialog(formMenu, REGISTRO_GUARDADO, REGISTRO, 1);
                        formMenu.agregarMenuEnTabla(menu);
                        formMenu.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formMenu, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        //metodo para registrar usuarios nuevos del sistema
        public void actualizarMenu(){
                //se envia a la bd
                if (menuDao.actualizar(menu, String.valueOf(formMenu.retornarIdMenuTemporal()))) {
                        JOptionPane.showMessageDialog(formMenu, REGISTRO_MODIFICADO, MODIFICACION, 1);
                        formMenu.actualizarMenuEnTabla();
                        formMenu.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formMenu, ERR_INSERCION, ERROR_ACTUALIZACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        //metodo para registrar usuarios nuevos del sistema
        public void eliminarMenu(){
                //se envia a la bd
                if (menuDao.eliminar(menu)) {
                        JOptionPane.showMessageDialog(formMenu, REGISTRO_ELIMINADO, ELIMINACION, 1);
                        formMenu.eliminarMenuEnTabla();
                        formMenu.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formMenu, MENU_NO_EXISTENETE, ERROR_ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        public List<Menu> recuperarMenus(int idRestaurante){
                return menuDao.recuperarMenusRestauranteEspecificco(idRestaurante);
        }
        public List<Restaurante> recuperarRestaurantes(){
                return restauranteDao.recuperarLista();
        }
        //metodo para consultar un usuario
        public void consultarMenu(){
                Menu us=menuDao.recuperarMenu(menu.getNumero(), menu.getIdRestaurante());
                if (us!=null) {
                        JOptionPane.showMessageDialog(formMenu, REGISTRO_RECUPERADO, RECUPERACION, 1);
                        formMenu.rellenarCampos(us);
                } else{
                        JOptionPane.showMessageDialog(formMenu, MENU_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public int recuperarRestaurante(String nombre){
                Restaurante rest=restauranteDao.recuperarIdRestaurante(nombre);
                if (rest!=null) {
                        return rest.getId();
                } else{
                        JOptionPane.showMessageDialog(formMenu, MENU_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }  
                return 0;
        }
}
