/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Hotel;

import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.HabitacionDAOImp;
import proyecto2ipc2.backend.DAO.Implementaciones.HotelDAOImp;
import proyecto2ipc2.backend.DAO.Interfaces.HabitacionDAO;
import proyecto2ipc2.backend.DAO.Interfaces.HotelDAO;
import proyecto2ipc2.database.OperadorEsquema;
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
import proyecto2ipc2.frontend.Forms.FormCRUDHabitacion;
import proyecto2ipc2.frontend.Forms.FormValoracionHabitacion;

/**
 *
 * @author bryan
 */

 
public class ControladorHabitaciones {
        public static final String HABITACION_NO_EXISTENETE="Esta Habitacion no existe";
        private Habitacion habitacion;
        private ValoracionHabitacion valoracionHabitacion;
        private HabitacionDAO habitacionDao;
        private HotelDAO hotelDao;
        private FormCRUDHabitacion formHabitacion;
        private FormValoracionHabitacion formOpinionHabitacion;

        public ControladorHabitaciones(Habitacion habitacion, FormCRUDHabitacion formHabitacion) {
            this.habitacion = habitacion;
            this.formHabitacion = formHabitacion;
            this.habitacionDao= new HabitacionDAOImp();
            this.hotelDao= new HotelDAOImp();
        }

        public ControladorHabitaciones(ValoracionHabitacion valoracionHabitacion, FormValoracionHabitacion formOpinionHabitacion) {
            this.valoracionHabitacion = valoracionHabitacion;
            this.formOpinionHabitacion = formOpinionHabitacion;
            this.habitacionDao= new HabitacionDAOImp();
        }
        
        public ControladorHabitaciones() {
                this.habitacionDao= new HabitacionDAOImp();
                this.hotelDao= new HotelDAOImp();
        }
        
        //metodo para consultar un usuario
        public void consultarHabitacion(){
                Habitacion habit=habitacionDao.recuperarHabitacion(habitacion.getNumero(),habitacion.getIdHotel());
                if (habit!=null) {
                        JOptionPane.showMessageDialog(formHabitacion, REGISTRO_RECUPERADO, RECUPERACION, 1);
                        formHabitacion.rellenarCampos(habit);
                } else{
                        JOptionPane.showMessageDialog(formHabitacion, HABITACION_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }   
        }
        //metodo para registrar usuarios nuevos del sistema
        public void registrarHabitacion(){
                if (habitacionDao.registrar(habitacion)) {
                        JOptionPane.showMessageDialog(formHabitacion, REGISTRO_GUARDADO, REGISTRO, 1);  
                        formHabitacion.agregarHabitacionEnTabla(habitacion);
                        formHabitacion.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formHabitacion, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void registrarPuntuacionHabitacion(){
                if (habitacionDao.registrarPuntuacionHabitacionHotel(valoracionHabitacion)) {
                        JOptionPane.showMessageDialog(formOpinionHabitacion, REGISTRO_GUARDADO, REGISTRO, 1);  
                        formOpinionHabitacion.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formOpinionHabitacion, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void actualizarHabitacion(){
                if (habitacionDao.actualizar(habitacion, String.valueOf(formHabitacion.retornarIdHabitacionTemporal()))) {
                        JOptionPane.showMessageDialog(formHabitacion, REGISTRO_MODIFICADO, MODIFICACION, 1);
                        formHabitacion.actualizarHabitacionEnTabla();
                        formHabitacion.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formHabitacion, ERR_INSERCION, ERROR_ACTUALIZACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void eliminarHabitacion(){
                 //se envia a la bd
                if (habitacionDao.eliminar(habitacion)) {
                        JOptionPane.showMessageDialog(formHabitacion, REGISTRO_ELIMINADO, ELIMINACION, 1);
                        formHabitacion.eliminarHabitacionlEnTabla();
                        formHabitacion.organizarFormulario();
                } else{
                        JOptionPane.showMessageDialog(formHabitacion, HABITACION_NO_EXISTENETE, ERROR_ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public List<Habitacion> recuperarHabitaciones(int idHotel){
                return habitacionDao.recuperarHabitacionesHotelEspecificco(idHotel);
        }
        public List<Habitacion> recuperarHabitacionesEstado(int idHotel,String estado){
                return habitacionDao.recuperarHabitacionesEstado(idHotel,estado);
        }
        public List<Hotel> recuperarHoteles(){
                return hotelDao.recuperarLista();
        }
        public int recuperarHotel(String nombre){
                Hotel hot=hotelDao.recuperarHotel(nombre);
                if (hot!=null) {
                        return hot.getId();
                } else{
                        JOptionPane.showMessageDialog(formHabitacion, HABITACION_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }  
                return 0;
        }
        
}
