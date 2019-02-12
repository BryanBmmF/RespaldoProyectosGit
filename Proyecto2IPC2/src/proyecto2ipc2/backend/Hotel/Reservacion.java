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
public class Reservacion {
        
        private int numero;
        private Cliente cliente;
        private Habitacion habitacion;    
        private LocalDate fechaIngreso;
        private LocalDate fechaRetiro;
        private String estado;
        private Hotel hotel;
       
        public Reservacion(int numero, Cliente cliente, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaRetiro, String estado, Hotel hotel) {
            this.numero = numero;
            this.cliente = cliente;
            this.habitacion = habitacion;
            this.fechaIngreso = fechaIngreso;
            this.fechaRetiro = fechaRetiro;
            this.estado = estado;
            this.hotel = hotel;
        }

        public Reservacion(Cliente cliente, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaRetiro, String estado, Hotel hotel) {
            this.cliente = cliente;
            this.habitacion = habitacion;
            this.fechaIngreso = fechaIngreso;
            this.fechaRetiro = fechaRetiro;
            this.estado = estado;
            this.hotel = hotel;
        }
        
        public Reservacion(Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaRetiro) {
            this.habitacion = habitacion;
            this.fechaIngreso = fechaIngreso;
            this.fechaRetiro = fechaRetiro;
        }

        public Reservacion(int numero, Habitacion habitacion, Hotel hotel) {
            this.numero = numero;
            this.habitacion = habitacion;
            this.hotel = hotel;
        }

        public Reservacion(int numero, String estado) {
            this.numero = numero;
            this.estado = estado;
        }

        public Reservacion(int numero, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaRetiro, Hotel hotel) {
            this.numero = numero;
            this.habitacion = habitacion;
            this.fechaIngreso = fechaIngreso;
            this.fechaRetiro = fechaRetiro;
            this.hotel = hotel;
        }

        public Reservacion() {
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public LocalDate getFechaIngreso() {
            return fechaIngreso;
        }

        public void setFechaIngreso(LocalDate fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
        }

        public LocalDate getFechaRetiro() {
            return fechaRetiro;
        }

        public void setFechaRetiro(LocalDate fechaRetiro) {
            this.fechaRetiro = fechaRetiro;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
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

        
}
