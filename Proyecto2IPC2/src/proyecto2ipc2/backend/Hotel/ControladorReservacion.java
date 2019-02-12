/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto2ipc2.backend.DAO.Implementaciones.HabitacionDAOImp;
import proyecto2ipc2.backend.DAO.Implementaciones.ReservacionDAOImp;
import proyecto2ipc2.backend.DAO.Interfaces.HabitacionDAO;
import proyecto2ipc2.backend.DAO.Interfaces.ReservacionDAO;
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
import proyecto2ipc2.frontend.Forms.FormCRUDReservacion;
import proyecto2ipc2.frontend.Forms.FormCheckIn;
import proyecto2ipc2.frontend.Forms.FormCheckOut;
import proyecto2ipc2.frontend.Forms.FormExtenderReservacion;

/**
 *
 * @author bryan
 */
public class ControladorReservacion {
        private Reservacion reservacion;
        private FormCRUDReservacion formReservacion;
        private FormCheckIn formCheckIn;
        private FormCheckOut formCheckOut;
        private FormExtenderReservacion formExtension;
        
        private ReservacionDAO reservacionDao;
        private HabitacionDAO habitacionDao;

        public static final String RESERVACION_NO_EXISTENETE="Esta Reservacion no existe";
        public static final String ERROR_FECHAS="La fecha de Retiro no puede ser antes"
                                        + "\n que la fecha de Ingreso, y la fecha de Ingreso"
                                        + "\n debe ser mayor o igual a la Actual";
        public static final String ERROR_DISPONIBILIDAD_HABITACION="La reservacion no se puede generar debido a que"
                                                        + "\n la habitacion seleccionada esta ocupada para esas fechas."
                                                        + "\n Revise la tabla de reservaciones de cada habitacion";
        public static final String ERROR_ACTULIZACION_HABITACION="No se pudo actualizar el estado de la habitacion";
        public static final String HABITACION_OCUPADA="Ocupada";
        public static final String HABITACION_DESOCUPADA="Desocupada";
        
        public ControladorReservacion(Reservacion reservacion, FormCRUDReservacion formReservacion) {
            this.reservacion = reservacion;
            this.formReservacion = formReservacion;
            this.reservacionDao= new ReservacionDAOImp();
            this.habitacionDao= new HabitacionDAOImp();
        }

        public ControladorReservacion(Reservacion reservacion, FormCheckIn formCheckIn) {
            this.reservacion = reservacion;
            this.formCheckIn = formCheckIn;
            this.reservacionDao= new ReservacionDAOImp();
        }

        public ControladorReservacion(Reservacion reservacion, FormCheckOut formCheckOut) {
            this.reservacion = reservacion;
            this.formCheckOut = formCheckOut;
            this.reservacionDao= new ReservacionDAOImp();
        }

        public ControladorReservacion(Reservacion reservacion, FormExtenderReservacion formExtension) {
            this.reservacion = reservacion;
            this.formExtension = formExtension;
            this.reservacionDao= new ReservacionDAOImp();
        }

