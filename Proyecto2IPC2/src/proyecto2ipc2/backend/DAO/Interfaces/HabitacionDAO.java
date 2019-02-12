/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;

import java.util.List;
import proyecto2ipc2.backend.Hotel.Habitacion;
import proyecto2ipc2.backend.Hotel.ValoracionHabitacion;

/**
 *
 * @author bryan
 */
public interface HabitacionDAO extends CRUD<Habitacion>{
        public boolean registrarPuntuacionHabitacionHotel(ValoracionHabitacion valoracion);
        public boolean actualizarEstadoHabitacion(String  estado, int numHabitacion,int idHotel);
        public Habitacion recuperarHabitacion(int numero,int idHotel);
        public List<Habitacion> recuperarHabitacionesEstado(int idHotel,String estado);
        public List<Habitacion> recuperarHabitacionesHotelEspecificco(int idHotel);
    
}
