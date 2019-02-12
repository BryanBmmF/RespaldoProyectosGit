/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;
import java.util.List;
import proyecto2ipc2.backend.Hotel.Reservacion;

/**
 *
 * @author bryan
 */
public interface ReservacionDAO extends CRUD<Reservacion>{
        public boolean actualizarDiasReservacion(int dias, int id);
        public boolean actualizarEstadoReservacion(int idReservacion, String estado);
        public boolean actualizarFechasReservacion(Reservacion reservacion);
        public Reservacion recuperarReservacion(String nombreCliente);
        public Reservacion recuperarReservacionConFecha(String fechaIn, String fechaRet,int numHabitacion, int idHotel);
        public Reservacion recuperarNumeroReservacion(int numero);
        public List<Reservacion> resuperarReservacionesHotel(int idHotel);
        public List<Reservacion> resuperarReservacionesHabitacionesHotel(int idHotel,String fecha);
        public List<Reservacion> recuperarReservacionesCliente(int idHotel,String fechaActual,String nitCliente, String estado);
        public List<Reservacion> recuperarReservacionesClienteActivasParaExtension(int idHotel,String nitCliente, String estado);
        public List<Reservacion> recuperarReservacionesClienteRetiro(int idHotel,String fechaActual,String nitCliente, String estado);
        public List<Reservacion> verificarDisponibilidadHabitacion(String fIngreso, String fRetiro, int numHabitacion, int idHotel);
        public List<Reservacion> verificarDisponibilidadHabitacionExcluyendo(String fIngreso, String fRetiro, int numHabitacion, int idHotel, int idReserv);
    
}
