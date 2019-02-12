/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.DAO.Interfaces;

import proyecto2ipc2.backend.Hotel.Hotel;
import proyecto2ipc2.backend.Hotel.IngresosHotel;

/**
 *
 * @author bryan
 */
public interface HotelDAO extends CRUD<Hotel>{
        public Hotel recuperarHotel(String nombre);
        public int recuperarNumeroHabitaciones(int idHotel);
        public boolean registrarIngresoHotel(IngresosHotel ingresoHotel);
}
