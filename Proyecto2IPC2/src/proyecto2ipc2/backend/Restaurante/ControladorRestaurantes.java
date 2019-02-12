/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Restaurante;

import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.RestauranteDAOImp;
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
import proyecto2ipc2.frontend.Forms.FormCRUDPedidos;
import proyecto2ipc2.frontend.Forms.FormCRUDRestaurante;

/**
 *
 * @author bryan
 */
public class ControladorRestaurantes {
        public static final String RESTAURANTE_NO_EXISTENETE="Este Restaurante no existe";
        private Restaurante restaurante;
        private RestauranteDAO restauranteDao;
        private FormCRUDRestaurante formRestaurante;
        private IngresosRestaurante ingresoRestaurante;
        private FormCRUDPedidos formPedidos;

        public ControladorRestaurantes(Restaurante restaurante, FormCRUDRestaurante formRestaurante) {
                this.restaurante = restaurante;
                this.formRestaurante = formRestaurante;
                this.restauranteDao= new RestauranteDAOImp();
        }

        public ControladorRestaurantes() {
                this.restauranteDao= new RestauranteDAOImp();
        }

        public ControladorRestaurantes(IngresosRestaurante ingresoRestaurante, FormCRUDPedidos formPedidos) {
            this.ingresoRestaurante = ingresoRestaurante;
            this.formPedidos = formPedidos;
            this.restauranteDao= new RestauranteDAOImp();
        }
        
        public void registrarRestaurante(){
                if (restauranteDao.registrar(restaurante)) {
                        JOptionPane.showMessageDialog(formRestaurante,REGISTRO_GUARDADO, REGISTRO, 1);  
                        formRestaurante.agregarHotelEnTabla(restauranteDao.recuperarIdRestaurante(restaurante.getNombre()));
                        formRestaurante.limpiarCampos();
                        formRestaurante.deshabilitarBotones();
                } else{
                        JOptionPane.showMessageDialog(formRestaurante, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void actualizarRestaurante(){
                if (restauranteDao.actualizar(restaurante,formRestaurante.retornarRestauranteTemporal())) {
                        JOptionPane.showMessageDialog(formRestaurante, REGISTRO_MODIFICADO, MODIFICACION, 1);
                        formRestaurante.actualizarRestauranteEnTabla();
                        formRestaurante.limpiarCampos();
                        formRestaurante.deshabilitarBotones();
                } else{
                        JOptionPane.showMessageDialog(formRestaurante, ERR_INSERCION, ERROR_ACTUALIZACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void eliminarRestaurante(){
                 //se envia a la bd
                if (restauranteDao.eliminar(restaurante)) {
                        JOptionPane.showMessageDialog(formRestaurante, REGISTRO_ELIMINADO, ELIMINACION, 1);
                        formRestaurante.eliminarRestauranteEnTabla();
                        formRestaurante.limpiarCampos();
                        formRestaurante.deshabilitarBotones();
                } else{
                        JOptionPane.showMessageDialog(formRestaurante,RESTAURANTE_NO_EXISTENETE, ERROR_ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void recuperarRestaurante(){
                Restaurante rest=restauranteDao.recuperarIdRestaurante(restaurante.getNombre());
                if (rest!=null) {
                        JOptionPane.showMessageDialog(formRestaurante, REGISTRO_RECUPERADO, RECUPERACION, 1);
                        formRestaurante.rellenarCampos(rest);
                } else{
                        JOptionPane.showMessageDialog(formRestaurante, RESTAURANTE_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }   
        }
        
        public List<Restaurante> recuperarRestaurantes(){
                return restauranteDao.recuperarLista();
        }
        public int recuperarNumeroMenus(int idRestaurante){
                return restauranteDao.recuperarNumeroMenus(idRestaurante);
        }
        public void registrarIngresoRestaurante(){
               if (restauranteDao.registrarIngresoRestaurante(ingresoRestaurante)) {
                        System.out.println("Ingreso Restaurante Registrado");
                } else{
                        JOptionPane.showMessageDialog(formPedidos, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }    
                
        }
        
        
}