        public ControladorReservacion() {
                this.reservacionDao= new ReservacionDAOImp();
                this.habitacionDao= new HabitacionDAOImp();
                this.reservacionDao= new ReservacionDAOImp();
        }
         //metodo para registrar usuarios nuevos del sistema
        public void verificarRegistroReservacion(){
                //se recupera la fecha actual 
                LocalDate dateActual = LocalDate.now();
                
                //comparacion de fechas erroneas
                if (reservacion.getFechaRetiro().isBefore(reservacion.getFechaIngreso())
                        ||reservacion.getFechaIngreso().isBefore(dateActual)) {
                        JOptionPane.showMessageDialog(formReservacion,ERROR_FECHAS, REGISTRO, 1);
                } else {    
                           
                            if (verificarDisponibilidadHabitacion(reservacion.getFechaIngreso().toString(), reservacion.getFechaRetiro().toString(), reservacion.getHabitacion().getNumero(), reservacion.getHotel().getId())) {
                                    realizarReservacion(reservacion.getFechaIngreso().toString(), reservacion.getFechaRetiro().toString());//se guarda la reservacion
                            } else {
                                        JOptionPane.showMessageDialog(formReservacion, ERROR_DISPONIBILIDAD_HABITACION, REGISTRO, 1);
                            }
                }
                
                
        }
        public void verificarActualizacionReservacion(){
                //se recupera la fecha actual 
                LocalDate dateActual = LocalDate.now();
                
                //comparacion de fechas erroneas
                if (reservacion.getFechaRetiro().isBefore(reservacion.getFechaIngreso())
                        ||reservacion.getFechaIngreso().isBefore(dateActual)) {
                        JOptionPane.showMessageDialog(formReservacion,ERROR_FECHAS, REGISTRO, 1);
                } else {    
                            
                            if (verificarDisponibilidadHabitacionExcluyendo(reservacion.getFechaIngreso().toString(), reservacion.getFechaRetiro().toString(), reservacion.getHabitacion().getNumero(), reservacion.getHotel().getId())) {
                                    actualizarReservacion(reservacion.getFechaIngreso().toString(), reservacion.getFechaRetiro().toString());//se guarda la reservacion
                            } else {
                                        JOptionPane.showMessageDialog(formReservacion, ERROR_DISPONIBILIDAD_HABITACION, REGISTRO, 1);
                            }
                }
                
                
        }
        public void realizarReservacion(String fechaIngreso,String fechaRetiro){
                if (reservacionDao.registrar(reservacion)) {
                        JOptionPane.showMessageDialog(formReservacion, REGISTRO_GUARDADO, REGISTRO, 1);                                                
                        
                        if (!habitacionDao.actualizarEstadoHabitacion(HABITACION_OCUPADA, reservacion.getHabitacion().getNumero(), reservacion.getHotel().getId())) {
                                JOptionPane.showMessageDialog(formReservacion, ERROR_ACTULIZACION_HABITACION, MODIFICACION, 1);
                        }
                        formReservacion.organizarFormulario();
                        formReservacion.cargarTablasHabitacion();
                        formReservacion.agregarReservacionEnTabla(reservacionDao.recuperarReservacionConFecha(fechaIngreso, fechaRetiro,reservacion.getHabitacion().getNumero(), reservacion.getHotel().getId()));
                } else {
                        JOptionPane.showMessageDialog(formReservacion, ERR_INSERCION, ERROR_CREACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void actualizarReservacion(String fechaIngreso,String fechaRetiro){
                if (reservacionDao.actualizar(reservacion, String.valueOf(formReservacion.retornarIdReservacionTemporal()))) {
                        JOptionPane.showMessageDialog(formReservacion, REGISTRO_MODIFICADO, MODIFICACION, 1);
                        if (!habitacionDao.actualizarEstadoHabitacion(HABITACION_OCUPADA, reservacion.getHabitacion().getNumero(), reservacion.getHotel().getId())) {
                                JOptionPane.showMessageDialog(formReservacion, ERROR_ACTULIZACION_HABITACION, MODIFICACION, 1);
                        }
                        formReservacion.cargarTablasHabitacion();
                        formReservacion.actualizarReservacionEnTabla();
                        formReservacion.organizarFormulario();   
                } else {
                        JOptionPane.showMessageDialog(formReservacion, ERROR_ACTUALIZACION, MODIFICACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void actualizarFechasReservacion(){
                if (reservacionDao.actualizarFechasReservacion(reservacion)) {
                        JOptionPane.showMessageDialog(formExtension, REGISTRO_MODIFICADO, MODIFICACION, 1);
                        formExtension.cargarTablasHabitacion();
                        formExtension.actualizarReservacionEnTabla();
                        formExtension.organizarFormulario();   
                } else {
                        JOptionPane.showMessageDialog(formExtension, ERROR_ACTUALIZACION, MODIFICACION, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public void verificarActualizacionFechasReservacion(){
                //se recupera la fecha actual 
                LocalDate dateActual = LocalDate.now();
                
                //comparacion de fechas erroneas
                if (reservacion.getFechaRetiro().isBefore(reservacion.getFechaIngreso())
                        ||reservacion.getFechaIngreso().isBefore(dateActual)) {
                        JOptionPane.showMessageDialog(formExtension,ERROR_FECHAS, REGISTRO, 1);
                } else {    
                           
                            if (verificarDisponibilidadHabitacionExcluyendoParaCambioFechas(reservacion.getFechaIngreso().toString(), reservacion.getFechaRetiro().toString(), reservacion.getHabitacion().getNumero(), reservacion.getHotel().getId())) {
                                    actualizarFechasReservacion();//se guarda la reservacion
                            } else {
                                        JOptionPane.showMessageDialog(formExtension, ERROR_DISPONIBILIDAD_HABITACION, REGISTRO, 1);
                            }
                }
                
                
        }
        public void actualizarEstadoReservacion(){
                if (reservacionDao.actualizarEstadoReservacion(reservacion.getNumero(), reservacion.getEstado())) {
                        JOptionPane.showMessageDialog(formReservacion, REGISTRO_MODIFICADO, MODIFICACION, 1);
                        formCheckIn.eliminarReservacionEnTabla();
                        formCheckIn.limpiarCampos();
                        formCheckIn.deshabilitarBotones();
                } else {
                            JOptionPane.showMessageDialog(formReservacion, ERROR_ACTUALIZACION, MODIFICACION, JOptionPane.ERROR_MESSAGE);
                }            
        
        }
        public void actualizarEstadoReservacionSaldada(){
                if (reservacionDao.actualizarEstadoReservacion(reservacion.getNumero(), reservacion.getEstado())) {
                        System.out.println("La Reservacion quedo SALDADA");
                        formCheckOut.eliminarReservacionEnTabla();
                        formCheckOut.limpiarCampos();
                        formCheckOut.deshabilitarBotones();
                } else {
                            JOptionPane.showMessageDialog(formCheckOut, ERROR_ACTUALIZACION, MODIFICACION, JOptionPane.ERROR_MESSAGE);
                }            
        
        }
        //metodo para registrar usuarios nuevos del sistema
        public void eliminarReservacion(){
                //se envia a la bd
                if (reservacionDao.eliminar(reservacion)) {
                        JOptionPane.showMessageDialog(formReservacion, REGISTRO_ELIMINADO, ELIMINACION, 1);
                        
                        if (!habitacionDao.actualizarEstadoHabitacion(HABITACION_DESOCUPADA, reservacion.getHabitacion().getNumero(), reservacion.getHotel().getId())) {
                                JOptionPane.showMessageDialog(formReservacion, ERROR_ACTULIZACION_HABITACION, MODIFICACION, 1);
                        }
                        formReservacion.organizarFormulario();
                        formReservacion.cargarTablasHabitacion();
                        formReservacion.eliminarReservacionEnTabla();
                } else{
                        JOptionPane.showMessageDialog(formReservacion, RESERVACION_NO_EXISTENETE, ERROR_ELIMINACION, JOptionPane.ERROR_MESSAGE);
                }   
                
        }
        //metodo para consultar un usuario
        public void consultarReservacion(){
                Reservacion us=reservacionDao.recuperarReservacion(reservacion.getCliente().getNombre());
                if (us!=null) {
                        JOptionPane.showMessageDialog(formReservacion, REGISTRO_RECUPERADO, RECUPERACION, 1);
                        formReservacion.rellenarCampos(us);
                } else{
                        JOptionPane.showMessageDialog(formReservacion, RESERVACION_NO_EXISTENETE, ERROR_RECUP, JOptionPane.ERROR_MESSAGE);
                }   
        }
        public List<Reservacion> recuperarReservaciones(int idHotel){
                return reservacionDao.resuperarReservacionesHotel(idHotel);
        }
        public List<Reservacion> recuperarReservacionesHabitaciones(int idHotel,String fecha){
                return reservacionDao.resuperarReservacionesHabitacionesHotel(idHotel, fecha);
        }
        public List<Reservacion> recuperarReservacionesCliente(int idHotel,String fecha,String nitCliente, String estado){
                return reservacionDao.recuperarReservacionesCliente(idHotel, fecha, nitCliente,estado);
        }
        public List<Reservacion> recuperarReservacionesClienteParaExtension(int idHotel,String nitCliente, String estado){
                return reservacionDao.recuperarReservacionesClienteActivasParaExtension(idHotel, nitCliente,estado);
        }
        public List<Reservacion> recuperarReservacionesClienteRetiro(int idHotel,String fecha,String nitCliente, String estado){
                return reservacionDao.recuperarReservacionesClienteRetiro(idHotel, fecha, nitCliente,estado);
        }
        public boolean verificarDisponibilidadHabitacion(String fIngreso,String fRetiro, int nunHabitacion, int idHotel){
                boolean disponibilidad=false;
                //si no hay reservaciones para esas fechas
                if (reservacionDao.verificarDisponibilidadHabitacion(fIngreso, fRetiro, nunHabitacion, idHotel).isEmpty()) {
                        disponibilidad=true;
                }
                return disponibilidad;
        }
        public boolean verificarDisponibilidadHabitacionExcluyendo(String fIngreso,String fRetiro, int nunHabitacion, int idHotel){
                boolean disponibilidad=false;
                //si no hay reservaciones para esas fechas
                if (reservacionDao.verificarDisponibilidadHabitacionExcluyendo(fIngreso, fRetiro, nunHabitacion, idHotel,
                        formReservacion.retornarIdReservacionTemporal()).isEmpty()) {
                        disponibilidad=true;
                }
                return disponibilidad;
        }
        public boolean verificarDisponibilidadHabitacionExcluyendoParaCambioFechas(String fIngreso,String fRetiro, int nunHabitacion, int idHotel){
                boolean disponibilidad=false;
                //si no hay reservaciones para esas fechas
                if (reservacionDao.verificarDisponibilidadHabitacionExcluyendo(fIngreso, fRetiro, nunHabitacion, idHotel,
                        reservacion.getNumero()).isEmpty()) {
                        disponibilidad=true;
                }
                return disponibilidad;
        }
        public Double calcularTotalReservacion(int dias){
                double total=0;
                total= dias*reservacion.getHabitacion().getPrecio();
                return total;
        }
        
        
}
