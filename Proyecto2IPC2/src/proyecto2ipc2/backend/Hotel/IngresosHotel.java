/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2.backend.Hotel;

import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class IngresosHotel {
        private int id;
        private Double ingreso;
        private LocalDate fecha;
        private Habitacion habitacion;
        private Hotel hotel;
        private Cliente cliente;

        public IngresosHotel(Double ingreso, LocalDate fecha, Habitacion habitacion, Hotel hotel, Cliente cliente) {
            this.ingreso = ingreso;
            this.fecha = fecha;
            this.habitacion = habitacion;
            this.hotel = hotel;
            this.cliente = cliente;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Double getIngreso() {
            return ingreso;
        }

        public void setIngreso(Double ingreso) {
            this.ingreso = ingreso;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public Habitacion getHabitacion() {
            return habitacion;
        }

        public void setHabitacion(Habitacion habitacion) {
            this.habitacion = habitacion;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public void setHotel(Hotel hotel) {
            this.hotel = hotel;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }    
        
    
}
